package aquila.comandos;



import java.util.LinkedList;
import java.util.List;

import aquila.Contexto;
import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Transition;
import aquila.estruturaDados.Tupla;
import gherkin.pickles.Argument;
import gherkin.pickles.PickleCell;
import gherkin.pickles.PickleRow;
import gherkin.pickles.PickleStep;
import gherkin.pickles.PickleTable;

public class UseValidData implements ComandosAquila {

	@Override
	public boolean verificar(PickleStep ps) {
		
		if(ps.getText().matches("use_valid_data$"))return false;
		for(Argument a : ps.getArgument())
		{
			if(a instanceof PickleTable)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public Tupla<FSM, State> processar(PickleStep ps) {
		Argument arg = null;
		for(Argument a : ps.getArgument())
		{
			if(a instanceof PickleTable)
			{
				arg = a;
			}
		}
		
		int contadorEstados = 0; //vai ser utilizado para os nomes dos estados
		State inicial = new State(Integer.toString(contadorEstados));
		contadorEstados++;
		
		FSM fsm = new FSM();
		fsm.addState(inicial);
		fsm.addFinalState(inicial);
		fsm.setStart(inicial);
		
		PickleTable table = (PickleTable) arg;
		boolean cabecalho = true;
		State ultimoEstado = inicial;
		State finalTabela = null;
		
		List<String> campos = new LinkedList<String>();
		for(PickleRow tr : table.getRows())
		{
			ultimoEstado = inicial;
			if(cabecalho)
			{
				for(int i = 0; i < tr.getCells().size(); i++)
				{
					PickleCell pc = tr.getCells().get(i);
					campos.add(pc.getValue());
				}
				cabecalho = false;
			}
			else
			{
				for(int i = 0; i < tr.getCells().size(); i++)
				{						
					PickleCell pc = tr.getCells().get(i);
					
					if(i + 1 == tr.getCells().size())
					{
						State novo = null;
						if(finalTabela == null)
						{
							finalTabela = new State(Integer.toString(contadorEstados));
							novo = finalTabela;
						}
						else
						{
							novo = finalTabela;
						}
						contadorEstados++;
						fsm.addState(novo);
						fsm.addFinalState(novo);
						String input = Contexto.getContext().getLinguagem().converter(this, campos.get(i), pc.getValue());
						Transition trans = new Transition(ultimoEstado, novo, input);
						fsm.addTransition(trans);
						ultimoEstado = novo;
					}
					else
					{
						State novo = new State(Integer.toString(contadorEstados));
						contadorEstados++;
						fsm.addState(novo);
						fsm.addFinalState(novo);
						String input = Contexto.getContext().getLinguagem().converter(this, campos.get(i), pc.getValue());
						Transition trans = new Transition(ultimoEstado, novo, input);
						fsm.addTransition(trans);
						ultimoEstado = novo;
					}
				}
			}
		}
		return new Tupla<FSM, State>(fsm, finalTabela);
	}

}
