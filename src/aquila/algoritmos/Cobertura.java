package aquila.algoritmos;

import java.util.List;

import aquila.estruturaDados.FSM;

public interface Cobertura {

	public List<List<String>> gerarSequencias(FSM fsm);
	
}
