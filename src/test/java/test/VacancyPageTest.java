package test;

import org.junit.jupiter.api.Test;
import testValues.TestValues;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VacancyPageTest extends BaseTest{

    @Test
    public void loadCandidatesPage() {
        autorizationPage.autorization(TestValues.login, TestValues.password);
        mainPage.clickVacancys();
        boolean toolbar = vacancysPage.displayToolbar();
        String getTitleText = vacancysPage.getTitleVacancysText();
        assertTrue(toolbar, "The toolbar of the vacancy page is not loaded");
        assertEquals(" ВАКАНСИИ", getTitleText, "The title 'Vacancy' was not found");
    }

    @Test
    public void loadDropDawnListElements() {
        autorizationPage.autorization(TestValues.login, TestValues.password);
        mainPage.clickVacancys();
        vacancysPage.focusVacancys();
        String elementCreateVacancy = vacancysPage.getTextCreateVacancy();
        String elementListOfVacancys = vacancysPage.getTextListOfVacancys();
        String elementArchiveOfVacancys = vacancysPage.getTextArchiveOfVacancys();
        String elementMyVacancys = vacancysPage.getTextMyVacancys();
        assertEquals("Создать", elementCreateVacancy, "The element 'Create Vacancy' of the candidates page is not loaded");
        assertEquals("Список", elementListOfVacancys, "The element 'List Of Vacancys' of the candidates page is not loaded");
        assertEquals("Архивы Вакансий", elementArchiveOfVacancys, "The element 'Archive Of Vacancys' of the candidates page is not loaded");
        assertEquals("Мои Вакансии", elementMyVacancys, "The element 'My Vacancys' of the candidates page is not loaded");
    }

}
