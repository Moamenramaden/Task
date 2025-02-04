package execution;

import org.testng.annotations.Test;
import nopCommerce.LoginScreen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.junit.jupiter.api.Test;
public class loginexecution {
    WebDriver driver;
    LoginScreen login;

    @Test(priority = 1, enabled = true, dataProvider = "loginData")
    public void validLogin(String email, String password) {
        login.homeLogin();
        login.email(email);
        login.password(password);
        login.rememberMe();
        login.loginBtn();
    }
@Test(priority = 2 , enabled = true, dataProvider = "loginData")
public void invalidLogin(String email, String password) {
    login.homeLogin();
    login.email(email);
    login.rememberMe();
    login.loginBtn();
    String pageError = driver.getPageSource();
	String errorMessage = "Login was unsuccessful. Please correct the errors and try again.\\n\"\n"+"The credentials provided are incorrect";
	Assert.assertNotNull(pageError.contains(errorMessage));
}
@Test(priority = 3 , enabled = true, dataProvider = "loginData")
public void invalidLogin2(String email, String password) {
    login.homeLogin();
    login.password(password);
    login.rememberMe();
    login.loginBtn();
    String pageError = driver.getPageSource();
	String errorMessage = "Please enter your email\\n";
	Assert.assertNotNull(pageError.contains(errorMessage));
}
@Test(priority = 4 , enabled = true, dataProvider = "loginData")
public void invalidLogin3(String email, String password) {
    login.homeLogin();
    login.rememberMe();
    login.loginBtn();
    String pageError = driver.getPageSource();
	String errorMessage = "Please enter your email\n";
	Assert.assertNotNull(pageError.contains(errorMessage));
}
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        login = new LoginScreen(driver);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {
        // Path to the JSON file containing login data
        String jsonFilePath = "C:\\Users\\DELL\\eclipse-workspace\\M&A Technical Assessment\\src\\main\\java\\utils\\login_data.json";

        // Read JSON file and parse its content
        Gson gson = new Gson();
        Map<String, String>[] data = gson.fromJson(new FileReader(jsonFilePath), Map[].class);

        // Convert parsed data to a 2D array
        Object[][] testData = new Object[data.length][];
        for (int i = 0; i < data.length; i++) {
            Map<String, String> entry = data[i];
            Object[] rowData = new Object[]{
                    entry.get("email"),
                    entry.get("password")
            };
            testData[i] = rowData;
        }

        return testData;
    }
}
