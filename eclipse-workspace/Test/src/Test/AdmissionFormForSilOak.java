package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AdmissionFormForSilOak {

	public static void main(String[] args) throws IOException, InterruptedException {
		AdmissionFormForSilOak adf = new AdmissionFormForSilOak();
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(adf.readProprtyFile("URL"));
		Thread.sleep(10000);
//		WebElement country = driver.findElement(By.xpath("//select[@name='Country']"));
//		Select conSel = new Select(country);
//		conSel.selectByVisibleText("Singapore");
//		Thread.sleep(1000);
		
		WebElement Campus = driver.findElement(By.xpath("//select[@name='Campus']"));
		Select camSel = new Select(Campus);
		camSel.selectByVisibleText(adf.readProprtyFile("Campus"));
		Thread.sleep(1000);
		
		WebElement AdmissionFor = driver.findElement(By.xpath("//select[@name='AdmissionFor']"));
		Select admSel = new Select(AdmissionFor);
		admSel.selectByVisibleText(adf.readProprtyFile("AdmissionForSession"));
		Thread.sleep(1000);
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='FatherFirstName1']"));
		firstName.sendKeys(adf.readProprtyFile("FatherFirstName"));
		//firstName.sendKeys("Testgh");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@name='FatherLastName']"));
		//lastName.sendKeys(adf.readProprtyFile("FatherLastName"));
		lastName.sendKeys("Father");
		
		WebElement eMail = driver.findElement(By.xpath("//input[@name='FatherEmailAddress']"));
		eMail.sendKeys(adf.readProprtyFile("FatherEmailAddress"));
		WebElement mobNum = driver.findElement(By.xpath("//input[@name='FatherhMobileNumber']"));
		mobNum.sendKeys(adf.readProprtyFile("FatherhMobileNumber"));
		WebElement relation = driver.findElement(By.xpath("//select[@name='RelationWithStudent']"));
		Select selrel = new Select(relation);
		selrel.selectByVisibleText(adf.readProprtyFile("RelationWithChild"));
		
		WebElement saveAndContBtn = driver.findElement(By.xpath("//button[@id='SaveAndContinueButtonPageOne']"));
		saveAndContBtn.click();
		
		// Page 2
		Thread.sleep(10000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js1.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h4[text()='Referral Details']")));
		
		js1.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		Thread.sleep(10000);
		 driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[1]")).click();
		 Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@id,'datepicker')]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[contains(@id,'datepicker')]")).click();
		 Thread.sleep(2000);
		java.util.List<WebElement> years = driver.findElements(By.xpath("//tbody//tr//td//button//span"));
		 
		 String dateOfBirthFather = adf.readProprtyFile("FatherDOB");
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
					 System.out.println(actualYear);
					 System.out.println(yearExp);
					 years.get(j).click();
					 Thread.sleep(2000);
					 java.util.List<WebElement> actualMonths = driver.findElements(By.xpath("//tbody//tr//td"));
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

					java.util.List<WebElement> actualDates = driver.findElements(By.xpath("//tbody//tr//td//span[@class='ng-binding']"));
					 Thread.sleep(2000);
					 for(int k=0;k<actualDates.size();k++)
					 {
						 //Thread.sleep(2000);
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
				 while(get==false)
				 {
					 driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-chevron-left']")).click();
					 break;
				 }

			 
			 
		 }
		 
		WebElement nationality = driver.findElement(By.xpath("//select[@name='FatherNationality']"));
		Select selNat = new Select(nationality);
		//System.out.println(nationality.getText());
		selNat.selectByVisibleText(adf.readProprtyFile("FatherNationality"));
		
		//ID selection
		Thread.sleep(1000);
		WebElement selectID =driver.findElement(By.xpath("//select[@name='FatherIdentification']"));
		Select selID = new Select(selectID);
		selID.selectByVisibleText("Aadhaar Card");
		driver.findElement(By.xpath("//input[@name='FatherIdentificationNumber']")).sendKeys(adf.readProprtyFile("IDNumberFather"));
	
		Thread.sleep(1000);
		WebElement education = driver.findElement(By.xpath("//select[@name='FatherEducation']"));
		Select selEdu = new Select(education);
		selEdu.selectByVisibleText("B.Tech");
		
		Thread.sleep(1000);
		WebElement annualInc = driver.findElement(By.xpath("//select[@name='FatherAnnualIncome']"));//FatherAnnualIncome
		Select selAnualInc = new Select(annualInc);
		selAnualInc.selectByVisibleText("140k-200k");
		
		driver.findElement(By.xpath("//input[@id='FatherEmployerName']")).sendKeys("GIF Technologies");
		//driver.findElement(By.xpath("//input[@id='FthExp']")).sendKeys("5");
		
		Thread.sleep(1000);
		WebElement currPosition = driver.findElement(By.xpath("//select[@name='FatherCurrentPosition']"));//
		Select selcurrPosition = new Select(currPosition);
		selcurrPosition.selectByVisibleText("Technical Consultant");
		
		Thread.sleep(1000);
		WebElement maritalStatus = driver.findElement(By.xpath("//select[@name='FatherMartialStatus']"));//
		Select selmaritalStatus = new Select(maritalStatus);
		selmaritalStatus.selectByVisibleText("Married");
		
		driver.findElement(By.xpath("//input[@name='FatherhHomeNumber']")).sendKeys("76548765");
		
		Thread.sleep(1000);
