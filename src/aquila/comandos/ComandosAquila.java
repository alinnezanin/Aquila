package aquila.comandos;



import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Tupla;
import gherkin.pickles.PickleStep;

//Todos comandos aquila devem implementar essa interface e serem adicionado na lista de comandos em APP
public interface ComandosAquila {
	
	// Verifica se a linha contem as palavras-chave do comando
	// recomendado  utilizar regex para identificar
	public boolean verificar(PickleStep ps);
	// devolve uma FSM e o ultimo estado dessa FSM
	public Tupla<FSM, State> processar(PickleStep ps);
	
}
