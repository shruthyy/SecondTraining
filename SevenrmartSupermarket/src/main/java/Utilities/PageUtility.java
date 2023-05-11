package Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public  void submit(WebElement element) {
		element.submit();
	}
	public String getCssValue(WebElement element) {
		String cssValue = element.getCssValue("background-color").toString();
		return cssValue;
	}
	public  String getCssValueLineHeight(WebElement element) {
		String cssValue = element.getCssValue("line-height").toString();
		return cssValue;
	}
	public  String getCssValueFontWeight(WebElement element) {
		String cssValue = element.getCssValue("font-weight").toString();
		return cssValue;
	}
	public SearchContext a(WebElement element) {
		SearchContext shadowRoot = element.getShadowRoot();
		return shadowRoot;
	}
	public  int getElementRowSize(List<WebElement> element) {
		return element.size();
	}
	public boolean isElementEnabled(WebElement element) {
		boolean status = element.isEnabled();
		return status;
	}
	public  boolean isElementSelected(WebElement element) {
		boolean status = element.isSelected();
		return status;
	}
	public boolean isDisplay(WebElement element) {
		boolean status = element.isDisplayed();
		return status;
	}
	public  void notify(WebElement element) {
		element.notify();
	}
	public boolean equals(WebElement element) {
		boolean status = element.equals(null);
		return status;
	}
	public  void clickOnElement(WebElement element) {
		element.click();
	}
	public  WebElement enterText(WebElement element, String value) {
		element.sendKeys(value);
		return element;
	}
	public  void sendKey(WebElement element, String s) {
		element.sendKeys(s);
	}
	public  String getElementText(WebElement element) {
		return element.getText();
	}
	public  void clickUsingAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	public  void mouseHoverAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public  void doubleclickAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	public  void rightclickAction(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	public  void dragAndDrop(WebElement source, WebElement destination, WebDriver driver) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
	}
	public  void clickAndHoldOnElement(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).build().perform();
	}
	public  void selectDropdownbyText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public  void selectDropdownbyIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public  WebElement enterIntValue(WebElement element, CharSequence[] value) {
		element.sendKeys(value);
		return element;
	}
	public  Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	public  void ScrollBy(WebDriver driver) {
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.scrollBy(0,2500)");
	}
	public  void stopPageRefresh(WebDriver driver) {
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.stop();");
	}
	public String getToolTip(WebElement element) {
		return element.getAttribute("title");
	}
	public void getClickElement(WebElement element) {
		element.click();
	}
	public void mediumDelay(int x) throws InterruptedException {
		Thread.sleep(x);
	}
	public void selectFuncbyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectFuncbyValue(WebElement element, String value) {
		Select select1 = new Select(element);
		select1.selectByValue(value);
	}
	public String selectFuncbyVisibletext(WebElement element, String visibletext) {
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
		WebElement selectedValue = select.getFirstSelectedOption();
		return (selectedValue.getText());
	}
	public String FirstSelectedOption(WebElement element) {
		Select select1 = new Select(element);
		String firstoption = select1.getFirstSelectedOption().getText();
		return (firstoption);
	}
	public List<WebElement> getAllOptions(Select s) {
		List<WebElement> op = s.getOptions();
		return op;
	}
	public List<String> convertToStringList(List<WebElement> weList) {
		List<String> strList = new ArrayList<String>();
		for (int i = 0; i < weList.size(); i++) {
			strList.add(weList.get(i).getText());
		}
		return strList;
	}
	public  String stylePropertyValidation(WebElement element, String propertyType) {
		return element.getCssValue(propertyType);
	}
	public boolean isSelected(WebElement element) {
		return element.isSelected();
	}
	public List<String> addList(List<String> list, String s) {
		list.add(s);
		return list;
	}
	public void alertHandlingaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public String alerttext(WebDriver driver) {
		return (driver.switchTo().alert().getText());
	}
	public boolean getElementTextList(List<WebElement> chkList, String element) {
		boolean value = true;
		for (int i = 0; i < chkList.size(); i++) {
			String text = chkList.get(i).getText();
			if (!text.equals(element)) {
				value = false;
			}
		}
		return value;
	}
	public boolean compareLists(List<String> actuallist, List<String> expectedlist) {
		boolean value = true;
		for (int i = 0; i < actuallist.size(); i++) {
			if (!actuallist.get(i).equals(expectedlist.get(i))) {
				value = false;
			}
		}
		return value;
	}
	public void managSliderList(List<WebElement> actuallist, List<WebElement> element) {
		for (int i = 0; i < actuallist.size(); i++) {
			String text = actuallist.get(i).getText();
			if (!text.equals(element)) {
				break;
			}
		}
	}
}
