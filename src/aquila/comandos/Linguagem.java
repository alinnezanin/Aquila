package aquila.comandos;

import java.util.List;

public interface Linguagem {

	public String converter(ComandosAquila ca, String valor);
	public String converter(ComandosAquila ca, String campo, String valor);
	public String gerarCodigo(List<List<String>> sequencias);
}
