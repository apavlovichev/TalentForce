package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import testValues.TestValues;

public class CreateVacancyPage extends BasePage{

    public CreateVacancyPage(WebDriver driver) {
        super(driver);
    }

    //Страница создания вакансии
    @FindBy(xpath = "//h2[contains(text(),'Создание Вакансии')]")
    private WebElement titleCreateVacancy; //Надпись "Создание вакансии"
    @FindBy(xpath = "//div[@id='toolbar']")
    private WebElement toolBar;
    @FindBy(xpath = "//span[text()=' Сохранить ']//ancestor::button")
    private WebElement saveButton;
    @FindBy(xpath = "//span[text()=' Закрыть ']//ancestor::button")
    private WebElement closeButton;

    public String getTitleCreateVacancy(){
        return isElementGetText(titleCreateVacancy);
    }

    public boolean displayToolbar(){
        toolBar.isDisplayed();
        return true;
    }

    //Шаблон вакансии
    @FindBy(xpath = "//input[@name='hrpac_vacancy_template_name']")
    private WebElement vacancyTemplate;
    @FindBy(xpath = "//span[text()='Разработчики Java ']/parent::li")
    private WebElement templateVacancyDevJava;
    @FindBy(xpath = "//span[contains(text(),'Подбор шаблона')]")
    private WebElement selectingATemplate;




    //Блок с основной информацией
    @FindBy(xpath = "//h3[contains(text(),'Основная информация')]")
    private WebElement titleMainInfo;
    @FindBy(xpath = "//input[@name='name_id']/parent::div")
    private WebElement nameVacancy;
    @FindBy(xpath = "//input[@name='name_id']")
    private WebElement inputNameVacancy;
    @FindBy(xpath = "//span[text()='Младщий специалист по автотестированию']")
    private WebElement juniorQAAutomatization;
    @FindBy(xpath = "//input[@name='amount']")
    private WebElement startingNumberOfPositions;
    @FindBy(xpath = "//input[@name='reason_for_opening']/parent::div")
    private WebElement reasonForOpeningAVacancy;
    @FindBy(xpath = "//span[text()='Новый сотрудник']")
    private WebElement newEmployee;
    @FindBy(xpath = "//input[@name='business_unit_id']/parent::div")
    private WebElement businessUnit;
    @FindBy(xpath = "//span[text()='Digital']")
    private WebElement digital;
    @FindBy(xpath = "//input[@name='department_id']/parent::div")
    private WebElement department;
    @FindBy(xpath = "//span[text()='BPM/Практика BPM/ECM/SOA, Отдел Тестирования']")
    private WebElement departmentOfTesting;
    @FindBy(xpath = "//input[@name='project_link_id']/parent::div")
    private WebElement project;
    @FindBy(xpath = "//span[text()='TalentForce']")
    private WebElement talentForce;
    @FindBy(xpath = "//input[@name='location_id']/parent::div")
    private WebElement location;
    @FindBy(xpath = "//span[text()='Москва']")
    private WebElement moscow;
    @FindBy(xpath = "//input[@name='office_job']/parent::span")
    private WebElement officeJob;
    @FindBy(xpath = "//input[@name='office_adress']")
    private WebElement officeAdressField;
    @FindBy(xpath = "//input[@name='remote_job']/parent::span")
    private WebElement remoteJob;

    public String getMainInfoTitle(){
        return isElementGetText(titleMainInfo);
    }

    //Заполнение поля "Наименование вакансии" через ввод + arrow down + enter (для универсальности проверки - берем из TestValues)
    public CreateVacancyPage typeNameVacancy(String nameVacancyValue){
        clickElement(nameVacancy);
        chooseValue(inputNameVacancy, nameVacancyValue);
        return this;
    }

//    public void typeNameVacancy() {
//        clickElement(nameVacancy);
//        clickElement(juniorQAAutomatization);
//    }

    public void typeReasonForOpeningAVacancy() {
        clickElement(reasonForOpeningAVacancy);
        clickElement(newEmployee);
    }

    public void typeDepartment() {
        clickElement(department);
        clickElement(departmentOfTesting);
    }

