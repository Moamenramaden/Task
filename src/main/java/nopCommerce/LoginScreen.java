package nopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen {
    WebDriver driver;
    By homeLogin = By.xpath(Constants.homelogin);
    By email = By.id(Constants.email);
    By password = By.id(Constants.passWord);
    By loginBtn = By.xpath(Constants.loginBtn);
    By rememberMe = By.id(Constants.rememberMe);
    
    public LoginScreen(WebDriver driver) {
        this.driver = driver;
    }
    
    public void homeLogin() {
        driver.findElement(homeLogin).click();
    }
    
    public void email(String emailAddress) {
        driver.findElement(email).sendKeys(emailAddress);
    }
    
    public void password(String passWord) {
        driver.findElement(password).sendKeys(passWord);
    }
    
    public void rememberMe() {
        driver.findElement(rememberMe).click();
    }
    
    public void loginBtn() {
        driver.findElement(loginBtn).click();
    }
}
