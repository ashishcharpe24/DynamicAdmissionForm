package com.qa.testcases;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.basicMethods;
import com.qa.pages.registrationForm;

public class registrationFormTest extends basicMethods {
	
	registrationForm rf;
	@BeforeMethod
	public void initialize() throws IOException
	{
		Browserselection();
		rf = new registrationForm();
		
	}
	
	@Test
	public void parentDetailsPageMethodTest() throws IOException, SQLException, InterruptedException
	{
		rf.fillRegistrationForm();
	}

}
