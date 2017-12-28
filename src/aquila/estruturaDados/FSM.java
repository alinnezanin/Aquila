package aquila.estruturaDados;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FSM {
	
	private Set<State> listaEstados;
	private Set<State> estadosFinais;
	private State start;
	private Map<State, Set<Transition>> transOrigem;
	private Map<State, Set<Transition>> transDestino;
	
	public FSM()
	{
		listaEstados = new HashSet<State>();
		estadosFinais = new HashSet<State>();
		start = null;
		transOrigem = new HashMap<State, Set<Transition>>();	
		transDestino = new HashMap<State, Set<Transition>>();
	}

	public List<State> getlistaEstados()
	{
		LinkedList<State> resposta = new LinkedList<State>();
		resposta.addAll(listaEstados);
		return resposta;
	}
	public List<State> getListaEstadosFinais()
	{
		LinkedList<State> resposta = new LinkedList<State>();
		resposta.addAll(estadosFinais);
		return resposta;
	}
	
	
	
	public State getStart() {
		return start;
	}
	public void setStart(State start) {
		this.start = start;
	}
	
	public boolean addState(State state)
	{
		if(listaEstados.add(state))
		{
			transOrigem.put(state, new HashSet<Transition>());
			transDestino.put(state, new HashSet<Transition>());
			return true;
		}
		return false;
	}

	public boolean addFinalState(State state)
	{
		return estadosFinais.add(state);
	}
	public boolean removeFinalState(State state)
	{
		return estadosFinais.remove(state);
	}
	
	public boolean addTransition(Transition trans)
	{
		Set<Transition> transListaOrigem = this.transOrigem.get(trans.getOrigin());
		Set<Transition> transListaDestino = this.transDestino.get(trans.getDestination());
		return transListaOrigem.add(trans) && transListaDestino.add(trans);
	}
	
	public List<Transition> getStateTransitions(State state)
	{
		if(!transOrigem.containsKey(state))return null;
		List<Transition> resposta = new LinkedList<Transition>();
		resposta.addAll(this.transOrigem.get(state));
		return resposta;
	}
	
	public List<Transition> getStateTransitionsDestino(State state)
	{
		if(!transDestino.containsKey(state))return null;
		List<Transition> resposta = new LinkedList<Transition>();
		resposta.addAll(this.transDestino.get(state));
		return resposta;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("FSM\n");
		for(State s : transOrigem.keySet())
		{
			Set<Transition> temp = transOrigem.get(s);
			for(Transition t :  temp)
			{
				sb.append(t + "\n");
			}
		}
		return sb.toString();
	}
	
	public static FSM removeNonDeterminism(FSM inicial)
	{
		FSM resposta = new FSM();
		
		Map<State,Set<State>> mapeamento = new HashMap<State,Set<State>>();
		
		for(State s : inicial.getlistaEstados())
		{
			Set<State> temp = new HashSet<State>();
			temp.add(s);
			mapeamento.put(s, temp);
		}
		for(State s : inicial.getlistaEstados())
		{
			for(Transition t1 : inicial.getStateTransitions(s))
			{	
				for(Transition t2 : inicial.getStateTransitions(s))
				{
					if(t1.getInput().equals(t2.getInput()) && !t1.getDestination().equals(t2.getDestination()))
					{
						Set<State> s1 = mapeamento.get(t1.getDestination());
						Set<State> s2 = mapeamento.get(t2.getDestination());
						s1.addAll(s2);
						mapeamento.put(t2.getDestination(), s1);
					}
				}
			}
		}
		
		
		//Ajustando o mapeamento
		Map<Set<State>, State> mapeamento2 = new HashMap<Set<State>, State>();
		for(State s : mapeamento.keySet())
		{
			if(mapeamento2.get(mapeamento.get(s)) == null )
			{
				Set<State> set = mapeamento.get(s);
				String nome = "";
				boolean estadoInicial = false;
				for(State s2 : set )
				{
					if(inicial.getStart().equals(s2))estadoInicial = true;
					nome += " " + s2.getName();  
				}
				State novo = new State(nome.substring(1));		
				if(estadoInicial)resposta.setStart(novo);
				resposta.addState(novo);
				resposta.addFinalState(novo);
				mapeamento2.put(mapeamento.get(s), novo);
			}
		}
		
		for(State s : inicial.getlistaEstados())
		{
			for(Transition t : inicial.getStateTransitions(s))
			{
				Transition novo = new Transition(mapeamento2.get(mapeamento.get(t.getOrigin())), mapeamento2.get(mapeamento.get(t.getDestination())), t.getInput());
				resposta.addTransition(novo);
			}			
		}
		
		return resposta;
	}

	
	public static Tupla<FSM, State> unirFSM(FSM pri, FSM seg, State uni, State lastFsm2)
	{
		FSM resposta = new FSM();
		int contador = 0;
		boolean pontoUniaoCriadoFlag = false;
		
		Map<State, State> mapeamento1 = new HashMap<State, State>();
		Map<State, State> mapeamento2 = new HashMap<State, State>();
		
		//Copia todos estados
		for(State s : pri.getlistaEstados())
		{
			State temp = new State(Integer.toString(contador));
			contador++;
						
			resposta.addState(temp);
			resposta.addFinalState(temp);
			
			
			if(s.equals(pri.getStart()))resposta.setStart(temp);
			if(s.equals(uni) && !pontoUniaoCriadoFlag)
			{
				pontoUniaoCriadoFlag = true;
				uni = temp;
			}
			
			mapeamento1.put(s, temp);
		}
		for(State s : seg.getlistaEstados())
		{
//			System.err.println(s);
//			System.err.println(lastFsm2);
//			lastFsm2 = new State(" " + lastFsm2);
//			System.err.println(s.equals(lastFsm2));
				
			
			if(!s.equals(seg.getStart()))
			{
				State temp = new State(Integer.toString(contador));
				contador++;
				
				resposta.addState(temp);
				resposta.addFinalState(temp);
				mapeamento2.put(s, temp);
								
			}
			else
			{
				mapeamento2.put(s, uni);
			}
		}
		
		for(State s : pri.getlistaEstados())
		{
			for(Transition t : pri.getStateTransitions(s))
			{
				State orig = mapeamento1.get(t.getOrigin());
				State desti = mapeamento1.get(t.getDestination());
				Transition temp = new Transition(orig, desti, t.getInput());
				
				resposta.addTransition(temp);
			}
		}
		for(State s : seg.getlistaEstados())
		{
			
			for(Transition t : seg.getStateTransitions(s))
			{
				State orig = mapeamento2.get(t.getOrigin());
				State desti = mapeamento2.get(t.getDestination());
				Transition temp = new Transition(orig, desti, t.getInput());
				
				resposta.addTransition(temp);
			}			
		}
		return new Tupla<FSM, State>(resposta, mapeamento2.get(lastFsm2));
	}
}
