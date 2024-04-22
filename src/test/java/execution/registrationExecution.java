package execution;

import org.testng.annotations.Test;
import nopCommerce.RegistrationScreen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class registrationExecution {
    WebDriver driver;
    RegistrationScreen regist;

    @Test(priority = 1, enabled = true, dataProvider = "registrationData")
    public void validRegistration(String firstName, String lastName, String day, String month, String year, String email, String password, String confirmPassword) {
        regist.homeRegister();
        regist.genderSelectMale();
        regist.firstName(firstName);
        regist.lastName(lastName);
        regist.selectDay(day);
        regist.selectMonth(month);
        regist.selectYear(year);
        regist.eMail(email);
        regist.password(password);
        regist.confirmPassword(confirmPassword);
        regist.register();
    }

    @Test(priority = 2, enabled = true)
    public void invalidRegistration1(String firstName, String lastName, String day, String month, String year, String email, String password, String confirmPassword) {
        regist.homeRegister();
        regist.genderSelectMale();
        regist.firstName(firstName);
        regist.lastName(lastName);
        regist.selectDay(day);
        regist.selectMonth(month);
        regist.selectYear(year);
       //we removed the email from the registration 
        regist.password(password);
        regist.confirmPassword(confirmPassword);
        regist.register();
        String pageError = driver.getPageSource();
    	String errorMessage = "Email is required.\n";
    	Assert.assertNotNull(pageError.contains(errorMessage));
    }
    @Test(priority = 3, enabled = true, dataProvider = "registrationData")
    public void validRegistration2(String firstName, String lastName, String day, String month, String year, String email, String password, String confirmPassword) {
        regist.homeRegister();
        regist.genderSelectMale();
        // we removed the first name
        regist.lastName(lastName);
        regist.selectDay(day);
        regist.selectMonth(month);
        regist.selectYear(year);
        regist.eMail(email);
        regist.password(password);
        regist.confirmPassword(confirmPassword);
        regist.register();
        String pageError = driver.getPageSource();
    	String errorMessage = "First name is required.\n";
    	Assert.assertNotNull(pageError.contains(errorMessage));
    }
    @Test(priority = 4, enabled = true, dataProvider = "registrationData")
    public void invalidRegistration3(String firstName, String lastName, String day, String month, String year, String email, String password, String confirmPassword) {
        regist.homeRegister();
        regist.genderSelectMale();
        regist.firstName(firstName);
        //we removed the last name
        regist.selectDay(day);
        regist.selectMonth(month);
        regist.selectYear(year);
        regist.eMail(email);
        regist.password(password);
        regist.confirmPassword(confirmPassword);
        regist.register();
        String pageError = driver.getPageSource();
    	String errorMessage = "last name is required.\n";
    	Assert.assertNotNull(pageError.contains(errorMessage));
    }
    @Test(priority = 5, enabled = true, dataProvider = "registrationData")
    public void invalidRegistration4(String firstName, String lastName, String day, String month, String year, String email, String password, String confirmPassword) {
        regist.homeRegister();
        regist.genderSelectMale();
        regist.firstName(firstName);
        regist.lastName(lastName);
        regist.selectDay(day);
        regist.selectMonth(month);
        regist.selectYear(year);
        regist.eMail(email);
        //we removed the password
        regist.register();
        String pageError = driver.getPageSource();
    	String errorMessage = "Password is required.\n";
    	Assert.assertNotNull(pageError.contains(errorMessage));
    }
    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        regist = new RegistrationScreen(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() throws IOException {
        // Path to the JSON file containing registration data
        String jsonFilePath = "C:\\Users\\DELL\\eclipse-workspace\\M&A Technical Assessment\\src\\main\\java\\utils\\registration_data.json";

        // Read JSON file and parse its content
        Gson gson = new Gson();
        Map<String, Object>[] data = gson.fromJson(new FileReader(jsonFilePath), Map[].class);

        // Convert parsed data to a 2D array
        Object[][] testData = new Object[data.length][];
        for (int i = 0; i < data.length; i++) {
            Map<String, Object> entry = data[i];
            Object[] rowData = new Object[]{
                    entry.get("firstName").toString(),
                    entry.get("lastName").toString(),
                    entry.get("day").toString(),
                    entry.get("month").toString(),
                    entry.get("year").toString(),
                    entry.get("email").toString(),
                    entry.get("password").toString(),
                    entry.get("confirmPassword").toString()
            };
            testData[i] = rowData;
        }

        return testData;
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}
