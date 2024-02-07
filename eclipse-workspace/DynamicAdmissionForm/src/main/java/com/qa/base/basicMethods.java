package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basicMethods {
	
	public static WebDriver driver;
	
	public static String Readpropertyfile(String value) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\acharpe\\eclipse-workspace\\DynamicAdmissionForm\\config.properties");
		Properties prop = new Properties();
		prop.load(file);
		
		return prop.getProperty(value);
		
	}
	
	public static String ReadpropertyfileOfData(String value) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\acharpe\\eclipse-workspace\\DynamicAdmissionForm\\records.properties");
		Properties prop = new Properties();
		prop.load(file);
		
		return prop.getProperty(value);
		
	}
	
	public static void  Browserselection() throws IOException
	{
		String browserName = Readpropertyfile("Browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions sslerr = new ChromeOptions();
			sslerr.addArguments("--remote-allow-origins=*");
			sslerr.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(sslerr);
			driver.manage().deleteAllCookies();
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions sslerr = new EdgeOptions();
			sslerr.addArguments("--remote-allow-origins=*");
			sslerr.addArguments("--disable-popup-blocking");
			sslerr.setAcceptInsecureCerts(true);
			driver = new EdgeDriver(sslerr);
		}
		
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions sslerr = new FirefoxOptions();
			//sslerr.addArguments("--remote-allow-origins=*");
			//sslerr.addArguments("--disable-popup-blocking");
			sslerr.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(sslerr);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Readpropertyfile("URL"));
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public String readExcel(int row , int col,String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("");
		Sheet data = WorkbookFactory.create(file).getSheet(sheetName);
		String value = data.getRow(row).getCell(col).getStringCellValue();
		return value;
	}

}
