package aquila.comandos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aquila.Contexto;
import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Transition;
import aquila.estruturaDados.Tupla;
import gherkin.ast.TableRow;
import gherkin.pickles.Argument;
import gherkin.pickles.PickleCell;
import gherkin.pickles.PickleRow;
import gherkin.pickles.PickleStep;
import gherkin.pickles.PickleTable;

public class Choose implements ComandosAquila {

	@Override
	public boolean verificar(PickleStep ps) {
		return ps.getText().matches(".*choose\\[.*\\]$");
	}

	@Override
	//FSM é a FSM que esta montando e estado é o final
	//PickleStep é o comando da aquila ou gherkin
	public Tupla<FSM, State> processar(PickleStep ps) {
		Pattern p = Pattern.compile(".*choose\\[(.*)\\]$");
		Matcher m = p.matcher(ps.getText());
		String field = "";
		if(!m.find())
		{
			System.err.println("Comando incorreto: " + ps.getText());
		}
		
		field = m.group(1);  
		
		State inicio = new State("0");
		State fim = new State("1");
		
		FSM resposta = new FSM();
		resposta.addState(inicio);
		resposta.addState(fim);
		resposta.addFinalState(fim);
		resposta.addFinalState(inicio);
		resposta.setStart(inicio);
		
		Argument arg = null;
		for(Argument a : ps.getArgument())
		{
			if(a instanceof PickleTable)
			{
				arg = a;
			}
		}
		
		PickleTable table = (PickleTable) arg;
		
		for(int a=1; a<table.getRows().size(); a++)
		{
			PickleRow tr = table.getRows().get(a);
			
			PickleCell pc = tr.getCells().get(0);
			
			String input = Contexto.getContext().getLinguagem().converter(this, field, pc.getValue());
			Transition tran = new Transition(inicio, fim, input);
			resposta.addTransition(tran);
		}
		
		return new Tupla<FSM, State>(resposta, fim);
	}

}
