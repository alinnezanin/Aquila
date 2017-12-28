package aquila.comandos;



import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Tupla;
import gherkin.pickles.PickleStep;

public interface ComandosAquila {

	public boolean verificar(PickleStep ps);
	public Tupla<FSM, State> processar(PickleStep ps);
	
}
