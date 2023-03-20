	package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCalender2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://10.200.102.55/GIISAdm/AdmissionForm/");
		Thread.sleep(10000);
		WebElement country = driver.findElement(By.xpath("//select[@name='Country']"));
		Select conSel = new Select(country);
		conSel.selectByVisibleText("India");
		Thread.sleep(1000);
		
		WebElement Campus = driver.findElement(By.xpath("//select[@name='Campus']"));
		Select camSel = new Select(Campus);
		camSel.selectByVisibleText("Surat");
		Thread.sleep(2000);
		
		WebElement AdmissionFor = driver.findElement(By.xpath("//select[@name='AdmissionFor']"));
		Select admSel = new Select(AdmissionFor);
		admSel.selectByVisibleText("2022-2023");
		Thread.sleep(1000);
		
		WebElement firstName = driver.findElement(By.xpath("//input[@name='FatherFirstName']"));
		//firstName.sendKeys(adf.readProprtyFile("FatherFirstName"));
		firstName.sendKeys("TestAAA");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@name='FatherLastName']"));
		//lastName.sendKeys(adf.readProprtyFile("FatherLastName"));
		lastName.sendKeys("Father");
		
		WebElement eMail = driver.findElement(By.xpath("//input[@name='FatherEmailAddress']"));
		//eMail.sendKeys("abc@test.com");
		eMail.sendKeys("Father@test.com");
		
		WebElement mobNum = driver.findElement(By.xpath("//input[@name='FatherhMobileNumber']"));
		//mobNum.sendKeys(adf.readProprtyFile("FatherhMobileNumber"));
		mobNum.sendKeys("1234567889");
		
		WebElement fatherRadBtn = driver.findElement(By.xpath("//input[@value='Father']"));
		WebElement motherRadBtn = driver.findElement(By.xpath("//input[@value='Mother']"));
		String parent="Father";
		if(parent.equalsIgnoreCase("Father"))
		{
			fatherRadBtn.click();
		}
		else if(parent.equalsIgnoreCase("Mother"))
		{
			motherRadBtn.click();
		}
		
		WebElement saveAndContBtn = driver.findElement(By.xpath("//button[@id='SaveAndContinueButtonPageOne']"));
		saveAndContBtn.click();
		
		Thread.sleep(10000);
		 driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[1]")).click();
		 Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@id,'datepicker')]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[contains(@id,'datepicker')]")).click();
		 Thread.sleep(2000);
		// List<WebElement> years = driver.findElements(By.xpath("//tbody//tr//td//button//span"));
		 List<WebElement> years = driver.findElements(By.xpath("//tbody//tr//td//button//span"));
		 
		 String dateOfBirthFather = "02-January-2001";
		 Thread.sleep(2000);
		 String[] dateSplit =  dateOfBirthFather.split("-");
		 String yearExp = dateSplit[2];
		 String monthExp=dateSplit[1];
		 String dateExp=dateSplit[0];
		 int yearMatched=0;
		 for(int i=0;(i<5) &&  yearMatched<=0 ;i++)
		 {
			 for(int j=0;(j<years.size()) && yearMatched<=0;j++)
			 {
			 years = driver.findElements(By.xpath("//tbody//tr//td//button//span"));
//			 Thread.sleep(2000);
			 String year = years.get(j).getText();
			 System.out.println(year);
//			 Thread.sleep(2000);
			
			 if(yearExp.equalsIgnoreCase(year))
			 {
				 yearMatched=1;
				 years.get(j).click();
				 //stop = true;
				 break;
			 }
			 }
			 if(yearMatched==0)
			 {
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-chevron-left']")).click();
				// break;
			 }
			 
			 
		 }
		 
		 
		 driver.findElement(By.xpath("//span[text()='"+monthExp+"']")).click();
		 
		 driver.findElement(By.xpath("//tbody//tr//td//span[@class='ng-binding' and text()='"+dateExp+"']")).click();
		 
}	 
	}

