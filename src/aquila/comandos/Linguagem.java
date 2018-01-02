package aquila.comandos;

public interface Linguagem {

	public String converter(ComandosAquila ca, String valor);
	public String converter(ComandosAquila ca, String campo, String valor);
}
