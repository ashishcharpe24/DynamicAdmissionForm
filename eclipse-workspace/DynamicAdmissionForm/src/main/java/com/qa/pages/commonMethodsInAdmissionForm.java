package com.qa.pages;



import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.xml.xpath.XPath;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;
import com.qa.base.basicMethods;

public class commonMethodsInAdmissionForm extends basicMethods{

	@FindBy(xpath = "//select[@name='Class']")private static WebElement classToTakeAdmission;
	@FindBy(xpath = "//select[@name='ClassStuding']")private static WebElement currentClass;
	@FindBy(xpath = "//input[@name='StudBithPlace']")private static WebElement birthPlace;
	@FindBy(xpath = "//select[@name='CountryofBirth']")private static WebElement birthCountry;
	@FindBy(xpath = "//input[@name='GuardianFirstName']")private static WebElement guardianFirstName;
	@FindBy(xpath = "//input[@name='GuardianLName']")private static WebElement guardianLastName;
	@FindBy(xpath = "//input[@name='GuardianEmail']")private static WebElement guardianMail;
	@FindBy(xpath = "//select[@name='GuardianRelationShipToStudent']")private static WebElement guardianrelation;
	@FindBy(xpath = "//input[@name='GuardianAddressed']")private static WebElement guardianAddress;
	@FindBy(xpath = "//input[@name='GuardianCity']")private static WebElement guardianCity;
	@FindBy(xpath = "//select[@name='GuardianCountry']")private static WebElement guardianCountry;
	@FindBy(xpath = "//input[@name='GuardianZipcode']")private static WebElement guardianZipCode;
	@FindBy(xpath = "//input[@name='PresentSchoolName']")private static WebElement presentSchoolName;
	@FindBy(xpath = "//input[@name='PresentSchoolCity']")private static WebElement presentSchoolCity;
	@FindBy(xpath = "//select[@name='PresentSchoolCountry']")private static WebElement presentSchoolCountry;
	@FindBy(xpath = "//input[@value='Same as Father']")private static WebElement fatherEcContact;
	@FindBy(xpath = "//input[@value='Same as Mother']")private static WebElement motherEcContact;
	@FindBy(xpath = "//input[@name='ECName']")private static WebElement ecName;
	@FindBy(xpath = "//button[@data-id='EmergencyMobileCode']")private static WebElement ecMobile;
	@FindBy(xpath = "//input[@name='ECAddress']")private static WebElement ecAddressLine1;
	@FindBy(xpath = "//input[@name='ECAddress2']")private static WebElement ecAddressLine2;
	@FindBy(xpath = "//input[@name='ECCity']")private static WebElement ecCity;
	@FindBy(xpath = "//select[@name='ECCountry']")private static WebElement ecCountry;
	@FindBy(xpath = "//input[@name='ECZip']")private static WebElement ecPostalCode;
	@FindBy(xpath = "//input[@name='EmergMobileNo']")private static WebElement ecMobileNumber;
	@FindBy(xpath = "//input[@name='EmergContactType']")private static WebElement radiobuttons;
	

	
	int a=1;
	int b=1;
	int c=1;
	int d=1;
	int e=1;
	int f=1;
	int g=1;
	int h=1;
	int j=1;
	int k=1;
	static String idTypeSelected="";
	
	static registrationForm rf = new registrationForm();
	public commonMethodsInAdmissionForm()
	{
		PageFactory.initElements(driver, this);
	}
	
	public static void nationality(int a,String id)
	{
		WebElement nat=driver.findElement(By.xpath("(//form[@id='"+id+"']//select[contains(@name,'Nationality')])["+a+"]"));
		
		Select selNat=new Select(nat);
		
		Random ran = new Random();
        
        int minRange = 1, maxRange= selNat.getOptions().size();
        int value = ran.nextInt(maxRange - minRange) + minRange;
        System.out.println(value); 
        
		selNat.selectByIndex(value);
		WebElement selOption = selNat.getFirstSelectedOption();
		System.out.println(selOption.getText());
		
	}
	
