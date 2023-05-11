package sevenrmartSupermarket.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SelectCategoryPage {
	public WebDriver driver;

	public SelectCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void SelectCategoryElement(String input) {
		List<WebElement> categories = driver.findElements(By.xpath("//ul[@data-widget='treeview']//li"));
		for (WebElement category : categories) {
			String categoryName = category.getText();
			if (categoryName.equals(input)) {
				category.click();
				break;
			}
		}
	}
}
