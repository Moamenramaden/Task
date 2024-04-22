package nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationScreen {
	WebDriver Driver;
	By Registerbtn = By.className(Constants.Registerbtn);
	By genderMale = By.id(Constants.genderMale);
	By genderFemale= By.id(Constants.genderFemale);
	By firstName = By.id(Constants.firstName);
	By lastName = By.id(Constants.lastName);
	By selectDay = By.xpath(Constants.day);
	By selectMonth = By.cssSelector(Constants.month);
	By selectYear= By.cssSelector(Constants.year);
	By eMail = By.id(Constants.eMail);
	By password = By.id(Constants.password);
	By confirmPassword = By.id(Constants.confirmPassword);
	By register = By.id(Constants.register);
	
	public RegistrationScreen(WebDriver Driver) {
		this.Driver = Driver;
	}
	
	public void homeRegister() {
		Driver.findElement(Registerbtn).click();
	}
	
	public void genderSelectMale () {
		Driver.findElement(genderMale).click();
	}
	public void genderSelectFemale() {
		Driver.findElement(genderFemale).click();
	}
	public void firstName (String firstname) {
		Driver.findElement(firstName).sendKeys(firstname);
	}
	public void lastName (String lastname) {
		Driver.findElement(lastName).sendKeys(lastname);
	}
	public void selectDay (String day) {
		Driver.findElement(selectDay).sendKeys(day);
	}
	public void selectMonth (String month) {
	Driver.findElement(selectMonth).sendKeys(month);
	
	}
	public void selectYear (String year) {
	Driver.findElement(selectYear).sendKeys(year);
	}
	public void eMail(String email) {
		Driver.findElement(eMail).sendKeys(email);
	}
	public void password (String passWord) {
		Driver.findElement(password).sendKeys(passWord);
	}
	public void confirmPassword (String password) {
		Driver.findElement(confirmPassword).sendKeys(password);
	}
	public void register () {
		Driver.findElement(register).click();
	}
}
