package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class AdmissionFormSigaporeExcel {


	// Admission form for singapore for session 2023-24.
		// Take name and surname from config properties file
		public static void main(String[] args) throws InterruptedException, IOException {
			//AdmissionFormSigaporeExcel adf=new AdmissionFormSigaporeExcel();
			
			FileInputStream file = new FileInputStream("C:\\Users\\acharpe\\eclipse-workspace\\Test\\TestData\\StudentListForSingEC.xlsx");
			Sheet data = WorkbookFactory.create(file).getSheet("Sheet1");
			String value = data.getRow(1).getCell(0).getStringCellValue();
			//String a = adf.readExcelFileSing(1,0);
			System.out.println(value);
		
		}
			
//			for(int i=0;i<=17;i++)
//			{
//			
//					AdmissionFormSigaporeExcel adf = new AdmissionFormSigaporeExcel();
//			
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions opt = new ChromeOptions();
//			opt.setAcceptInsecureCerts(true);
//			WebDriver driver = new ChromeDriver(opt);
//			driver.manage().window().maximize();
//			driver.manage().deleteAllCookies();
//			driver.get(adf.readPropertyFile("URL"));
//			Thread.sleep(10000);
//			WebElement country = driver.findElement(By.xpath("//select[@name='Country']"));
//			Select conSel = new Select(country);
//			conSel.selectByVisibleText("Singapore");
//			Thread.sleep(1000);
//			
//			WebElement Campus = driver.findElement(By.xpath("//select[@name='Campus']"));
//			Select camSel = new Select(Campus);
//			camSel.selectByVisibleText("East Coast");
//			Thread.sleep(1000);
//			
//			WebElement AdmissionFor = driver.findElement(By.xpath("//select[@name='AdmissionFor']"));
//			Select admSel = new Select(AdmissionFor);
//			admSel.selectByVisibleText("2022-2023");
//			Thread.sleep(1000);
//			
//			WebElement firstName = driver.findElement(By.xpath("//input[@name='FatherFirstName']"));
//			//firstName.sendKeys(adf.readExcelFile(i, 0));
//			firstName.sendKeys(adf.readExcelFile(0, 0));
//			Thread.sleep(2000);
//			WebElement lastName = driver.findElement(By.xpath("//input[@name='FatherLastName']"));
//			lastName.sendKeys(adf.readExcelFile(i, 1));
//			Thread.sleep(2000);
//			
//			WebElement eMail = driver.findElement(By.xpath("//input[@name='FatherEmailAddress']"));
//			eMail.sendKeys(adf.readExcelFile(i, 2));
//			Thread.sleep(2000);
//			
//			WebElement mobNum = driver.findElement(By.xpath("//input[@name='FatherhMobileNumber']"));
//			mobNum.sendKeys(adf.readExcelFile(i, 3));
//			Thread.sleep(2000);
//			
//			WebElement fatherRadBtn = driver.findElement(By.xpath("//input[@value='Father']"));
//			WebElement motherRadBtn = driver.findElement(By.xpath("//input[@value='Mother']"));
//			String parent=adf.readExcelFile(i, 4);
//			if(parent.equalsIgnoreCase("Father"))
//			{
//				fatherRadBtn.click();
//			}
//			else if(parent.equalsIgnoreCase("Mother"))
//			{
//				motherRadBtn.click();
//			}
//				}}
//			WebElement saveAndContBtn = driver.findElement(By.xpath("//button[@id='SaveAndContinueButtonPageOne']"));
//			saveAndContBtn.click();
//			//		WebElement country = driver.findElement(By.xpath(""));
////			WebElement country = driver.findElement(By.xpath(""));
//			
//			//2nd Page
//			
//			//WebElement calendar = driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[1]"));
////			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
////			wait.until(ExpectedConditions.elementToBeClickable(calendar));
//			Thread.sleep(15000);
//			//DOB Picker
////			try {
////				WebElement calendar = driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[1]"));
////			    calendar.click();
////			}
////			catch(org.openqa.selenium.StaleElementReferenceException ex)
////			{
////				WebElement calendar = driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[1]"));
////			    calendar.click();
////			}
//			
////			
////			//driver.findElement(By.xpath(""));driver.findElement(By.xpath("//button[contains(@id,'date')]")).click();
////			Thread.sleep(1000);;
////			driver.findElement(By.xpath("//button[contains(@id,'date')]")).click();
////			Thread.sleep(1000);
////			List<WebElement> years = driver.findElements(By.xpath("//tbody//tr//td//button//span"));
////			WebElement backBtn = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm pull-left uib-left']"));
////			String DOB = "24-02-1990";
////			String date=null,month=null,year = null;
////			String[] splitDOB = DOB.split("-");
////			for(int j=0;j<=splitDOB.length;j++)
////			{
////				 date =splitDOB[0];
////				 month=splitDOB[1];
////				 year = splitDOB[2];		 
////			}
////			
////			System.out.println(date);
////			System.out.println(month);
////			System.out.println(year);
//			//Iterator it = years.iterator();
//		
//			
////			for(int i=0;i<6;i++)
////			{
////				for(int j=0;j<years.size();j++)
////				{
////				String yearPres = years.get(i).getText();
////				if(year.equalsIgnoreCase(yearPres))
////					
////				{
////					 years.get(i).click();
////					 break;
////				}	
////				
////				
////			}
////				backBtn.click();
////				Thread.sleep(1000);
////			
////			
////		}
//			//Father Details
//			//Nationality Selection
//			
//			//input[@name='FatherDateofBirth']
//			
//			//button[contains(@id,'datepicker')]
//			
////			 driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[1]")).click();
////		    
////			String monthAndYear = driver.findElement(By.xpath("//button[contains(@id,'datepicker')]")).getText();
////			System.out.println(monthAndYear);
////			String dateAndMonthFromUser="October 2022";
////			for(int i =0;i<2;i++)
////			{
////			if(monthAndYear.equalsIgnoreCase(dateAndMonthFromUser))
////			{
////				break;
////			}
////			else
////			{
////				driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm pull-left uib-left']")).click();
////				Thread.sleep(1000);
////			}
////			}
//			
//			
//			Thread.sleep(2000);
//			 driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[1]")).click();
//			 Thread.sleep(1000);
//			 driver.findElement(By.xpath("//button[text()='Today']")).click();
//			 Thread.sleep(1000);
//			 
//			WebElement nationality = driver.findElement(By.xpath("//select[@name='FatherNationality']"));
//			Select selNat = new Select(nationality);
//			selNat.selectByVisibleText("Indian");
//			
//			//ID selection
//			Thread.sleep(1000);
//			WebElement selectID =driver.findElement(By.xpath("//select[@name='FatherIdentification']"));
//			Select selID = new Select(selectID);
//			selID.selectByVisibleText("NRIC");
//			driver.findElement(By.xpath("//input[@id='FatherIdentificationNumber']")).sendKeys("NRIC001");
//		
//			Thread.sleep(1000);
//			WebElement education = driver.findElement(By.xpath("//select[@name='FatherEducation']"));
//			Select selEdu = new Select(education);
//			selEdu.selectByVisibleText("B.Tech");
//			
//			Thread.sleep(1000);
//			WebElement annualInc = driver.findElement(By.xpath("//select[@name='FatherAnnualIncome']"));//FatherAnnualIncome
//			Select selAnualInc = new Select(annualInc);
//			selAnualInc.selectByVisibleText("80k-140k(SGD)");
//			
//			driver.findElement(By.xpath("//input[@id='FatherEmployerName']")).sendKeys("GIF Technologies");
//			driver.findElement(By.xpath("//input[@id='FthExp']")).sendKeys("5");
//			
//			Thread.sleep(1000);
//			WebElement currPosition = driver.findElement(By.xpath("//select[@name='FatherCurrentPosition']"));//
//			Select selcurrPosition = new Select(currPosition);
//			selcurrPosition.selectByVisibleText("Technical Consultant");
//			
//			Thread.sleep(1000);
//			WebElement maritalStatus = driver.findElement(By.xpath("//select[@name='FatherMartialStatus']"));//
//			Select selmaritalStatus = new Select(maritalStatus);
//			selmaritalStatus.selectByVisibleText("Married");
//			
//			driver.findElement(By.xpath("//input[@name='FatherhHomeNumber']")).sendKeys("76548765");
//			
//			Thread.sleep(1000);
//			WebElement socioEco = driver.findElement(By.xpath("//select[@name='FthSocioEconomic']"));//
//			Select selsocioEco = new Select(socioEco);
//			selsocioEco.selectByVisibleText("Graduate-Service");
//			
//			driver.findElement(By.xpath("(//a[text()='Upload Photograph'])[1]")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys("C:\\Users\\acharpe\\Downloads\\img.jpg");
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[@class='btn btn-primary ng-pristine ng-untouched ng-valid ng-empty']")).click();
//			
//			//Mother Details
//			Thread.sleep(5000);
//			
//			driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[2]")).click();
//			driver.findElement(By.xpath("//button[text()='Today']")).click();
//			JavascriptExecutor js = (JavascriptExecutor) driver;  
//			js.executeScript("window.scrollBy(0,250)", "");
//			driver.findElement(By.xpath("//input[@name='MotherFirstName']")).sendKeys(adf.readProprtyFile("MotherFirstName"));
//			driver.findElement(By.xpath("//input[@name='MotherLastName']")).sendKeys(adf.readProprtyFile("MotherLastName"));
//			
//			Thread.sleep(1000);
//			WebElement nationalityMother = driver.findElement(By.xpath("//select[@name='MotherNationality']"));
//			Select selNatMother = new Select(nationalityMother);
//			selNatMother.selectByVisibleText("Indian");
//			
//			//ID selection
//			Thread.sleep(1000);
//			WebElement selectIDMother =driver.findElement(By.xpath("//select[@name='MotherIdentification']"));
//			Select selIDMother  = new Select(selectIDMother);
//			selIDMother .selectByVisibleText("NRIC");
//			driver.findElement(By.xpath("//input[@name='MotherIdentificationNumber']")).sendKeys("NRIC001");
//		
//			Thread.sleep(1000);
//			WebElement educationMother  = driver.findElement(By.xpath("//select[@name='MotherEducation']"));
//			Select selEduMother  = new Select(educationMother);
//			selEduMother .selectByVisibleText("B.Tech");
//			
//			Thread.sleep(1000);
//			WebElement annualIncMother  = driver.findElement(By.xpath("//select[@name='MotherAnnualIncome']"));//FatherAnnualIncome
//			Select selAnualIncMother  = new Select(annualIncMother);
//			selAnualIncMother .selectByVisibleText("80k-140k(SGD)");
//			
//			driver.findElement(By.xpath("//input[@id='MotherEmployerName']")).sendKeys("GIF Technologies");
//			driver.findElement(By.xpath("//input[@id='MthExp']")).sendKeys("2");
//			
//			Thread.sleep(1000);
//			WebElement currPositionMother  = driver.findElement(By.xpath("//select[@name='MotherCurrentPosition']"));//
//			Select selcurrPositionMother  = new Select(currPositionMother);
//			selcurrPositionMother .selectByVisibleText("Consultant");
//			
//			Thread.sleep(1000);
//			WebElement maritalStatusMother  = driver.findElement(By.xpath("//select[@name='MotherMartialStatus']"));//
//			Select selmaritalStatusMother  = new Select(maritalStatusMother);
//			selmaritalStatusMother .selectByVisibleText("Married");
//			
//			driver.findElement(By.xpath("//input[@name='MotherEmailAddress']")).sendKeys("abc@test.com");
//			driver.findElement(By.xpath("//input[@name='MotherhMobileNumber']")).sendKeys("543234567");
//			
//			driver.findElement(By.xpath("//input[@name='MotherhHomeNumber']")).sendKeys("543764567");
//			
//			Thread.sleep(1000);
//			WebElement socioEcoMother  = driver.findElement(By.xpath("//select[@name='MthSocioEconomic']"));//
//			Select selsocioEcoMother  = new Select(socioEcoMother);
//			selsocioEcoMother .selectByVisibleText("Graduate-Service");
//			
//			driver.findElement(By.xpath("(//a[text()='Upload Photograph'])[2]")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys("C:\\Users\\acharpe\\Downloads\\img.jpg");
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[@class='btn btn-primary ng-pristine ng-valid ng-not-empty ng-touched']")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//button[normalize-space(text())='Save & Continue'])[3]")).click();
//			
//			
//			
//			//page 3 student info
//			Thread.sleep(10000);
//			driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(adf.readProprtyFile("FirstNameStudent"));
//			driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(adf.readProprtyFile("LastNameStudent"));
//			
//			driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[3]")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//button[text()='Today']")).click();
//			
//			String gender=adf.readProprtyFile("GenderStudent");
//			if(gender.equalsIgnoreCase("Male"))
//			{
//				driver.findElement(By.xpath("//input[@value='Male']")).click();
//			}
//			else if(gender.equalsIgnoreCase("Female"))
//			{
//				driver.findElement(By.xpath("//input[@value='Female']")).click();
//			}
//			
//			driver.findElement(By.xpath("//input[@name='PhoneNumber']")).sendKeys("234566687");
//			
//			WebElement stuID = driver.findElement(By.xpath("//select[@name='Identification']"));
//			Select selStudID = new Select(stuID);
//			selStudID.selectByVisibleText("NRIC");
//			driver.findElement(By.xpath("//input[@name='IdentificationNumber']")).sendKeys("NRIC003");
//			
//			WebElement studNationality = driver.findElement(By.xpath("//select[@name='Nationality']"));
//			Select selStudNationality = new Select(studNationality);
//			selStudNationality.selectByVisibleText("Indian");
//			
//			driver.findElement(By.xpath("//input[@name='StudBithPlace']")).sendKeys("Nagpur");
//			
//			WebElement studBirthCountry = driver.findElement(By.xpath("//select[@name='CountryofBirth']"));
//			Select selstudBirthCountry = new Select(studBirthCountry);
//			selstudBirthCountry.selectByVisibleText("India");
//			
//			//select[@name='ClassStuding']
//			WebElement studSeekingAdmiss = driver.findElement(By.xpath("//select[@name='ClassStuding']"));
//			Select selstudSeekingAdmiss = new Select(studSeekingAdmiss);
//			selstudSeekingAdmiss.selectByVisibleText(adf.readProprtyFile("ClassToTakeAdmissionIn"));
//			
//			WebElement studCurrClass = driver.findElement(By.xpath("//select[@name='Class']"));
//			Select selstudCurrClass = new Select(studCurrClass);
//			selstudCurrClass.selectByVisibleText(adf.readProprtyFile("CurrClass"));
//			
//			
//			driver.findElement(By.xpath("//input[@name='PresentSchoolName']")).sendKeys("Pre Primary");
//			
//			driver.findElement(By.xpath("//input[@name='PresentSchoolCity']")).sendKeys("Nagpur");
//			
//			
//			WebElement studCurrentSchoolCountry = driver.findElement(By.xpath("//select[@name='PresentSchoolCountry']"));
//			Select selstudCurrentSchoolCountry = new Select(studCurrentSchoolCountry);
//			selstudCurrentSchoolCountry.selectByVisibleText("India");
//			
//			
//			WebElement studBloodGrp = driver.findElement(By.xpath("//select[@name='BloodGroup']"));
//			Select selstudBloodGrp = new Select(studBloodGrp);
//			selstudBloodGrp.selectByVisibleText("B+");
//			
//			driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[4]")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//button[text()='Today']")).click();
//			
//			
//			WebElement studMotherTongue = driver.findElement(By.xpath("//select[@name='MotherTongue']"));
//			Select selstudMotherTongue = new Select(studMotherTongue);
//			selstudMotherTongue.selectByVisibleText("Hindi/Urdu");
//			
//			
//			WebElement studEthnicGrp = driver.findElement(By.xpath("//select[@name='StudRaceId']"));
//			Select selstudEthnicGrp = new Select(studEthnicGrp);
//			selstudEthnicGrp.selectByVisibleText("Indian");
//			
//			
//			driver.findElement(By.xpath("//a[@id='AncStudentPhotograph']")).click();
//			driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys("C:\\Users\\acharpe\\Downloads\\img1.jpg");
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
//			Thread.sleep(2000);
//			
//			WebElement studSecondLang = driver.findElement(By.xpath("//select[@name='SecondLang']"));
//			Select selstudSecondLang = new Select(studSecondLang);
//			selstudSecondLang.selectByValue("30");
//			
//
//			WebElement studThirdLang = driver.findElement(By.xpath("//select[@name='ThirdLang']"));
//			Select selstudThirdLang = new Select(studThirdLang);
//			selstudThirdLang.selectByVisibleText("Hindi");
//			
//			
//			WebElement studResidentStatus = driver.findElement(By.xpath("//select[@name='ResidentialStatus']"));
//			Select selstudResidentStatus= new Select(studResidentStatus);
//			selstudResidentStatus.selectByVisibleText("Own");
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@name='Block']")).sendKeys("32");
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@name='AddressLine1']")).sendKeys("Mihan");
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@name='AddressLine2']")).sendKeys("Mihan2");
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@name='City']")).sendKeys("Nagpur",Keys.TAB);
//			Thread.sleep(1000);
//			WebElement studHomeCont = driver.findElement(By.xpath("//select[@name='CurrentHomeCountry']"));
//			Thread.sleep(1000);
//			Select selstudHomeCont = new Select(studHomeCont);
//			selstudHomeCont.selectByValue("India");
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@name='PostalCode']")).sendKeys("123456");
//			Thread.sleep(1000);
//			String studentStayWithParent = "Yes";
//			if(studentStayWithParent.equalsIgnoreCase("Yes"))
//			{
//				driver.findElement(By.xpath("(//input[@name='StudentStayWithParent'])[1]")).click();
//			}
//			else
//			{
//				driver.findElement(By.xpath("(//input[@name='StudentStayWithParent'])[2]")).click();
//			}
//			
//			
//			driver.findElement(By.xpath("//input[@name='SibName']")).sendKeys(adf.readProprtyFile("SiblingName"));
//			
//			driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[5]")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[text()='Today']")).click();
//			driver.findElement(By.xpath("//input[@name='SibPrestSchlName']")).sendKeys(adf.readProprtyFile("SiblingPresentSchool"));
//			
//			//emergencyContact by default set to father
//			
//			driver.findElement(By.xpath("(//button[normalize-space(text())='Save & Continue'])[5]")).click();
//			
//			
//			
//			//page4
//			 
//			Thread.sleep(15000);
//			 WebElement medicalConditionNo = driver.findElement(By.xpath("//input[@name='OptionSelected_1'][2]"));
//			 medicalConditionNo.click();
//			 
//			 
//			 WebElement hearingSpeechNo = driver.findElement(By.xpath("//input[@name='OptionSelected_2'][2]"));
//			 hearingSpeechNo.click();
//			 
//			 
//			 WebElement specialNeedNo = driver.findElement(By.xpath("//input[@name='OptionSelected_3'][2]"));
//			 specialNeedNo.click();
//			 
//			 WebElement behaviouralDiffNo = driver.findElement(By.xpath("//input[@name='OptionSelected_4'][2]"));
//			 behaviouralDiffNo.click();
//			 
//			 
//			 WebElement anyOtherNo = driver.findElement(By.xpath("//input[@name='OptionSelected_5'][2]"));
//			 anyOtherNo.click();
//			 
//			String pickUp = adf.readProprtyFile("PickUp");//
//			
//			if(pickUp.equalsIgnoreCase("Bus"))
//			{
//				driver.findElement(By.xpath("//input[@value='School Bus']")).click();
//			}
//			else if(pickUp.equalsIgnoreCase("Mother"))
//			{
//				driver.findElement(By.xpath("//input[@value='Mother']")).click();
//			}
//			else if(pickUp.equalsIgnoreCase("Father"))
//			{
//				driver.findElement(By.xpath("//input[@value='Father']")).click();
//			}
//			else if(pickUp.equalsIgnoreCase("Another Individual"))
//			{
//				driver.findElement(By.xpath("//input[@value='Another Individual']")).click();
//			}
//			
//			Thread.sleep(2000);
//			//to upload passport
//			driver.findElement(By.xpath("//a[text()='Upload Document'][1]")).click();
//			driver.findElement(By.xpath("//input[@name='UploadPhotoModal']")).sendKeys("C:\\Users\\acharpe\\Downloads\\img1.jpg");
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
//			Thread.sleep(10000);
//			
//			// to upload NRIC
//			
//					driver.findElement(By.xpath("(//a[text()='Upload Document'])[2]")).click();
//					driver.findElement(By.xpath("//input[@name='UploadPhotoModal']")).sendKeys("C:\\Users\\acharpe\\Downloads\\img1.jpg");
//					Thread.sleep(2000);
//					driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
//					Thread.sleep(10000);
//			//to upload immunization 
//				
//							
//				            driver.findElement(By.xpath("(//a[text()='Upload Document'])[3]")).click();
//							driver.findElement(By.xpath("//input[@name='UploadPhotoModal']")).sendKeys("C:\\Users\\acharpe\\Downloads\\img1.jpg");
//							Thread.sleep(2000);
//							driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
//							Thread.sleep(10000);
//					
//							// to upload TC
//							driver.findElement(By.xpath("(//a[text()='Upload Document'])[4]")).click();
//							driver.findElement(By.xpath("//input[@name='UploadPhotoModal']")).sendKeys("C:\\Users\\acharpe\\Downloads\\img1.jpg");
//							Thread.sleep(2000);
//							driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
//							Thread.sleep(10000);
//							
//							
//							// to upload Ms
//							driver.findElement(By.xpath("(//a[text()='Upload Document'])[5]")).click();
//							driver.findElement(By.xpath("//input[@name='UploadPhotoModal']")).sendKeys("C:\\Users\\acharpe\\Downloads\\img1.jpg");
//							Thread.sleep(2000);
//							driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
//							Thread.sleep(10000);
//							
//							
//							// to upload MR
//							driver.findElement(By.xpath("(//a[text()='Upload Document'])[6]")).click();
//							driver.findElement(By.xpath("//input[@name='UploadPhotoModal']")).sendKeys("C:\\Users\\acharpe\\Downloads\\img1.jpg");
//							Thread.sleep(2000);
//							driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
//							Thread.sleep(10000);
//							
//							// to upload other
//							driver.findElement(By.xpath("(//a[text()='Upload Document'])[7]")).click();
//							driver.findElement(By.xpath("//input[@name='UploadPhotoModal']")).sendKeys("C:\\Users\\acharpe\\Downloads\\img1.jpg");
//							Thread.sleep(2000);
//							driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
//							Thread.sleep(10000);
//							
//							 String satisfactionNum = adf.readProprtyFile("Rating");
//							 
//							 if(satisfactionNum.equals("1"))
//							 {
//								 driver.findElement(By.xpath("(//input[@name='SatisfactionLevel'])[1]")).click();
//							 }
//							 else if(satisfactionNum.equals("2"))
//								 {
//									 driver.findElement(By.xpath("(//input[@name='SatisfactionLevel'])[2]")).click();
//								 }
//							 else if(satisfactionNum.equals("3"))
//							 {
//								 driver.findElement(By.xpath("(//input[@name='SatisfactionLevel'])[3]")).click();
//							 }
//							 else if(satisfactionNum.equals("4"))
//							 {
//								 driver.findElement(By.xpath("(//input[@name='SatisfactionLevel'])[4]")).click();
//							 }
//							 else if(satisfactionNum.equals("5"))
//							 {
//								 driver.findElement(By.xpath("(//input[@name='SatisfactionLevel'])[5]")).click();
//							 }
//							 
//							 Thread.sleep(2000);
//							 driver.findElement(By.xpath("//input[@name='AdditionalFeedback']")).sendKeys(adf.readProprtyFile("AdditionalFeedback"));
//							 Thread.sleep(2000);
//							 driver.findElement(By.xpath("(//button[normalize-space(text())='Submit'])[1]")).click();
//				}
			//}
		
//		public String readExcelFileSing(int row,int cell) throws IOException
//		{
//			FileInputStream file = new FileInputStream("C:\\Users\\acharpe\\eclipse-workspace\\Test\\TestData\\StudentListForSingEC.xlsx");
//			Sheet data = WorkbookFactory.create(file).getSheet("Sheet1");
//			String value = data.getRow(row).getCell(cell).getStringCellValue();
//			return value;
//		}
//		
//		public String readPropertyFile(String value) throws IOException
//		{
//			FileInputStream file = new FileInputStream("C:\\Users\\acharpe\\eclipse-workspace\\Test\\AdmiFormExcelSinga.properties");
//			Properties prop = new Properties();
//			prop.load(file);
//			return prop.getProperty(value);
//		}
		
	}


