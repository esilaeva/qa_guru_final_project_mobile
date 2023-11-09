package helpers;

import com.codeborne.selenide.SelenideElement;
import drivers.EmulationDriver;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.appium.java_client.AppiumBy.id;
import static io.appium.java_client.AppiumBy.xpath;

public class Steps extends EmulationDriver {

    @Step("Click Log In button")
    public void clickLogInBtn() {
        $(id("com.wire:id/welcomeLoginButton")).click();
    }

    @Step("Click OK")
    public void clickBtnLaunchConfirm() {
        $(id("com.wire:id/zb__first_launch__confirm")).click();
    }

    @Step("Verify: Start a conversation or create a group has been appeared")
    public void checkStart() {
        $(id("com.wire:id/button_container")).shouldBe(appear);
    }

    @Step("No")
    public void clickNo() {
        sleep(3000);
        $(id("android:id/button2")).shouldBe(appear).click();
    }

    @Step("Click button")
    public void clickEnter() {
        $(id("com.wire:id/action_bar_root")).shouldBe(appear);
        $(id("com.wire:id/pcb__signin__email")).click();
    }

    @Step("Press Email")
    public void inputEmail(String email) {
        $(xpath("//*[@resource-id='com.wire:id/tet__profile__guided']")).press(email);
    }

    @Step("Press password")
    public void inputPassword(String password) {
        $(id("com.wire:id/get__sign_in__password")).click();
        $(xpath("//*[@text='Password']")).press(password);
    }

    @Step("Verify: button 'Forgot password' has been appeared")
    public void checkBtnForgotPasswordAppeared() {
        $(id("com.wire:id/ttv_signin_forgot_password")).shouldBe(appear);
    }

    @Step("Open List settings")
    public void openListSettings() {
        $(id("com.wire:id/conversation_list_settings")).click();
    }

    @Step("Open Settings")
    public void openSettings() {
        $(id("com.wire:id/profile_settings")).click();
    }

    @Step("Settings -> Device")
    public void clickDevices() {
        $(xpath("//*[@text='Devices']")).click();
    }

    @Step("Delete device")
    public void deleteDevices(String password) {
        SelenideElement iconEnd = $(id("com.wire:id/preference_icon_end"));

        while (iconEnd.exists() || iconEnd.isDisplayed()) {
            $(xpath("(//*[@resource-id='com.wire:id/preference_title'])[2]")).click();
            $(xpath("//*[@text='Remove device']")).click();
            $(id("com.wire:id/confirmation_with_password_edit_text")).press(password);
            $(id("android:id/button1")).click();
        }
    }

    @Step("Verify: list devices is empty")
    public void checkListDevicesEmpty() {
        $(id("com.wire:id/preference_icon_end")).shouldBe(disappear);
    }

    @Step("Verify: alert title appeared")
    public void checkAlertTitleAppeared() {
        $(id("com.wire:id/alertTitle")).shouldBe(appear);
    }

    @Step("Create group")
    public void createGroupConversation(){
        $(xpath("(//*[@resource-id='com.wire:id/icon'])[1]")).click();
    }

    @Step("Create group")
    public void createGroup(){
        $(id("com.wire:id/create_group_button")).click();
    }

    @Step("Press name group")
    public void pressGroupName(String nameGroup){
        $(id("com.wire:id/edit_text")).press(nameGroup);
    }

    @Step("Click Button")
    public void clickButton(){
        $(id("com.wire:id/fragment_default_toolbar_textview_action")).click();
    }

    @Step("Type message")
    public void typeMessage(String message){
        $(id("com.wire:id/cet__cursor")).click();
        $(id("com.wire:id/cet__cursor")).press(message);
    }

    @Step("Send message")
    public void sendMessage(){
        $(id("com.wire:id/cib__send")).click();
    }

    @Step("Verify: status message appeared")
    public void checkStatusMessage(){
        $(id("com.wire:id/timestamp_and_status")).shouldBe(appear);
    }
}