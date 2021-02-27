package test;

import org.junit.jupiter.api.Test;
import page.BasePage;
import test.BaseTest;
import testValues.TestValues;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateCandidatePageTest extends BaseTest {

    @Test
    public void loadCreateCandidatesPage() {
        autorizationPage.autorization(TestValues.login, TestValues.password);
        mainPage.clickCandidates();
        candidatesPage.createCandidate();
        boolean toolbar = createCandidatePage.displayToolbar();
        String getTitleText = createCandidatePage.getTitleCreateCandidateText();
        assertTrue(toolbar, "The toolbar of the create candidates page is not loaded");
        assertEquals("СОЗДАНИЕ КАНДИДАТА", getTitleText, "The title 'Create Candidate' was not found");
    }

    @Test
    public void loadingBlocksField() {
        autorizationPage.autorization(TestValues.login, TestValues.password);
        mainPage.clickCandidates();
        candidatesPage.createCandidate();
        String titleMainText = createCandidatePage.getMainInfoTitle();
        String titleCommunicationText = createCandidatePage.getCommunicationTitle();
        String titleDesiredSalaryAndExperienceText = createCandidatePage.getDesiredSalaryAndExperienceTitle();
        String titleResumeText = createCandidatePage.getResumeTitle();
        assertEquals("Основная информация", titleMainText, "The 'Main information' block is not loaded");
        assertEquals("Средства связи", titleCommunicationText, "The 'Communication' block is not loaded");
        assertEquals("Желаемая зарплата и опыт", titleDesiredSalaryAndExperienceText, "The 'Desired salary and experience' block is not loaded");
        assertEquals("Резюме", titleResumeText, "The 'Resume' block is not loaded");
    }

    @Test
    public void createWithEmptyRequiredFields() {
        autorizationPage.autorization(TestValues.login, TestValues.password);
        mainPage.clickCandidates();
        candidatesPage.createCandidate();
        createCandidatePage.saveCandidate();
        String emptyFirstName = createCandidatePage.getErrorFirstNameField();
        String emptyResumeSourse = createCandidatePage.getErrorResumeSourseText();
        assertEquals("Необходимо заполнить поле", emptyFirstName, "The error text of an empty required field 'First Name' is missing or does not match");
        assertEquals("Необходимо заполнить поле", emptyResumeSourse, "The error text of an empty required field 'Resume Source' is missing or does not match");
    }

    @Test
    public void createWithIncorrectValues() {
        autorizationPage.autorization(TestValues.login, TestValues.password);
        mainPage.clickCandidates();
        candidatesPage.createCandidate();
        createCandidatePage .addEmailField()
                            .addPhoneField()
                            .addFacebookField();
        String invalidEmail = createCandidatePage.getInvalidEmail(TestValues.incorrectValues);
        String invalidPhone = createCandidatePage.getInvalidPhone(TestValues.incorrectValues);
        String invalidFacebook = createCandidatePage.getInvalidFacebook(TestValues.incorrectValues);
        String invalidResumeLink = createCandidatePage.getInvalidResumeLink(TestValues.incorrectValues);
        assertEquals("Введенный email указан некорректно", invalidEmail, "The error text of an empty required field 'Email' is missing or does not match");
        assertEquals("Номер должен содержать как минимум 7 цифр", invalidPhone, "The error text of an empty required field 'Phone' is missing or does not match");
        assertEquals("Введен некорректный URL адрес", invalidFacebook, "The error text of an empty required field 'Facebook' is missing or does not match");
        assertEquals("Введен некорректный URL адрес", invalidResumeLink, "The error text of an empty required field 'Facebook' is missing or does not match");
     }

     @Test
     public void createCandidateTest() throws InterruptedException {
         String candidateFIO = new StringBuilder().append(TestValues.lastName.toUpperCase()).append(" ").append(TestValues.firstName.toUpperCase()).append(" ").append(TestValues.middleName.toUpperCase()).toString();
         autorizationPage.autorization(TestValues.login, TestValues.password);
         mainPage.clickCandidates();
         candidatesPage.createCandidate();
         createCandidatePage.typeMainInfo(TestValues.lastName, TestValues.firstName, TestValues.middleName, TestValues.birthday)
                            .chooseCommunication()
                            .typeCommunication(TestValues.email, TestValues.phone, TestValues.skype, TestValues.facebook, TestValues.linkedin, TestValues.telegram, TestValues.site)
                            .typeDesiredSalaryAndExperience(TestValues.desiredPosition, TestValues.desiresSalary, TestValues.experience, TestValues.lastWorkPlace, TestValues.lastPosition)
                            .typeResume(TestValues.resumelink, TestValues.date, TestValues.time, TestValues.resumeText)
                            .saveCandidate();
         boolean candidateView = candidateDetailView.displayCandidateView();
         boolean candidateViewInfo = candidateDetailView.displayCandidateViewInfo();
         String getTitleCandidateText = candidateDetailView.getTitleCandidateText();
         assertEquals(candidateFIO, getTitleCandidateText, "The title 'FIO' was not found");
         assertTrue(candidateView, "The candidate view of the candidates detail view page is not loaded");
         assertTrue(candidateViewInfo, "The candidate view info of the candidates detail view page is not loaded");
     }




}
