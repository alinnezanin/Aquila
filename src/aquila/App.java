package aquila;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import aquila.algoritmos.BuscaProfundidade;
import aquila.comandos.*;
import aquila.estruturaDados.FSM;
import aquila.estruturaDados.State;
import aquila.estruturaDados.Transition;
import aquila.estruturaDados.Tupla;
import gherkin.AstBuilder;
import gherkin.Parser;
import gherkin.ast.GherkinDocument;
import gherkin.pickles.Compiler;
import gherkin.pickles.Pickle;
import gherkin.pickles.PickleStep;


public class App {

	public static void main(String[] args) {
		
		String arq = "cenario.txt";
			
		
		Scanner in = null;
		
		try
		{
			in = new Scanner(new FileInputStream(arq), "UTF-8");
		}
		catch(Exception e)
		{
			System.err.println("Erro na leitura do arquivo: " + arq);
		}
		StringBuilder sb = new StringBuilder();
		while(in.hasNextLine())
		{
			sb.append(in.nextLine() + "\n");
		}
		

		Parser<GherkinDocument> parser = new Parser<GherkinDocument>(new AstBuilder());
		GherkinDocument gd = parser.parse(sb.toString());
		List<Pickle> pickles = new Compiler().compile(gd);
		
		Contexto.getContext().setLinguagem(new Selenium());
		Contexto.getContext().setCobertura(new BuscaProfundidade());
		
		List<ComandosAquila> listaComandos = new LinkedList<ComandosAquila>();
		listaComandos.add(new UseValidData());
		listaComandos.add(new Extender());
		listaComandos.add(new Driver());
		listaComandos.add(new Click());
		listaComandos.add(new Link());
		listaComandos.add(new Put());
		listaComandos.add(new Disable());
		listaComandos.add(new DontFillOut());
		listaComandos.add(new Enable());
		listaComandos.add(new Open());
		listaComandos.add(new SelectData());
		listaComandos.add(new Showed());
		
				
		for(Pickle p : pickles)
		{
			int contadorEstados = 0; //vai ser utilizado para os nomes dos estados
			State inicial = new State(Integer.toString(contadorEstados));
			contadorEstados++;
			FSM fsm = new FSM();
			fsm.addState(inicial);
			fsm.addFinalState(inicial);
			fsm.setStart(inicial);
			
			State ultimoEstado = fsm.getStart();
			for(PickleStep ps: p.getSteps())
			{
				boolean pickleT = false;				
				for(ComandosAquila ca : listaComandos)
				{
					if(ca.verificar(ps))
					{
						pickleT = true;
						Tupla<FSM, State> temp = ca.processar(ps); // Gera uma FSM separada
						
						
						Tupla<FSM, State> tupla = FSM.unirFSM(fsm, temp.getPri(), ultimoEstado, temp.getSeg());
						fsm = tupla.getPri();
						
						ultimoEstado = tupla.getSeg();
						
						
						contadorEstados = Integer.parseInt(ultimoEstado.getName());
						contadorEstados++;
						break;
					}	
				}
				if(!pickleT) 
				{
					State novo = new State(Integer.toString(contadorEstados));
					contadorEstados++;
					fsm.addState(novo);
					fsm.addFinalState(novo);
					Transition trans = new Transition(ultimoEstado, novo, ps.getText());
					fsm.addTransition(trans);
					ultimoEstado = novo;
				}
			}

			fsm = FSM.removeNonDeterminism(fsm);
			Contexto.getContext().addFSM(p.getName(), new Tupla<FSM, State>(fsm, ultimoEstado));	
			System.out.println(fsm);
			
			List<List<String>> sequencias = Contexto.getContext().getCobertura().gerarSequencias(fsm);
			
			for(List<String> ls : sequencias)
			{
				System.out.println("Sequencia");
				for(String s : ls)
				{
					System.out.println(s);
				}
				System.out.println("\n\n\n");
			}
						
		}
		
	}
}
