package aquila.comandos;

import aquila.Contexto;
import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Transition;
import aquila.estruturaDados.Tupla;
import gherkin.pickles.PickleStep;

public class Enable implements ComandosAquila {

	@Override
	public boolean verificar(PickleStep ps) {
		return ps.getText().matches(".*enable$");
	}

	@Override
	public Tupla<FSM, State> processar(PickleStep ps) {
		State inicio = new State("0");
		State fim = new State("1");
		
		FSM resposta = new FSM();
		resposta.addState(inicio);
		resposta.addState(fim);
		resposta.addFinalState(fim);
		resposta.addFinalState(inicio);
		resposta.setStart(inicio);
		
		Transition tran = new Transition(inicio, fim, Contexto.getContext().getLinguagem().converter(this, ""));
		resposta.addTransition(tran);
		
		return new Tupla<FSM, State>(resposta, fim);
	}

}