    public void typeLocation() {
        clickElement(location);
        clickElement(moscow);
    }

    public CreateVacancyPage typeNumberOfPositions(String numberOfPositions) {
        startingNumberOfPositions.clear();
        writeText(startingNumberOfPositions, numberOfPositions);
        return this;
    }

    public void typeBusinessUnit() {
        clickElement(businessUnit);
        clickElement(digital);
    }

    public void typeProject() {
        clickElement(project);
        clickElement(talentForce);
    }

    public CreateVacancyPage typeOfficeJob(String officeAdress) {
        clickElement(officeJob);
        writeText(officeAdressField, officeAdress);
        return this;
    }

    public void typeRemoteJob() {
        clickElement(remoteJob);
    }

    //Метод ввода данных в блоке "Основная информация"
    public CreateVacancyPage typeMainInfo(String nameVacancyValue, String numberOfPositions, String officeAdress){
        this.typeNameVacancy(nameVacancyValue);
//        typeNameVacancy();
        typeReasonForOpeningAVacancy();
        typeDepartment();
        typeLocation();
        this.typeNumberOfPositions(numberOfPositions);
        typeBusinessUnit();
        typeProject();
        this.typeOfficeJob(officeAdress);
        typeRemoteJob();
        return this;
    }

    //Блок с опытом и оплатой
    @FindBy(xpath = "//h3[contains(text(),'Опыт и оплата')]")
    private WebElement titleExperienceAndWork;
    @FindBy(xpath = "//input[@name='grade']/parent::div")
    private WebElement grade;
    @FindBy(xpath = "//span[text()='Грейд 2']")
    private WebElement grade2;
    @FindBy(xpath = "//span[text()='Грейд 3']")
    private WebElement grade3;
    @FindBy(xpath = "//input[@name='job_experience_from']")
    private WebElement jobExperienceFrom;
    @FindBy(xpath = "//input[@name='job_experience_to']")
    private WebElement jobExperienceTo;
    @FindBy(xpath = "//input[@name='bonuses']/parent::span")
    private WebElement bonuses;
    @FindBy(xpath = "//input[@name='frequency']")
    private WebElement frequency;
    @FindBy(xpath = "//input[@name='salary_min']")
    private WebElement salaryMin;
    @FindBy(xpath = "//input[@name='salary_max']")
    private WebElement salaryMax;
    @FindBy(xpath = "//input[@name='currency_id']/parent::div")
    private WebElement currency;
    @FindBy(xpath = "//span[text()='$']")
    private WebElement dollar;
    @FindBy(xpath = "//input[@name='stack_skills_ids']/..")
//    @FindBy(css = ".el-form-item.is-required.el-form-item--mini.row .el-select__input.is-mini")
    private WebElement keySkills;
    private String dropList = "//div[@x-placement='top-start']//li";
//    @FindBy(xpath = "//div[@x-placement='top-start']//span[text()='SAP PI/PO']")
//    private WebElement saspPiPo;
    @FindBy(xpath = "//input[@name='desirable_skills_ids']/..")
//    @FindBy(css = ".vacancy-form__section.el-form__section:nth-child(3) .el-form-item.row:last-child .el-form-item.el-form-item--mini.row .el-select__input.is-mini")
    private WebElement desirableSkills;
    @FindBy(xpath = "//span[text()='Исполнительность']")
    private WebElement executiveСapacity;
    @FindBy(xpath = "//span[text()='soap']")
    private WebElement soap;

    public String getExperienceAndWork(){
        return isElementGetText(titleExperienceAndWork);
    }

    public void typeGrade(){
        clickElement(grade);
        clickElement(grade2);
        clickElement(grade3);
    }

    public CreateVacancyPage typeJobExperience(String jobExperienceFromValue, String jobExperienceToValue){
        writeText(jobExperienceFrom, jobExperienceFromValue);
        writeText(jobExperienceTo, jobExperienceToValue);
        return this;
    }

    public CreateVacancyPage typeSalary(String salaryMinValue, String salaryMaxValue){
        writeText(salaryMin, salaryMinValue);
        writeText(salaryMax, salaryMaxValue);
        clickElement(currency);
        clickElement(dollar);
        return this;
    }

