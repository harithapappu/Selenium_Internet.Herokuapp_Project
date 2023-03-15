package internet_herokuapp_tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import internet_herokuapp_base.Base_Tests;
import utilities.CommonUtilities;

public class AutomationScripts extends Base_Tests{
	@Test
	public static void launchInternetHerokuappTC1() throws IOException {
		captureScreenshot("launchInternetHerokuappTC1");
		report.attachScreenshot("launchInternetHerokuappTC1");
	}
	@Test
	public static void launchABTestingTC2() throws IOException  {
		driver.findElement(By.xpath("//a[@href='/abtest']")).click();
		captureScreenshot("launchABTestingTC2");
		report.attachScreenshot("launchABTestingTC2");	
	}
	@Test
	public static void launchAddRemoveElementsTC3() throws IOException  {
		driver.findElement(By.xpath("//a[@href='/add_remove_elements/']")).click();
		WebElement addElement= driver.findElement(By.xpath("//button[@onclick='addElement()']"));
		for(int i=0;i<6;i++) {
	    	if(i<3) {
	    		addElement.click();
	    		continue;
	    	}
	    	WebElement deleteElement = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
	    	deleteElement.click();
	    }
		captureScreenshot("launchAddRemoveElementsTC3");
		report.attachScreenshot("launchAddRemoveElementsTC3");		
	}
	@Test
	public static void launchBasicAuthTC4() throws IOException  {
		driver.findElement(By.xpath("//a[@href='/basic_auth']")).click();
		captureScreenshot("launchBasicAuthTC4");
		report.attachScreenshot("launchBasicAuthTC4");		
	}
	@Test
	public static void launchBrokenImagesTC5() throws IOException  {
		driver.findElement(By.xpath("//a[@href='/broken_images']")).click();
		for(int i=0;i<3;i++) {
			WebElement imgElement=driver.findElement(By.xpath("/html/body/div[2]/div/div/img["+(i+1)+"]"));
			Object result = ((JavascriptExecutor) driver).executeScript(
					   "return arguments[0].complete && "+
					   "typeof arguments[0].naturalWidth != \"undefined\" && "+
					   "arguments[0].naturalWidth > 0", imgElement);
			boolean loaded = false;
			if (result instanceof Boolean) {
				loaded = (Boolean) result;
				System.out.println(loaded);
			}
		}
		captureScreenshot("launchBrokenImagesTC5");
		report.attachScreenshot("launchBrokenImagesTC5");		
	}
	@Test
	public static void launchChallengingDOMTC6() throws IOException  {
		driver.findElement(By.xpath("//a[@href='/challenging_dom']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/a[2]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/a[3]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[3]/td[7]/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[7]/td[7]/a[2]")).click();
		captureScreenshot("launchChallengingDOMTC6");
		report.attachScreenshot("launchChallengingDOMTC6");		
	}
	@Test
	public static void launchCheckboxesTC7() throws IOException  {
		driver.findElement(By.xpath("//a[@href='/checkboxes']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click();
		captureScreenshot("launchCheckboxesTC7");
		report.attachScreenshot("launchCheckboxesTC7");		
	}
	@Test
	public static void launchContextMenuTC8() throws IOException  {
		driver.findElement(By.xpath("//a[@href='/context_menu']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div"));
		String alertMessage=CommonUtilities.getPropertyValue("alertMessage");
	    String expectedAlertMessage = alertMessage;
	    String actualAlertMessage = driver.switchTo().alert().getText();
	    testResult(actualAlertMessage, expectedAlertMessage);
	    driver.switchTo().alert().accept();
	    captureScreenshot("launchContextMenuTC8");
		report.attachScreenshot("launchContextMenuTC8");		
	}
	@Test
	public static void launchDisaapearingElementsTC9() throws IOException, InterruptedException  {
		driver.findElement(By.xpath("//a[@href='/disappearing_elements']")).click();
		for(int i=0;i<5;i++) {
	    	driver.navigate().refresh();
	    	Thread.sleep(4000);
	    }
	    captureScreenshot("launchDisaapearingElementsTC9");
		report.attachScreenshot("launchDisaapearingElementsTC9");		
	}
	@Test
	public static void launchDragAndDropTC10() throws IOException  {
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//a[@href='/drag_and_drop']")).click();
		WebElement colA=driver.findElement(By.xpath("//div[@id='column-a']"));
	    WebElement colB=driver.findElement(By.xpath("//div[@id='column-b']"));
	    action.dragAndDrop(colA,colB).build().perform();
	    action.dragAndDrop(colA,colB).build().perform();
	    captureScreenshot("launchDragAndDropTC10");
		report.attachScreenshot("launchDragAndDropTC10");		
	}
	@Test
	public static void launchDropdownTC11() throws IOException {
		
		driver.findElement(By.xpath("//a[@href='/dropdown']")).click();
		WebElement selectOption=driver.findElement(By.id("dropdown"));
		selectByText(selectOption,"Option 2");
	    captureScreenshot("launchDropdownTC11");
		report.attachScreenshot("launchDropdownTC11");		
	}
	@Test
	public static void launchDynamicContentTC12() throws IOException {
		
		driver.findElement(By.xpath("//a[@href='/dynamic_content']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]/a")).click();
	    captureScreenshot("launchDynamicContentTC12");
		report.attachScreenshot("launchDynamicContentTC12");		
	}
	@Test
	public static void launchDynamicLoadingTC13() throws IOException {
		
		driver.findElement(By.xpath("//a[@href='/dynamic_loading']")).click();
		driver.findElement(By.xpath("//a[@href='/dynamic_loading/1']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/button")).click();
		waitForElemtToBeVisible(By.xpath("/html/body/div[2]/div/div/div[3]/h4"),2000);
		captureScreenshot("launchDynamicLoading1TC13");
		report.attachScreenshot("launchDynamicLoading1TC13");
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='/dynamic_loading/2']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button")).click();
		waitForElemtToBeVisible(By.xpath("/html/body/div[2]/div/div/div[1]/h4"),2000);
		captureScreenshot("launchDynamicLoading2TC13");
		report.attachScreenshot("launchDynamicLoading2TC13");	
	}
	@Test
	public static void launchEntryAdTC14() throws IOException {
		
		driver.findElement(By.xpath("//a[@href='/entry_ad']")).click();
		driver.findElement(By.linkText("click here")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div"));
		String modalWindow=CommonUtilities.getPropertyValue("modalWindow");
		String expectedAlertMessage = modalWindow;
	    String actualAlertMessage = driver.switchTo().alert().getText();
	    testResult(actualAlertMessage, expectedAlertMessage);	   
	    captureScreenshot("launchEntryAdTC14");
		report.attachScreenshot("launchEntryAdTC14");	
	}
	@Test
	public static void launchExitIntentTC15() throws IOException {
		
		driver.findElement(By.xpath("//a[@href='/exit_intent']")).click();
		WebElement e = driver.findElement(By.cssSelector("h3"));
        Actions action = new Actions(driver);
        action.moveToElement(e).moveByOffset(600,-1).build().perform();
        driver.findElement(By.xpath(".//*[@id='ouibounce-modal']/div[2]/div[3]/p")).click();
        String modalWindow=CommonUtilities.getPropertyValue("modalWindow");
		String expectedAlertMessage = modalWindow;
	    String actualAlertMessage = driver.switchTo().alert().getText();
	    testResult(actualAlertMessage, expectedAlertMessage);	   
	    captureScreenshot("launchExitIntentTC15");
		report.attachScreenshot("launchExitIntentTC15");	
	}
	@Test
	public static void launchFileDownloadTC16() throws IOException {
		
		driver.findElement(By.xpath("//a[@href='/download']")).click();
		driver.findElement(By.xpath("//a[@href='download/some-file (1).txt']")).click();
	    captureScreenshot("launchFileDownloadTC16");
		report.attachScreenshot("launchFileDownloadTC16");	
	}
	@Test
	public static void launchFileUploadTC17() throws IOException {
		
		driver.findElement(By.xpath("//a[@href='/upload']")).click();
		String fileUpload=CommonUtilities.getPropertyValue("fileUpload");
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys(fileUpload);
		driver.findElement(By.id("file-submit")).click();
		driver.findElement(By.xpath("//div[@id='drag-drop-upload']")).sendKeys(fileUpload);
	    captureScreenshot("launchFileUploadTC17");
		report.attachScreenshot("launchFileUploadTC17");	
	}
	@Test
	public static void launchFloatingMenuTC18() throws IOException {
		
		driver.findElement(By.xpath("//a[@href='/floating_menu']")).click();
		driver.findElement(By.xpath("//a[@href='#home']")).click();
		driver.findElement(By.xpath("//a[@href='#news']")).click();
		driver.findElement(By.xpath("//a[@href='#contact']")).click();
		driver.findElement(By.xpath("//a[@href='#about']")).click();
	    captureScreenshot("launchFloatingMenuTC18");
		report.attachScreenshot("launchFloatingMenuTC18");	
	}
	@Test
	public static void launchForgotPasswordTC19() throws IOException {
		
		driver.findElement(By.xpath("//a[@href='/forgot_password']")).click();
		String forgotPasswordEmail=CommonUtilities.getPropertyValue("forgotPasswordEmail");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(forgotPasswordEmail);
		driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']")).click();
	    captureScreenshot("launchForgotPasswordTC19");
		report.attachScreenshot("launchForgotPasswordTC19");	
	}
	@Test
	public static void launchFormAuthenticationTC20() throws IOException {
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		String formAuthenticationUsername=CommonUtilities.getPropertyValue("formAuthenticationUsername");
		String formAuthenticationPassword=CommonUtilities.getPropertyValue("formAuthenticationPassword");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(formAuthenticationUsername);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(formAuthenticationPassword);
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();		
	    driver.findElement(By.xpath("//a[@href='/logout']")).click();
	    captureScreenshot("launchFormAuthenticationTC20");
		report.attachScreenshot("launchFormAuthenticationTC20");	
	}
	@Test
	public static void launchFramesTC21() throws IOException {
		driver.findElement(By.xpath("//a[@href='/frames']")).click();
		captureScreenshot("launchFramesTC21");
		report.attachScreenshot("launchFramesTC21");
		driver.findElement(By.xpath("//a[@href='/nested_frames']")).click();
	    captureScreenshot("launchNestedFramesTC21");
		report.attachScreenshot("launchNestedFramesTC21");	
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@href='/iframe']")).click();
		captureScreenshot("launchIFramesTC21");
		report.attachScreenshot("launchIFramesTC21");
	}
	@Test
	public static void launchGeolocationTC22() throws IOException {
		driver.findElement(By.xpath("//a[@href='/geolocation']")).click();
		captureScreenshot("launchGeolocationTC22");
		report.attachScreenshot("launchGeolocationTC22");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	    captureScreenshot("launchYourGeolocationTC22");
		report.attachScreenshot("launchYourGeolocationTC22");	
		driver.findElement(By.xpath("/html/body/div[2]/div/div/p/div[3]/a")).click();
		captureScreenshot("launchGoogleMapsGeolocationTC22");
		report.attachScreenshot("launchGoogleMapsGeolocationTC22");
	}
	@Test
	public static void launchHorizontalSliderTC23() throws IOException {
		driver.findElement(By.xpath("//a[@href='/horizontal_slider']")).click();
		captureScreenshot("launchHorizontalSliderTC23");
		report.attachScreenshot("launchHorizontalSliderTC23");
		WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/input"));
		for(int i=1;i<=3;i++) {
			slider.sendKeys(Keys.ARROW_RIGHT);
		}
	    captureScreenshot("launchHorizontalSliderActionTC23");
		report.attachScreenshot("launchHorizontalSliderActionTC23");	
	}
	@Test
	public static void launchHoversTC24() throws IOException {
		driver.findElement(By.xpath("//a[@href='/hovers']")).click();
		captureScreenshot("launchHoversTC24");
		report.attachScreenshot("launchHoversTC24");
		WebElement firstImage=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/img"));
		Actions hoversAction=new Actions(driver);
		hoversAction.moveToElement(firstImage).perform();
		captureScreenshot("launchfirstImageHoversTC24");
		report.attachScreenshot("launchfirstImageHoversTC24");
		WebElement secondImage=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/img"));
		hoversAction.moveToElement(secondImage).perform();
		captureScreenshot("launchsecondImageHoversTC24");
		report.attachScreenshot("launchsecondImageHoversTC24");
		WebElement thirdImage=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/img"));
		hoversAction.moveToElement(thirdImage).perform();
		captureScreenshot("launchthirdImageHoversTC24");
		report.attachScreenshot("launchthirdImageHoversTC24");
	    
	}
	@Test
	public static void launchInfiniteScrollTC25() throws IOException {
		driver.findElement(By.xpath("//a[@href='/infinite_scroll']")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a")).click();
        captureScreenshot("launchInfiniteScrollTC25");
		report.attachScreenshot("launchInfiniteScrollTC25");
	}
	@Test
	public static void launchInputsTC26() throws IOException {
		driver.findElement(By.xpath("//a[@href='/inputs']")).click();
		String inputNumberToBeEntered=CommonUtilities.getPropertyValue("inputNumberToBeEntered");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/input")).sendKeys(inputNumberToBeEntered);
        captureScreenshot("launchInputsTC26");
		report.attachScreenshot("launchInputsTC26");
	}
	@Test
	public static void launchJQueryUIMenusTC27() throws IOException {
		driver.findElement(By.xpath("//a[@href='/jqueryui/menu']")).click();
		Actions builder = new Actions(driver);
	    Action mouseOverMenu;
	    mouseOverMenu = builder.moveToElement(driver.findElement(By.id("ui-id-2"))).build();
	    mouseOverMenu.perform(); 
	    waitForElemtToBeVisible(By.id("ui-id-4"),2000);	    
	    mouseOverMenu = builder.moveToElement(driver.findElement(By.id("ui-id-4"))).build();
	    mouseOverMenu.perform(); 
	    WebElement webElement2= driver.findElement(By.cssSelector("a#ui-id-6.ui-corner-all")); 
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", webElement2);
        captureScreenshot("launchJQueryUIMenusTC27");
		report.attachScreenshot("launchJQueryUIMenusTC27");
	}
	@Test
	public static void launchJavaScriptAlertsTC28() throws IOException {
		driver.findElement(By.xpath("//a[@href='/javascript_alerts']")).click();
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();	
		String jsAlert=CommonUtilities.getPropertyValue("jsAlert");
		String expectedJSAlertMessage = jsAlert;
		String actualJSAlertMessage = driver.switchTo().alert().getText();
		testResult(actualJSAlertMessage, expectedJSAlertMessage);
		driver.switchTo().alert().accept();
		captureScreenshot("launchJavaScriptJSAlertsTC28");
		report.attachScreenshot("launchJavaScriptJSAlertsTC28");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		String jsConfirm=CommonUtilities.getPropertyValue("jsConfirm");
		String expectedJSConfirmMessage = jsConfirm;
		String actualJSConfirmMessage = driver.switchTo().alert().getText();
		testResult(actualJSConfirmMessage, expectedJSConfirmMessage);
		driver.switchTo().alert().accept();
		captureScreenshot("launchJavaScriptJSConfirmAlertsTC28");
		report.attachScreenshot("launchJavaScriptJSConfirmAlertsTC28");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		String jsPrompt=CommonUtilities.getPropertyValue("jsPrompt");
		String expectedJSPromptMessage = jsPrompt;
		String actualJSPromptMessage = driver.switchTo().alert().getText();
		testResult(actualJSPromptMessage, expectedJSPromptMessage);
		String jsPromptTextToEnter=CommonUtilities.getPropertyValue("jsPromptTextToEnter");
		driver.switchTo().alert().sendKeys(jsPromptTextToEnter);
		driver.switchTo().alert().accept();
		captureScreenshot("launchJavaScriptJSPromptAlertsTC28");
		report.attachScreenshot("launchJavaScriptJSPromptAlertsTC28");
	}
	@Test
	public static void launchJavaScriptOnLoadEventErrorTC29() throws IOException {
		driver.findElement(By.xpath("//a[@href='/javascript_error']")).click();
        captureScreenshot("launchJavaScriptOnLoadEventErrorTC29");
		report.attachScreenshot("launchJavaScriptOnLoadEventErrorTC29");
	}
	@Test
	public static void launchKeyPressesTC30() throws IOException {
		driver.findElement(By.xpath("//a[@href='/key_presses']")).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.SPACE).build().perform();
		String keyPressSpace=CommonUtilities.getPropertyValue("keyPressSpace");
		String expectedSpaceKeyPressMessage = keyPressSpace;
		String actualSpaceKeyPressMessage = driver.findElement(By.id("result")).getText();
		testResult(actualSpaceKeyPressMessage, expectedSpaceKeyPressMessage);
		action.sendKeys(Keys.ENTER).build().perform();
		String keyPressEnter=CommonUtilities.getPropertyValue("keyPressEnter");
		String expectedEnterKeyPressMessage = keyPressEnter;
		String actualEnterKeyPressMessage = driver.findElement(By.id("result")).getText();
		testResult(actualEnterKeyPressMessage, expectedEnterKeyPressMessage);	
        captureScreenshot("launchKeyPressesTC30");
		report.attachScreenshot("launchKeyPressesTC30");
	}
	@Test
	public static void launchLargeAndDeepDOMTC31() throws IOException {
		driver.findElement(By.xpath("//a[@href='/large']")).click();
        captureScreenshot("launchLargeAndDeepDOMTC31");
		report.attachScreenshot("launchLargeAndDeepDOMTC31");
	}
	@Test
	public static void launchMultipleWindowsTC32() throws IOException {
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		String expectedNewPageTitle="New Window";
		String actualNewPageTitle=driver.getTitle();
		testResult(actualNewPageTitle, expectedNewPageTitle);
        captureScreenshot("launchMultipleWindowsTC32");
		report.attachScreenshot("launchMultipleWindowsTC32");
	}
	@Test
	public static void launchNestedFramesTC33() throws IOException {
		driver.findElement(By.xpath("//a[@href='/nested_frames']")).click();
        captureScreenshot("launchNestedFramesTC33");
		report.attachScreenshot("launchNestedFramesTC33");
	}
	@Test
	public static void launchNotificationMessagesTC34() throws IOException {
		driver.findElement(By.xpath("//a[@href='/notification_message']")).click();
		driver.findElement(By.xpath("//a[@href='/notification_message']")).click();
		String notificationMessage=CommonUtilities.getPropertyValue("notificationMessage");
		String expectedNotificationMessage = notificationMessage;
		String actualNotificationMessage = driver.findElement(By.xpath("/html/body/div[1]/div/div")).getText();
		testResult(actualNotificationMessage, expectedNotificationMessage);
        captureScreenshot("launchNotificationMessagesTC34");
		report.attachScreenshot("launchNotificationMessagesTC34");
	}
	@Test
	public static void launchRedirectLinkTC35() throws IOException {
		driver.findElement(By.xpath("//a[@href='/redirector']")).click();
		captureScreenshot("launchFirstRedirectLinkTC35");
		report.attachScreenshot("launchFirstRedirectLinkTC35");
		driver.findElement(By.xpath("//a[@href='redirect']")).click();
        captureScreenshot("launchSecondRedirectLinkTC35");
		report.attachScreenshot("launchSecondRedirectLinkTC35");
		driver.findElement(By.xpath("//a[@href='status_codes/200']")).click();
		captureScreenshot("launchStatusCodes200LinkTC35");
		report.attachScreenshot("launchStatusCodes200LinkTC35");	
		driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
		driver.findElement(By.xpath("//a[@href='status_codes/301']")).click();
		captureScreenshot("launchStatusCodes301LinkTC35");
		report.attachScreenshot("launchStatusCodes301LinkTC35");
		driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
		driver.findElement(By.xpath("//a[@href='status_codes/404']")).click();
		captureScreenshot("launchStatusCodes404LinkTC35");
		report.attachScreenshot("launchStatusCodes404LinkTC35");
		driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
		driver.findElement(By.xpath("//a[@href='status_codes/500']")).click();
		captureScreenshot("launchStatusCodes500LinkTC35");
		report.attachScreenshot("launchStatusCodes500LinkTC35");
	}
	@Test
	public static void launchSecureFileDownloadTC36() throws IOException {
		driver.findElement(By.xpath("//a[@href='/download_secure']")).click();
        captureScreenshot("launchSecureFileDownloadTC36");
		report.attachScreenshot("launchSecureFileDownloadTC36");
		driver.findElement(By.xpath("//a[@href='download_secure/LambdaTest.txt']")).click();
		captureScreenshot("launchSecureFileDownloadTC36");
		report.attachScreenshot("launchSecureFileDownloadTC36");
	}
	@Test
	public static void launchShadowDOMTC37() throws IOException {
		driver.findElement(By.xpath("//a[@href='/shadowdom']")).click();
        captureScreenshot("launchShadowDOMTC37");
		report.attachScreenshot("launchShadowDOMTC37");
	}
	@Test
	public static void launchShiftingContentTC38() throws IOException {
		driver.findElement(By.xpath("//a[@href='/shifting_content']")).click();
        captureScreenshot("launchShiftingContentTC38");
		report.attachScreenshot("launchShiftingContentTC38");
		driver.findElement(By.xpath("//a[@href='/shifting_content/menu']")).click();
        captureScreenshot("launchShiftingContentMenuTC38");
		report.attachScreenshot("launchShiftingContentMenuTC38");
		driver.findElement(By.xpath("//a[@href='/shifting_content/menu?mode=random']")).click();
		captureScreenshot("launchShiftingContentMenuRandomTC38");
		report.attachScreenshot("launchShiftingContentMenuRandomTC38");
		driver.findElement(By.xpath("//a[@href='/shifting_content/menu?pixel_shift=100']")).click();
		captureScreenshot("launchShiftingContentMenuPixelsShiftTC38");
		report.attachScreenshot("launchShiftingContentMenuPixelsShiftTC38");
		driver.findElement(By.xpath("//a[@href='/shifting_content/menu?mode=random&amp;pixel_shift=100']")).click();
		captureScreenshot("launchShiftingContentMenuRandomAndPixelsShiftTC38");
		report.attachScreenshot("launchShiftingContentMenuRandomAndPixelsShiftTC38");
		driver.findElement(By.xpath("//a[@href='/shifting_content/image']")).click();
        captureScreenshot("launchShiftingContentImageTC38");
		report.attachScreenshot("launchShiftingContentImageTC38");
		driver.findElement(By.xpath("//a[@href='/shifting_content/image?mode=random']")).click();
		captureScreenshot("launchShiftingContentImageRandomTC38");
		report.attachScreenshot("launchShiftingContentImageRandomTC38");
		driver.findElement(By.xpath("//a[@href='/shifting_content/image?pixel_shift=100']")).click();
		captureScreenshot("launchShiftingContentImagePixelsShiftTC38");
		report.attachScreenshot("launchShiftingContentImagePixelsShiftTC38");
		driver.findElement(By.xpath("//a[@href='/shifting_content/image?mode=random&amp;pixel_shift=100']")).click();
		captureScreenshot("launchShiftingContentImageRandomAndPixelsShiftTC38");
		report.attachScreenshot("launchShiftingContentImageRandomAndPixelsShiftTC38");
		driver.findElement(By.xpath("//a[@href='/shifting_content/image?image_type=simple']")).click();
		captureScreenshot("launchShiftingContentImageSingleTC38");
		report.attachScreenshot("launchShiftingContentImageSingleTC38");
		driver.findElement(By.xpath("//a[@href='/shifting_content/list']")).click();
        captureScreenshot("launchShiftingContentListTC38");
		report.attachScreenshot("launchShiftingContentListTC38");
	}
	@Test
	public static void launchSlowResourcesTC39() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//a[@href='/slow']")).click();
		Thread.sleep(3000);
        captureScreenshot("launchSlowResourcesTC39");
		report.attachScreenshot("launchSlowResourcesTC39");
	}
	@Test
	public static void launchSortedDataTablesTC40() throws IOException{
		driver.findElement(By.xpath("//a[@href='/tables']")).click();
		List<WebElement> columns=driver.findElements(By.xpath("//table[@id='table1']//tr//th"));
        System.out.println("Number of columns : "+columns.size());
        for (WebElement col : columns) {
                   System.out.println("Columns are : "+col.getText());
        }
        List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("Number of rows : "+rows.size());
        for (WebElement row : rows) {
                   System.out.println("Rows are : "+row.getText());
       }
        String tableRow=CommonUtilities.getPropertyValue("tableRow");
        String tableColumn=CommonUtilities.getPropertyValue("tableColumn");
        String content=driver.findElement(By.xpath("//table[@id='table1']//tr["+tableRow+"]/td["+tableColumn+"]")).getText();
        System.out.println(content);
        captureScreenshot("launchSortedDataTablesTC40");
		report.attachScreenshot("launchSortedDataTablesTC40");
	}
	@Test
	public static void launchStatusCodesTC41() throws IOException{
		driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
		captureScreenshot("launchStatusCodesTC41");
		report.attachScreenshot("launchStatusCodesTC41");
		driver.findElement(By.xpath("//a[@href='status_codes/200']")).click();
		captureScreenshot("launchStatusCodes200LinkTC41");
		report.attachScreenshot("launchStatusCodes200LinkTC41");	
		driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
		driver.findElement(By.xpath("//a[@href='status_codes/301']")).click();
		captureScreenshot("launchStatusCodes301LinkTC41");
		report.attachScreenshot("launchStatusCodes301LinkTC41");
		driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
		driver.findElement(By.xpath("//a[@href='status_codes/404']")).click();
		captureScreenshot("launchStatusCodes404LinkTC41");
		report.attachScreenshot("launchStatusCodes404LinkTC41");
		driver.findElement(By.xpath("//a[@href='/status_codes']")).click();
		driver.findElement(By.xpath("//a[@href='status_codes/500']")).click();
		captureScreenshot("launchStatusCodes500LinkTC41");
		report.attachScreenshot("launchStatusCodes500LinkTC41");
        
	}
	@Test
	public static void launchTyposTC42() throws IOException {
		driver.findElement(By.xpath("//a[@href='/typos']")).click();
        captureScreenshot("launchTyposTC42");
		report.attachScreenshot("launchTyposTC42");
	}
	@Test
	public static void launchWYSIWYGEditorTC43() throws IOException {
		driver.findElement(By.xpath("//a[@href='/tinymce']")).click();
        captureScreenshot("launchWYSIWYGEditorTC43");
		report.attachScreenshot("launchWYSIWYGEditorTC43");
	}
}
