package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VacancyDetailView extends BasePage{

    public VacancyDetailView(WebDriver driver) {
        super(driver);
    }

    //Карточка вакансии
    @FindBy(xpath = "//h2[@class='module-title-text']")
    private WebElement titleVacancy; // Наименование вакансии
    @FindBy(xpath = "//div[@class='stages-panel']")
    private WebElement vacancyStagePanel; // Панель этапов подбора
    @FindBy(xpath = "//form[@id='vacancy-view']")
    private WebElement vacancyView; // Информация о вакансии
    @FindBy(xpath = "//div[@class='vacancy-view__main']")
    private WebElement viewVacancyInfo; // Блок с описанием, историей, документами и др.

    public String getTitleVacancyText(){
        return isElementGetText(titleVacancy);
    }

    public boolean displayVacancyStagePanel(){
        isElementDisplayed(vacancyStagePanel);
        return true;
    }

    public boolean displayVacancyView(){
        isElementDisplayed(vacancyView);
        return true;

    }    public boolean displayVacancyViewInfo(){
        isElementDisplayed(viewVacancyInfo);
        return true;
    }



}
