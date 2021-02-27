package test;

import org.junit.jupiter.api.Test;
import testValues.TestValues;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static testValues.TestValues.login;

public class MainPageTest extends BaseTest {

    @Test
    public void loadMainPage() {
        autorizationPage.autorization(login, TestValues.password);
        boolean mainToolbar = mainPage.displayToolbar();
        boolean mainText = mainPage.displayMainTextToolbar();
        String usernameText = mainPage.getUsernameText();
        assertTrue(mainToolbar, "The main toolbar of the main page is not loaded");
        assertTrue(mainText, "Text 'MAIN' of the main page is not loaded");
        assertEquals(login, usernameText, "The username doesn't match");
    }

    @Test
    public void loadDropDawnListElements() {
        autorizationPage.autorization(login, TestValues.password);
        mainPage.focusMain();
        String elementVacancy = mainPage.getTextElementVacancy();
        String elementCandidates = mainPage.getTextElementCandidate();
        String elementSelectionPanel = mainPage.getTextElementSelectionPanel();
        String elementMain = mainPage.getTextElementMain();
        assertEquals("Вакансии", elementVacancy, "The element 'Vacancy' of the main page is not loaded");
        assertEquals("Кандидаты", elementCandidates, "The element 'Candidates' of the main page is not loaded");
        assertEquals("Панель Подбора", elementSelectionPanel, "The element 'Selection Panel' of the main page is not loaded");
        assertEquals("Главная", elementMain, "The element 'Main' of the main page is not loaded");
    }



}
