package aquila.comandos;

import java.util.List;

import aquila.Contexto;

public class Selenium implements Linguagem {

	@Override
	public String converter(ComandosAquila ca, String valor) {

		if(ca instanceof Driver)return "driver.get(" + valor + ");\n";
		if(ca instanceof Click)return String.format("WebElement click = driver.findElement(By.name(\"%s\"));\n"
				+ "click.click();\n", valor);
		if(ca instanceof Link)return String.format("WebElement click = driver.findElement(By.partialLinkText(\"%s\"));\n"
				+ "click.click();\n", valor);
		if(ca instanceof DontFillOut)return String.format("WebElement field= driver.findElement(By.name(\"%s\"));\n"
				+ "field.sendKey(��);\n", valor);
		if(ca instanceof Enable)return String.format("WebElement d = driver.findElement(By.name(\"%s\"));\nboolean enable = d.isEnabled();\n"
				+ "	assertEquals(true, enable);\n",valor);
		if(ca instanceof Disable)return String.format("WebElement d = driver.findElement(By.name(\"%s\"));\nboolean enable = d.isEnabled();\n"
				+ "	assertEquals(false, enable);\n", valor);
		if(ca instanceof Showed)return String.format("assertEquals(true, driver.getPageSource().contains(\"%s\"));\n", valor);
                
                if(ca instanceof ShowedTitle)return String.format("assertEquals(true, driver.gettitle().contains(\"%s\"));\n", valor);

		if(ca instanceof Opened)return String.format("assertEquals(\"%s\", driver.getCurrentUrl());\n",valor);
		if(ca instanceof MouseOver)return String.format("field = driver.findElement(By.linkText(\"%s\"));\naction = new Actions(driver);\naction.moveToElement(element).build().perform();\n", valor);
		
		return null;
	}

	@Override
	public String converter(ComandosAquila ca, String campo, String valor) {
		if(ca instanceof Put)return String.format("\\nWebElement field= driver.findElement(By.name(\"%s\"));\n"
				+ "field.sendKey(\"%s\");\n", campo, valor);
		if(ca instanceof UseValidData)return String.format(	"list = driver.findElements(By.name(\"%s\"));\nfield = list.get(0);\nvalor = (\"%s\");\n\nif(field.getTagName().equals(\"input\") && (field.getAttribute(\"type\").equals(\"text\")  || field.getAttribute(\"type\").equals(\"password\") || field.getAttribute(\"type\").equals(\"Date\") ||  field.getAttribute(\"type\").equals(\"datetime-local\") || field.getAttribute(\"type\").equals(\"email\") || field.getAttribute(\"type\").equals(\"month\") || field.getAttribute(\"type\").equals(\"number\")))\n{\n\tfield.sendKey(field);\n}\nelse if(field.getTagName().equals(\"input\") && field.getAttribute(\"type\").equals(\"radio\"))\n{\n\t field.click();\n}\nelse if(field.getTagName().equals(\"input\") && field.getAttribute(\"type\").equals(\"checkbox\"))\n{\n\tList<String> valores = valor.split(\"&\");\n\tfor(WebElement wb : list)\n\t{\n\t\tfor(String s : valores)\n\t\t{\n\t\tif(wb.getAttribute(\"value\").equals(s))\n\t\t\t{\n\t\t\t\twb.click();\n\t\t\t}\n\t\t}\n\t}\n}\nelse\n{\n\tSelect dropdown = new Select(field);\n\tdropdown.selectByIndex(0);\n}\n\n"
, campo, valor);
		if(ca instanceof SelectData)return String.format("\nSelect dropdown = new Select(driver.findElement(By.name(\"%s\")));\n"
				+ "dropdown.selectByVisibleText(\"%s\");\n", campo, valor);
		if(ca instanceof Checked)return String.format("\nfield = driver.findElement(By.name(\"%s\");\nvalor = \"%s\";\n\nif(field.getTagName().equals(\"input\") && field.getAttribute(\"type\").equals(\"radio\"))\n{\n\tfield.click();\n}\nelse if(field.getTagName().equals(\"input\") && field.getAttribute(\"type\").equals(\"checkbox\"))\n{\n\tList<String> valores = valor.split(\"&\");\n\tfor(WebElement wb : list)\n\t{\n\t\tfor(String s : valores)\n\t\t{\n\t\t\tif(wb.getAttribute(\"value\").equals(s))\n\t\t\t{\n\t\t\twb.click();\n\t\t}\n\t}\n}\n}" ,campo, valor);
		if(ca instanceof Choose) return String.format("\nfield = driver.findElement(By.name(\"%s\");\nvalor = \"%s\";\n\nif(field.getTagName().equals(\"input\") && field.getAttribute(\"type\").equals(\"radio\"))\n{\n\tfield.click();\n}\nelse if(field.getTagName().equals(\"input\") && field.getAttribute(\"type\").equals(\"checkbox\"))\n{\n\tList<String> valores = valor.split(\"&\");\n\tfor(WebElement wb : list)\n\t{\n\t\tfor(String s : valores)\n\t\t{\n\t\t\tif(wb.getAttribute(\"value\").equals(s))\n\t\t\t{\n\t\t\twb.click();\n\t\t}\n\t}\n}\n}" ,campo, valor);
		if(ca instanceof ShowedIn)return String.format("\nPattern p = Pattern.compile(\"(.*<.*>.*)*<.*name=\"%s\".*>(.*<.*>.*)*%s\");\nMatcher m = p.matcher(driver.getPageSource());\nassert(true,m.find());\n", campo, valor);
                return null;
	}

	@Override
	public String gerarCodigo(List<List<String>> sequencias) {
		int contador = 1;
		StringBuilder resposta = new StringBuilder();
				
		//Cabecalho do arquivo
		resposta.append("Webdriver driver;\nList<WebElements> list;\nWebElement field;\nString valor;\nActions action;\n\n\n@Before\npublic void setUp(){\n\t//setando o caminho do gecko\n"
				+ "\tSystem.setProperty(\"webdriver.gecko.driver\", \"C:\\Eclipse\\geckodriver.exe\");\n"
				+ "\t//instanciando o firefox\n\tdriver = new FirefoxDriver();\n}\n\n");
		
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
	
	public String gerarBiblioteca()
	{
		StringBuilder resposta = new StringBuilder();
		resposta.append("public Class AquilaBib{\n\n");
		for(String s :Contexto.getContext().listaMetodos())
		{
			resposta.append("\tpublic static void " + s.substring(0, s.length()-2) + "\n");
			resposta.append("\t{\n");
			resposta.append("\t\t//TO DO\n");
			resposta.append("\t}\n\n");
		}
		
		resposta.append("\n}");
		
		return resposta.toString();
	}
	
	

	

	
	

	
	
	
	
	
}
