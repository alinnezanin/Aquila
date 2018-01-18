package aquila.comandos;

import java.util.List;

//Interface que deve ser utilizada para cada framework que sera suportado pelo aquila
// basiciamente um mapeamento do comando auqila e o codigo que deve ser gerado. Em alguns casos deve ser enviado campos
// e valores junto. 
public interface Linguagem {

	public String converter(ComandosAquila ca, String valor);
	public String converter(ComandosAquila ca, String campo, String valor);
	public String gerarCodigo(List<List<String>> sequencias);
}