	public static void dateOfBirth(int b,String id) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//form[@id='"+id+"']//input[contains(@name,'B')]//following-sibling::span)["+b+"]")).click();
		String count="";
		 String dateOfBirthFather = "24-June-2023";
		 String[] dateSplit =  dateOfBirthFather.split("-");
		 String year = dateSplit[2];
		 String month=dateSplit[1];
		 String date=dateSplit[0];
		while(!count.equalsIgnoreCase("3"))
		{
			String s = driver.findElement(By.xpath("//button[@ng-click='toggleMode()']/parent::th")).getAttribute("colspan");
			count=s;
			driver.findElement(By.xpath("//button[@ng-click='toggleMode()']")).click();
		}

		outer:
		{
		while(true){
			List<WebElement> years = driver.findElements(By.xpath("//td[@class='uib-year text-center ng-scope']"));
		    Iterator itr = years.iterator();
		for(WebElement year1:years)
		{
		
			if(year1.getText().equalsIgnoreCase(year))
			{
			 driver.findElement(By.xpath("//span[text()='"+(year)+"']")).click();
			 break outer;
		    }
		
		}
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm pull-left uib-left']")).click();
		}
		}
		driver.findElement(By.xpath("//span[text()='"+month+"']")).click();
		driver.findElement(By.xpath("//span[@class='ng-binding' and text()='"+date+"']")).click();
	}
	
	public static void identificationType(int c,String idname)
	{
		
		int value=0;
		WebElement id = driver.findElement(By.xpath("(//form[@id='"+idname+"']//select[contains(@name,'Identification')])["+c+"]"));
    	Select selId=new Select(id);
    	
		Random ran = new Random();
        
        int minRange = 1, maxRange= selId.getOptions().size();
         value = ran.nextInt(maxRange - minRange) + minRange;
        System.out.println(value); 
		selId.selectByIndex(value);
		WebElement selOption = selId.getFirstSelectedOption();
		System.out.println(selOption.getText());
		idTypeSelected = selOption.getText();
		
	}
	
	public static void education(int d)
	{
		int value = 0;
		WebElement educ = driver.findElement(By.xpath("(//select[contains(@name,'Education')])["+d+"]"));
		Select seledu=new Select(educ);

		Random ran = new Random();
		int minRange = 1, maxRange= seledu.getOptions().size();
		value = ran.nextInt(maxRange - minRange) + minRange;
		System.out.println(value); 
		seledu.selectByIndex(value);
		WebElement selOption = seledu.getFirstSelectedOption();
		System.out.println(selOption.getText());
	}
	
	public static void maritalStatus(int e)
	{
		int value = 0;
		WebElement mts = driver.findElement(By.xpath("(//select[contains(@name,'MartialStatus')])["+e+"]"));
		Select selmts=new Select(mts);

		Random ran = new Random();
		int minRange = 1, maxRange= selmts.getOptions().size();
		value = ran.nextInt(maxRange - minRange) + minRange;
		System.out.println(value); 
		selmts.selectByIndex(value);
		WebElement selOption = selmts.getFirstSelectedOption();
		System.out.println(selOption.getText());
	}
	
	public static void emailGen(WebElement em)
	{
		 Faker faker = new Faker();
		 String email= faker.internet().emailAddress();
		 em.sendKeys(email);
	}
	
	public static void phoneAndMobileNumber(WebElement ph)
	{
		
		
		 int pm=Integer.parseInt(ph.getAttribute("maxlength"));  
		 RandomStringUtils mobileOrPhone= new RandomStringUtils();
		 String NumHomeFather = mobileOrPhone.randomNumeric(pm);
		 ph.sendKeys(NumHomeFather);
	}
	
	public static void socioEconomic(int g)
	{
		int value = 0;
		WebElement socioEco = driver.findElement(By.xpath("(//select[contains(@name,'Socio')])["+g+"]"));
		Select selmts=new Select(socioEco);

		Random ran = new Random();
		int minRange = 1, maxRange= selmts.getOptions().size();
		value = ran.nextInt(maxRange - minRange) + minRange;
		//        String num = Integer.toString(value);
		System.out.println(value); 



		selmts.selectByIndex(value);
		//	String selOption = driver.findElement(By.xpath("//select[@name='MotherNationality']")).getAttribute("Value");
		WebElement selOption = selmts.getFirstSelectedOption();
		System.out.println(selOption.getText());
	
	}
	
	public static void uploadPhoto(int h) throws IOException, InterruptedException
	{
		String fatherPhoto=Readpropertyfile("fatherPhotoPath");
		String motherPhoto=Readpropertyfile("motherPhotoPath");
		String childPhoto=Readpropertyfile("studentPhotoPath");
		
//		if(h==2)
//		{
//			
//		}
		
		
		WebElement photo= driver.findElement(By.xpath("(//a[text()='Upload Photograph'])["+h+"]"));
		photo.click();
		WebElement file=driver.findElement(By.xpath("//input[@name='UploadPhotoModal']"));
		if(h==1)
		{
		file.sendKeys(fatherPhoto);
		Thread.sleep(1000);
		}
		else if(h==2)
		{
		file.sendKeys(motherPhoto);
		Thread.sleep(1000);
		}
		else if(h==3)
		{
		file.sendKeys(childPhoto);
		Thread.sleep(1000);
		}
		driver.findElement(By.xpath("//button[@ng-click='UploadPhoto()']")).click();
		Thread.sleep(2000);
	}
	
	public static void currentPosition(int j)
	{
		int value=0;
		WebElement currPos = driver.findElement(By.xpath("(//select[contains(@name,'CurrentPosition')])["+j+"]"));
		Select selcurrPos=new Select(currPos);

		Random ran = new Random();
		int minRange = 1, maxRange= selcurrPos.getOptions().size();
		value = ran.nextInt(maxRange - minRange) + minRange;
		System.out.println(value); 

		selcurrPos.selectByIndex(value);
		WebElement selOption = selcurrPos.getFirstSelectedOption();
		System.out.println(selOption.getText());
	}
	
	
	public static void passport(int k) throws SQLException, InterruptedException
	{
		
		
		
		if(rf.id.equalsIgnoreCase("admissionPartOne")&&rf.text.toLowerCase().contains(""))
		{
			WebElement passNos = driver.findElement(By.xpath("(//input[contains(@name,'PassportNumber') or contains(@name,'PassportNo')])["+k+"]"));
			WebElement passIssueDate=driver.findElement(By.xpath("(//input[contains(@name,'PassportIssueDate')]//following-sibling::div//following-sibling::span/button)["+k+"]"));
			WebElement passExpiryDate=driver.findElement(By.xpath("(//input[contains(@name,'PassportExpiryDate')]//following-sibling::div//following-sibling::span/button)["+k+"]"));
			WebElement passCountryIssue = driver.findElement(By.xpath("(//select[contains(@name,'PassportCountyIssue')])["+k+"]"));
			passNos.sendKeys("Pass");
			passIssueDate.click();
			driver.findElement(By.xpath("//button[text()='Today']")).click();
			passExpiryDate.click();
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm pull-right uib-right']")).click();
			driver.findElement(By.xpath("//span[text()='15']")).click();
			//			methodForNationality(passCountryIssue);

			WebElement nat=driver.findElement(By.xpath("(//select[contains(@name,'CountyIssue')])["+k+"]"));

			Select selNat=new Select(nat);

			Random ran = new Random();

			int minRange = 1, maxRange= selNat.getOptions().size();
			int value = ran.nextInt(maxRange - minRange) + minRange;
			System.out.println(value); 

			selNat.selectByIndex(value);
			WebElement selOption = selNat.getFirstSelectedOption();
			System.out.println(selOption.getText());

		}
		
		if(rf.id.equalsIgnoreCase("admissionPartTwo"))
		{

			WebElement passNos = driver.findElement(By.xpath("(//div[@ng-if='lbl_PassportNumber.Show']//input[contains(@name,'PassportNo')])["+k+"]"));
			WebElement passIssueDate=driver.findElement(By.xpath("(//div[@ng-if='lbl_StudPassportIssue.Show']//input[contains(@name,'PassportIssueDate')]//following-sibling::div//following-sibling::span/button)["+k+"]"));
			WebElement passExpiryDate=driver.findElement(By.xpath("(//div[@ng-if='lbl_StudPassportExipry.Show']//input[contains(@name,'PassportExpiryDate')]//following-sibling::div//following-sibling::span/button)["+k+"]"));
			WebElement passCountryIssue = driver.findElement(By.xpath("(//div[@ng-if='lbl_StudPassCountryIssue.Show']//select[contains(@name,'PassportCountyIssue')])["+k+"]"));
			
			passNos.sendKeys("Pass");
			passIssueDate.click();
			driver.findElement(By.xpath("//button[text()='Today']")).click();
			passExpiryDate.click();
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm pull-right uib-right']")).click();
			driver.findElement(By.xpath("//span[text()='15']")).click();
			//			methodForNationality(passCountryIssue);

			WebElement nat=driver.findElement(By.xpath("(//div[@ng-if='lbl_StudPassCountryIssue.Show']//select[contains(@name,'CountyIssue')])["+k+"]"));

			Select selNat=new Select(nat);

			Random ran = new Random();

			int minRange = 1, maxRange= selNat.getOptions().size();
			int value = ran.nextInt(maxRange - minRange) + minRange;
			System.out.println(value); 

			selNat.selectByIndex(value);
			WebElement selOption = selNat.getFirstSelectedOption();
			System.out.println(selOption.getText());
			
		}
		
	}
	
	 public static String IntToLetter(int Int) {
		    if (Int<27)
		    {
		      return "Test "+Character.toString((char)(Int+96));
		    } else {
		      if (Int%26==0) {
		        return IntToLetter((Int/26)-1)+IntToLetter(((Int-1)%26+1));
		      } else {
		        return "Test "+IntToLetter(Int/26)+IntToLetter(Int%26);
		      }
		    }
		  }
	 
	 public static String idNumber()
	 {
 //		 WebElement idNumber=driver.findElement(By.xpath("//input[@name='FatherIdentificationNumber']"));
 //		 int num=Integer.parseInt(idNumber.getAttribute("maxlength"));  
		 RandomStringUtils a= new RandomStringUtils();
		 String NumStr = a.randomNumeric(4);
		 return NumStr;
			
	 }
	 
	 public void classSelectionForAdmission() throws IOException, InterruptedException
	 {
		 if(Readpropertyfile("grade").equalsIgnoreCase(""))
		 {
			 Select selClass=new Select(classToTakeAdmission);
			 Random ran = new Random();

			 int minRange = 1, maxRange= selClass.getOptions().size();
			 int value = ran.nextInt(maxRange - minRange) + minRange;
			 System.out.println(value); 

			 selClass.selectByIndex(value);
			 WebElement selOption = selClass.getFirstSelectedOption();
			 System.out.println(selOption.getText());
			 
			 Thread.sleep(1000);
			 if(value-1==0)
			 {
				 Select selCurrClass=new Select(currentClass);
				 selCurrClass.selectByIndex(value);
			 }
			 else
			 {
				 Select selCurrClass=new Select(currentClass);
				 selCurrClass.selectByIndex(value-1);
			 }
			 
		 }
		 else 
		 {
			 Select selClass=new Select(classToTakeAdmission);
			 selClass.selectByValue(Readpropertyfile("grade"));
			 WebElement selOption = selClass.getFirstSelectedOption();
			 System.out.println(selOption.getText());
			 Select selCurrClass=new Select(currentClass);
			 selCurrClass.selectByVisibleText(Readpropertyfile("grade"));
		 }
		 
		 
	 }
	 
