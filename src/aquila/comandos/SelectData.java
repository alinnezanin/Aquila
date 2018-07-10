package aquila.comandos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class SelectData implements ComandosAquila {

	@Override
	public boolean verificar(PickleStep ps) {
		return ps.getText().matches(".*select-data\\[.*\\]$");
	}

	@Override
	public Tupla<FSM, State> processar(PickleStep ps) {
		
		Pattern p = Pattern.compile(".*select-data\\[(.*)\\]$");
		Matcher m = p.matcher(ps.getText());
		String campo  = "";
		
		Argument arg = null;
		for(Argument a : ps.getArgument())
		{
			if(a instanceof PickleTable)
			{
				arg = a;
			}
		}
		
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
		
		PickleTable table = (PickleTable) arg;

		for(int a=1; a<table.getRows().size(); a++)
		{
			PickleRow tr = table.getRows().get(a);
			PickleCell pc = tr.getCells().get(0);

			Transition trans = new Transition(inicio, fim, Contexto.getContext().getLinguagem().converter(this, campo, pc.getValue()));
			resposta.addTransition(trans);		
			
		}
				
		return new Tupla<FSM, State>(resposta, fim);
	}

}
