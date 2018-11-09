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
	driver.get(http://toolsqa.com/automation-practice-form/);
	\nlist = driver.findElements(By.name("firstname"));
	field = list.get(0);
	valor = ("Aline");
	
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
	
	\nlist = driver.findElements(By.name("lastname"));
	field = list.get(0);
	valor = ("Zanin");
	
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
	
	\nlist = driver.findElements(By.name("datepicker"));
	field = list.get(0);
	valor = ("09/10/1991");
	
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
	
	\nlist = driver.findElements(By.name("sex-0"));
	field = list.get(0);
	valor = ("sex-0");
	
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
	
	\nlist = driver.findElements(By.name("exp-0"));
	field = list.get(0);
	valor = ("exp-0");
	
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
	
	\nlist = driver.findElements(By.name("profession-0"));
	field = list.get(0);
	valor = ("profession-0");
	
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
	
	\nlist = driver.findElements(By.name("Selenium Automation Hybrid Framework"));
	field = list.get(0);
	valor = ("Selenium Automation Hybrid Framework");
	
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
	
	\nlist = driver.findElements(By.name("tool-0"));
	field = list.get(0);
	valor = ("tool-0");
	
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
	
	\nlist = driver.findElements(By.name("Africa"));
	field = list.get(0);
	valor = ("Africa");
	
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
	
	\nlist = driver.findElements(By.name("Switch Commands"));
	field = list.get(0);
	valor = ("Switch Commands");
	
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
	
	WebElement click = driver.findElement(By.name("submit"));
	click.click();
	
}

@test
public void teste2(){
	driver.get(http://toolsqa.com/automation-practice-form/);
	
	field = driver.findElement(By.name("profession");
	valor = "Automation Tester";
	
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
}

