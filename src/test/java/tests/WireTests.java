package tests;

import annotations.Manual;
import helpers.Steps;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Owner("Elena")
public class WireTests extends TestBase {

    @CsvFileSource(resources = "/credentials.csv")
    @ParameterizedTest(name = "Positive login")
    @Tag("positive")
    @DisplayName("Success LogIn")
    @Feature("Login")
    public void openAppTest(String email, String password) {
        Steps step = new Steps();

        step.clickLogInBtn();
        step.checkBtnForgotPasswordAppeared();
        step.inputEmail(email);
        step.inputPassword(password);
        step.clickEnter();
        step.clickBtnLaunchConfirm();
        step.clickNo();

        step.checkStart();
    }

    @CsvFileSource(resources = "/wrong_credentials.csv")
    @ParameterizedTest(name = "Negative login {0}")
    @Tag("negative")
    @DisplayName("LogIn. Wrong email or password")
    @Feature("Login")
    public void negativeLoginWithWrongEmailTest(String nameTests, String email, String password) {
        Steps step = new Steps();

        step.clickLogInBtn();
        step.checkBtnForgotPasswordAppeared();
        step.inputEmail(email);
        step.inputPassword(password);
        step.clickEnter();

        step.checkAlertTitleAppeared();
    }

    @CsvFileSource(resources = "/credentials.csv")
    @ParameterizedTest(name = "Delete devices")
    @Tag("positive")
    @DisplayName("Delete devices")
    @Feature("Account")
    public void deleteDevices(String email, String password) {
        Steps step = new Steps();

        step.clickLogInBtn();
        step.checkBtnForgotPasswordAppeared();
        step.inputEmail(email);
        step.inputPassword(password);
        step.clickEnter();
        step.clickBtnLaunchConfirm();
        step.clickNo();
        step.openListSettings();
        step.openSettings();

        step.clickDevices();
        step.deleteDevices(password);

        step.checkListDevicesEmpty();
    }

    @CsvFileSource(resources = "/credentials.csv")
    @ParameterizedTest(name = "Create group")
    @Tag("positive")
    @Feature("Chat")
    public void createGroup(String email, String password) {
        Steps step = new Steps();

        step.clickLogInBtn();
        step.checkBtnForgotPasswordAppeared();
        step.inputEmail(email);
        step.inputPassword(password);
        step.clickEnter();
        step.clickBtnLaunchConfirm();
        step.clickNo();

        step.createGroupConversation();
        step.createGroup();
        step.pressGroupName("test group");
        step.clickButton();
        step.clickButton();
        step.typeMessage("Test message");
        step.sendMessage();

        step.checkStatusMessage();
    }
}