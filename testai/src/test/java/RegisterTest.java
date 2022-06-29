import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class RegisterTest extends BaseTest {

    RegisterPage registerPage = new RegisterPage(driver);

    @Test
    void newUserCanRegisterWithValidData() {
        driver.get("http://localhost:8080/registruoti");
        double randomID = (Math.random() * 100) + (Math.random() * 10);
        registerPage.fillUsername(userName + (int)randomID );
        registerPage.fillPassword(validPassword);
        registerPage.fillPasswordConfirm(validPassword);
        registerPage.clickSubmit();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "http://localhost:8080/skaiciuotuvas",
                "Registracija nepavyko!");

    }

    @Test
    void newUserCanNotRegisterWithInvalidData() {
        driver.get("http://localhost:8080/registruoti");
        double randomID = (Math.random() * 100) + (Math.random() * 10);
        registerPage.fillUsername(userName + (int)randomID );
        registerPage.fillPassword(validPassword);
        registerPage.fillPasswordConfirm(invalidPassword);
        registerPage.clickSubmit();
        WebElement passwordConfirmError = driver.findElement(By.id("passwordConfirm.errors"));
        Assertions.assertTrue(passwordConfirmError.isDisplayed(), "Registered with invalid password!");

    }
}
