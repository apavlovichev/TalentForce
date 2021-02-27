package test;

import org.junit.jupiter.api.Test;
import testValues.TestValues;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutorizationPageTest extends BaseTest {

    @Test
    public void checkUrlAndTitlePageAutorization() {
        String url = autorizationPage.getUrlAutorizationPage();
        String title = autorizationPage.getTitleAutorizationPage();
        assertEquals(TestValues.url,url, "URL the page is different from the expected result");
        assertEquals(TestValues.title,title, "Title the page is different from the expected result");
    }

    @Test
    public void loadAutorizationPage() {
        boolean logoPresent = autorizationPage.displayLogoPresent();
        boolean loginButton = autorizationPage.displayLoginButton();
        assertTrue(logoPresent, "The logo of the autorization page is not loaded");
        assertTrue(loginButton, "Login button of the autorization page is not loaded");
    }

    @Test
    public void autorizationWithInvalidCreds(){
        autorizationPage.autorization(TestValues.invalidLogin, TestValues.invalidPassword);
        String autorizationError = autorizationPage.getErrorAutorizationText();
        assertEquals("Вы должны указать правильные логин и пароль.",autorizationError, "There is no information text about the correctness of the data entered");
    }
// Проверка всплывающего сообщения о пустом поле. Пока не знаю как реализовать
//    Возможное решение тут https://www.cyberforum.ru/html/thread1721095.html
//    @Test
//    public void autorizationWithEmptyField(){
//        AutorizationPage autorizationPage = PageFactory.initElements(driver, AutorizationPage.class);
//        autorizationPage.autorization(TestValues.emptyLogin, TestValues.password);
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, 2);
//            wait.until(ExpectedConditions.alertIsPresent());
//            Alert alert = driver.switchTo().alert();
//            System.out.println(alert.getText());
//            alert.accept();
//            Assert.assertTrue(alert.getText().contains("Thanks."));
//        } catch (Exception e) {
//        }
//    }

}
