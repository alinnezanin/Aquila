package aquila.comandos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aquila.Contexto;
import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Tupla;
import gherkin.pickles.PickleStep;

public class Extender implements ComandosAquila {

	@Override
	public boolean verificar(PickleStep ps) {
		return ps.getText().matches(".*\\{.*\\}");
	}

	@Override
	public Tupla<FSM, State> processar(PickleStep ps) {
		Pattern pattern = Pattern.compile("\\{(.*)\\}");
		Matcher matcher =  pattern.matcher(ps.getText());
		String nomeFSM = "";
		
		if(!matcher.find())
		{
			System.err.println("FSM não encontrada: " + ps.getText());
		}
		nomeFSM = matcher.group(1);
		Tupla<FSM, State> resposta = Contexto.getContext().getFSM(nomeFSM);
		
		return resposta;
	}

}
