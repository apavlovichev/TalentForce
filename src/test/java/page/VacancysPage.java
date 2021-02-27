package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VacancysPage extends BasePage{

    public VacancysPage(WebDriver driver) {
        super(driver);
    }

    //Страница "Вакансии"
    @FindBy(xpath = "//h2[contains(text(),'Вакансии')]")
    private WebElement titleVacancys; //Наличие надписи "Вакансии"
    @FindBy(xpath = "//div[@id='toolbar']")
    private WebElement toolBar;
    @FindBy(xpath = "//span[@class='currentTab']/a[@id='moduleTab_HRPAC_VACANCY']")
    private WebElement mainVacancys;
    @FindBy(xpath = "//span[contains(text(),'Создать')]")
    private WebElement createVacancy;
    @FindBy(xpath = "//span[contains(text(),'Список')]")
    private WebElement listOfVacancys;
    @FindBy(xpath = "//span[contains(text(),'Мои Вакансии')]")
    private WebElement myVacancys;
    @FindBy(xpath = "//span[contains(text(),'Архивы Вакансий')]")
    private WebElement archiveOfVacancys;

    public String getTitleVacancysText(){
        return titleVacancys.getText();
    }

    public boolean displayToolbar(){
        isElementDisplayed(toolBar);
        return true;
    }

    public String getTextCreateVacancy(){
        return isElementGetText(createVacancy);
    }

    public String getTextListOfVacancys(){
        return isElementGetText(listOfVacancys);
    }

    public String getTextArchiveOfVacancys(){
        return isElementGetText(archiveOfVacancys);
    }

    public String getTextMyVacancys(){
        return isElementGetText(myVacancys);
    }

    public void focusVacancys(){
        mouseOver(mainVacancys);
        waitVisability(createVacancy);
        waitVisability(listOfVacancys);
        waitVisability(myVacancys);
        waitVisability(archiveOfVacancys);
    }

    public CreateVacancyPage createVacancy(){
        this.focusVacancys();
        clickElement(createVacancy);
        return new CreateVacancyPage(driver);
    }


}