    public CreateVacancyPage typeKeySkills(String keySkillName){
        mouseOver(titleRequirementsAndResponsibilities);
        clickElement(keySkills);
        selectValue(dropList, keySkillName);
        clickElement(keySkills);
        clickElement(keySkills);
        return this;
    }

    public CreateVacancyPage typeBonuses(String frequencyValue){
        clickElement(bonuses);
        writeText(frequency, frequencyValue);
        return this;
    }

    public CreateVacancyPage typeDesirableSkills(String desirablesSkillName){
        mouseOver(titleRequirementsAndResponsibilities);
        clickElement(desirableSkills);
        selectValue(dropList, desirablesSkillName);
        clickElement(desirableSkills);
        clickElement(desirableSkills);
        return this;
    }

    //Метод ввода данных в блоке "Опыт и оплата"
    public CreateVacancyPage typeExperienceAndWork(String salaryMinValue, String salaryMaxValue, String keySkillName, String jobExperienceFromValue, String jobExperienceToValue, String frequencyValue, String desirablesSkillName){
        typeGrade();
        this.typeSalary(salaryMinValue, salaryMaxValue);
        this.typeKeySkills(keySkillName);
        this.typeJobExperience(jobExperienceFromValue, jobExperienceToValue);
        this.typeBonuses(frequencyValue);
        this.typeDesirableSkills(desirablesSkillName);
        return this;
    }

    //Блок с требованиями и обязанностями
    @FindBy(xpath = "//h3[contains(text(),'Требования и Обязанности')]")
    private WebElement titleRequirementsAndResponsibilities;
    @FindBy(xpath = "//iframe[@id='demands_ifr']")
    private WebElement jobRequirements;
    @FindBy(xpath = "//iframe[@id='description_ifr']")
    private WebElement responsibilitiesAndTasks;
    @FindBy(xpath = "//body")
    private WebElement requirementsAndResponsibilitiesText;

    public String getrequirementsAndResponsibilities(){
        return isElementGetText(titleRequirementsAndResponsibilities);
    }

    public CreateVacancyPage typeJobRequirements(String jobRequirementsValue){
        driver.switchTo().frame(jobRequirements);
        writeText(requirementsAndResponsibilitiesText, jobRequirementsValue);
        driver.switchTo().defaultContent();
        return this;
    }

    public CreateVacancyPage typeResponsibilitiesAndTasks(String responsibilitiesAndTasksValue){
        driver.switchTo().frame(responsibilitiesAndTasks);
        writeText(requirementsAndResponsibilitiesText, responsibilitiesAndTasksValue);
        driver.switchTo().defaultContent();
        return this;
    }

    //Метод дввода данных в блоке "Требования и Обязанности"
    public CreateVacancyPage typeRequirementsAndResponsibilities(String jobRequirementsValue, String responsibilitiesAndTasksValue){
        this.typeJobRequirements(jobRequirementsValue);
        this.typeResponsibilitiesAndTasks(responsibilitiesAndTasksValue);
        return this;
    }

    //Блок с участниками
    @FindBy(xpath = "//h3[contains(text(),'Участники')]")
    private WebElement titleParticipants;
    @FindBy(xpath = "//input[@name='supervisor_id']") // Менеджер Нанимающий
    private WebElement supervisor;
    @FindBy(xpath = "//input[@name='manager_id']") // Рекрутеров Руководитель
    private WebElement manager;
    @FindBy(xpath = "//input[@name='technical_experts_ids']") // Admin Administrator, Recruiter Test
    private WebElement technicalExperts;
    @FindBy(xpath = "//input[@name='additional_managers_ids']") // Process Test, process2 test
    private WebElement additionalManagers;
    @FindBy(xpath = "//input[@name='spectators_ids']") // process3 test, process4 test
    private WebElement spectators;
    @FindBy(xpath = "//input[@name='external_customer']")
    private WebElement externalCustomerCheckBox;
    @FindBy(xpath = "//input[@name='external_customer_contact']") // Внешний заказчик
    private WebElement externalCustomerField;
    @FindBy(xpath = "//input[@name='additional_assigned_ids']") // process5 test, process6 test
    private WebElement additionalRecruter;
    @FindBy(xpath = "//input[@name='assigned_user_name']")
    private WebElement recruter;

