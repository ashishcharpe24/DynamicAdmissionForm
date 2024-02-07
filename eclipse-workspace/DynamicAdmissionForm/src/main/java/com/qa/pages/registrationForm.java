package com.qa.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.swing.plaf.basic.BasicArrowButton;

import org.apache.commons.collections4.Get;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.qa.base.basicMethods;

import net.bytebuddy.asm.Advice.Enter;
import net.sf.saxon.functions.Parse;

public class registrationForm extends basicMethods {
	
	@FindBy(xpath = "//button[@ng-click='submitPartOne(admissionPartOne)']")private static WebElement saveAndContinueBtnOnParentPage;
	@FindBy(xpath = "//input[@name='MotherFirstName']")private static WebElement motherFirstName;
	@FindBy(xpath = "//div[@ng-if='lbl_fthFirstName.Show']//input[@name='FatherFirstName']")private static WebElement fatherFirstName;
	
	//First Page
	@FindBy(xpath = "//select[@name='Country']")private static WebElement campusCountry;
	@FindBy(xpath = "//select[@name='Campus']")private static WebElement campus;
	@FindBy(xpath = "//select[@name='AdmissionFor']")private static WebElement session;
	@FindBy(xpath = "//input[@id='FatherFirstName']")private static WebElement firstName;
	@FindBy(xpath = "//input[@name='FatherLastName']")private static WebElement lastName;
	@FindBy(xpath = "//input[@name='FatherEmailAddress']")private static WebElement eMail;
	@FindBy(xpath = "//input[@name='FatherhMobileNumber']")private static WebElement mobileNumber;
	@FindBy(xpath = "//select[@name='RelationWithStudent']")private static WebElement relationWithStudent;
	@FindBy(xpath = "//input[@name='ParentPriority' and @value='Father']")private static WebElement priorityParentFather;
	@FindBy(xpath = "//input[@name='ParentPriority' and @value='Mother']")private static WebElement priorityParentMother;
	@FindBy(xpath = "//button[@id='SaveAndContinueButtonPageOne']")private static WebElement saveAndContinue;
	
	@FindBy(xpath = "//input[@name='FirstName']")private static WebElement studFirstName;
	@FindBy(xpath = "//input[@name='LastName']")private static WebElement studLastName;
	@FindBy(xpath = "//input[@value='Male']")private static WebElement male;
	@FindBy(xpath = "//input[@value='Female']")private static WebElement female;
	@FindBy(xpath = "//input[@name='StudentStayWithParent' and @value='No']")private static WebElement guardianDetailsRequired;
	@FindBy(xpath = "//input[@name='StudentStayWithParent' and @value='Yes']")private static WebElement guardianDetailsNotRequired;
	@FindBy(xpath = "//select[@name='ResidentialStatus']")private static WebElement residentialStatus;
	@FindBy(xpath = "//input[@name='Block']")private static WebElement blockOrPlot;
	@FindBy(xpath = "//input[@name='AddressLine1']")private static WebElement address1;
	@FindBy(xpath = "//input[@name='AddressLine2']")private static WebElement address2;
	@FindBy(xpath = "//input[@name='FlatNo']")private static WebElement unit;
	@FindBy(xpath = "//input[@name='City']")private static WebElement city;
	@FindBy(xpath = "//input[@name='State']")private static WebElement state;
	@FindBy(xpath = "//select[@name='CurrentHomeCountry']")private static WebElement country;
	@FindBy(xpath = "//input[@name='PostalCode']")private static WebElement postalCode;
	@FindBy(xpath = "//select[@name='BloodGroup']")private static WebElement bloodGroup;
	@FindBy(xpath = "//select[@name='MotherTongue']")private static WebElement motherTongue;
	@FindBy(xpath = "//select[@name='SecondLang']")private static WebElement secondLang;
	@FindBy(xpath = "//select[@name='ThirdLang']")private static WebElement thirddLang;
	@FindBy(xpath = "//input[@name='ECName']")private static WebElement ecName;
	@FindBy(xpath = "//button[@data-id='EmergencyMobileCode']")private static WebElement ecMobile;
	@FindBy(xpath = "//input[@name='ECAddress']")private static WebElement ecAddressLine1;
	@FindBy(xpath = "//input[@name='ECAddress2']")private static WebElement ecAddressLine2;
	@FindBy(xpath = "//input[@name='ECCity']")private static WebElement ecCity;
	@FindBy(xpath = "//select[@name='ECCountry']")private static WebElement ecCountry;
	@FindBy(xpath = "//input[@name='ECZip']")private static WebElement ecPostalCode;
	@FindBy(xpath = "//input[@name='EmergMobileNo']")private static WebElement ecMobileNumber;
	@FindBy(xpath = "//select[@name='Nationality']")private static WebElement studNationality;
	@FindBy(xpath = "//select[@name='Identification']")private static WebElement studIdentification;
	@FindBy(xpath = "//select[@name='CurrentHomeCountry']")private static WebElement homeCountry;
	@FindBy(xpath = "//button[@ng-click='submitPartTwo(admissionPartTwo)']")private static WebElement submitPartTwo;
	@FindBy(xpath = "//div[@ng-show='showPageOne']//input[@name='FatherEmailAddress']")private static WebElement fatherEmail;
	@FindBy(xpath = "//input[@name='MotherEmailAddress']")private static WebElement motherEmail;
	@FindBy(xpath = "//h4[text()='Emergency Contact']")private static WebElement eContact;
	@FindBy(xpath = "//*[@id='admissionPartTwo']//label[text()='If you would want to repeat the contact information that was shared earlier, please select ']")private static WebElement textForSelection;
	@FindBy(xpath = "//input[@name='SameasAbove']")private static WebElement sameAsAboveChkBox;
	@FindBy(xpath = "//button[@ng-click='submitPartThree(admissionPartThree)']")private static WebElement submitButtonDocsStep;
	
