package com.obsqura.TestNGNew;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RadioButtonsDemo extends Base{
	@Test
	public void radioButtonDemo() {
		SelectCategory selectcategory=new SelectCategory (driver);
		selectcategory.SelectElement("Radio Buttons Demo");
		WebElement radioButton=driver.findElement(By.xpath("//a[@href='radio-button-demo.php']"));
		radioButton.click();
		
	}
	@Test
	public void verifyFemale() {
		String expectedMessageFemale="Radio button 'Female' is checked";
		radioButtonDemo();
		WebElement femaleButton=driver.findElement(By.cssSelector("input.form-check-input[id=inlineRadio2]"));
		WebElement maleButton=driver.findElement(By.cssSelector("input.form-check-input[id=inlineRadio1]"));
	    boolean isMaleButtonSelectabledOrNot=maleButton.isSelected();
	    assertFalse(isMaleButtonSelectabledOrNot,"MaleGender button is marked as selected ");//to check if the button is not selected by default
	    boolean isFemaleButtonSelectedOrNot=femaleButton.isSelected();
	    assertFalse(isFemaleButtonSelectedOrNot,"FemaleGender button is marked as selected ");
	    femaleButton.click();
	    boolean isFemaleButtonSelectedNow=femaleButton.isSelected();
		WebElement showSelectedValueButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		boolean isShowSelectedValueButtonEnabledOrNot=showSelectedValueButton.isEnabled();
		showSelectedValueButton.click();
		WebElement displayedMessage=driver.findElement(By.xpath("//div[@id='message-one']"));
		String actualMessageFemale= displayedMessage.getText();
		assertEquals(expectedMessageFemale,actualMessageFemale,"Showed message is not same");
		
	}
	@Test
	public void verifyMale() {
		String expectedMessageMale="Radio button 'Male' is checked";
		radioButtonDemo();
		WebElement maleButton=driver.findElement(By.cssSelector("input.form-check-input[id=inlineRadio1]"));
		boolean isMaleButtonSelectedOrNot=maleButton.isSelected();
		maleButton.click();
		WebElement showSelectedValueButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		boolean isShowSelectedValueButtonEnabledOrNot=showSelectedValueButton.isEnabled();
		showSelectedValueButton.click();
		showSelectedValueButton.click();
		WebElement displayedMessage=driver.findElement(By.xpath("//div[@id='message-one']"));
		String actualMessageMale= displayedMessage.getText();
		assertEquals(expectedMessageMale,actualMessageMale,"Showed message is not same");		
	}
	@Test
	public void groupRadioButtonsDemo() {
		String expectedGetResultOutput="Gender : Male\n"+ "Age group: 45 to 60";
		radioButtonDemo();
		WebElement genderMaleButton=driver.findElement(By.cssSelector("input.form-check-input[id=inlineRadio11]"));
		genderMaleButton.click();
		boolean isGenderMaleButtonSelectedOrNot=genderMaleButton.isSelected();
		WebElement ageSelectButton=driver.findElement(By.xpath("//input[@value='45 to 60']"));
		ageSelectButton.click();
		boolean isaAgeSelectButtonSelectedOrNot=ageSelectButton.isSelected();
		WebElement getResultButton=driver.findElement(By.xpath("//button[@id='button-two']"));
		boolean isGetResultButtonEnabledOrNot=getResultButton.isEnabled();
		getResultButton.click();
		WebElement viewResult=driver.findElement(By.xpath("//div[@id='message-two']"));
		String actualGetResultOutput=viewResult.getText();
		assertEquals(expectedGetResultOutput,actualGetResultOutput,"messages are not same");
	}

}
