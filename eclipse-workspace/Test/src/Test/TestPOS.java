package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPOS {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://10.200.102.40");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='userId']")).sendKeys("Sanjeev");
		driver.findElement(By.id("userPassword")).sendKeys("giis123");
		driver.findElement(By.xpath("//span[@title='Select Campus']")).click();
		List<WebElement> availableCampuses = driver.findElements(By.xpath("//ul[@id='select2-select-campus-login-results']//li"));
		List<WebElement> listOfCampus = availableCampuses;
		  
		 // Iterator itr = listOfCampus.iterator();
		  Actions act =new Actions(driver);
		
		  for(int i=0;i<=listOfCampus.size();i++)
		  {
			  
			  String temp = listOfCampus.get(i).getText();
			  
			 String req = "Tokyo-Nishikasai";
			  if(temp.equals(req))
			  {
				  act.sendKeys(Keys.ENTER).build().perform();
				  break;
			  }
			  act.sendKeys(Keys.ARROW_DOWN).build().perform();
		  }
		  
		driver.findElement(By.xpath("//input[@class='blue-btn']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[text()='POS']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Book Shop (Daily Sale)(A)']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Online Order Detail']")).click();
		Thread.sleep(15000);
		
		//driver.findElement(By.xpath("//input[@name='userId']"));
		
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='iframe']"));
		driver.switchTo().frame(frame);
		List<WebElement> table = driver.findElements(By.xpath("//tr[@class='gridViewRow']"));
		System.out.println("for loop");
		Thread.sleep(5000);
		//int i =1;
		//Thread.sleep(2000);
		//WebElement a = driver.findElement(By.xpath("//a[@id='gdParentOrderDetailList_lnkView_"+i+"']"));//tr[@class='gridViewRow']
		//System.out.println(a.getText());
		//Thread.sleep(2000);
		for(int i=0;i<table.size();i++)
		{
			WebElement a = driver.findElement(By.xpath("//tr[@class='gridViewRow']//a[@id='gdParentOrderDetailList_lnkView_"+i+"']"));
			//System.out.println("for loop");
			//System.out.println(a.getText());
			 String transNumber = "TKOS2200388";
			if(a.getText().equals(transNumber))
				//if(a.getText().equals(from property file))
			{
				int c=i+1;
				WebElement b = driver.findElement(By.xpath("(//a[@id='lnkEnquiry'])"+"["+c+"]"));
				//driver.findElement(By.xpath("(//a[@id='lnkEnquiry'])[20]"));
				System.out.println(b.getText());
				Thread.sleep(2000);
				b.click();
				
				
				
				
				
				Thread.sleep(2000);
				WebElement iframe = driver.findElement(By.xpath("//iframe[@src='UpdateOrderStatus.aspx?resno="+transNumber+"&CollectionStatusVal=-1#top']"));
			    driver.switchTo().frame(iframe);
			   
			    WebElement preparingToShipBtn = driver.findElement(By.xpath("//input[@value='Preparing to Ship']"));
				if(preparingToShipBtn.getAttribute("Value").equals("Preparing to Ship"))
				{
					
					Thread.sleep(2000);
					WebElement remarks1 = driver.findElement(By.xpath("//textarea[@name='txtRemarks']"));
					Thread.sleep(2000);
					remarks1.sendKeys("Test Ok Preparing to Ship");
					Thread.sleep(2000);
					preparingToShipBtn.click();
				 
				}
				else 
				{
					System.out.println("Button name not matched");
				}
				
			    
//			    WebElement deliveredBtn = driver.findElement(By.xpath("//input[@value='Delivered']"));
//				if(deliveredBtn.getAttribute("Value").equals("Delivered"))
//				{
//					
//					Thread.sleep(2000);
//					WebElement remarks1 = driver.findElement(By.xpath("//textarea[@name='txtRemarks']"));
//					Thread.sleep(2000);
//					remarks1.sendKeys("Test Ok Delivered");
//					Thread.sleep(2000);
//					deliveredBtn.click();
//				 
//				}
//				else 
//				{
//					System.out.println("Button name not matched");
//				}
//				
				
			}
			
			
			
		}
		
	}

}
