package aquila;
import java.util.HashMap;
import java.util.Map;

import aquila.comandos.Linguagem;
import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Tupla;

public class Contexto {
	
	private static Contexto instance = null;
	private  Linguagem linguagem = null;
	
	Map<String, Tupla<FSM, State>> contexto;
	
	public static Contexto getContext()
	{
		if(instance == null) instance = new Contexto();
		return instance;
	}
	
	private Contexto()
	{
		contexto = new HashMap<String, Tupla<FSM, State>>();
	}
	
	public  Tupla<FSM, State> getFSM(String nome)
	{	
		return contexto.get(nome);
	}
	
	public  Tupla<FSM, State> addFSM(String nome, Tupla<FSM, State> tup)
	{
		return contexto.put(nome, tup);
	}

	public  Linguagem getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(Linguagem linguagem) {
		this.linguagem = linguagem;
	}
}
