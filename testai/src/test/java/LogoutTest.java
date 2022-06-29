import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTest {

    LoginPage LoginPage = new LoginPage(driver);

    @Test
    void user() {
        LoginPage.fillUsername(userName);
        LoginPage.fillPassword(validPassword);
        LoginPage.clickSubmit();
        LoginPage.clickLogout();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "http://localhost:8080/prisijungti?logout",
                "Vartotojas neatsijungė!");

    }

}