	static String id ;
	static String text;
	static Properties props = new Properties();
	static int h=1;
	public registrationForm()
	{
		PageFactory.initElements(driver, this);
	}
	
	static commonMethodsInAdmissionForm cmf;
	basicMethods bm=new basicMethods();
	static List<String> tagNamesFP= new ArrayList <String>();
	static List <String> tagnamesPP = new ArrayList <String>();
	static List<String> tagNamesSP	= new ArrayList <String>();
	static int l=1;
	static int m=1;
	
	public static <Readpropertyfile> void fillRegistrationForm() throws IOException, SQLException, InterruptedException
	{	
		
		cmf= new commonMethodsInAdmissionForm();
		int numberOfStudent = Integer.parseInt(Readpropertyfile("numberOfStudent"));	
		int studentCompleted = Integer.parseInt(ReadpropertyfileOfData("studentCompleted"));
		for(int n=1;n<=numberOfStudent;n++)
		{
			if(studentCompleted>=n)
			{
				
			}
			else
			{
			if(n>1)
			{
				driver.get(Readpropertyfile("URL"));
				Thread.sleep(2000);
			}
			
			
			String priorityParent = Readpropertyfile("priorityParent");
			
			List<WebElement> tagNamesFirstPage = driver.findElements(By.xpath("//form[@id='admissionPartVerifyEmail']//span[@class='required-field']//parent::label"));
			
			for(WebElement temp:tagNamesFirstPage)
			{
				tagNamesFP.add(temp.getText());
			}
			
			for(int j=0;j<tagNamesFP.size();j++)
			{
				if(tagNamesFP.get(j).toLowerCase().contains("country")&&campusCountry.getAttribute("value").equals(""))
				{
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
					WebElement selectDropCountry = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='Country']")));
					Select selCont = new Select(selectDropCountry);
					// selCont.selectByVisibleText(Readpropertyfile("country"));
					 selCont.selectByIndex(1);
				}
				else if(tagNamesFP.get(j).toLowerCase().contains("campus")&&campus.getAttribute("value").equals(""))
				{
					Select selCamp = new Select(campus);
					selCamp.selectByVisibleText(Readpropertyfile("campus"));
				}
				else if(tagNamesFP.get(j).toLowerCase().contains("admission for"))
				{
					Select selSess = new Select(session);
					selSess.selectByVisibleText(Readpropertyfile("session"));
				}
				else if(tagNamesFP.get(j).toLowerCase().contains("first name")&&firstName.getAttribute("value").equals(""))
				{
					firstName.sendKeys(cmf.IntToLetter(n));
				}
				else if(tagNamesFP.get(j).toLowerCase().contains("last")&&lastName.getAttribute("value").equals(""))
				{
					if(Readpropertyfile("priorityParent").equalsIgnoreCase("father"))
					{
						lastName.sendKeys("father");
					}
					else if(Readpropertyfile("priorityParent").equalsIgnoreCase("mother"))
					{
						lastName.sendKeys("mother");
					}
				}
				else if(tagNamesFP.get(j).toLowerCase().contains("email")&&eMail.getAttribute("value").equals(""))
				{
					if(Readpropertyfile("email").equalsIgnoreCase(""))
					{
						eMail.sendKeys("test@test.com");
					}
					else if(!Readpropertyfile("email").equalsIgnoreCase(""))
					{
						eMail.sendKeys(Readpropertyfile("email"));
					}
					
				}
				
				else if(tagNamesFP.get(j).toLowerCase().contains("mobile")&&mobileNumber.getAttribute("value").equals("")||tagNamesFP.get(j).toLowerCase().contains("phone")&&mobileNumber.getAttribute("value").equals(""))
				{
					cmf.phoneAndMobileNumber(mobileNumber);
				}
				
				else if(tagNamesFP.get(j).toLowerCase().contains("relationship")&&relationWithStudent.getAttribute("value").equals(""))
				{
					Select selRel = new Select(relationWithStudent);
					 Random ran = new Random();
				        
				        int minRange = 1, maxRange= selRel.getOptions().size();
				        int value = ran.nextInt(maxRange - minRange) + minRange;
				        System.out.println(value); 
				        selRel.selectByIndex(value);
					
				}
				
				else if(tagNamesFP.get(j).toLowerCase().contains("priority"))
				{
					if(Readpropertyfile("priorityParent").equalsIgnoreCase("father"))
					{
						priorityParentFather.click();
					}
					else if(Readpropertyfile("priorityParent").equalsIgnoreCase("mother"))
					{
						priorityParentMother.click();
					}
				}
				
			}
			
			saveAndContinue.click();
			
			
			
			
			
		
			//Parent Details Page
			
			Thread.sleep(5000);
			
    		List<WebElement> tagNamesParentPage = driver.findElements(By.xpath("//div[@ng-show='showPageOne']//span[contains(@class,'required-field')]//ancestor::label")); 
			for(WebElement tagNamePP:tagNamesParentPage)
			{
				tagnamesPP.add(tagNamePP.getText());

			}
			System.out.println(tagnamesPP);
			id="admissionPartOne";
			
//			try (FileInputStream in = new FileInputStream("C:\\Users\\acharpe\\eclipse-workspace\\DynamicAdmissionForm\\records.properties")) {
//			    props.setProperty("url", driver.getCurrentUrl());
//			}
			
		for(int i=0;i<tagnamesPP.size();i++)
		{
		
			
			if(tagnamesPP.get(i).toLowerCase().contains("nationality"))
			{

				if(cmf.a>2)
				{
					cmf.a=1;
				}
				cmf.nationality(cmf.a,id);
				cmf.a++;
			}
			
			else if(tagnamesPP.get(i).toLowerCase().contains("first"))
			{
				
				if(priorityParent.equalsIgnoreCase("father"))
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;  
					 text = (String) js.executeScript("return arguments[0].value", motherFirstName);
					
				}
				else
				{
					JavascriptExecutor js = (JavascriptExecutor) driver;  
					text = (String) js.executeScript("return arguments[0].value", fatherFirstName);
				}
				
				System.out.println("Text in mother field-"+text);
				
				if(priorityParent.equalsIgnoreCase("father")&&text.toLowerCase().contains("test")/*||priorityParent.equalsIgnoreCase("Mother")&&i==0&&text.toLowerCase().contains("test")*/)
				{
					break;
				}
			else
			{
					if(priorityParent.equalsIgnoreCase("father")&&i!=0)
					{
						motherFirstName.sendKeys(cmf.IntToLetter(n));
						//we will update the code in place of "i+1" will update number of student 
					}
					
					else if(priorityParent.equalsIgnoreCase("Mother")&&i==0)
					{
						fatherFirstName.sendKeys(cmf.IntToLetter(n));
					}
					
				}
				
			}
			
			else if(tagnamesPP.get(i).toLowerCase().contains("last"))
			{
				
				if(priorityParent.equalsIgnoreCase("father")&&i!=1)
				{
					driver.findElement(By.xpath("//input[@name='MotherLastName']")).sendKeys("Mother");
				}
				
				else if(priorityParent.equalsIgnoreCase("Mother")&&i==1)
				{
					driver.findElement(By.xpath("//div[@ng-if='lbl_fthLastName.Show']//input[@name='FatherLastName']")).sendKeys("Father");
				}
			
				
			}
			else if(tagnamesPP.get(i).toLowerCase().contains("date of birth")||tagnamesPP.get(i).toLowerCase().contains("dob"))
			{
				if(cmf.b>2)
				{
					cmf.b=1;
				}
				if(cmf.b==2)
				{
					cmf.dateOfBirth(cmf.b,id);
				}
				else 
				{
					cmf.dateOfBirth(cmf.b,id);
				}
				cmf.b++;
			
			}
			
			else if(tagnamesPP.get(i).toLowerCase().contains("identification"))
			{

				if(cmf.c>2)
				{
					cmf.c=1;
				}
				cmf.identificationType(cmf.c,id);
				
				WebElement idNumber = driver.findElement(By.xpath("(//input[contains(@name,'Identification')])["+cmf.c+"]"));
				idNumber.sendKeys(cmf.idNumber());
				String idnum = idNumber.getAttribute("value");
				System.out.println("Id Number is="+idnum);
				cmf.c++;
				
			}
			
			else if(tagnamesPP.get(i).toLowerCase().contains("education"))
			{

				if(cmf.d>2)
				{
					cmf.d=1;
				}
				cmf.education(cmf.d);
				cmf.d++;
				
			}
			
			else if(tagnamesPP.get(i).toLowerCase().contains("marital"))
			{

				if(cmf.e>2)
				{
					cmf.e=1;
				}
				cmf.maritalStatus(cmf.e);	
				cmf.e++;
				
			}
			
			else if(tagnamesPP.get(i).toLowerCase().contains("email"))
			{
				WebElement em = null;
				
//				WebElement em = driver.findElement(By.xpath("(//input[contains(@name,'EmailAddress')])["+e+"]"));
				if(priorityParent.equalsIgnoreCase("father"))
				{
				 em=motherEmail;
				 
				}
				if(priorityParent.equalsIgnoreCase("mother"))
				{
					em=fatherEmail;
				}
				
					cmf.emailGen(em);
					
			
			}
			
//			else if(names.get(i).toLowerCase().contains("phone")||names.get(i).toLowerCase().contains("mobile")||names.get(i).toLowerCase().contains("office"))
//			{
//				WebElement mobOrPhn = driver.findElement(By.xpath("(//form[@id='admissionPartOne']//input[@placeholder='Phone Number'])["+cmf.f+"]"));
//				cmf.phoneAndMobileNumber(mobOrPhn,cmf.f);
//				cmf.f++;
//				
//			}
			
			else if(tagnamesPP.get(i).toLowerCase().contains("socio"))
			{

				if(cmf.g>2)
				{
					cmf.g=1;
				}
				cmf.socioEconomic(cmf.g);
				cmf.g++;
				
			}
			
			else if(tagnamesPP.get(i).toLowerCase().contains("current position"))
			{

				if(cmf.j>2)
				{
					cmf.j=1;
				}
				cmf.currentPosition(cmf.j);
				cmf.j++;
			}
			else if(tagnamesPP.get(i).toLowerCase().contains("father's passport number")||cmf.idTypeSelected.contains("passport")||tagnamesPP.get(i).toLowerCase().contains("mother's passport number")||tagnamesPP.get(i).toLowerCase().contains("passport number"))
			{

				if(cmf.k>2)
				{
					cmf.k=1;
				}
				cmf.passport(cmf.k);
				cmf.k++;
				
			}
			else if(tagnamesPP.get(i).toLowerCase().contains("photo"))
			{
				
				if(h>2)
				{
					h=1;
				}
				cmf.uploadPhoto(h);
				h++;
			}
			
			
			
//			if(cmf.idTypeSelected.contains("Passport"))
//				{
//					cmf.passport(cmf.k);
//				}
			
			
			}
		
		
		
			List<WebElement> phoneNumbersField=driver.findElements(By.xpath("//form[@id='admissionPartOne']//input[@placeholder='Phone Number' or @placeholder='Mobile Number' or contains(@placeholder,'Mobile')]"));
			
			List<WebElement> phoneCodes = driver.findElements(By.xpath("//form[@id='admissionPartOne']//input[@placeholder='Phone Number' or @placeholder='Mobile Number']//preceding-sibling::div//select"));
			List<String> phoneCodeTag = new ArrayList();
			for(WebElement phoneCode:phoneCodes)
			{
				System.out.println("Phone code - "+phoneCode.getAttribute("value"));
				if(phoneCode.getAttribute("value").equals("? string: ?"))
				{
					Select selCode = new Select(phoneCode);
					selCode.selectByValue("376");
				}
			}

		
			for(WebElement phoneNumberField:phoneNumbersField)
			{
				if(phoneNumberField.getAttribute("value").equals(""))
				{
				 cmf.phoneAndMobileNumber(phoneNumberField);
				}
			}
		
		saveAndContinueBtnOnParentPage.click();
			
//		
//		
//		
		//Student details page
		
		
		Thread.sleep(5000);
		
		id="admissionPartTwo";
		cmf= new commonMethodsInAdmissionForm();
		System.out.println(cmf.a+" "+cmf.b+" "+cmf.c+" "+cmf.d);
		List<WebElement> tagNamesStudentPage = driver.findElements(By.xpath("//div[@ng-show='showPageTwo']//span[@class='required-field ng-scope']//ancestor::label")); 
//		List<WebElement> fields = driver.findElements(By.xpath("(//div[@ng-show='showPageTwo']//span[@class='required-field ng-scope']//ancestor::label//following-sibling::*)["+2+"]")); 
		
		
		for(WebElement tagNameSP:tagNamesStudentPage)
		{
			tagNamesSP.add(tagNameSP.getText());
		}
		System.out.println(tagNamesSP);
		
//		List<WebElement> tagNamesStudentPage = driver.findElements(By.xpath("//div[@ng-show='showPageTwo']//span[@class='required-field ng-scope']//ancestor::label")); 
		if(studFirstName.getAttribute("value").equalsIgnoreCase("test"))
		{
			break;
		}
		else 
		{
		for(int j=0;j<tagNamesStudentPage.size();j++)
		{
			
			if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("first")&&!tagNamesStudentPage.get(j).getText().toLowerCase().contains("guardian")&&studFirstName.getAttribute("value").equals(""))
			{
				studFirstName.sendKeys(cmf.IntToLetter(n));
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("last")&&!tagNamesStudentPage.get(j).getText().toLowerCase().contains("guardian")&&studLastName.getAttribute("value").equals(""))
			{
				studLastName.sendKeys("Student");
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("date of birth")||tagNamesStudentPage.get(j).getText().toLowerCase().contains("dob"))
			{
				cmf.dateOfBirth(cmf.b,id);
				
			
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("gender"))
			{
				if(Readpropertyfile("StudentGender").equalsIgnoreCase("male"))
				{
					male.click();
				}
				else if(Readpropertyfile("StudentGender").equalsIgnoreCase("female"))
				{
					female.click();
				}
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("identification")&&!tagNamesStudentPage.get(j).getText().toLowerCase().contains("guardian")&&studIdentification.getAttribute("value").equals(""))
			{
				System.out.println(cmf.c);
				cmf.identificationType(cmf.c,id);
				
				WebElement idNumber = driver.findElement(By.xpath("(//form[@id='admissionPartTwo']//input[contains(@name,'Identification')])["+cmf.c+"]"));
				idNumber.sendKeys(cmf.idNumber());
				String idnum = idNumber.getAttribute("value");
				System.out.println("Id Number is="+idnum);
				cmf.c++;
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("nationality")&&!tagNamesStudentPage.get(j).getText().toLowerCase().contains("guardian nationality")&&studNationality.getAttribute("value").equals(""))
			{
				cmf.nationality(cmf.a,id);
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("passport number")||cmf.idTypeSelected.contains("passport"))
			{
				cmf.passport(cmf.k);
				cmf.k++;
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("place of birth")||tagNamesStudentPage.get(j).getText().toLowerCase().contains("birth place"))
			{
				cmf.birthRelatedFields();
			}
			
			
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("stay with parent during course"))
			{
				
				if(Readpropertyfile("guardianDetailsRequired").equalsIgnoreCase("yes"))
				{
					Thread.sleep(2000);
					guardianDetailsRequired.click();
					cmf.guardianDetails(n);
				}
				else if(Readpropertyfile("guardianDetailsRequired").equalsIgnoreCase("no"))
				{
					Thread.sleep(2000);
					guardianDetailsNotRequired.click();
				}
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("photo"))
			{
				
				cmf.uploadPhoto(3);
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("class")||tagNamesStudentPage.get(j).getText().toLowerCase().contains("grade")&&!tagNamesStudentPage.get(j).getText().toLowerCase().contains("current grade"))
			{
				cmf.classSelectionForAdmission();
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("residential status"))
			{
				Select selres = new Select(residentialStatus);
				 Random ran = new Random();
			        
			        int minRange = 1, maxRange= selres.getOptions().size();
			        int value = ran.nextInt(maxRange - minRange) + minRange;
			        System.out.println(value); 
			        selres.selectByIndex(value);
			}
			
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("current school name")||tagNamesStudentPage.get(j).getText().toLowerCase().contains("present school name"))
			{
				cmf.presentSchoolDetails();
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("date child will attend")||tagNamesStudentPage.get(j).getText().toLowerCase().contains("date student will")||tagNamesStudentPage.get(j).getText().toLowerCase().contains("date of join"))
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@name='SchoolAttendingDate']//following-sibling::div//following-sibling::span/button")).click();
				driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm pull-right uib-right']")).click();
				driver.findElement(By.xpath("//span[text()='15']")).click();
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("block/plot")&&blockOrPlot.getAttribute("value").equalsIgnoreCase(""))
			{
				blockOrPlot.sendKeys("Test block/Plot");
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("address line 1")&&address1.getAttribute("value").equalsIgnoreCase("")||tagNamesStudentPage.get(j).getText().toLowerCase().contains("address 1")&&address1.getAttribute("value").equalsIgnoreCase(""))
			{
				address1.sendKeys("Test address 1");
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("address line 2")&&address2.getAttribute("value").equalsIgnoreCase("")||tagNamesStudentPage.get(j).getText().toLowerCase().contains("address 2")&&address2.getAttribute("value").equalsIgnoreCase(""))
			{
				address2.sendKeys("Test address 2");
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("city")&&!tagNamesStudentPage.get(j).getText().toLowerCase().contains("school city")&&city.getAttribute("value").equalsIgnoreCase(""))
			{
				city.sendKeys("Test city");
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("state")&&state.getAttribute("value").equalsIgnoreCase(""))
			{
				state.sendKeys("Test state");
				
			}
			
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("country")&&!tagNamesStudentPage.get(j).getText().toLowerCase().contains("passport country")&&!tagNamesStudentPage.get(j).getText().toLowerCase().contains("school country")&&!tagNamesStudentPage.get(j).getText().toLowerCase().contains("country of birth")&&homeCountry.getAttribute("value").equals(""))
			{
				
				Select selCont = new Select(country);
				 Random ran = new Random();
			        
			        int minRange = 1, maxRange= selCont.getOptions().size();
			        int value = ran.nextInt(maxRange - minRange) + minRange;
			        System.out.println(value); 
			        selCont.selectByIndex(value);
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("postal code")&&postalCode.getAttribute("value").equalsIgnoreCase(""))
			{
				postalCode.sendKeys("12345");
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("blood group"))
			{
				
				
				Select selCont = new Select(bloodGroup);
				 Random ran = new Random();
			        
			        int minRange = 1, maxRange= selCont.getOptions().size();
			        int value = ran.nextInt(maxRange - minRange) + minRange;
			        System.out.println(value); 
			        selCont.selectByIndex(value);
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("mother tongue"))
			{
				
				
				Select selCont = new Select(motherTongue);
				 Random ran = new Random();
			        
			        int minRange = 1, maxRange= selCont.getOptions().size();
			        int value = ran.nextInt(maxRange - minRange) + minRange;
			        System.out.println(value); 
			        selCont.selectByIndex(value);
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("2nd language")||tagNamesStudentPage.get(j).getText().toLowerCase().contains("second language"))
			{
				
				
				Select selCont = new Select(secondLang);
				 Random ran = new Random();
			        
			        int minRange = 1, maxRange= selCont.getOptions().size();
			        int value = ran.nextInt(maxRange - minRange) + minRange;
			        System.out.println(value); 
			        selCont.selectByIndex(value);
				
			}
			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("3rd language")||tagNamesStudentPage.get(j).getText().toLowerCase().contains("third language"))
			{
				
				
				Select selCont = new Select(thirddLang);
				 Random ran = new Random();
			        
			        int minRange = 1, maxRange= selCont.getOptions().size();
			        int value = ran.nextInt(maxRange - minRange) + minRange;
			        System.out.println(value); 
			        selCont.selectByIndex(value);
				
			}

			else if(tagNamesStudentPage.get(j).getText().toLowerCase().contains("emergency contact name")&&ecName.getAttribute("value").equalsIgnoreCase("")/*||textForSelection.getText().toLowerCase().contains("if you would want to repeat the contact information that was shared earlier, please select ")&&ecName.getAttribute("value").equalsIgnoreCase("")*/)
			{
				cmf.emergencyContact(n);
//				ecName.sendKeys(cmf.IntToLetter(n));
//				System.out.println("Same as above ="+!sameAsAboveChkBox.isSelected());
				
			}
			
			
