package main;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import generics.Excel;
import generics.Property;

public class DeltaDriver extends BaseDriver
{
public	ArrayList<String> list;
public String data;

@BeforeClass
public void open() throws MalformedURLException
{    
	String username = System.getenv("BROWSERSTACK_USER");
	String accessKey = System.getenv("BROWSERSTACK_ACCESSKEY");
	String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
	String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");

	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	capabilities.setCapability("browser", "Chrome");
	capabilities.setCapability("browser_version", "54.0");
	capabilities.setCapability("os", "Windows");
	capabilities.setCapability("os_version", "7");
	capabilities.setCapability("resolution", "1024x768");
		
	capabilities.setCapability("browserstack.local", browserstackLocal);
	capabilities.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
	driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), capabilities);
	driver.get("https://bmo-esf-qa.galepartners.com/");
}


@Test(dataProvider="getScenarios")
public void testScenarios(String scenarioSheet, String executionStatus) throws InterruptedException
{    
	
	list=new ArrayList<String>();
	testReport=eReport.startTest(scenarioSheet);
	list.clear();
	list.add(0,"dummyvalue");
	if(executionStatus.equalsIgnoreCase("yes"))
    {  
    int stepCount = Excel.getRowCount(scenariosPath,scenarioSheet);
    
    for(int i=1;i<=stepCount;i++)
    {
    String description = Excel.getCellValue(scenariosPath, scenarioSheet, i, 0);
   
    String action = Excel.getCellValue(scenariosPath, scenarioSheet, i, 1);
    
    String input1 = Excel.getCellValue(scenariosPath, scenarioSheet, i, 2);
    
    String input2 = Excel.getCellValue(scenariosPath, scenarioSheet, i, 3);
//    if(action.equalsIgnoreCase("verify")){
//    keywordlib lib=new keywordlib();
//    lib.verify(driver, action, input1,input2,scenarioSheet,description,testReport,this);
//     break;
//    }
   
    String msg = "DESCRIPTION: "+description+ ", ACTION: "+action+ ", INPUT1: "+input1+ ", INPUT2: "+input2;
    testReport.log(LogStatus.INFO,msg);
    data=KeyWord.executekeyword(driver, action, input1, input2,i,scenarioSheet,description,testReport,this); 
    list.add(i,data);
    }
    }
    else
    {
    testReport.log(LogStatus.SKIP,"Execution status is 'NO'");
    throw new SkipException("Skipping this scenario");
    }
    
}

}

