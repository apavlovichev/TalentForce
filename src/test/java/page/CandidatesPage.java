package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandidatesPage extends BasePage{

    public CandidatesPage(WebDriver driver) {
        super(driver);
    }

    //Страница "Кандидаты"
    @FindBy(xpath = "//h2[contains(text(),'Кандидаты')]")
    private WebElement titleCandidate; //Наличие надписи "Кандидаты"
    @FindBy(xpath = "//div[@id='toolbar']")
    private WebElement toolBar;
    @FindBy(xpath = "//span[@class='currentTab']/a[@id='moduleTab_HRPAC_CANDIDATES']")
    private WebElement mainCandidates;
    @FindBy(xpath = "//span[contains(text(),'Создать')]")
    private WebElement createCandidate;
    @FindBy(xpath = "//span[contains(text(),'Список')]")
    private WebElement listOfCandidates;
    @FindBy(xpath = "//span[contains(text(),'Импорт')]")
    private WebElement importCandidate;

    public String getTitleCandidateText(){
        return isElementGetText(titleCandidate);
    }

    public boolean displayToolbar(){
        isElementDisplayed(toolBar);
        return true;
    }

    public String getTextCreateCandidate(){
        return isElementGetText(createCandidate);
    }

    public String getTextlayListOfCandidate(){
        return isElementGetText(listOfCandidates);
    }

    public String getTextImportCandidate(){
        return isElementGetText(importCandidate);
    }

    public void focusCandidates(){
        mouseOver(mainCandidates);
        waitVisability(createCandidate);
        waitVisability(listOfCandidates);
        waitVisability(importCandidate);
    }

    public CreateCandidatePage createCandidate(){
        this.focusCandidates();
        clickElement(createCandidate);
        return new CreateCandidatePage(driver);
    }






}

