package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Test2 {
//For two optional subjects 
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
			Test2 test = new Test2();
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(opt);
			driver.get("https://10.200.102.40");
			driver.manage().window();
			driver.findElement(By.xpath("//input[@name='userId']")).sendKeys("Amit48363");//Amit48363
			driver.findElement(By.id("userPassword")).sendKeys("2C727EE0AF");//2C727EE0AF
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
			String optionalSub = "hindi";//This value will come from excel
			String optionalSub2 = "G-I";
			 if(optionalSub.equalsIgnoreCase("Hindi"))
			 {
				 test.forHindi();
				 
			 }
			 else  if(optionalSub.equalsIgnoreCase("French"))
			 {
				 test.forFrench();
			 }
			 else  if(optionalSub.equalsIgnoreCase("Tamil"))
			 {
				 test.forTamil();
			 }
			
		
		 if(optionalSub2.equalsIgnoreCase("G-I"))
		 {
			 test.forg1();
			 
		 }
		 else  if(optionalSub2.equalsIgnoreCase("G-II"))
		 {
			 test.forg2();
		 }
		 else  if(optionalSub2.equalsIgnoreCase("G-III"))
		 {
			 test.forg3();
		 }
		 else  if(optionalSub2.equalsIgnoreCase("G-IV"))
		 {
			 test.forg4();
		 }
		
			 driver.findElement(By.xpath("//button[text()='Add To Cart']")).click();
			 Thread.sleep(5000);// need give explicit wait
			 driver.findElement(By.xpath("//button[text()='Proceed']")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@placeholder='Enter city name.']")).sendKeys("asdfg");
			 driver.findElement(By.xpath("//input[@placeholder='Enter zip code.']")).clear();
			 driver.findElement(By.xpath("//input[@placeholder='Enter zip code.']")).sendKeys("1234567");
			 driver.findElement(By.xpath("//input[@id='termAndCondition']")).click();
			 driver.findElement(By.xpath("//button[text()='Proceed to pay']")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//button[text()='Accept']")).click();
			 Thread.sleep(40000);
			 WebElement frame = driver.findElement(By.xpath("//iframe[@name='stripe_checkout_app']"));
			 driver.switchTo().frame(frame);
			 driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4242");
			 driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4242");
			 driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4242");
			 driver.findElement(By.xpath("//input[@id='card_number']")).sendKeys("4242");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@placeholder='MM / YY']")).sendKeys("01");
			 driver.findElement(By.xpath("//input[@placeholder='MM / YY']")).sendKeys("24");
			 Thread.sleep(1000);
			 
			driver.findElement(By.xpath("//input[@placeholder='CVC']")).sendKeys("123");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[@class='iconTick']")).click();
			 
	}
		
		
		//g1 //input[@id='groupCheck-2']
		
		public void forHindi()
		{
			driver.findElement(By.xpath("//input[@id='groupCheck-7']")).click();
		}
		public void forFrench()
		{
			driver.findElement(By.xpath("//input[@id='groupCheck-6']")).click();
		}
		public void forTamil()
		{
			driver.findElement(By.xpath("//input[@id='groupCheck-8']")).click();
		}
		
		public void forg1()
		{
			driver.findElement(By.xpath("//input[@id='groupCheck-2']")).click();
		}
		public void forg2()
		{
			driver.findElement(By.xpath("//input[@id='groupCheck-3']")).click();
		}
		public void forg3()
		{
			driver.findElement(By.xpath("//input[@id='groupCheck-4']")).click();
		}
		public void forg4()
		{
			driver.findElement(By.xpath("//input[@id='groupCheck-5']")).click();
		}
		
		
}