    public String getParticipants(){
        return isElementGetText(titleParticipants);
    }

    public CreateVacancyPage typeSupervisor(String supervisorValues){
        mouseOver(selectionProcess);
        clickElement(supervisor);
        selectValue(dropList, supervisorValues);
        return this;
    }

    public CreateVacancyPage typeTechnicalExperts(String technicalExpertsValue){
        mouseOver(selectionProcess);
        clickElement(technicalExperts);
        selectValue(dropList, technicalExpertsValue);
        clickElement(titleParticipants);
        return this;
    }

    public CreateVacancyPage typeSpectators(String spectatorsValue){
        mouseOver(selectionProcess);
        clickElement(spectators);
        selectValue(dropList, spectatorsValue);
        clickElement(titleParticipants);
        return this;
    }

    public CreateVacancyPage typeManager(String managerValue){
        mouseOver(selectionProcess);
        clickElement(manager);
        selectValue(dropList, managerValue);
        return this;
    }

    public CreateVacancyPage typeAdditionalManagers(String additionalManagersValue){
        mouseOver(selectionProcess);
        clickElement(additionalManagers);
        selectValue(dropList, additionalManagersValue);
        clickElement(titleParticipants);
        return this;
    }

    public CreateVacancyPage typeExternalCustomer(String externalCustomerValue) {
        clickElement(externalCustomerCheckBox);
        writeText(externalCustomerField, externalCustomerValue);
        return this;
    }

    public CreateVacancyPage typeAdditionalRecruter(String additionalRecruterValue){
        mouseOver(selectionProcess);
        clickElement(additionalRecruter);
        selectValue(dropList, additionalRecruterValue);
        clickElement(titleParticipants);
        return this;
    }

    //Метод заполнения блока "Участники"

    public CreateVacancyPage typeParticipants(String supervisorValues, String technicalExpertsValue1, String spectatorsValue1, String managerValue, String additionalManagersValue1, String externalCustomerValue, String additionalRecruterValue1){
        this.typeSupervisor(supervisorValues);
        this.typeTechnicalExperts(technicalExpertsValue1);
//        this.typeTechnicalExperts(technicalExpertsValue2);
        this.typeSpectators(spectatorsValue1);
//        this.typeSpectators(spectatorsValue2);
        this.typeManager(managerValue);
        this.typeAdditionalManagers(additionalManagersValue1);
//        this.typeAdditionalManagers(additionalManagersValue2);
        this.typeExternalCustomer(externalCustomerValue);
        this.typeAdditionalRecruter(additionalRecruterValue1);
//        this.typeAdditionalRecruter(additionalRecruterValue2)
//        this.typeAdditionalRecruter(additionalRecruterValue2);
        return this;
    }

    //Блок с процессом подбора
    @FindBy(xpath = "//h3[contains(text(),'Процесс подбора')]")
    private WebElement selectionProcess;
    @FindBy(xpath = "//input[@name='hrpac_vacancy_difficulty_level_name']")
    private WebElement difficultyLevel;
    @FindBy(xpath = "//span[text()='Сложная']/parent::li")
    private WebElement hardVacancy;
    @FindBy(xpath = "//input[@name='stage_templates_name']")
    private WebElement templatesForSelectionStages;
    @FindBy(xpath = "//input[@name='vacansy_url']")  // http://stage.hr.tsconsulting.com/thisVacancy/
    private WebElement vacansyUrl;
    @FindBy(xpath = "//input[@name='test_url']") // http://stage.hr.tsconsulting.com/entryPoint/sqlAssessment/
    private WebElement testUrl;

    public String getSelectionProcess(){
        return isElementGetText(selectionProcess);
    }

    public void typeDifficultyLevel(){
        clickElement(difficultyLevel);
        clickElement(hardVacancy);
    }

    public CreateVacancyPage typeTemplatesForSelectionStages(String templatesForSelectionStagesValue){
        chooseValue(templatesForSelectionStages, templatesForSelectionStagesValue);
        return this;
    }

