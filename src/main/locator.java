package main;

import org.openqa.selenium.By;

public class locator {
    
	    public static By getLocator(String input1)
	    {
	        By b=null;
	       
	        int p=input1.indexOf("_");
	        String locator=input1.substring(0, p);
	        String value=input1.substring(p+1);
	        
	        
	        if(locator.equalsIgnoreCase("ID")){
	            b=By.id(value);
	        }
	        else if(locator.equalsIgnoreCase("NAME")){
	            b=By.name(value);
	        }
	        else if(locator.equalsIgnoreCase("XPATH")){
	            b=By.xpath(value);
	            
	        }
	        else if(locator.equalsIgnoreCase("CSSSELECTOR")){
	            b=By.cssSelector(value);
	            
	        }
	        else if(locator.equalsIgnoreCase("LINKTEXT")){
	            b=By.linkText(value);
	            
	        }
	        else if(locator.equalsIgnoreCase("CLASSNAME")){
	            b=By.className(value);
	            
	        }
	        else if(locator.equalsIgnoreCase("TAGNAME")){
	            b=By.tagName(value);
	            
	        }
	        else if(locator.equalsIgnoreCase("PARTIALLINKTEXT")){
	            b=By.partialLinkText(value);
	        }
	        else{
	            System.out.println("invalid selector");
	        }
	    return b;

	    }
	  
	    }

