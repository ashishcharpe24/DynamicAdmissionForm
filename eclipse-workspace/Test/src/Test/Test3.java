package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//readPropertyFile();
//		FileInputStream file = new FileInputStream("C:\\Users\\acharpe\\eclipse-workspace\\Test\\Test.properties");
//		Properties prop = new Properties();
////		prop.load(file);
//		String a = "Ashish";
//		prop.setProperty("Name", a);
//		prop.store(new FileWriter("Test.properties"), "write");
//	}

//	public static void readPropertyFile() throws IOException
//	{
//		FileInputStream file = new FileInputStream("C:\\Users\\acharpe\\eclipse-workspace\\Test\\Test.properties");
//		Properties prop = new Properties();
//		prop.load(file);
//		String a = "Null";
//		prop.setProperty("Name", a);
//	
//	
		WebDriverManager.chromedriver().setup();
		ChromeOptions sslerr = new ChromeOptions();
		sslerr.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(sslerr);
		driver.manage().window().maximize();
		driver.get("https://10.200.102.40/#/?campus=Miners");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='userId']")).sendKeys("Neetat");
		driver.findElement(By.id("userPassword")).sendKeys("1550675697553722301");
		driver.findElement(By.xpath("//input[@class='blue-btn']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='POS']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Book Shop (Daily Sale)']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Online Order details New']")).click();
		Thread.sleep(3000);
		WebElement frm = driver.findElement(By.xpath("//iframe[@id='iframe']"));
		driver.switchTo().frame(frm);
		Select selLOc=new Select(driver.findElement(By.xpath("//select[@name='ddLocation']")));
		selLOc.selectByVisibleText("Surat");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Click to Hide Search']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='chkByClass']")).click();
		Thread.sleep(2000);
		
		WebElement classesSel = driver.findElement(By.xpath("//select[@name='ddlClass']"));
		List<WebElement> classes = driver.findElements(By.xpath("//select[@name='ddlClass']"));
		Select selClss=new Select(classesSel);
		System.out.println(classes.size());
		
		selClss.selectByVisibleText("Pre Nursery");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='chkBySection']")).click();
		Thread.sleep(2000);
		WebElement section = driver.findElement(By.xpath("//select[@name='ddlClassSection']"));
		Thread.sleep(2000);
		List<WebElement> sections = driver.findElements(By.xpath("//select[@name='ddlClassSection']"));
		Thread.sleep(2000);
		Select selSect=new Select(section);
		Thread.sleep(2000);
		System.out.println(sections.size());
		for(int i=0;i<sections.size();i++)
		{
			Thread.sleep(2000);
			WebElement a = selSect.getFirstSelectedOption();
			System.out.println(a.getText());
			if(a.isSelected())
			{
				break;
			}
			else
			{
				selSect.selectByVisibleText(sections.get(i).getText());
				Thread.sleep(2000);
			}
//			selSect.selectByVisibleText(sections.get(i).getText());
			//Thread.sleep(2000);
		}
		}
	}
		
		
		
//		driver.findElement(By.xpath(""))
//		driver.findElement(By.xpath(""))
//		driver.findElement(By.xpath(""))
//		driver.findElement(By.xpath(""))
//		driver.findElement(By.xpath(""))
//		driver.findElement(By.xpath(""))
//		driver.findElement(By.xpath(""))
//		driver.findElement(By.xpath(""))
//		driver.findElement(By.xpath(""))
//		driver.findElement(By.xpath(""))
//		driver.findElement(By.xpath(""))
//		driver.findElement(By.xpath(""))
		
		
		
	
		
		
		
	