//		WebElement socioEco = driver.findElement(By.xpath("//select[@name='FthSocioEconomic']"));//
//		Select selsocioEco = new Select(socioEco);
//		selsocioEco.selectByVisibleText("Graduate-Service");
		WebElement passportNum=driver.findElement(By.xpath("//input[@name='FatherPassportNumber']"));
		passportNum.sendKeys(adf.readProprtyFile("FatherPassNum"));
		Thread.sleep(1000);
		
		WebElement passIssueDate=driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[2]"));
		passIssueDate.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		Thread.sleep(2000);
		
		WebElement passExpDate = driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[3]"));
		passExpDate.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm pull-right uib-right']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='06']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[text()='Today']")).click();
		//Thread.sleep(2000);
		
		WebElement passIssueCnty = driver.findElement(By.xpath("//select[@name='FatherPassportCountyIssue']"));
		Select passIssueCntySel = new Select(passIssueCnty);
		passIssueCntySel.selectByVisibleText(adf.readProprtyFile("FathPassIssueCountry"));
		
//		driver.findElement(By.xpath("(//a[text()='Upload Photograph'])[1]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("FatherPhotoAddress"));
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@class='btn btn-primary ng-pristine ng-untouched ng-valid ng-empty']")).click();
//		
		
		
		
		//Mother Details
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='MotherFirstName']")).sendKeys(adf.readProprtyFile("MotherFirstName"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='MotherLastName']")).sendKeys("Mother");
		Thread.sleep(1000);
		Thread.sleep(10000);
		 driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[4]")).click();
		 Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@id,'datepicker')]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[contains(@id,'datepicker')]")).click();
		 Thread.sleep(2000);
		 java.util.List<WebElement> yearsMother = driver.findElements(By.xpath("//tbody//tr//td//button//span"));
		 
		 String dateOfBirthMother = adf.readProprtyFile("MotherDOB");
		 Thread.sleep(2000);
		 String[] dateSplitMother =  dateOfBirthMother.split("-");
		 String yearExpMother = dateSplitMother[2];
		 String monthExpMother=dateSplitMother[1];
		 String dateExpMother=dateSplitMother[0];
		 boolean getFlagMother=false;
		 for( int l=0;l<5;l++)
		 {

			 yearsMother = driver.findElements(By.xpath("//tbody//tr//td//button//span"));
			 for(int m=0;m<yearsMother.size();m++)
			 {
				 Thread.sleep(2000);
				 String actualYearMother = yearsMother.get(m).getText();

				 if(actualYearMother.equals(yearExpMother))
				 {
					 getFlagMother = true;
					 yearsMother.get(m).click();
					 Thread.sleep(2000);
					 java.util.List<WebElement> actualMonthsMother = driver.findElements(By.xpath("//tbody//tr//td"));
					 Thread.sleep(2000);
					 for(int n=0;n<actualMonthsMother.size();n++)
					 {
						 Thread.sleep(2000);
						 String actualMonthMother = actualMonthsMother.get(n).getText();
						 if(monthExpMother.equals(actualMonthMother))
						 {
							 actualMonthsMother.get(n).click();
							 break;
						 }
					 }

					 Thread.sleep(2000);

					 java.util.List<WebElement> actualDatesMother = driver.findElements(By.xpath("//tbody//tr//td//span[@class='ng-binding']"));
					 Thread.sleep(2000);
					 for(int o=0;o<actualDatesMother.size();o++)
					 {
						 Thread.sleep(2000);
						 String actualDateMother = actualDatesMother.get(o).getText();
						 if(dateExpMother.equals(actualDateMother))
						 {
							 actualDatesMother.get(o).click();
							 break;
						 }
					 }

					 break;
				 }
			 }
				 while(getFlagMother==false)
				 {
					 driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-chevron-left']")).click();
					 break;
				 }


			 }
		
		
		WebElement nationalityMother = driver.findElement(By.xpath("//select[@name='MotherNationality']"));
		Select selNatMother = new Select(nationalityMother);
		selNatMother.selectByVisibleText(adf.readProprtyFile("MotherNationality"));
		
		//ID selection
		Thread.sleep(1000);
		WebElement selectIDMother =driver.findElement(By.xpath("//select[@name='MotherIdentification']"));
		Select selIDMother  = new Select(selectIDMother);
		selIDMother .selectByVisibleText("Aadhaar Card");
		driver.findElement(By.xpath("//input[@name='MotherIdentificationNumber']")).sendKeys(adf.readProprtyFile("IDNumberMother"));
	
		Thread.sleep(1000);
		WebElement educationMother  = driver.findElement(By.xpath("//select[@name='MotherEducation']"));
		Select selEduMother  = new Select(educationMother);
		selEduMother .selectByVisibleText("B.Tech");
		
		Thread.sleep(1000);
		WebElement annualIncMother  = driver.findElement(By.xpath("//select[@name='MotherAnnualIncome']"));//FatherAnnualIncome
		Select selAnualIncMother  = new Select(annualIncMother);
		selAnualIncMother .selectByVisibleText("200k-250k");
		
		driver.findElement(By.xpath("//input[@id='MotherEmployerName']")).sendKeys(adf.readProprtyFile("MEmployer"));
		//driver.findElement(By.xpath("//input[@id='MthExp']")).sendKeys("2");
		
		Thread.sleep(1000);
		WebElement currPositionMother  = driver.findElement(By.xpath("//select[@name='MotherCurrentPosition']"));//
		Select selcurrPositionMother  = new Select(currPositionMother);
		selcurrPositionMother .selectByVisibleText("Consultant");
		
		Thread.sleep(1000);
		WebElement maritalStatusMother  = driver.findElement(By.xpath("//select[@name='MotherMartialStatus']"));//
		Select selmaritalStatusMother  = new Select(maritalStatusMother);
		selmaritalStatusMother .selectByVisibleText("Married");
		
		driver.findElement(By.xpath("//input[@name='MotherEmailAddress']")).sendKeys(adf.readProprtyFile("MotherEmailAdd"));
		driver.findElement(By.xpath("//input[@name='MotherhMobileNumber']")).sendKeys(adf.readProprtyFile("MotherMobNum"));
		
		//driver.findElement(By.xpath("//input[@name='MotherhHomeNumber']")).sendKeys(adf.readProprtyFile("MotherHomNum"));
		
		WebElement passportNumMother=driver.findElement(By.xpath("//input[@name='MotherPassportNumber']"));
		passportNumMother.sendKeys(adf.readProprtyFile("passportNumMother"));
		Thread.sleep(1000);
		
		WebElement passIssueDateMother=driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[5]"));
		passIssueDateMother.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		Thread.sleep(2000);
		
		WebElement passExpDateMother = driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[6]"));
		passExpDateMother.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm pull-right uib-right']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='07']")).click();
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[text()='Today']")).click();
		Thread.sleep(2000);
		
		WebElement passIssueCntyMother = driver.findElement(By.xpath("//select[@name='MotherPassportCountyIssue']"));
		Select passIssueCntyMotherSel = new Select(passIssueCntyMother);
		passIssueCntyMotherSel.selectByVisibleText(adf.readProprtyFile("MotherPassIssueCountry"));
		Thread.sleep(2000);
