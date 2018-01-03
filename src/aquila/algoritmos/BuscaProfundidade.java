package aquila.algoritmos;

import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Transition;

public class BuscaProfundidade implements Cobertura {

	@Override
	public List<List<String>> gerarSequencias(FSM fsm) {
		
		Set<State> visitados = new HashSet<State>();
		List<String> lista = new ArrayList<String>();
		List<List<String>> resultado = new ArrayList<List<String>>();
		State inicial = fsm.getStart();
		
		recursao(fsm, inicial, lista, resultado, visitados);
		return resultado;
	}
	private void  recursao(FSM fsm, State estado, List<String> lista, List<List<String>> resultado,Set<State> visitados)
	{
		if(visitados.contains(estado))
		{
			resultado.add(lista);
			return;
		}
		else if(fsm.getStateTransitions(estado).size() == 0)
		{
			resultado.add(lista);
			return;
		}
		
		visitados.add(estado);
		
		for(Transition t : fsm.getStateTransitions(estado))
		{
			List temp = ((List) ((ArrayList) lista).clone());
			temp.add(t.getInput());
			recursao(fsm, t.getDestination(), temp, resultado, visitados);
		}	
		visitados.remove(estado);
	}
	
}
