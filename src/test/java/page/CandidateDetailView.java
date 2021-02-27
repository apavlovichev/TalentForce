package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandidateDetailView extends BasePage{

    public CandidateDetailView(WebDriver driver) {
        super(driver);
    }

    //Карточка кандидата
    @FindBy(xpath = "//h2[@class='module-title-text']")
    private WebElement titleCandidate; //ФИО кандидата
    @FindBy(xpath = "//form[@id='candidate-view']")
    private WebElement candidateView; //Блок с информацией о кандидате
    @FindBy(xpath = "//div[@class='candidate-view__info']")
    private WebElement viewCandidateInfo; //Блок с сабпанелями резюме, история и пр.

    public String getTitleCandidateText(){
        return isElementGetText(titleCandidate);
    }

    public boolean displayCandidateView(){
        isElementDisplayed(candidateView);
        return true;
    }

    public boolean displayCandidateViewInfo(){
        isElementDisplayed(viewCandidateInfo);
        return true;
    }



}

