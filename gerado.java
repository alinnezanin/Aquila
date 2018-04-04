Webdriver driver;
List<WebElements> list;
WebElement field;
String valor;
Actions action;


@Before
public void setUp(){
	//setando o caminho do gecko
	System.setProperty("webdriver.gecko.driver", "C:\Eclipse\geckodriver.exe");
	//instanciando o firefox
	driver = new FirefoxDriver();
}

@test
public void teste1(){
	WebElement click = driver.findElement(By.name("aaa"));
	click.click();
	AquilaBib.Parte_2();
	AquilaBib.Parte_3();
	AquilaBib.Parte_4();
	AquilaBib.Parte_5();
	
}

@test
public void teste2(){
	WebElement click = driver.findElement(By.name("aaa"));
	click.click();
	\nlist = driver.findElements(By.name("cabecalho"));
	field = list.get(0);
	valor = ("João");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	\nlist = driver.findElements(By.name("cabecalho2"));
	field = list.get(0);
	valor = ("12");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	AquilaBib.Parte_7();
	AquilaBib.Parte_8();
	\nlist = driver.findElements(By.name("cabecalho"));
	field = list.get(0);
	valor = ("A1");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	\nlist = driver.findElements(By.name("cabecalho2"));
	field = list.get(0);
	valor = ("A2");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	
}

@test
public void teste3(){
	WebElement click = driver.findElement(By.name("aaa"));
	click.click();
	\nlist = driver.findElements(By.name("cabecalho"));
	field = list.get(0);
	valor = ("João");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	\nlist = driver.findElements(By.name("cabecalho2"));
	field = list.get(0);
	valor = ("12");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	AquilaBib.Parte_7();
	AquilaBib.Parte_8();
	\nlist = driver.findElements(By.name("cabecalho"));
	field = list.get(0);
	valor = ("R1");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	\nlist = driver.findElements(By.name("cabecalho2"));
	field = list.get(0);
	valor = ("R2");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	
}

@test
public void teste4(){
	WebElement click = driver.findElement(By.name("aaa"));
	click.click();
	\nlist = driver.findElements(By.name("cabecalho"));
	field = list.get(0);
	valor = ("Maria");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	\nlist = driver.findElements(By.name("cabecalho2"));
	field = list.get(0);
	valor = ("13");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	AquilaBib.Parte_7();
	AquilaBib.Parte_8();
	\nlist = driver.findElements(By.name("cabecalho"));
	field = list.get(0);
	valor = ("A1");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	\nlist = driver.findElements(By.name("cabecalho2"));
	field = list.get(0);
	valor = ("A2");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	
}

@test
public void teste5(){
	WebElement click = driver.findElement(By.name("aaa"));
	click.click();
	\nlist = driver.findElements(By.name("cabecalho"));
	field = list.get(0);
	valor = ("Maria");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	\nlist = driver.findElements(By.name("cabecalho2"));
	field = list.get(0);
	valor = ("13");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	AquilaBib.Parte_7();
	AquilaBib.Parte_8();
	\nlist = driver.findElements(By.name("cabecalho"));
	field = list.get(0);
	valor = ("R1");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	\nlist = driver.findElements(By.name("cabecalho2"));
	field = list.get(0);
	valor = ("R2");
	
	if(field.getTagName().equals("input") && (field.getAttribute("type").equals("text")  || field.getAttribute("type").equals("password") || field.getAttribute("type").equals("Date") ||  field.getAttribute("type").equals("datetime-local") || field.getAttribute("type").equals("email") || field.getAttribute("type").equals("month") || field.getAttribute("type").equals("number")))
	{
		field.sendKey(field);
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		 field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
			if(wb.getAttribute("value").equals(s))
				{
					wb.click();
				}
			}
		}
	}
	else
	{
		Select dropdown = new Select(field);
		dropdown.selectByIndex(0);
	}
	
	
}

@test
public void teste6(){
	WebElement click = driver.findElement(By.name("aaa"));
	click.click();
	AquilaBib.P1();
	WebElement click = driver.findElement(By.name("aaa"));
	click.click();
	AquilaBib.Parte_2();
	AquilaBib.Parte_3();
	AquilaBib.Parte_4();
	AquilaBib.Parte_5();
	AquilaBib.p3();
	
	field = driver.findElement(By.name("checkbox");
	valor = "Checkbox2";
	
	if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
				if(wb.getAttribute("value").equals(s))
				{
				wb.click();
			}
		}
	}
	}
	assertEquals(true, Driver.getPageSource().contains("bla bla bla"));
	
}

@test
public void teste7(){
	WebElement click = driver.findElement(By.name("aaa"));
	click.click();
	AquilaBib.P1();
	WebElement click = driver.findElement(By.name("aaa"));
	click.click();
	AquilaBib.Parte_2();
	AquilaBib.Parte_3();
	AquilaBib.Parte_4();
	AquilaBib.Parte_5();
	AquilaBib.p3();
	
	field = driver.findElement(By.name("checkbox");
	valor = "Checkbox1 & Checkbox2";
	
	if(field.getTagName().equals("input") && field.getAttribute("type").equals("radio"))
	{
		field.click();
	}
	else if(field.getTagName().equals("input") && field.getAttribute("type").equals("checkbox"))
	{
		List<String> valores = valor.split("&");
		for(WebElement wb : list)
		{
			for(String s : valores)
			{
				if(wb.getAttribute("value").equals(s))
				{
				wb.click();
			}
		}
	}
	}
	assertEquals(true, Driver.getPageSource().contains("bla bla bla"));
	
}

