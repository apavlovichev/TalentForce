package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    //Основная страница
    @FindBy(xpath = "//div[@id='toolbar']")
    private WebElement toolBar;
    @FindBy(xpath = "//a[@id='grouptab_0']")
    private WebElement mainToolBar;
    @FindBy(xpath = "//a[@id='moduleTab_9_Кандидаты']")
    private WebElement candidates;
    @FindBy(xpath = "//a[@id='moduleTab_9_Вакансии']")
    private WebElement vacancy;
    @FindBy(xpath = "//a[@id='moduleTab_9_Панель Подбора']")
    private WebElement selectionPanel;
    @FindBy(xpath = "//a[@href='index.php?module=Home&action=index&parentTab=Основная']")
    private WebElement main;
    @FindBy(xpath = "//span[contains(text(),'apavlovichev')]")
    private WebElement userName;

    // Забираем имя пользователя, под которым авторизовались с помощью метода, реализованного в BasePage
    public String getUsernameText(){
        return isElementGetText(userName);
    }

    public boolean displayToolbar(){
        isElementDisplayed(toolBar);
        return true;
    }

    public boolean displayMainTextToolbar(){
        isElementDisplayed(mainToolBar);
        return true;
    }

    //Наведение мыши на "Основная"
    public void focusMain(){
        mouseOver(mainToolBar);
        waitVisability(candidates);
        waitVisability(vacancy);
        waitVisability(selectionPanel);
        waitVisability(main);
    }

    // Забираем название элемента выпадающего списка с помощью метода, реализованного в BasePage
    public String getTextElementCandidate(){
        return isElementGetText(candidates);
    }

    public String getTextElementVacancy(){
        return isElementGetText(vacancy);
    }

    public String getTextElementSelectionPanel(){
        return isElementGetText(selectionPanel);
    }

    public String getTextElementMain(){
        return isElementGetText(main);
    }

    public CandidatesPage clickCandidates(){
        this.focusMain();
        clickElement(candidates);
        return new CandidatesPage(driver);
    }

    public VacancysPage clickVacancys(){
        this.focusMain();
        clickElement(vacancy);
        return new VacancysPage(driver);
    }





}

