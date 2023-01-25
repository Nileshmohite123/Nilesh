package Com.Ecommerce.BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Com.Ecommerce.Configuration.Readconfiguration;
import Com.Ecommerce.Utilitities.TestUtils;
import net.bytebuddy.utility.RandomString;

public class Ecommerce_BaseClass {
	
	Readconfiguration readconfig= new Readconfiguration();
	
	public String BaseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;
	@Parameters("Browsername")
	@BeforeMethod
	public void intialization(String Browsername) {
		
		logger=logger.getLogger("30JulyEcommerce");
		
		PropertyConfigurator.configure("Log4j.properties");
		
		if(Browsername.equals("Chrome")) {
		
		System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
	    driver=new ChromeDriver();
		}
		else if(Browsername.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getEdgepath());
		    driver=new EdgeDriver();
		}
		
		else if(Browsername.equals("Firefox")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getFirefox());
		    driver=new FirefoxDriver();
		}
	    driver.manage().window().maximize();
	    
	    driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		
	    driver.get(BaseURL);
	    
	    
	}
	public String getScreenshotAs(String Testcasename) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String Random=RandomString.make(5);
		
	String Dest=	System.getProperty("user.dir")+ "/Screenshots/"+ Testcasename + ""+ Random +".png";
		
	FileUtils.copyFile(source, new File(Dest));
	return Dest;
	}
	@AfterMethod
	 public void Teardown() {
	    	driver.quit();
	    }

}
