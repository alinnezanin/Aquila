package aquila.comandos;

import aquila.Contexto;
import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Transition;
import aquila.estruturaDados.Tupla;
import gherkin.pickles.PickleStep;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Enable implements ComandosAquila {

	@Override
	public boolean verificar(PickleStep ps) {
		return ps.getText().matches(".*enable\\[.*\\]$");
	}

	@Override
	public Tupla<FSM, State> processar(PickleStep ps) {
                Pattern p = Pattern.compile(".*enable\\[(.*)\\]$");
		Matcher m = p.matcher(ps.getText());
		String input = "";
		if(!m.find())
		{
			System.err.println("Comando incorreto: " + ps.getText());
		}
		input = Contexto.getContext().getLinguagem().converter(this, m.group(1));
                
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
		
		return new Tupla<FSM, State>(resposta, fim);
	}

}
