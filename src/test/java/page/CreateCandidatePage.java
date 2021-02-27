package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCandidatePage extends BasePage{

    public CreateCandidatePage(WebDriver driver) {
        super(driver);
    }

    //Страница создания кандидата
    @FindBy(xpath = "//h2[contains(text(),'Создание кандидата')]")
    private WebElement titleCreateCandidate; //Надпись "Создание кандидата"
    @FindBy(xpath = "//div[@id='toolbar']")
    private WebElement toolBar; //Надпись "Создание кандидата"
    @FindBy(xpath = "//span[text()='Сохранить']//ancestor::button")
    private WebElement saveButton;
    @FindBy(xpath = "//span[text()='Закрыть']//ancestor::button")
    private WebElement closeButton;

    public String getTitleCreateCandidateText() {
        return isElementGetText(titleCreateCandidate);
    }

    public boolean displayToolbar() {
        isElementDisplayed(toolBar);
        return true;
    }

    //Блок с основной информацией
    @FindBy(xpath = "//h3[contains(text(),'Основная информация')]")
    private WebElement titleMainInfo; // Надпись "Основная информация"
    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement firstNameField;
    @FindBy(xpath = "//h3[text()='Основная информация']/parent::div[@class='candidate-form__section el-form__section']//div[contains(text(), 'Необходимо заполнить поле')]")
    private WebElement emptyErrorFirstName;  //Ошибка при заполении имени кандидата
    @FindBy(xpath = "//input[@name='middle_name']")
    private WebElement middleNameField;
    @FindBy(xpath = "//input[@name='gender']/parent::div")
    private WebElement genderField;
    @FindBy(xpath = "//span[text()='Мужской']/parent::li")
    private WebElement male;
    @FindBy(xpath = "//input[@name='birth_date']")
    private WebElement birthDateField;
    @FindBy(xpath = "//input[@name='location_id']/parent::div")
    private WebElement locationField;
    @FindBy(xpath = "//span[text()='Москва']/parent::li")
    private WebElement moscow;
    @FindBy(xpath = "//input[@name='photo_file']")
    private WebElement loadPhoto;

    public String getMainInfoTitle() {
        return isElementGetText(titleMainInfo);
    }

    public String getErrorFirstNameField() {
        return isElementGetText(emptyErrorFirstName);
    }

    //Загружаем фото кандидата
    public void uploadPhoto() {
        loadPhoto.sendKeys("C:\\Users\\apavlovichev\\IdeaProjects\\TalentForce\\pic\\candidateMale.png");
    }

    public CreateCandidatePage typeLastName(String lastname) {
        writeText(lastNameField, lastname);
        return this;
    }

    public CreateCandidatePage typeFirstName(String firstname) {
        writeText(firstNameField, firstname);
        return this;
    }

    public CreateCandidatePage typeMiddleName(String middlename) {
        writeText(middleNameField, middlename);
        return this;
    }

    public CreateCandidatePage typeBirthDate(String birthdate) {
        writeText(birthDateField, birthdate);
        return this;
    }

    public void typeLocation() {
        clickElement(locationField);
        clickElement(moscow);
    }

    //Метод ввода данных в блоке "Основная информация"
    public CreateCandidatePage typeMainInfo(String lastname, String firstname, String middlename, String birthdate) {
        this.typeLastName(lastname);
        this.typeFirstName(firstname);
        this.typeMiddleName(middlename);
        this.typeBirthDate(birthdate);
//        gender.click();
//        male.click();
        typeLocation();
        uploadPhoto();
        return this;
    }

    //Блок с коммуникациями
    @FindBy(xpath = "//h3[contains(text(),'Средства связи')]")
    private WebElement titleCommunication; //Надпись "Средства связи"
    @FindBy(xpath = "//div[@class='el-submenu__title']/button")
    private WebElement communicationButton;
    @FindBy(xpath = "//li[contains(text(),'E-mail')]")
    private WebElement email;
    @FindBy(xpath = "//li[contains(text(),'Телефон')]")
    private WebElement phone;
    @FindBy(xpath = "//li[contains(text(),'Skype')]")
    private WebElement skype;
    @FindBy(xpath = "//span[text()='Социальные сети']/parent::div")
    private WebElement socialNetworkButton;
    @FindBy(xpath = "//li[contains(text(),'Facebook')]")
    private WebElement facebook;
    @FindBy(xpath = "//li[contains(text(),'LinkedIn')]")
    private WebElement linkedIn;
    @FindBy(xpath = "//li[contains(text(),'Telegram')]")
    private WebElement telegram;
    @FindBy(xpath = "//li[contains(text(),'Сайт')]")
    private WebElement site;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@type='tel']")
    private WebElement phoneField;
    @FindBy(xpath = "//span[text()='Skype']/following::input[1]")
    private WebElement skypeField;
    @FindBy(xpath = "//input[@type='email']/following::button[1]")
    private WebElement deleteEmailButton;    //Для проверки удаления средства связи
    @FindBy(xpath = "//span[text()='Facebook']/following::input[@type='url'][1]")
    private WebElement facebookField;
    @FindBy(xpath = "//span[text()='LinkedIn']/following::input[@type='url'][1]")
    private WebElement linkedInField;
    @FindBy(xpath = "//span[text()='Telegram']/following::input[@type='text' and @maxlength='64'][1]")
    private WebElement telegramField;
    @FindBy(xpath = "//span[text()='Сайт']/following::input[@type='url'][1]")
    private WebElement siteField;

    //Некорректные заполнения полей коммуникации и поля "Резюме, Ссылка" в блоке "Резюме"
    @FindBy(xpath = "//h3[text()='Средства связи']/parent::div[@class='candidate-form__section el-form__section']//div[contains(text(), 'Введенный email указан некорректно')]")
    private WebElement invalidEmail;
    @FindBy(xpath = "//h3[text()='Средства связи']/parent::div[@class='candidate-form__section el-form__section']//div[contains(text(), 'Номер должен содержать как минимум 7 цифр')]")
    private WebElement invalidPhone;
    @FindBy(xpath = "//input[@type='url']/ancestor::div[@class='el-form-item__content']/div[contains(text(), 'Введен некорректный URL адрес')]")
    private WebElement invalidFacebook;
    @FindBy(xpath = "//h3[text()='Резюме']/parent::div[@class='candidate-form__section el-form__section']//div[contains(text(), 'Введен некорректный URL адрес')]")
    private WebElement invalidResumeLink;

    public String getCommunicationTitle() {
        return isElementGetText(titleCommunication);
    }

    //Прокликивание средств связи (каждый метод теперь отдельно, для того, что бы использовать их в тестах)
    public void clickCommunicationButton() {
        clickElement(communicationButton);
    }

    public void clicksocialNetworkButton() {
        clickElement(socialNetworkButton);
    }

    public CreateCandidatePage addEmailField() {
        clickCommunicationButton();
        clickElement(email);
        return this;
    }

    public CreateCandidatePage addPhoneField() {
        clickCommunicationButton();
        clickElement(phone);
        return this;
    }

    public CreateCandidatePage addSkypeField() {
        clickCommunicationButton();
        clickElement(skype);
        return this;
    }

    public CreateCandidatePage addFacebookField() {
        clickCommunicationButton();
        clicksocialNetworkButton();
        clickElement(facebook);
        return this;
    }

    public CreateCandidatePage addLinkedInField() {
        clickCommunicationButton();
        clicksocialNetworkButton();
        clickElement(linkedIn);
        return this;
    }

    public CreateCandidatePage addTelegramField() {
        clickCommunicationButton();
        clicksocialNetworkButton();
        clickElement(telegram);
        return this;
    }

    public CreateCandidatePage addSiteField() {
        clickCommunicationButton();
        clicksocialNetworkButton();
        clickElement(site);
        return this;
    }

    //Метод добавления коммуникаций
    public CreateCandidatePage chooseCommunication() throws InterruptedException {
        addEmailField();
        addPhoneField();
        addSkypeField();
        addFacebookField();
        addLinkedInField();
        addTelegramField();
        addSiteField();
        return this;
    }

    public CreateCandidatePage typeEmail(String email) {
        writeText(emailField, email);
        return this;
    }

    public CreateCandidatePage typePhone(String phone) {
        writeText(phoneField, phone);
        return this;
    }

    public CreateCandidatePage typeSkype(String skype) {
        writeText(skypeField, skype);
        return this;
    }

    public CreateCandidatePage typeFacebook(String facebook) {
        writeText(facebookField, facebook);
        return this;
    }

    public CreateCandidatePage typeLinkedIn(String linkedin) {
        writeText(linkedInField, linkedin);
        return this;
    }

    public CreateCandidatePage typeTelegram(String telegram) {
        writeText(telegramField, telegram);
        return this;
    }

    public CreateCandidatePage typeSite(String site) {
        writeText(siteField, site);
        return this;
    }

    //Метод ввода значений в поля коммуникаций
    public CreateCandidatePage typeCommunication(String email, String phone, String skype, String facebook, String linkedin, String telegram, String site) {
        this.typeEmail(email);
        this.typePhone(phone);
        this.typeSkype(skype);
        this.typeFacebook(facebook);
        this.typeLinkedIn(linkedin);
        this.typeTelegram(telegram);
        this.typeSite(site);
        return this;
    }

    //Методы с вводом некорректных значений в поля коммуникации и резюме
    public String getInvalidEmail(String email) {
        writeText(emailField, email);
        clickElement(phoneField);
        return isElementGetText(invalidEmail);
    }

    public String getInvalidPhone(String phone) {
        writeText(phoneField,phone);
        clickElement(facebookField);
        return isElementGetText(invalidPhone);
    }

    public String getInvalidFacebook(String facebook) {
        writeText(facebookField, facebook);
        clickElement(resumeLinkField);
        return isElementGetText(invalidFacebook);
    }

    public String getInvalidResumeLink(String resumeLink) {
        writeText(resumeLinkField, resumeLink);
        clickElement(emailField);
        return isElementGetText(invalidResumeLink);
    }

    //Блок с желаемой зарплатой и опытом
    @FindBy(xpath = "//h3[contains(text(),'Желаемая зарплата и опыт')]")
    private WebElement titleDesiredSalaryAndExperience; //Надпись "Желаемая зарплата и опыт"
    @FindBy(xpath = "//label[text()='Желаемая Должность']/following::input[@type='text'][1]")
    private WebElement desiredPositionField;
    @FindBy(xpath = "//label[text()='Желаемая зарплата']/following::input[@type='text'][1]")
    private WebElement desiredSalaryField;
    @FindBy(xpath = "//input[@name='currency_id']/parent::div")
    private WebElement currencyMultiType;
    @FindBy(xpath = "//span[text()='Евро']/parent::li")
    private WebElement currencyEuro;
    @FindBy(xpath = "//label[text()='Опыт Работы, Лет']/following::input[@type='text'][1]")
    private WebElement experienceField;
    @FindBy(xpath = "//label[text()='Последнее Место Работы']/following::input[@type='text'][1]")
    private WebElement lastWorkPlaceField;
    @FindBy(xpath = "//label[text()='Последняя Должность']/following::input[@type='text'][1]")
    private WebElement lastPositionField;

    public String getDesiredSalaryAndExperienceTitle() {
        return isElementGetText(titleDesiredSalaryAndExperience);
    }

    public CreateCandidatePage typeDesiresPosition(String desiredPosition) {
        writeText(desiredPositionField, desiredPosition);
        return this;
    }

    public CreateCandidatePage typeDesiresSalary(String desiresSalary) {
        writeText(desiredSalaryField, desiresSalary);
        return this;
    }

    public CreateCandidatePage typeExperience(String experience) {
        writeText(experienceField, experience);
        return this;
    }

    public CreateCandidatePage typeLastWorkPlace(String lastWorkPlace) {
        writeText(lastWorkPlaceField, lastWorkPlace);
        return this;
    }

    public CreateCandidatePage typeLastPosition(String lastPosition) {
        writeText(lastPositionField, lastPosition);
        return this;
    }

    //Метод ввода значений Зарплаты и Опыта
    public CreateCandidatePage typeDesiredSalaryAndExperience(String desiredPosition, String desiresSalary, String experience, String lastWorkPlace, String lastPosition) {
        this.typeDesiresPosition(desiredPosition);
        this.typeDesiresSalary(desiresSalary);
        clickElement(currencyMultiType);
        clickElement(currencyEuro);
        this.typeExperience(experience);
        this.typeLastWorkPlace(lastWorkPlace);
        this.typeLastPosition(lastPosition);
        return this;
    }

    //Блок с резюме
    @FindBy(xpath = "//h3[contains(text(),'Резюме')]")
    private WebElement titleResume;
    @FindBy(xpath = "//input[@name='resume_source_id']/parent::div")
    private WebElement resumeSource;
    @FindBy(xpath = "//h3[text()='Резюме']/parent::div[@class='candidate-form__section el-form__section']//div[contains(text(), 'Необходимо заполнить поле')]")
    private WebElement errorResumeSource;
    @FindBy(xpath = "//span[text()='HH.ru']/parent::li")
    private WebElement hh;
    @FindBy(xpath = "//label[text()='Резюме, Ссылка']/following::input[@type='text'][1]")
    private WebElement resumeLinkField;
    @FindBy(xpath = "//input[@name='resume_date_upd']")
    private WebElement resumeUpdateDate;
    @FindBy(xpath = "//label[contains(text(),'Резюме, Дата Обновления')]")
    private WebElement labelResumeUpdateDate;
    @FindBy(xpath = "//input[@placeholder='Выбрать дату']")
    private WebElement selectDate;
    @FindBy(xpath = "//input[@placeholder='Выбрать время']")
    private WebElement selectTime;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    private WebElement selectTimeOK;
    @FindBy(xpath = "//span[contains(text(), 'OK')]")
    private WebElement dateIsOK;
    @FindBy(xpath = "//iframe[@id='resume_text_ifr']")
    private WebElement resumeTextField;

    public String getResumeTitle() {
        return isElementGetText(titleResume);
    }

    public String getErrorResumeSourseText() {
        return isElementGetText(errorResumeSource);
    }

    public void typeResumeSource() {
        clickElement(resumeSource);
        clickElement(hh);
    }

    public CreateCandidatePage typeResumeLink(String resumelinkValues) {
        writeText(resumeLinkField, resumelinkValues);
        return this;
    }

    public CreateCandidatePage typeUpdateDate(String date, String time) {
        clickElement(resumeUpdateDate);
        writeText(selectDate, date);
        clickElement(selectTime);
        writeText(selectTime, time);
        clickElement(labelResumeUpdateDate);
        return this;
    }

    public CreateCandidatePage typeResumeText(String resumeText) {
        writeText(resumeTextField, resumeText);
        return this;
    }

    public CreateCandidatePage typeResume(String resumelink, String date, String time, String resumeText){
        typeResumeSource();
        this.typeResumeLink(resumelink);
        this.typeUpdateDate(date, time);
        this.typeResumeText(resumeText);
        return this;
    }

    public CandidateDetailView saveCandidate() {
        clickElement(saveButton);
        return new CandidateDetailView(driver);
    }

}
