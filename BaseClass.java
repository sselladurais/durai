package org.libgobal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
    //1. browser lanuch
	public static void browserLaunch() {
		driver = new ChromeDriver();
	}
    //2. EnterApplnUrl 
	public static void enterApplnUrl(String webpage) {
		driver.get(webpage);
	}
    //3. Maximize the window- check 
	public static void maximizeWindow() {
		driver.manage().window().maximize();

	}
    //4.Insert value in Text Box- check
	public void sendKeys(WebElement element, String name) {
		element.sendKeys(name);
	}
    //5.Click Button- Check
	public void clickButton(WebElement element) {
		element.click();
	}
    //6.Find Locators By Id - check
	public WebElement findElementById(String Idname) {
		WebElement element=driver.findElement(By.id(Idname));
		return element;
	}
    //7.Find Locators By Name -check
	public WebElement findElementByName(String name) {
		WebElement element=driver.findElement(By.name(name));
		return element;
	}
    //8.Find Locators By className -check
	public WebElement findElementByclassName(String classname) {
		WebElement element = driver.findElement(By.className("locator"));
		return element;
	}
	//9.Find Locators By TagName -check
	public WebElement findElementByTagName(String Tagname) {
		WebElement element = driver.findElement(By.tagName("locator"));
		return element;
	}
    //10.Find Locators By cssSelector -check
	public WebElement findElementBycssselector(String cssselector) {
		WebElement element = driver.findElement(By.cssSelector(cssselector));
		return element;
	}
    //11.Find Locators By xpath -check
	public WebElement findelementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	//13.Find Locators By linkedText -check
	public WebElement findElementByLinkedText(String linkedtext) {
		WebElement element = driver.findElement(By.linkText(linkedtext));
		return element;
	}
    //14.Switch to Alert Box and Accept -check
	public void elementOkAccept() {
		 driver.switchTo().alert().accept();
	}
    //15.Switch to Alert Box and Dismiss -check
	public void elementOkDimiss() {
		driver.switchTo().alert().dismiss();
		
	}
    //16.Get the Text From Web Page - check
	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}
    //14.Get the Inserted Value From the Text Box - check
	public String elementInsertedValue(WebElement element, String value) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
    //15.Close All Window - Check
	public void allWindow() {
		driver.quit();
	}
    //16.Close Current Window - Check
	public void currentWindow() {
		driver.close();
	}
    //17.Get The Title -Check
	public String getTheTitle() {
		String title = driver.getTitle();
		return title;
	}
    //18.Get the Current Url - Check
	public String enteredCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
    //19.Select Drop-Down option by text - check
	public void selectByValue(WebElement element, String attributevalue) {
		Select select = new Select(element);
		select.selectByValue(attributevalue);
	}
    //20.Select Drop-Down option by Text - check
	public void selectByText(WebElement element, String visibletext) {
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}
    //21.Select Drop-Down option by IndexNo -check
	public void selectByIndex(WebElement element, int indexno) {
		Select select = new Select(element);
		select.selectByIndex(indexno);
	}
    //22.Insert Value In Text Box By Using JavaScript - check
	public void javaScriptsetAttribute(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}
    //23.Click Button By JavaScript -Check
	public void javaScriptclick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()",element);
	}
    //24.
	public void takeScreenShot(String data) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs,
				new File("C:\\Users\\User\\eclipse-workspace\\BaseClass\\images\\" + data + ".PNG"));
	}
    //25.
	public void ScreenShot(WebElement element, String data) throws IOException {
		File screen = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("C:\\Users\\User\\eclipse-workspace\\BaseClass\\images\\" + data + ".PNG"));
	}
    //26.Get All Options from Drop down as Text -check
	public List<WebElement> dropDownAsText(WebElement element) {
		Select dropdown = new Select(element);
		List<WebElement> alldropdown = dropdown.getOptions();
		int size = alldropdown.size();
		for (WebElement element1 : alldropdown) {
			String text = element1.getText();
			System.out.println(text);
		}
		return alldropdown;
	}
    //27.SelectAllOption from Index - Check
	public static void selectAllOption(WebElement dropdown) {
		Select select = new Select(dropdown);
		int optionCount = select.getOptions().size();
		for (int i = 0; i < optionCount; i++) {
			select.selectByIndex(i);
		}
	}
    //28.Get All option from drop down as attribute value - check
	public List<WebElement> dropDownAsAttribute(WebElement element, String name) {
		Select dropdown = new Select(element);
		List<WebElement> alldropdown = dropdown.getOptions();
		int size = alldropdown.size();
		for (int i = 0; i <= alldropdown.size(); i++) {
			WebElement webElement = alldropdown.get(i);
			String text = webElement.getAttribute("value");
			System.out.println(text);
		}
		return alldropdown;
	}
	//29.Thread Sleep -check
	public void sleep() throws InterruptedException
	{
		Thread.sleep(3000);
	}
	//30.Explicit Wait - check
	public void visibilityOfElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//31.Implicit Wait -check
	public static void implictWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	//32.Implicit Wait By Sec - check
	public void implictWait(int seconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	//33.
	public String switchChildWindow()
	{
	    String windowHandle = driver.getWindowHandle();
	    Set<String> windowHandles = driver.getWindowHandles();
	    for (String eachWindow : windowHandles) 
	    {
			if(!windowHandle.equals(eachWindow))
			{
				driver.switchTo().window(eachWindow);
			}
		}
	    return windowHandle;
	}

	public String getCellData(String sheetName,int rownum,int cellnum) throws IOException
	{  
		String res="";
		File file = new File("C:\\Users\\User\\eclipse-workspace\\BaseClass\\ExcelData\\EmpolyeeDetails.xlsx");
		FileInputStream input = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(input);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res= cell.getStringCellValue();
			//System.out.println(stringCellValue);
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yy");
				res = dateformat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (numericCellValue == round) {
					res = String.valueOf(round);
				} else {
					res=String.valueOf(numericCellValue);
				}
			}
           break;
		default:
			break;
		}
		return res;

	
	}
	public void createCellData(String excelname,int rownum,int cellrum,String data) throws IOException
	{
		File file=new File("C:\\Users\\User\\eclipse-workspace\\libgobal\\ExcelData\\EmpolyeeDetails.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(excelname);
	    Row row = sheet.getRow(rownum);
	    Cell cell = row.createCell(cellrum);
	                cell.setCellValue(data);
	    FileOutputStream outputstream=new FileOutputStream(file);
	    workbook.write(outputstream);
	}

}