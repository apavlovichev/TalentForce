package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AutorizationPage extends BasePage{

    public AutorizationPage(WebDriver driver) {
    super(driver);
    }

    //Страница авторизации
    @FindBy(xpath = "//img[@alt='SuiteCRM']")
    private WebElement logoPresent;
    @FindBy(xpath = "//input[@id='user_name']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@id='username_password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id='bigbutton']")
    private WebElement loginButton;
    @FindBy(xpath = "//span[contains(text(),'Вы должны указать правильные логин и пароль.')]")
    private WebElement errorAutorizationText;

    //Получаем Тайтл и УРЛ страницы авторизации
    public String getTitleAutorizationPage(){
        return driver.getTitle();
         }

    public String getUrlAutorizationPage(){
        return driver.getCurrentUrl();
    }

    //Проверяем отображение веб-элемента с помощью метода, реализованного в BasePage
    public boolean displayLogoPresent(){
        isElementDisplayed(logoPresent);
        return true;
    }

    public boolean displayLoginButton(){
        isElementDisplayed(loginButton);
        return true;
    }

        public AutorizationPage typeLogin(String login){
        writeText(loginField, login);
        return this;
    }

    public AutorizationPage typePassword(String password){
        writeText(passwordField, password);
        return this;
    }

        public MainPage clickLoginButton(){
        clickElement(loginButton);
        return new MainPage(driver);

    }
    public MainPage autorization(String login, String password){
        this.typeLogin(login);
        this.typePassword(password);
        this.clickLoginButton();
        return new MainPage(driver);
    }

//    public AutorizationPage typeInvalidLogin(String invalidlogin) {
//        loginField.sendKeys(invalidlogin);
//        return this;
//
//    }
//
//    public AutorizationPage typeInvalidPassword(String invalidpassword) {
//        passwordField.sendKeys(invalidpassword);
//        return this;
//
//    }
//
//    public AutorizationPage autorizationWithInvalidCreds(String invalidlogin, String invalidpassword){ //Авторизация с не корректными данными. Необходима для выполнения проверки
//        this.typeInvalidLogin(invalidlogin);
//        this.typeInvalidPassword(invalidpassword);
//        this.clickLoginButton();
//        return new AutorizationPage(driver);
//    }

    public String getErrorAutorizationText(){
        return isElementGetText(errorAutorizationText);
    }

}

