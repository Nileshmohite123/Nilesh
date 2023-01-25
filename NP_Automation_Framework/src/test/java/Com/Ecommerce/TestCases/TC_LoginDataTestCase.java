package Com.Ecommerce.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Ecommerce.BaseClass.Ecommerce_BaseClass;
import Com.Ecommerce.PageClass.TC_Ecommerce_Login_Page;
import Com.Ecommerce.Utilitities.XLUtils;

public class TC_LoginDataTestCase extends Ecommerce_BaseClass{
	
	    @Test(dataProvider = "LoginData")
		public void LoginData(String user, String Pwd, String Expected) throws InterruptedException {
		
			
	    	logger.info("Open commerce url");
			
			TC_Ecommerce_Login_Page TE= new TC_Ecommerce_Login_Page();
			
			TE.SetUsername(user);
			
			logger.info("Enter user mail");
			
			TE.SetPasswordname(Pwd);
			logger.info("Enter user password");
			
			Thread.sleep(300);
			
			TE.LoginBtn();
			
			logger.info("Clicked on login button");
			
			String Actual_Result=driver.getTitle();
			String Expected_Result="nopCommerce demo store";
			
			if(Expected.equals("Valid")) {
				
				if(Actual_Result.equals(Expected_Result)) {
				
				TE.Logout();
				
				Assert.assertTrue(true);
			}
			
			else {
				Assert.assertTrue(false);
			}
			}
			
			else if(Expected_Result.equals("Invalid")) {
				if(Actual_Result.equals(Expected_Result)) {
					TE.Logout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
			
		}
	    
	    @DataProvider(name="LoginData")
	    public String[][] getdata() throws IOException {
	    	
    	String path=System.getProperty("user.dir")+"\\src\\main\\java\\Com\\Ecommerce\\TestData\\Username.xlsx";
	    	
	    	int rownum=XLUtils.getRowCount(path, "Sheet1");
	    	
	    	int cellcount=XLUtils.getCellCount(path, "Sheet1", 1);
	    	
	    	String logindata [][]=new String[rownum][cellcount];
	    	
	    	for(int i=1;i<=rownum;i++) {
	    		for(int j=0;j<cellcount;j++) {
	    			
	    		logindata[i-1][j]=	XLUtils.getCellData(path, "Sheet1", i, j);
	    		}
	    	}
	    	
	    	return logindata;
	    }
			}
