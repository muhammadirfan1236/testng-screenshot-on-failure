package data;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "loginCredentials")
    public static Object[][] loginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce"},  // valid
            {"locked_out_user", "secret_sauce"}, // locked user
            {"problem_user", "secret_sauce"},    // has some bugs
           // {"invalid_user", "wrong_pass"},      // invalid login
        };
    }
}