//		WebElement socioEcoMother  = driver.findElement(By.xpath("//select[@name='MthSocioEconomic']"));//
//		Select selsocioEcoMother  = new Select(socioEcoMother);
//		selsocioEcoMother .selectByVisibleText("Graduate-Service");
		
//		driver.findElement(By.xpath("(//a[text()='Upload Photograph'])[2]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("PhotoAddress"));
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@class='btn btn-primary ng-pristine ng-valid ng-not-empty ng-touched']")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[normalize-space(text())='Save & Continue'])[3]")).click();
		
		
		
		//page 3 student info
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(adf.readProprtyFile("FirstNameStudent"));
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(adf.readProprtyFile("FirstNameStudent"));
		//driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(adf.readProprtyFile("LastNameStudent"));
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Student");
		
		 driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[7]")).click();
		 Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@id,'datepicker')]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[contains(@id,'datepicker')]")).click();
		 Thread.sleep(2000);
		java.util.List<WebElement> yearsStudent = driver.findElements(By.xpath("//tbody//tr//td//button//span"));
		 
		 String dateOfBirthStudent = adf.readProprtyFile("StudentDOB");
		 Thread.sleep(2000);
		 String[] dateSplitStudent =  dateOfBirthStudent.split("-");
		 String yearExpStudent = dateSplitStudent[2];
		 String monthExpStudent=dateSplitStudent[1];
		 String dateExpStudent=dateSplitStudent[0];
		 boolean getFlagStudent=false;
		 for( int p=0;p<5;p++)
		 {

			 yearsStudent = driver.findElements(By.xpath("//tbody//tr//td//button//span"));
			 for(int q=0;q<yearsStudent.size();q++)
			 {


				 String actualYear = yearsStudent.get(q).getText();

				 if(actualYear.equals(yearExpStudent))
				 {
					 getFlagStudent = true;
					 yearsStudent.get(q).click();
					 Thread.sleep(2000);
					  java.util.List<WebElement> actualMonthsStudent = driver.findElements(By.xpath("//tbody//tr//td"));
					 Thread.sleep(2000);
					 for(int r=0;r<actualMonthsStudent.size();r++)
					 {
						 
						 String actualMonth = actualMonthsStudent.get(r).getText();
						 if(monthExpStudent.equals(actualMonth))
						 {
							 actualMonthsStudent.get(r).click();
							 break;
						 }
					 }

					 Thread.sleep(2000);

					  java.util.List<WebElement> actualDatesStudent = driver.findElements(By.xpath("//tbody//tr//td//span[@class='ng-binding']"));
					 Thread.sleep(2000);
					 for(int s=0;s<actualDatesStudent.size();s++)
					 {
						 
						 String actualDateStudent = actualDatesStudent.get(s).getText();
						 if(dateExpStudent.equals(actualDateStudent))
						 {
							 actualDatesStudent.get(s).click();
							 break;
						 }
					 }

					 break;
				 }
			 }
				 while(getFlagStudent==false)
				 {
					 driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-chevron-left']")).click();
					 break;
				 }


			 
		 }
		
		
		
		
		String gender=adf.readProprtyFile("GenderStudent");
		if(gender.equalsIgnoreCase("Male"))
		{
			driver.findElement(By.xpath("//input[@value='Male']")).click();
		}
		else if(gender.equalsIgnoreCase("Female"))
		{
			driver.findElement(By.xpath("//input[@value='Female']")).click();
		}
		
		driver.findElement(By.xpath("//input[@name='PhoneNumber']")).sendKeys("234566687");
		
		WebElement stuID = driver.findElement(By.xpath("//select[@name='Identification']"));
		Select selStudID = new Select(stuID);
		selStudID.selectByVisibleText("Others");
		driver.findElement(By.xpath("//input[@name='IdentificationNumber']")).sendKeys(adf.readProprtyFile("IDNumberStudent"));
		
		Thread.sleep(1000);
		WebElement studNationality = driver.findElement(By.xpath("//select[@name='Nationality']"));
		Select selStudNationality = new Select(studNationality);
		selStudNationality.selectByVisibleText(adf.readProprtyFile("StudentNationality"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='StudentBirthPlace']")).sendKeys(adf.readProprtyFile("PlaceOfBirth"));
		
		WebElement studBirthCountry = driver.findElement(By.xpath("//select[@name='CountryofBirth']"));
		Select selstudBirthCountry = new Select(studBirthCountry);
		selstudBirthCountry.selectByVisibleText(adf.readProprtyFile("StudBirthCountry"));
		Thread.sleep(1000);
		
		//select[@name='ClassStuding']
		WebElement studSeekingAdmiss = driver.findElement(By.xpath("//select[@name='Class']"));
		Select selstudSeekingAdmiss = new Select(studSeekingAdmiss);
		//selstudSeekingAdmiss.selectByVisibleText(adf.readProprtyFile("ClassToTakeAdmissionIn"));
		selstudSeekingAdmiss.selectByVisibleText(adf.readProprtyFile("ClassToTakeAdmissionIn"));
		Thread.sleep(1000);
		
		WebElement studCurrClass = driver.findElement(By.xpath("//select[@name='CurrentGrade']"));
		Select selstudCurrClass = new Select(studCurrClass);
		selstudCurrClass.selectByVisibleText(adf.readProprtyFile("CurrClass"));
		
		
		driver.findElement(By.xpath("//input[@name='PresentSchoolName']")).sendKeys(adf.readProprtyFile("PresentSchoolName"));
		
		driver.findElement(By.xpath("//input[@name='PresentSchoolCity']")).sendKeys(adf.readProprtyFile("SchoolCity"));
		
		
		WebElement studCurrentSchoolCountry = driver.findElement(By.xpath("//select[@name='PresentSchoolCountry']"));
		Select selstudCurrentSchoolCountry = new Select(studCurrentSchoolCountry);
		selstudCurrentSchoolCountry.selectByVisibleText(adf.readProprtyFile("PresentSchoolCountry"));
		
		
		WebElement studBloodGrp = driver.findElement(By.xpath("//select[@name='BloodGroup']"));
		Select selstudBloodGrp = new Select(studBloodGrp);
		selstudBloodGrp.selectByVisibleText("B+");
		
//		driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[4]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[text()='Today']")).click();
		Thread.sleep(10000);
		 driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[8]")).click();
		 Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@id,'datepicker')]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[contains(@id,'datepicker')]")).click();
		 Thread.sleep(2000);
		  java.util.List<WebElement> yearsStudentAttend = driver.findElements(By.xpath("//tbody//tr//td//button//span"));
		 
		 String dateStudentWillJoin= adf.readProprtyFile("StudentJoiningDate");
		 Thread.sleep(2000);
		 String[] dateSplitStudentJoining =  dateStudentWillJoin.split("-");
		 String yearExpStudentJoining = dateSplitStudentJoining[2];
		 String monthExpStudentJoining=dateSplitStudentJoining[1];
		 String dateExpStudentJoining=dateSplitStudentJoining[0];
		 boolean getFlagStudentJoining=false;
		 for( int t=0;t<5;t++)
		 {

			 yearsStudent = driver.findElements(By.xpath("//tbody//tr//td//button//span"));
			 for(int u=0;u<yearsStudentAttend.size();u++)
			 {


				 String actualYearAtten = yearsStudentAttend.get(u).getText();

				 if(actualYearAtten.equals(yearExpStudentJoining))
				 {
					 getFlagStudentJoining = true;
					 yearsStudentAttend.get(u).click();
					 Thread.sleep(2000);
					java.util.List<WebElement> actualMonthsStudent = driver.findElements(By.xpath("//tbody//tr//td"));
					 Thread.sleep(2000);
					 for(int v=0;v<actualMonthsStudent.size();v++)
					 {
						 
						 String actualMonth = actualMonthsStudent.get(v).getText();
						 if(monthExpStudentJoining.equals(actualMonth))
						 {
							 actualMonthsStudent.get(v).click();
							 break;
						 }
					 }

					 Thread.sleep(2000);

					 java.util.List<WebElement> actualDatesStudent = driver.findElements(By.xpath("//tbody//tr//td//span[@class='ng-binding']"));
					 Thread.sleep(2000);
					 for(int w=0;w<actualDatesStudent.size();w++)
					 {
						 
						 String actualDateStudent = actualDatesStudent.get(w).getText();
						 if(dateExpStudentJoining.equals(actualDateStudent))
						 {
							 actualDatesStudent.get(w).click();
							 break;
						 }
					 }

					 break;
				 }
			 }
				 while(getFlagStudentJoining==false)
				 {
					 driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-chevron-right']")).click();
					 break;
				 }


			 
		 }
		
		
		WebElement passportNumStudent=driver.findElement(By.xpath("//input[@name='StudentPassportNumber']"));
		passportNumStudent.sendKeys(adf.readProprtyFile("passportNumStudent"));
		Thread.sleep(1000);
		
		WebElement passIssueDateStudent=driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[9]"));
		passIssueDateStudent.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		Thread.sleep(2000);
		
		WebElement passExpDateStudent = driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[10]"));
		passExpDateStudent.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm pull-right uib-right']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='07']")).click();
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[text()='Today']")).click();
		Thread.sleep(2000);
		
		WebElement passIssueCntyStudent = driver.findElement(By.xpath("//select[@name='PassportCountyIssue']"));
		Select passIssueCntyStudentSel = new Select(passIssueCntyStudent);
		passIssueCntyStudentSel.selectByVisibleText(adf.readProprtyFile("StudentPassIssueCountry"));
		Thread.sleep(2000);
		
		
		
		
		WebElement studMotherTongue = driver.findElement(By.xpath("//select[@name='MotherTongue']"));
		Select selstudMotherTongue = new Select(studMotherTongue);
		selstudMotherTongue.selectByVisibleText("Hindi/Urdu");
		
