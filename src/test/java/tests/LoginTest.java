package tests;


import data.TestData;
import pages.LoginPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;



public class LoginTest {

	private WebDriver driver;

	private LoginPage loginPage;

	
	
	@BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
	
	@Test(dataProvider = "loginCredentials", dataProviderClass = TestData.class)

	public void testLogin(String username, String password) {
        loginPage.login(username, password);
        if (username.equals("standard_user") && password.equals("secret_sauce")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Should navigate to inventory page.");
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should appear.");
        }
    }

	
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
