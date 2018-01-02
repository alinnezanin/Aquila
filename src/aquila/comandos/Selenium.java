package aquila.comandos;

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
		if(ca instanceof SelectData)return String.format("Select dropdown = new Select(driver.findElement(By.name(\"%s\")));\n"
				+ "dropdown.selectByVisibleText(String text);\n", valor);
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
		if(ca instanceof UseValidData)return String.format("WebElement field= driver.findElement(By.name(\"%s\"));\n"
				+ "field.sendKey(\"%s\");\n", campo, valor);
		return null;
	}
}