    public CreateVacancyPage typeVacansyUrl(String vacansyUrlValue){
        writeText(vacansyUrl, vacansyUrlValue);
        return this;
    }

    public CreateVacancyPage typeTestUrl(String testUrlValue){
        writeText(testUrl, testUrlValue);
        return this;
    }

    //Метод ввода данных в блок "Процесс подбора"
    public CreateVacancyPage typeSelectionProcess(String vacansyUrlValue, String testUrlValue){
        typeDifficultyLevel();
        this.typeVacansyUrl(vacansyUrlValue);
        this.typeTestUrl(testUrlValue);
        return this;
    }

    //Сохранение вакансии
    public VacancyDetailView saveVacancy() {
        clickElement(saveButton);
        return new VacancyDetailView(driver);
    }

    //Информационое сообщение о необходимости заполнения обязательных полей
    @FindBy(xpath = "//label[text()='Наименование']/parent::div/descendant::div[contains(text(),'Необходимо заполнить поле')]")
    private WebElement emptyVacancyNameField;
    @FindBy(xpath = "//label[text()='Причина открытия вакансии']/parent::div/descendant::div[contains(text(),'Необходимо заполнить поле')]")
    private WebElement emptyReasonForOpeningAJobField;
    @FindBy(xpath = "//label[text()='Отдел']/parent::div/descendant::div[contains(text(),'Необходимо заполнить поле')]")
    private WebElement emptyDepartmentField;
    @FindBy(xpath = "//label[text()='Бизнес Юнит']/parent::div/descendant::div[contains(text(),'Необходимо заполнить поле')]")
    private WebElement emptyBusinessUnitField;
    @FindBy(xpath = "//label[text()='Грэйд']/parent::div/descendant::div[contains(text(),'Необходимо заполнить поле')]")
    private WebElement emptyGradeField;
    @FindBy(xpath = "//label[text()='Ключевые навыки']/parent::div/descendant::div[contains(text(),'Необходимо заполнить поле')]")
    private WebElement emptyKeySkillsField;
    @FindBy(xpath = "//label[text()='Должностные Требования']/parent::div/descendant::div[contains(text(),'Необходимо заполнить поле')]")
    private WebElement emptyJobRequirementsField;
    @FindBy(xpath = "//label[text()='Обязанности и задачи']/parent::div/descendant::div[contains(text(),'Необходимо заполнить поле')]")
    private WebElement emptyResponsibilitiesAndTasksField;
    @FindBy(xpath = "//label[text()='Директор БЮ/Зам.директора БЮ']/parent::div/descendant::div[contains(text(),'Необходимо заполнить поле')]")
    private WebElement emptyDirectorBUField;
    @FindBy(xpath = "//label[text()='Директор проекта/Руководитель проекта']/parent::div/descendant::div[contains(text(),'Необходимо заполнить поле')]")
    private WebElement emptyDirectorOfProjectField;

    //Забираем информацио о необходимости заполнения обязательных полей в блоке "Основаная информация"

    public String getErrorVacancyNameField() {
        return isElementGetText(emptyVacancyNameField);
    }

    public String getErrorReasonForOpeningAJobField() {
        return isElementGetText(emptyReasonForOpeningAJobField);
    }

    public String getErrorDepartmentField() {
        return isElementGetText(emptyDepartmentField);
    }

    public String getErrorBusinessUnitField() {
        return isElementGetText(emptyBusinessUnitField);
    }

    public String getErrorGradeField() {
        return isElementGetText(emptyGradeField);
    }

    public String getErrorKeySkillsField() {
        return isElementGetText(emptyKeySkillsField);
    }

    public String getErrorJobRequirementsField() {
        return isElementGetText(emptyJobRequirementsField);
    }

    public String getErrorResponsibilitiesAndTasksField() {
        return isElementGetText(emptyResponsibilitiesAndTasksField);
    }

    public String getErrorDirectorBUField() {
        return isElementGetText(emptyDirectorBUField);
    }

    public String getErrorDirectorOfProjectField() {
        return isElementGetText(emptyDirectorOfProjectField);
    }










}

