package test;

import org.junit.jupiter.api.Test;
import testValues.TestValues;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CandidatesPageTest extends BaseTest {

    @Test
    public void loadCandidatesPage() {
        autorizationPage.autorization(TestValues.login, TestValues.password);
        mainPage.clickCandidates();
        boolean toolbar = candidatesPage.displayToolbar();
        String getTitleText = candidatesPage.getTitleCandidateText();
        assertTrue(toolbar, "The toolbar of the candidates page is not loaded");
        assertEquals(" КАНДИДАТЫ", getTitleText, "The title 'Candidates' was not found");
    }

    @Test
    public void loadDropDawnListElements() {
        autorizationPage.autorization(TestValues.login, TestValues.password);
        mainPage.clickCandidates();
        candidatesPage.focusCandidates();
        String elementCreateCandidate = candidatesPage.getTextCreateCandidate();
        String elementListOfCandidate = candidatesPage.getTextlayListOfCandidate();
        String elementImportCandidate = candidatesPage.getTextImportCandidate();
        assertEquals("Создать", elementCreateCandidate, "The element 'Create Candidate' of the candidates page is not loaded");
        assertEquals("Список", elementListOfCandidate, "The element 'List Of Candidate' of the candidates page is not loaded");
        assertEquals("Импорт", elementImportCandidate, "The element 'Import Candidate' of the candidates page is not loaded");
    }


}
