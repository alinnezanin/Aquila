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

public class Put implements ComandosAquila {

	@Override
	public boolean verificar(PickleStep ps) {
		return ps.getText().matches(".*put\\[.*\\]$");
	}

	@Override
	public Tupla<FSM, State> processar(PickleStep ps) {
		
		Pattern p = Pattern.compile(".*put\\[.*\\]$");
		Matcher m = p.matcher(ps.getText());
		String campo  = "";
		
		if(!m.find())
		{
			System.err.println("Erro comando: " + ps.getText());
		}
		campo = m.group(1);
		
		Argument arg = null;
		for(Argument a : ps.getArgument())
		{
			if(a instanceof PickleTable)
			{
				arg = a;
			}
		}
		
		int contadorEstados = 0; //vai ser utilizado para os nomes dos estados
		State inicial = new State(Integer.toString(contadorEstados));

		
		State finalTabela = new State(Integer.toString(contadorEstados));

		
		FSM fsm = new FSM();
		fsm.addState(inicial);
		fsm.addFinalState(inicial);
		fsm.setStart(inicial);
		
		fsm.addState(finalTabela);
		fsm.addFinalState(finalTabela);
		
		
		PickleTable table = (PickleTable) arg;

		for(PickleRow tr : table.getRows())
		{

			PickleCell pc = tr.getCells().get(0);
				
			Transition trans = new Transition(inicial, finalTabela, Contexto.getContext().getLinguagem().converter(this, campo, pc.getValue()));
			fsm.addTransition(trans);				
		}
		return new Tupla<FSM, State>(fsm, finalTabela);
	}

}