//			else if(!sameAsAboveChkBox.isSelected()&&address1.getAttribute("value").equalsIgnoreCase("Test"))
//			{
//				
//				sameAsAboveChkBox.click();
//			}
			
//			
		}
		}
		sameAsAboveChkBox.click();
		submitPartTwo.click();
		
		
		//Health and Docs
		
		Thread.sleep(5000);
        List<WebElement> healthQuestion=driver.findElements(By.xpath("//input[@ng-model='formdata.StudentHealthInfo[$index].OptionSelected']/following-sibling::label[text()='Yes']"));
		System.out.println("Number of Health question="+healthQuestion.size());
		 for(int y=1;y<=healthQuestion.size();y++)
		 {
			 Thread.sleep(1000);
			 if(y==1)
			 {
				 driver.findElement(By.xpath("//input[@ng-model='formdata.StudentHealthInfo[$index].OptionSelected']["+y+"]")).click();
				 driver.findElement(By.xpath("(//input[@name='Detail'])["+y+"]")).sendKeys("hfgfgf");
			 }
			 else {	
			 driver.findElement(By.xpath("(//input[@ng-model='formdata.StudentHealthInfo[$index].OptionSelected']/following-sibling::input[@value='No'])["+y+"]")).click();
			//"(//a[@class='view-doc upl-doc-btn']//span)["2"]"
		 }}
		
		 if(Readpropertyfile("priorityParent").equalsIgnoreCase("father"))
		 {
			 driver.findElement(By.xpath("(//input[@value='Father'])[2]")).click();
		 }
		 else if(Readpropertyfile("priorityParent").equalsIgnoreCase("mother"))
		 {
			 driver.findElement(By.xpath("(//input[@value='Mother'])[2]")).click();
		 }
		 
		
		 List<WebElement> documents=driver.findElements(By.xpath("//div[@ng-repeat='dynamicDoc in formdata.documentList']//a//span[contains(text(),'Upload')]"));
			System.out.println("Number of Health question="+healthQuestion.size());
		
			for(int z=1;z<=documents.size();z++)
			{
				 Thread.sleep(2000);
				 driver.findElement(By.xpath("(//a[@class='view-doc upl-doc-btn']//span)["+z+"]")).click();
				 driver.findElement(By.xpath("//input[@name='UploadPhotoModal']")).sendKeys("C:\\Users\\acharpe\\Documents\\TestPdf2.pdf");
				 Thread.sleep(500);
				 driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
				 Thread.sleep(500);
			}
//			submitButtonDocsStep.click();
			
			
			try (FileInputStream in = new FileInputStream("C:\\Users\\acharpe\\eclipse-workspace\\DynamicAdmissionForm\\records.properties")) {
		    props.load(in);
		}
		        
		try (FileOutputStream out = new FileOutputStream("C:\\Users\\acharpe\\eclipse-workspace\\DynamicAdmissionForm\\records.properties"))
		{
			if(n!=numberOfStudent)
			{
				props.setProperty("studentCompleted", Integer.toString(n));
			    props.store(out, null);
			}
			else
			{
				props.setProperty("studentCompleted", "0");
			    props.store(out, null);
			}
		    
		}
		
		
	}

	}
	
}
}

		



