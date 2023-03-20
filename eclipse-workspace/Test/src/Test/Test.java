package Test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {
	//For 1 optional subject and no optional subject
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		Test test = new Test();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(opt);
		driver.get("https://10.200.102.40");
		driver.manage().window();
		driver.findElement(By.xpath("//input[@name='userId']")).sendKeys("Amit48363");//Omendra10, Test49347,Amit48363
		driver.findElement(By.id("userPassword")).sendKeys("2C727EE0AF");//giis123,94536FAAF0,2C727EE0AF
		driver.findElement(By.xpath("//span[@title='Select Campus']")).click();
		List<WebElement> availableCampuses = driver.findElements(By.xpath("//ul[@id='select2-select-campus-login-results']//li"));
		List<WebElement> listOfCampus = availableCampuses;
		  
		 // Iterator itr = listOfCampus.iterator();
		  Actions act =new Actions(driver);
		
		  for(int i=0;i<=listOfCampus.size();i++)
		  {
			  
			  String temp = listOfCampus.get(i).getText();
			  
			 String req = "PG-SmartCampus";
			  if(temp.equals(req))
			  {
				  act.sendKeys(Keys.ENTER).build().perform();
				  break;
			  }
			  act.sendKeys(Keys.ARROW_DOWN).build().perform();
		  }
		  
		driver.findElement(By.xpath("//input[@class='blue-btn']")).click();
		//driver.findElement(By.xpath("//input[@name='userId']"));
		Thread.sleep(2000);
		WebElement a = driver.findElement(By.xpath("//p[text()='Book set for 2022-2023 is available for purchase.']"));// also give the condition for next session sale 
		String actual = a.getText();
		System.out.println(actual);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//h4[@class='reminders-ico']")) );
//		
		//if()
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@id='collapsible']")).click();
		driver.findElement(By.xpath("//h4[text() = 'Book Sale']//following-sibling::a")).click();
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//a[text()='Catalogue']")) );
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary customAddToCart customBottomPaddingToTheButton']//h6[text()='More Details']")).click();
		Thread.sleep(2000);
		String optionalSub = "";//This value will come from excel
////		String optionalSub2 = "G-I";
////		List<WebElement> subjects = driver.findElements(By.xpath("//tbody/tr"));
////		Iterator<WebElement> it = subjects.iterator();
////		while(it.hasNext())
////		{
////			WebElement x = it.next();
////			String y = x.getText();
////			//System.out.println(y);
//		//if(y.equalsIgnoreCase("II LANG-HINDI"))
////			if(y.equalsIgnoreCase(optionalSub))
////			{
////				test.forHindi();
////				break;
////				//System.out.println(y);
////			}
////			else if(y.equalsIgnoreCase(optionalSub))
////			{
////				test.forTamil();
////				break;
////			}
////			else if(y.contains("II lang-French"))
////			{
////				test.forFrench();
////				break;
////			}
////		}
////		for(int i=0;i<1;i++)
////		{
////			String z = subjects.get(i).getText();
////			System.out.println(z);
////			String langOpt = "II LANG-HINDI\r\n"
////					+ "";
////			if(z.contains("Hindi"))
////			{
////			  
////			   //test.forHindi();
////			   System.out.println("GENERAL\r\n"
////			   		+ "INFORMATION TECHNOLOGY -9");
////			}
//		 if(optionalSub.equalsIgnoreCase("Hindi"))
//		 {
//			 test.forHindi();
//			 
//		 }
//		 else  if(optionalSub.equalsIgnoreCase("French"))
//		 {
//			 test.forFrench();
//		 }
//		 else  if(optionalSub.equalsIgnoreCase("Tamil"))
//		 {
//			 test.forTamil();
//		 }
//		
//	
////	 if(optionalSub2.equalsIgnoreCase("G-I"))
////	 {
////		 test.forHindi();
////		 
////	 }
////	 else  if(optionalSub2.equalsIgnoreCase("G-II"))
////	 {
////		 test.forFrench();
////	 }
////	 else  if(optionalSub2.equalsIgnoreCase("G-III"))
////	 {
////		 test.forTamil();
////	 }
////	 else  if(optionalSub2.equalsIgnoreCase("G-IV"))
////	 {
////		 test.forTamil();
////	 }
//	
//		 driver.findElement(By.xpath("//button[text()='Add To Cart']")).click();
//		 Thread.sleep(5000);// need give explicit wait
//		 driver.findElement(By.xpath("//button[text()='Proceed']")).click();
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@placeholder='Enter city name.']")).sendKeys("asdfg");
//		 driver.findElement(By.xpath("//input[@placeholder='Enter zip code.']")).clear();
//		 driver.findElement(By.xpath("//input[@placeholder='Enter zip code.']")).sendKeys("1234567");
//		 driver.findElement(By.xpath("//input[@id='termAndCondition']")).click();
//		 driver.findElement(By.xpath("//button[text()='Proceed to pay']")).click();
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//button[text()='Accept']")).click();
//		 Thread.sleep(40000);
//		 WebElement frame = driver.findElement(By.xpath("//iframe[@name='stripe_checkout_app']"));
//		 driver.switchTo().frame(frame);
//		 driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4242");
//		 driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4242");
//		 driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4242");
//		 driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4242");
//		 Thread.sleep(1000);
//		 driver.findElement(By.xpath("//input[@placeholder='MM / YY']")).sendKeys("01");
//		 driver.findElement(By.xpath("//input[@placeholder='MM / YY']")).sendKeys("24");
//		 Thread.sleep(1000);
//		 
//		driver.findElement(By.xpath("//input[@placeholder='CVC']")).sendKeys("123");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//span[@class='iconTick']")).click();
//		 
//	
//	
//	}
//	
//	//g1 //input[@id='groupCheck-2']
//	
//	public void forHindi()
//	{
//		driver.findElement(By.xpath("//input[@id='groupCheck-3']")).click();
//	}
//	public void forFrench()
//	{
//		driver.findElement(By.xpath("//input[@id='groupCheck-2']")).click();
//	}
//	public void forTamil()
//	{
//		driver.findElement(By.xpath("//input[@id='groupCheck-4']")).click();
//	}
//	
////	public void forg1()
////	{
////		driver.findElement(By.xpath("//input[@id='groupCheck-2']")).click();
////	}
////	public void forg2()
////	{
////		driver.findElement(By.xpath("//input[@id='groupCheck-3']")).click();
////	}
////	public void forg3()
////	{
////		driver.findElement(By.xpath("//input[@id='groupCheck-4']")).click();
////	}
}}
