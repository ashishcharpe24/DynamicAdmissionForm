package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCalendarForAdmiForm {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://harrods.myglobalschool.org/Adm/AdmissionForm/");
		Thread.sleep(10000);
		WebElement country = driver.findElement(By.xpath("//select[@name='Country']"));
		Select conSel = new Select(country);
		conSel.selectByVisibleText("Cambodia");
		Thread.sleep(1000);
		
		WebElement Campus = driver.findElement(By.xpath("//select[@name='Campus']"));
		Select camSel = new Select(Campus);
		camSel.selectByVisibleText("Harrods (RIS)");
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
		 boolean get=false;
		 for( int i=0;i<5;i++)
		 {
			 
			 years = driver.findElements(By.xpath("//tbody//tr//td//button//span"));
			 for(int j=0;j<years.size();j++)
			 {
			 
			 System.out.println(years.size());
			  
			 String actualYear = years.get(j).getText();
			 
			 if(actualYear.equals(yearExp))
			 {
				 get = true;
				// actualYear.click();
				 System.out.println(actualYear);
				 System.out.println(yearExp);
				 years.get(j).click();
				 Thread.sleep(2000);
				List<WebElement> actualMonths = driver.findElements(By.xpath("//tbody//tr//td"));
				Thread.sleep(2000);
				for(int k=0;k<actualMonths.size();k++)
				{
					 Thread.sleep(2000);
					String actualMonth = actualMonths.get(k).getText();
					 if(monthExp.equals(actualMonth))
					 {
						 actualMonths.get(k).click();
						 break;
					 }
				}
				
				Thread.sleep(2000);
				
				List<WebElement> actualDates = driver.findElements(By.xpath("//tbody//tr//td//span[@class='ng-binding']"));
				Thread.sleep(2000);
				for(int k=0;k<actualDates.size();k++)
				{
					 Thread.sleep(2000);
					String actualDate = actualDates.get(k).getText();
					 if(dateExp.equals(actualDate))
					 {
						 actualDates.get(k).click();
						 break;
					 }
				}
				
				 break;
			 }
			 
			 }
//			 
			 while(get==false)
			 {
				 driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-chevron-left']")).click();
				 break;
			 }
			 
			 
		 }
//		 WebElement year = driver.findElement(By.xpath("//span[text()='"+yearExp+"']"));
//		 year.click();
//			String dateOfBirthFather = "24-01-2000";
//			Thread.sleep(2000);
//			String[] dateSplit =  dateOfBirthFather.split("-");
//			Thread.sleep(2000);
//			String date = dateSplit[0];
//			Thread.sleep(1000);
//			String monthAndYear = (dateSplit[1]+" "+dateSplit[2]);
//			//System.out.println(monthAndYear);
//			WebElement currDate = driver.findElement(By.xpath("//strong[@class='ng-binding']"));
//			Thread.sleep(1000);
//			String actualMonthAndYear = currDate.getText();
//			Thread.sleep(1000);
//			//System.out.println(actualMonthAndYear);
//			
//			while(!monthAndYear.equals(actualMonthAndYear))
//			{
//				System.out.println("while loop");
//				driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-chevron-left']")).click();
//				Thread.sleep(1000);
//				actualMonthAndYear=currDate.getText();
//				Thread.sleep(1000);
//			}
//			
//			WebElement expDate=driver.findElement(By.xpath("//button//span[@class='ng-binding' and text()='"+date+"']"));
//			 expDate.click();
			// Thread.sleep(2000);

	}}


