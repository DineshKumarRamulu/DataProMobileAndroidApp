import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;

public class test {
	private static final int PointOption = 0;
	public static AndroidDriver<AndroidElement> driver;
	public static DesiredCapabilities cap; 
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\DataproAndroidMobileApp\\chromedriver.exe");
        WebDriver driver1 = new ChromeDriver(); 
        driver1.get("http://demo40.stopdatapro.com");

        driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		
		driver1.switchTo().frame("Frame1");
		driver1.findElement(By.xpath("//input[@id='login_userid']")).sendKeys("3333");
		Thread.sleep(2000);
		driver1.findElement(By.xpath("//input[@id='login_pwd']")).sendKeys("admin123*");
		driver1.findElement(By.xpath("//input[@value='Submit']")).click();
		
		driver1.switchTo().parentFrame();
		
		driver1.findElement(By.xpath("//div[contains(text(),'User Management')]")).click();
		
		Thread.sleep(8000);
		
		WebElement AddUser = driver1.findElement(By.xpath("//input[@value='Add']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver1;
		js.executeScript("arguments[0].scrollIntoView();", AddUser);
		
		driver1.findElement(By.xpath("//input[@value='Add']")).click();
		
		driver1.findElement(By.xpath("//input[@id='ursusername']")).sendKeys("dinesh2");
		driver1.findElement(By.xpath("//input[@id='ursfirstname']")).sendKeys("dinesh2");
		driver1.findElement(By.xpath("//input[@id='urslastname']")).sendKeys("kumar2");
		driver1.findElement(By.xpath("//input[@id='ursemailid']")).sendKeys("dinesh2@dupont.com");
		
		WebElement role = driver1.findElement(By.xpath("//select[@id='ursdefaultrole']"));
		Select select = new Select(role);
		
		//select.selectByValue("Site Administrator");
		select.selectByVisibleText("Site Administrator");
		
		WebElement mobileApp = driver1.findElement(By.xpath("//select[@id='ursoffline']"));
		Select select1 = new Select(mobileApp);
		
		//select1.selectByValue("Yes");
		select1.selectByVisibleText("Yes");
       WebElement password = driver1.findElement(By.xpath("//input[@id='urspassword']"));
		
		//JavascriptExecutor js = (JavascriptExecutor) driver1;
		js.executeScript("arguments[0].scrollIntoView();", password);
		
		driver1.findElement(By.xpath("//input[@id='urspassword']")).sendKeys("admin");
		driver1.findElement(By.xpath("//input[@id='ursconfirmpassword']")).sendKeys("admin");
		
        WebElement save = driver1.findElement(By.xpath("//div[@id='usrsave']//input"));
		
		//JavascriptExecutor js = (JavascriptExecutor) driver1;
		js.executeScript("arguments[0].scrollIntoView();", save);
		
		driver1.findElement(By.xpath("//div[@id='usrsave']//input")).click();
		
		String usersave =driver1.findElement(By.xpath("//td[text()='User created successfully.']")).getText();
		System.out.println(usersave);
		
		driver1.findElement(By.xpath("//span[contains(text(),'OK')]"));
		
		driver1.close();
		
		
        
		//****************************************************************************************************************/
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Note9");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		//cap.setCapability(MobileCapabilityType.APP, "C:\\Selenium\\Appium\\APK Files\\selendroid\\selendroid-test-app-0.17.0.apk");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.dupont.STOPDataPro");//this is to test app from the already installed apps
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.dupont.STOPDataPro.MainActivity");//this is to test app from the already installed apps
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		
		        driver= new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		        
		        //Login
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.EditText")).sendKeys("dinesh2");
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View/android.widget.EditText")).sendKeys("admin");
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View[4]/android.view.View/android.widget.EditText")).sendKeys("Demo40.stopdatapro.com");
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View[5]")).click();
		        
		        
		        //Profile
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View[7]/android.view.View[3]/android.widget.Spinner")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View[8]/android.view.View[4]/android.widget.Spinner")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View[12]/android.view.View[4]/android.widget.Spinner")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View[16]/android.view.View")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button")).click();
		        
		        //Download CheckList
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.ListView[1]/android.view.View[2]/android.view.View[1]")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View")).click();
		        
	            //HomeButton	        
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[1]")).click();
		        
		        //Observation Entry
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.ListView[2]/android.view.View[1]/android.view.View[1]")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[9]/android.view.View/android.view.View/android.widget.EditText")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View[4]/android.view.View/android.view.View/android.view.View[1]/android.widget.ListView[2]/android.view.View[1]/android.view.View")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View[4]/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[2]")).click();     
		        
		      //  Thread.sleep(2000);
		       
		        
		        scrollDown();
		        		
		        Thread.sleep(3000);
		        
		        scrollDown();
		        scrollDown();
		        
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View[14]/android.widget.EditText")).sendKeys("1");
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View[17]/android.widget.EditText")).sendKeys("1");
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View[20]/android.widget.EditText")).sendKeys("1");
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View[27]/android.widget.Button")).click();
		        
		        //Observation Entry-Checklist
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[1]/android.widget.ListView/android.view.View[2]/android.view.View/android.widget.EditText[1]")).sendKeys("1");
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[1]/android.widget.ListView/android.view.View[3]/android.view.View/android.widget.EditText[1]")).sendKeys("1");
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[1]/android.widget.ListView/android.view.View[4]/android.view.View/android.widget.EditText[1]")).sendKeys("1");
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View")).click();
		        //Thread.sleep(2000);
		        scrollDown();
		       // Thread.sleep(2000);
		        scrollDown();
		       // Thread.sleep(2000);
		        scrollDown();
		        scrollDown();
		       
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button[2]")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button")).click();
		        
		      //Review/Sync Observation Data
		        
		        
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.ListView[2]/android.view.View[2]/android.view.View[1]")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[2]")).click();
		        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button")).click();
		        
		        String ApprovalMsg = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.widget.ListView/android.view.View/android.view.View[1]/android.view.View/android.view.View[4]")).getText();
		        
		        System.out.println(ApprovalMsg);
		        
		        //*****************************************************************************************************//
		        
		        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\DataproAndroidMobileApp\\chromedriver.exe");
		        WebDriver driver2 = new ChromeDriver(); 
		        driver2.get("http://demo40.stopdatapro.com");

		        driver2.manage().window().maximize();
		        driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		        driver2.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
				
		        driver2.switchTo().frame("Frame1");
		        driver2.findElement(By.xpath("//input[@id='login_userid']")).sendKeys("3333");
				Thread.sleep(2000);
				driver2.findElement(By.xpath("//input[@id='login_pwd']")).sendKeys("admin123*");
				driver2.findElement(By.xpath("//input[@value='Submit']")).click();
				
				driver2.switchTo().parentFrame();
				
				driver2.findElement(By.xpath("//div[contains(text(),'User Management')]")).click();
				
				Thread.sleep(8000);
				driver2.findElement(By.xpath("//span[contains(text(),'Data Entry')]")).click();
				Thread.sleep(2000);
				driver2.findElement(By.xpath("//span[contains(text(),'Approval')]")).click();
				
				Thread.sleep(5000);
				
				driver2.findElement(By.xpath("//tr[@id='obsofflinechklist_row_1']")).click();
				
				Thread.sleep(8000);
				
				
				String SiteLocal = driver2.findElement(By.xpath("//div[@id='divsitename']")).getText();
				String ChecklistSetup = driver2.findElement(By.xpath("//div[@id='divsetupname']")).getText();
				
				
				
				// JavascriptExecutor js = (JavascriptExecutor) driver1;
				// js.executeScript("arguments[0].scrollIntoView();", save);
				//String Length = driver1.findElement(By.xpath("//input[@id='obschklisttxtlength']")).getText();
				//String PeopleContacted = driver1.findElement(By.xpath("//input[@id='obschklisttxtpeoplecontact']")).getText();
				//String PeopleObserved = driver1.findElement(By.xpath("//input[@id='obschklisttxtpeopleobserved']")).getText();
				
				
				
				System.out.println(SiteLocal);
				System.out.println(ChecklistSetup);
				//System.out.println(Length);
				//System.out.println(PeopleContacted);
				//System.out.println(PeopleObserved);
				driver2.findElement(By.xpath("//span[contains(text(),'Approval')]")).click();
				driver2.findElement(By.xpath("//input[@id='obsofflinechklist_chk_1']")).click();
				driver2.findElement(By.xpath("//div[@id='btnApproveall']//input")).click();
				driver2.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
				driver2.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
	            Thread.sleep(2000);
	            driver2.close();
	
	//***************************************************************************************************************//
	
	
    cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Note9");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
	//cap.setCapability(MobileCapabilityType.APP, "C:\\Selenium\\Appium\\APK Files\\selendroid\\selendroid-test-app-0.17.0.apk");
	cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.dupont.STOPDataPro");//this is to test app from the already installed apps
	cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.dupont.STOPDataPro.MainActivity");//this is to test app from the already installed apps
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
	
	        driver= new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	        
	        //Login
	        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.EditText")).sendKeys("dinesh2");
	        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View/android.widget.EditText")).sendKeys("admin");
	        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View[4]/android.view.View/android.widget.EditText")).sendKeys("Demo40.stopdatapro.com");
	        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[3]/android.view.View[5]")).click();
	        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.ListView[2]/android.view.View[2]/android.view.View[1]")).click();
	        
	        String observationMsg = driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.TextView")).getText();
	        System.out.println(observationMsg);
	        driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button")).click();
	        
	        
	        
	}
	public static void scrollDown()
	{
		
		Dimension d = driver.manage().window().getSize();
		TouchAction act = new TouchAction(driver);
        act.press(io.appium.java_client.touch.offset.PointOption.point(d.width/2, 3*d.height/4));
        act.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)));
        act.moveTo(io.appium.java_client.touch.offset.PointOption.point(d.width/2, d.height/4));
        act.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)));
        act.release().perform();
        
	}
	
	

}