//		
//		WebElement studEthnicGrp = driver.findElement(By.xpath("//select[@name='StudRaceId']"));
//		Select selstudEthnicGrp = new Select(studEthnicGrp);
//		selstudEthnicGrp.selectByVisibleText("Indian");
		
		
//		driver.findElement(By.xpath("//a[@id='AncStudentPhotograph']")).click();
//		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("SphotoAddress"));
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
//		Thread.sleep(2000);
		
//		WebElement studSecondLang = driver.findElement(By.xpath("//select[@name='SecondLang']"));
//		Select selstudSecondLang = new Select(studSecondLang);
//		selstudSecondLang.selectByValue("30");
//		
//
//		WebElement studThirdLang = driver.findElement(By.xpath("//select[@name='ThirdLang']"));
//		Select selstudThirdLang = new Select(studThirdLang);
//		selstudThirdLang.selectByVisibleText("Hindi");
		
		
		WebElement studResidentStatus = driver.findElement(By.xpath("//select[@name='ResidentialStatus']"));
		Select selstudResidentStatus= new Select(studResidentStatus);
		selstudResidentStatus.selectByVisibleText(adf.readProprtyFile("residentStatus"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='Block']")).sendKeys(adf.readProprtyFile("Block"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='AddressLine1']")).sendKeys(adf.readProprtyFile("AddreLine1"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='AddressLine2']")).sendKeys(adf.readProprtyFile("AddreLine2"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='City']")).sendKeys(adf.readProprtyFile("City"));
		Thread.sleep(1000);
		WebElement studHomeCont = driver.findElement(By.xpath("//select[@name='CurrentHomeCountry']"));
		Thread.sleep(1000);
		Select selstudHomeCont = new Select(studHomeCont);
		selstudHomeCont.selectByValue(adf.readProprtyFile("Country"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='PostalCode']")).sendKeys(adf.readProprtyFile("PostalCode"));
		Thread.sleep(1000);
		String studentStayWithParent = "Yes";
		if(studentStayWithParent.equalsIgnoreCase("Yes"))
		{
			driver.findElement(By.xpath("(//input[@name='StudentStayWithParent'])[1]")).click();
		}
		else
		{
			driver.findElement(By.xpath("(//input[@name='StudentStayWithParent'])[2]")).click();
		}
		
		
//		driver.findElement(By.xpath("//input[@name='SibName']")).sendKeys(adf.readProprtyFile("SiblingName"));
//		
//		driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-calendar'])[5]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[text()='Today']")).click();
//		driver.findElement(By.xpath("//input[@name='SibPrestSchlName']")).sendKeys(adf.readProprtyFile("SiblingPresentSchool"));
		
		//emergencyContact by default set to father
		
		driver.findElement(By.xpath("(//button[normalize-space(text())='Save & Continue'])[5]")).click();
		
		
		
		//page4
		 
		Thread.sleep(5000);
//		 WebElement medicalConditionNo = driver.findElement(By.xpath("//input[@name='OptionSelected_1'][2]"));
//		 medicalConditionNo.click();
//		 
//		 
//		 WebElement hearingSpeechNo = driver.findElement(By.xpath("//input[@name='OptionSelected_2'][2]"));
//		 hearingSpeechNo.click();
//		 
//		 
//		 WebElement specialNeedNo = driver.findElement(By.xpath("//input[@name='OptionSelected_3'][2]"));
//		 specialNeedNo.click();
//		 
//		 WebElement behaviouralDiffNo = driver.findElement(By.xpath("//input[@name='OptionSelected_4'][2]"));
//		 behaviouralDiffNo.click();
//		 
//		 
//		 WebElement anyOtherNo = driver.findElement(By.xpath("//input[@name='OptionSelected_5'][2]"));
//		 anyOtherNo.click();
		 
		String pickUp = adf.readProprtyFile("PickUp");//
		
		if(pickUp.equalsIgnoreCase("Bus"))
		{
			driver.findElement(By.xpath("//input[@value='School Bus']")).click();
		}
		else if(pickUp.equalsIgnoreCase("Mother"))
		{
			driver.findElement(By.xpath("//input[@value='Mother']")).click();
		}
		else if(pickUp.equalsIgnoreCase("Father"))
		{
			driver.findElement(By.xpath("//input[@value='Father']")).click();
		}
		else if(pickUp.equalsIgnoreCase("Another Individual"))
		{
			driver.findElement(By.xpath("//input[@value='Another Individual']")).click();
		}
		
		Thread.sleep(2000);
		
		//to upload father photograph
		driver.findElement(By.xpath("(//a[text()='Upload Photograph'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("FatherPhotoAddress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
		
		//to upload mother photograph
		driver.findElement(By.xpath("(//a[text()='Upload Photograph'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("MotherPhotoAddress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
		
		//to upload student photograph
		driver.findElement(By.xpath("(//a[text()='Upload Photograph'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("StudentphotoAddress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
		
		//to upload Student passport
		driver.findElement(By.xpath("(//a[text()='Upload Document'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("StudentPassFileAdress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
		
		
		// to upload NRIC
		
		driver.findElement(By.xpath("(//a[text()='Upload Document'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("StudentNRICFileAdress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
				
				
		//to upload father passport
		driver.findElement(By.xpath("(//a[text()='Upload Document'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("FatherPassFileAdress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
		
		//to upload father NRIC
		driver.findElement(By.xpath("(//a[text()='Upload Document'])[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("FatherNRICFileAdress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);

		
		//To upload mother passport
		driver.findElement(By.xpath("(//a[text()='Upload Document'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("MotherPassFileAdress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
						
		//To upload mother NRIC
		driver.findElement(By.xpath("(//a[text()='Upload Document'])[6]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("MotherNRICFileAdress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
		
		//to upload immunization
		
		driver.findElement(By.xpath("(//a[text()='Upload Document'])[7]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("ImmunizationFileAdress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
						
						
		//To upload Medical report
		
		driver.findElement(By.xpath("(//a[text()='Upload Document'])[8]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("MedicalReportFileAdress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
						
		// To upload birth certificates
		
		driver.findElement(By.xpath("(//a[text()='Upload Document'])[9]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("BirthCertificateFileAdress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
		
		// To upload Other Docs
		
		driver.findElement(By.xpath("(//a[text()='Upload Document'])[10]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("OtherDocFileAdress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
		
		
		// To upload TC
		
		driver.findElement(By.xpath("(//a[text()='Upload Document'])[11]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("TCFileAdress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
		
		// To upload Progression report

		driver.findElement(By.xpath("(//a[text()='Upload Document'])[12]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='UploadPhotoModal']")).sendKeys(adf.readProprtyFile("AcademicProggFileAdress"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space(text())='Upload']")).click();
		Thread.sleep(5000);
						
		Thread.sleep(2000);

		js1.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[normalize-space(text())='Save & Continue'])[7]")).click();

		Thread.sleep(5000);
		String satisfactionNum = adf.readProprtyFile("Rating");

		if(satisfactionNum.equals("1"))
		{
			driver.findElement(By.xpath("(//input[@name='SatisfactionLevel'])[1]")).click();
		}
		else if(satisfactionNum.equals("2"))
		{
			driver.findElement(By.xpath("(//input[@name='SatisfactionLevel'])[2]")).click();
		}
		else if(satisfactionNum.equals("3"))
		{
			driver.findElement(By.xpath("(//input[@name='SatisfactionLevel'])[3]")).click();
		}
		else if(satisfactionNum.equals("4"))
		{
			driver.findElement(By.xpath("(//input[@name='SatisfactionLevel'])[4]")).click();
		}
		else if(satisfactionNum.equals("5"))
		{
			driver.findElement(By.xpath("(//input[@name='SatisfactionLevel'])[5]")).click();
		}

		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@name='AdditionalFeedback']")).sendKeys(adf.readProprtyFile("AdditionalFeedback"));
		driver.findElement(By.xpath("//input[@id='IsIAgreeTermsCondition']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[normalize-space(text())='Submit'])[2]")).click();
		Thread.sleep(2000);
	
	}
	

	

	
	public String readProprtyFile(String value) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\acharpe\\eclipse-workspace\\Test\\AdmissionForSilOak.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(value);
	}
}
