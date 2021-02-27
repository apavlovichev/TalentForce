package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.*;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    String SITE_URL = "http://stage.hr.tsconsulting.com/";
    WebDriver driver;
    WebDriverWait wait;
    public MainPage mainPage;
    public AutorizationPage autorizationPage;
    public CandidatesPage candidatesPage;
    public CreateCandidatePage createCandidatePage;
    public CandidateDetailView candidateDetailView;
    public VacancysPage vacancysPage;
    public CreateVacancyPage createVacancyPage;
    public VacancyDetailView vacancyDetailView;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(SITE_URL);
        autorizationPage = PageFactory.initElements(driver, AutorizationPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        candidatesPage = PageFactory.initElements(driver, CandidatesPage.class);
        createCandidatePage = PageFactory.initElements(driver, CreateCandidatePage.class);
        candidateDetailView = PageFactory.initElements(driver, CandidateDetailView.class);
        vacancysPage = PageFactory.initElements(driver, VacancysPage.class);
        createVacancyPage = PageFactory.initElements(driver,CreateVacancyPage.class);
        vacancyDetailView = PageFactory.initElements(driver,VacancyDetailView.class);
    }

//    @AfterEach
//        public void ternDown(){
//        driver.quit();
//    }



}
