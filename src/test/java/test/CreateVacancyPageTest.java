package test;

import org.junit.jupiter.api.Test;
import testValues.TestValues;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateVacancyPageTest extends BaseTest{



    @Test
    public void createWithEmptyRequiredFields() {
        autorizationPage.autorization(TestValues.login, TestValues.password);
        mainPage.clickVacancys();
        vacancysPage.createVacancy();
        createVacancyPage.saveVacancy();
        String emptyVacancyName = createVacancyPage.getErrorVacancyNameField();
        String emptyReasonForOpeningAJob = createVacancyPage.getErrorReasonForOpeningAJobField();
        String emptyDepartment = createVacancyPage.getErrorDepartmentField();
        String emptyBusinessUnit = createVacancyPage.getErrorBusinessUnitField();
        String emptyGrade = createVacancyPage.getErrorGradeField();
        String emptyKeySkills = createVacancyPage.getErrorKeySkillsField();
        String emptyJobRequirements = createVacancyPage.getErrorJobRequirementsField();
        String emptyResponsibilitiesAndTasks = createVacancyPage.getErrorResponsibilitiesAndTasksField();
        String emptyDirectorBU = createVacancyPage.getErrorDirectorBUField();
        String emptyDirectorOfProject = createVacancyPage.getErrorDirectorOfProjectField();
        assertEquals("Необходимо заполнить поле", emptyVacancyName, "The error text of an empty required field 'Vacancy Name' is missing or does not match");
        assertEquals("Необходимо заполнить поле", emptyReasonForOpeningAJob, "The error text of an empty required field 'Reason For Opening A Job' is missing or does not match");
        assertEquals("Необходимо заполнить поле", emptyDepartment, "The error text of an empty required field 'Department' is missing or does not match");
        assertEquals("Необходимо заполнить поле", emptyBusinessUnit, "The error text of an empty required field 'Business Unit' is missing or does not match");
        assertEquals("Необходимо заполнить поле", emptyGrade, "The error text of an empty required field 'Grade' is missing or does not match");
        assertEquals("Необходимо заполнить поле", emptyKeySkills, "The error text of an empty required field 'Key Skills' is missing or does not match");
        assertEquals("Необходимо заполнить поле", emptyJobRequirements, "The error text of an empty required field 'Job Requirements' is missing or does not match");
        assertEquals("Необходимо заполнить поле", emptyResponsibilitiesAndTasks, "The error text of an empty required field 'Responsibilities And Tasks' is missing or does not match");
        assertEquals("Необходимо заполнить поле", emptyDirectorBU, "The error text of an empty required field 'Director BU' is missing or does not match");
        assertEquals("Необходимо заполнить поле", emptyDirectorOfProject, "The error text of an empty required field 'Director Of Project' is missing or does not match");
    }

    @Test
    public void createVacancyTest() {
        autorizationPage.autorization(TestValues.login, TestValues.password);
        mainPage.clickVacancys();
        vacancysPage.createVacancy();
        createVacancyPage.typeMainInfo(TestValues.nameVacancyValue, TestValues.numberOfPositions, TestValues.officeAdress)
                         .typeExperienceAndWork(TestValues.salaryMinValue, TestValues.salaryMaxValue, TestValues.keySkill0ne,TestValues.jobExperienceFromValue, TestValues.jobExperienceToValue, TestValues.frequencyValue, TestValues.keySkillTwo)
                         .typeRequirementsAndResponsibilities(TestValues.jobRequirementsValue, TestValues.responsibilitiesAndTasksValue)
                         .typeParticipants(TestValues.supervisorValues, TestValues.technicalExpertsValue1, TestValues.spectatorsValue1,
                          TestValues.managerValue, TestValues.additionalManagersValue1, TestValues.externalCustomerValue, TestValues.additionalRecruterValue1)
                         .typeSelectionProcess(TestValues.vacansyUrlValue, TestValues.testUrlValue)
                         .saveVacancy();
        boolean vacancyStagePanel = vacancyDetailView.displayVacancyStagePanel();
        boolean vacancyView = vacancyDetailView.displayVacancyView();
        boolean vacancyViewInfo = vacancyDetailView.displayVacancyViewInfo();
        String titleVacancyText = vacancyDetailView.getTitleVacancyText();
        assertEquals (TestValues.nameVacancyValue, titleVacancyText, "The title 'Vacancy Name' was not found");
        assertTrue(vacancyStagePanel, "The Stage Panel of the vacancy detail view page is not loaded");
        assertTrue(vacancyView, "The vacancy view of the vacancy detail view page is not loaded");
        assertTrue(vacancyViewInfo, "The vacancy view info of the vacancy detail view page is not loaded");
    }

}
