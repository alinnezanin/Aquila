package aquila.algoritmos;

import java.util.List;

import aquila.estruturaDados.FSM;

public interface Cobertura {
	// Interface que algoritmos de cobertura devem utilizar
	public List<List<String>> gerarSequencias(FSM fsm);
	
}
