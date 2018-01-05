package aquila.comandos;

import java.util.List;

public class Selenium implements Linguagem {

	@Override
	public String converter(ComandosAquila ca, String valor) {

		if(ca instanceof Driver)return "driver.get(" + valor + ");\n";
		if(ca instanceof Click)return String.format("WebElement click = driver.findElement(By.name(\"%s\"));\n"
				+ "click.click();\n", valor);
		if(ca instanceof Link)return String.format("WebElement click = driver.findElement(By.partialLinkText(\"%s\"));\n"
				+ "click.click();\n", valor);
		if(ca instanceof DontFillOut)return String.format("WebElement field= driver.findElement(By.name(\"%s\"));\n"
				+ "field.sendKey(“”);\n", valor);
		if(ca instanceof Enable)return "WebElement d = driver.findElement(By.name(\"firstname\"));\nboolean enable = d.isEnabled();\n"
				+ "	assertEquals(true, enable);\n";
		if(ca instanceof Disable)return "WebElement d = driver.findElement(By.name(\"firstname\"));\nboolean enable = d.isEnabled();\n"
				+ "	assertEquals(false, enable);\n";
		
		
		return null;
	}

	@Override
	public String converter(ComandosAquila ca, String campo, String valor) {
		if(ca instanceof Put)return String.format("WebElement field= driver.findElement(By.name(\"%s\"));\n"
				+ "field.sendKey(\"%s\");\n", campo, valor);
		if(ca instanceof UseValidData)return String.format("WebElement field= driver.findElement(By.name(%s));\nif(field.getTagName().equals(“input”) && field.getAttribute(\"type\").equals(\"text\"))\n"
			+	"{\n\tfield.sendKey(%s)\n}\nelse if(field.getTagName().equals(\"input\") && field.getAttribute(\"type\").equals(\"radio\"))\n{\n"
			+	"\tfield.click();\n}\nelse\n{\n\tSelect dropdown = new Select(driver.findElement(By.name(%s)));\n\tdropdown.selectByIndex(0);\n}\n\n", campo, valor, valor);
		if(ca instanceof SelectData)return String.format("Select dropdown = new Select(driver.findElement(By.name(\"%s\")));\n"
				+ "dropdown.selectByVisibleText(\"%s\");\n", campo, valor);
		return null;
	}

	@Override
	public String gerarCodigo(List<List<String>> sequencias) {
		int contador = 1;
		StringBuilder resposta = new StringBuilder();
		
		//Cabecalho do arquivo
		resposta.append("Webdriver driver;\n@Before\npublic void setUp() {\n//setando o caminho do gecko\n"
				+ "\tSystem.setProperty(\"webdriver.gecko.driver\", \"C:\\Eclipse\\geckodriver.exe\");\n"
				+ "//instanciando o firefox\n\tdriver = new FirefoxDriver();\n}\n\n");
		
		for(List<String> ls : sequencias)
		{
			resposta.append("@test\npublic void teste" + Integer.toString(contador) + "(){\n\t");
			for(String s : ls)
			{
				s =  s.replace("\n", "\n\t");
				resposta.append(s);				
			}
			resposta.append("\n}\n\n");
			contador++;
		}
		
		return resposta.toString();
	}
	
	
	
}
