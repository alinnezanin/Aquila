package aquila.comandos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Transition;
import aquila.estruturaDados.Tupla;
import gherkin.pickles.PickleStep;

public class selectData implements ComandosAquila {

	@Override
	public boolean verificar(PickleStep ps) {
		return ps.getText().matches(".*select-data\\[.*\\]$");
	}

	@Override
	public Tupla<FSM, State> processar(PickleStep ps) {
		
		Pattern p = Pattern.compile(".*select-data\\[(.*)\\]$");
		Matcher m = p.matcher(ps.getText());
		String campo  = "";
		
		if(!m.find())
		{
			System.err.println("Erro comando: " + ps.getText());
		}
		campo = m.group(1);
		
		State inicio = new State("0");
		State fim = new State("1");
		
		FSM resposta = new FSM();
		resposta.addState(inicio);
		resposta.addState(fim);
		resposta.addFinalState(fim);
		resposta.addFinalState(inicio);
		resposta.setStart(inicio);
		
		Transition tran = new Transition(inicio, fim, campo);
		resposta.addTransition(tran);
		
		return new Tupla<FSM, State>(resposta, fim);
	}

}
