package Utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 10;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 50;
	public static final long FLUENT_WAIT =10;//Fluent Timeout wait
	public static final long POLLING_WAIT =5;//Fluent Polling wait

	public static void waitForElement(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}
	public static void pageLoadTimeOutWait(WebDriver driver,WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}
	public static void waitForElement(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(target));
	}
	public static void waitForElementClickable(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public static void waitForElementClickable(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public static void waitForElementSelected(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public static void waitFortextToBePresentInElement(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public static void waitForElementIsPresent(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfElementLocated(target));
	}
	public static void waitForAlterIsPresent(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(target));
	}
	public static void waitForInvisibilityOfElementLocated(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(target));
	}
	public static void waitForPresenceOfAllElementsLocated(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(target));
	}
	public static void waitForPresenceOfElementsLocatedBy(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfElementLocated(target));
	}
	public static void waitForPresenceOfElementsLocated(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfElementLocated(target));
	}
	public static void waitForTextToBePresentInElementLocated(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(target, null));
	}
	public static void waitForAttributeToBe(WebDriver driver, By target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.attributeToBe(target, null, null));
	}
	public static void waitForAttributeContains(WebDriver driver, By target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		 fluentWait.until(ExpectedConditions.attributeContains(target, null, null));
	}
	public static void waitForAttributeContainsWebElement(WebDriver driver, WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(target, null, null));
	}
	public static void waitForInvisibilityOfWebElement(WebDriver driver, WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
	    fluentWait.until(ExpectedConditions.invisibilityOf(target));
	}
	public static void waitForClickableByLocator(WebDriver driver, By target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public static void waitForClickableByWebElement(WebDriver driver, WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public static void waitForSelectctedByLocator(WebDriver driver, By target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeSelected(target));
	}
	public static void waitForSelectedByWebElement(WebDriver driver, WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeSelected(target));
	}
	public static void waitForPresenceOfAllElementsLocatedByLocator(WebDriver driver, By target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(target));
	}
	public static void waitForTitleContains(WebDriver driver) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.titleContains(null));
	}
	public static void waitForTitles(WebDriver driver) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.titleIs(null));
	}
	public static void waitForVisibilityOfWebElement(WebDriver driver, WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(target));
	}
	public static void waitForUrlToBe(WebDriver driver) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.urlToBe(null));
	}
	public static void waitForUrlContains(WebDriver driver) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(FLUENT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(POLLING_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.urlContains(null));
	}
}