//	 public static void currentClass()
//	 {
//		 Select selCurrClass=new Select(currentClass);
//		 Random ran = new Random();
//
//		 int minRange = 1, maxRange= selCurrClass.getOptions().size();
//		 int value = ran.nextInt(maxRange - minRange) + minRange;
//		 System.out.println(value); 
//
//		 selCurrClass.selectByIndex(value);
//		 WebElement selOption = selCurrClass.getFirstSelectedOption();
//		 System.out.println(selOption.getText());
//	 }
	 
	 public static void birthRelatedFields()
	 {
		 birthPlace.sendKeys("Test Birth City");
		 
		 Select selCont=new Select(birthCountry);
		 Random ran = new Random();

		 int minRange = 1, maxRange= selCont.getOptions().size();
		 int value = ran.nextInt(maxRange - minRange) + minRange;
		 System.out.println(value); 

		 selCont.selectByIndex(value);
		 WebElement selOption = selCont.getFirstSelectedOption();
		 System.out.println(selOption.getText());
		 
	 }
	 
	 public static void guardianDetails(int n)
	 {
		 List<WebElement> guardianSection = driver.findElements(By.xpath("//div[contains(@ng-if,'formdata.StudentStayWithParent')]//span[@class='required-field ng-scope']//ancestor::label"));
		 List<String> guardianSectionLabels=new ArrayList();
		 for(WebElement temp:guardianSection)
		 {
			 guardianSectionLabels.add(temp.getText());
		 }
		
		 for(String guardianSectionLabel:guardianSectionLabels)
		 {
		 if(guardianSectionLabel.toLowerCase().contains("guardian first name")||guardianSectionLabel.toLowerCase().contains("first name"))
		 {
			 guardianFirstName.sendKeys(IntToLetter(n));
		 }
		 else if(guardianSectionLabel.toLowerCase().contains("guardian last name")||guardianSectionLabel.toLowerCase().contains("last name"))
		 {
			 guardianLastName.sendKeys("Guardian");
		 }
		 else if(guardianSectionLabel.toLowerCase().contains("guardian identification number")||guardianSectionLabel.toLowerCase().contains("identification"))
		 {
				int value=0;
				WebElement id = driver.findElement(By.xpath("//select[@name='GuardianIdentification']"));
		    	Select selId=new Select(id);
		    	
				Random ran = new Random();
		        
		        int minRange = 1, maxRange= selId.getOptions().size();
		         value = ran.nextInt(maxRange - minRange) + minRange;
		        System.out.println(value); 
				selId.selectByIndex(value);
				WebElement selOption = selId.getFirstSelectedOption();
				System.out.println(selOption.getText());
				idTypeSelected = selOption.getText();
				
				WebElement idNumber = driver.findElement(By.xpath("//input[@name='GuardianIdentificationNumber']"));
				idNumber.sendKeys(idNumber());
				String idnum = idNumber.getAttribute("value");
				System.out.println("Id Number is="+idnum);
		 }
		 
		 else if(guardianSectionLabel.toLowerCase().contains("guardian mobile")||guardianSectionLabel.toLowerCase().contains("phone"))
		 {
			 phoneAndMobileNumber(driver.findElement(By.xpath("//input[@name='GuardianMobile']")));
		 }
		 else if(guardianSectionLabel.toLowerCase().contains("guardian email")||guardianSectionLabel.toLowerCase().contains("email"))
		 {
			 guardianMail.sendKeys("test@guardian.com");
		 }
		 else if(guardianSectionLabel.toLowerCase().contains("guardian relationship"))
		 {
			 Select selGuarRel = new Select(guardianrelation);
			 Random ran = new Random();

			 int minRange = 1, maxRange= selGuarRel.getOptions().size();
			 int value = ran.nextInt(maxRange - minRange) + minRange;
			 
			 selGuarRel.selectByIndex(value);
		 }
		 else if(guardianSectionLabel.toLowerCase().contains("guardian nationality")||guardianSectionLabel.toLowerCase().contains("nationality"))
		 {
			 WebElement nat=driver.findElement(By.xpath("//select[@name='GuardianNationality']"));
				
				Select selNat=new Select(nat);
				
				Random ran = new Random();
		        
		        int minRange = 1, maxRange= selNat.getOptions().size();
		        int value = ran.nextInt(maxRange - minRange) + minRange;
		        System.out.println(value); 
		        
				selNat.selectByIndex(value);
				WebElement selOption = selNat.getFirstSelectedOption();
				System.out.println(selOption.getText());
		 }
		 else if(guardianSectionLabel.toLowerCase().contains("address"))
		 {
			 guardianAddress.sendKeys("test guardian address");
		 }
		 else if(guardianSectionLabel.toLowerCase().contains("guardian city"))
		 {
			 guardianCity.sendKeys("test guardian city");
		 }
		 else if(guardianSectionLabel.toLowerCase().contains("guardian country"))
		 {
			 Select selNat=new Select(guardianCountry);
				
				Random ran = new Random();
		        
		        int minRange = 1, maxRange= selNat.getOptions().size();
		        int value = ran.nextInt(maxRange - minRange) + minRange;
		        System.out.println(value); 
		        
				selNat.selectByIndex(value);
				WebElement selOption = selNat.getFirstSelectedOption();
				System.out.println(selOption.getText());
		 }
		 else if(guardianSectionLabel.toLowerCase().contains("guardian zip code"))
		 {
			 guardianZipCode.sendKeys("656565");
		 }
		 }
		 
	 }
	 
	 public static void presentSchoolDetails()
	 {
		 presentSchoolName.sendKeys("Test school name");
		 presentSchoolCity.sendKeys("Test school city");
		 
		 Select selSchoolCon = new Select(presentSchoolCountry);
		 
		 Random ran = new Random();
	        
	        int minRange = 1, maxRange= selSchoolCon.getOptions().size();
	        int value = ran.nextInt(maxRange - minRange) + minRange;
	        System.out.println(value); 
	        selSchoolCon.selectByIndex(value);
	 }
	 
	 public static void emergencyContact(int n) throws IOException
	 {
		 List<WebElement> emergencyContactTagNames = driver.findElements(By.xpath("//fieldset[@ng-disabled='DisabledEmergencyContact']//div//label"));
		List<String> emergencyContactLabels = new ArrayList <String>() ;
		 for(WebElement emergencyContactTagName : emergencyContactTagNames)
		 {
			 emergencyContactLabels.add(emergencyContactTagName.getText()) ;
		 }
		 
		 if(radiobuttons.isEnabled())
		 {
			 if(Readpropertyfile("priorityParent").equalsIgnoreCase("father"))
			 {
				 fatherEcContact.click();
			 }
			 else if(Readpropertyfile("priorityParent").equalsIgnoreCase("mother"))
			 {
				 motherEcContact.click();
			 }
		 }
		 else
		 {
			 for(String emergencyContactLabel:emergencyContactLabels )
			 {
				 
			 if(emergencyContactLabel.contains("name"))
			 {
				 ecName.sendKeys(IntToLetter(n));
			 }
			 
			 else if(emergencyContactLabel.toLowerCase().contains("mobile"))
				{
					Actions act = new Actions(driver);
					act.moveToElement(ecMobile).click().build().perform();
					for(int k=0;k<=2;k++)
					{
					 act.sendKeys(Keys.ARROW_DOWN).build().perform();
					}
					act.sendKeys(Keys.ENTER).build().perform();
					phoneAndMobileNumber(ecMobileNumber);
					
				}
				
				else if(emergencyContactLabel.toLowerCase().contains("address line 1"))
				{
					ecAddressLine1.sendKeys("Emergency contact address line 1 test");
					
				}
				else if(emergencyContactLabel.toLowerCase().contains("address line 2")&&ecAddressLine2.getAttribute("value").equalsIgnoreCase(""))
				{
					ecAddressLine2.sendKeys("Emergency contact address line 2 test");
					
				}
				else if(emergencyContactLabel.toLowerCase().contains("city"))
				{
					ecCity.sendKeys("Emergency contact city test");
					
				}
				else if(emergencyContactLabel.toLowerCase().contains("country"))
				{
					Select selCont = new Select(ecCountry);
					 Random ran = new Random();
				        
				        int minRange = 1, maxRange= selCont.getOptions().size();
				        int value = ran.nextInt(maxRange - minRange) + minRange;
				        System.out.println(value); 
				        selCont.selectByIndex(value);
					
				}
				
				else if(emergencyContactLabel.toLowerCase().contains("postal")&&ecPostalCode.getAttribute("value").equalsIgnoreCase(""))
				{
					ecPostalCode.sendKeys("23456");
				}
	 }
	 }
	 }
}
		 
		 
	 
