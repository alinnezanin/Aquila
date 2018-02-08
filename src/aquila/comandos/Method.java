package aquila.comandos;

import aquila.Contexto;
import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Transition;
import aquila.estruturaDados.Tupla;
import gherkin.pickles.PickleStep;

public class Method implements ComandosAquila {

	@Override
	public boolean verificar(PickleStep ps) {
		return true;
	}

	@Override
	public Tupla<FSM, State> processar(PickleStep ps) {
		
		String input = ps.getText();
		input = input.replace(' ', '_');
		input += "();\n";
		
		State inicio = new State("0");
		State fim = new State("1");
		
		FSM resposta = new FSM();
		resposta.addState(inicio);
		resposta.addState(fim);
		resposta.addFinalState(fim);
		resposta.addFinalState(inicio);
		resposta.setStart(inicio);
		
		Transition tran = new Transition(inicio, fim, input);
		resposta.addTransition(tran);
		
		if(!Contexto.getContext().listaMetodos().contains(input))
		{
			Contexto.getContext().addMethod(input);
		}
		
		return new Tupla<FSM, State>(resposta, fim);
	}

}
