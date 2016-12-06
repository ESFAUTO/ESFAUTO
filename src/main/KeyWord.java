package main;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class KeyWord 
{

public static String executekeyword(WebDriver driver,String action,String input1,String input2,int i,String scenarioSheet,String description,ExtentTest testReport,DeltaDriver d) throws InterruptedException
{
	keywordlib lib = null;
	String data = null;	
	
	if(action.equalsIgnoreCase("click"))
	{
	lib=new keywordlib();
	data=lib.click(driver, input1, action,i,testReport);
	}
	if(action.equalsIgnoreCase("clickonbutton"))
	{
		
		keywordlib.clickOnButton(driver, input1, action, i, testReport);
	}
	else if(action.equalsIgnoreCase("Selectfromdropdown"))
	{
		lib=new keywordlib();
	data=lib.Selectfromdropdown(driver, input1, input2, action, i, testReport);
	}
	else if(action.equalsIgnoreCase("Selectfromlookup"))
	{
		lib=new keywordlib();
	data=lib.Selectfromlookup(driver, input1, input2, action,i, testReport);
	}
	else if(action.equalsIgnoreCase("SelectForm"))
	{
	keywordlib.SelectForm(driver,input1,input2, action, testReport);
	}
	else if(action.equalsIgnoreCase("login"))
	{
		keywordlib.login(driver, input1, input2, action,testReport);
	}
	else if(action.equalsIgnoreCase("NavigateToFormPage"))
	{
		keywordlib.NavigateToFormPage(driver, action,testReport);
	}
	else if(action.equalsIgnoreCase("enter"))
	{
		lib=new keywordlib();
	data=lib.enter(driver, input1, input2, action,i, testReport);
	}
	
	else if(action.equalsIgnoreCase("Verifysavestatus"))
	{
		keywordlib.Verifysavestatus(driver, action, input1, input2,testReport);
	}
	else if(action.equalsIgnoreCase("signout")){
		keywordlib.signout(driver, action, input1,testReport);
	}

	else if(action.equalsIgnoreCase("upload")){
		keywordlib.uploadFile(driver, action, input1,input2,testReport);
	}
	else if(action.equalsIgnoreCase("verifyupload")){
		keywordlib.verifyUpload(driver, action, input1,input2,testReport);
	}
	else if(action.equalsIgnoreCase("submit")){
		keywordlib.submit(driver, action, input1,testReport);
	}
	else if(action.equalsIgnoreCase("storeinexcel")){
	lib=new keywordlib();
	 data=lib.storeInExcel(driver, input1, action, scenarioSheet, i, testReport);	
	}
	else if(action.equalsIgnoreCase("verify")){
		lib=new keywordlib();
		lib.verify(driver, action, input1, input2, scenarioSheet, description, testReport, d);	
		}
	return data;	
}
}