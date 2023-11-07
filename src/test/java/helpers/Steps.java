package helpers;

import com.codeborne.selenide.SelenideElement;
import config.EmulationDriverConfig;
import drivers.EmulationDriver;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.appium.java_client.AppiumBy.id;
import static io.appium.java_client.AppiumBy.xpath;

public class Steps extends EmulationDriver {

    static EmulationDriverConfig config = ConfigFactory.create(EmulationDriverConfig.class, System.getProperties());

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
        $(xpath("//android.widget.TextView[@text=\"Start a conversation or create a group.\"]")).shouldBe(appear);
    }

    @Step("No")
    public void clickNo() {
        sleep(5000);
        $(id("android:id/button2")).shouldBe(appear).click();
    }

    @Step("Click button")
    public void clickEnter() {
        $(id("com.wire:id/action_bar_root")).shouldBe(appear);
        $(id("com.wire:id/pcb__signin__email")).click();
    }

    @Step("Press Email")
    public void inputEmail(String email) {
        $(xpath("//android.widget.EditText[@resource-id=\"com.wire:id/tet__profile__guided\" and @text=\"Email\"]")).press(email);
    }

    @Step("Press password")
    public void inputPassword(String password) {
        $(xpath("//android.widget.EditText[@resource-id=\"com.wire:id/tet__profile__guided\" and @text=\"Password\"]")).click();
        $(xpath("//android.widget.EditText[@resource-id=\"com.wire:id/tet__profile__guided\" and @text=\"Password\"]")).press(password);
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
        $(xpath("//android.widget.TextView[@resource-id=\"com.wire:id/preference_title\" and @text=\"Devices\"]")).click();
    }

    @Step("Delete device")
    public void deleteDevices(String password) {
        SelenideElement removeDevice = $(xpath("//android.widget.TextView[@text='Remove one of your other devices to start using Wire on this one.']"));
        SelenideElement device = $(xpath("(//android.widget.TextView[@resource-id='com.wire:id/preference_title'])[2]"));
        SelenideElement iconEnd = $(xpath("(//android.widget.ImageView[@resource-id=\"com.wire:id/preference_icon_end\"])[1]"));

        if (removeDevice.exists()) {
            $(id("zb__otr_device_limit__manage_devices")).click();
        }
        while (iconEnd.exists() || iconEnd.isDisplayed()) {
            $(xpath("(//android.widget.TextView[@resource-id='com.wire:id/preference_title'])[2]")).click();
            $(xpath("//android.widget.TextView[@resource-id='com.wire:id/preference_title' and @text='Remove device']")).click();
            $(id("com.wire:id/confirmation_with_password_edit_text")).press(password);
            $(id("android:id/button1")).click();
        }
    }

    @Step("Verify: list devices is empty")
    public void checkListDevicesEmpty() {
        $(id("(//android.widget.ImageView[@resource-id='com.wire:id/preference_icon_end'])")).shouldBe(disappear);
    }

    @Step("Verify: alert title appeared")
    public void checkAlertTitleAppeared() {
        $(id("com.wire:id/alertTitle")).shouldBe(appear);
    }

    @Step("Create group")
    public void createGroupConversation(){
        $(xpath("(//android.widget.ImageView[@resource-id=\"com.wire:id/icon\"])[1]")).click();
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

    @Step("Add emoji")
    public void addEmoji(){
        $(id("com.wire:id/fl__cursor__emoji_container")).click();
    }

    @Step("Click emoji")
    public void clickEmoji(){
        $(id("com.wire:id/cib__emoji")).click();
    }

    @Step("Choose emoji")
    public void chooseEmoji(){
        $(xpath("//android.widget.TextView[@resource-id=\"com.wire:id/emoji_keyboard_item\" and @text=\"\uD83D\uDE0E\"]")).click();
    }

    @Step("Verify: status message appeared")
    public void checkStatusMessage(){
        $(xpath("//android.widget.TextView[@resource-id=\"com.wire:id/timestamp_and_status\"]")).isDisplayed();
    }

    @Step("Choose group")
    public void chooseGroup(){
        $(id("tv__conversation_toolbar__title")).click();
    }

    @Step("Settings group")
    public void settingsGroup(){
        $(xpath("//android.view.ViewGroup[@resource-id=\"com.wire:id/t_conversation_toolbar\"]/android.widget.LinearLayout")).click();
    }

    @Step("Click participants right action")
    public void clickParticipantsRightAction(){
        $(id("gtv__participants__right__action")).click();
    }

    @Step("Click Leave group...")
    public void clickLeaveGroup(){
        $(xpath("//android.widget.TextView[@resource-id=\"com.wire:id/gtv__participants__right__action\"]")).click();
    }

    @Step("Click Leave and clear content")
    public void clickLeaveGroupAndClearContent(){
        $(id("android:id/button2")).click();
    }
    @Step("Verify: Message Appeared")
    public void checkMessageAppeared(String message){
        $(id("com.wire:id/conversation_list_empty_title")).shouldHave(text(message));
    }

    @Step("Step Back")
    public void stepBack(){
        $(id("android.widget.ImageButton")).click();
    }

    @Step("Rename group")
    public void renameGroup(String newName){
        $(id("conversation_name_edit_text")).click();
        $(id("conversation_name_edit_text")).sendKeys(Keys.BACK_SPACE);
        $(id("conversation_name_edit_text")).sendKeys(newName);
        $(id("conversation_name_edit_text")).sendKeys(Keys.TAB);
    }

    @Step("Close details")
    public void closeDetailsGroup(){
        $(id("close_button")).click();
    }

    @Step("Verify: name group changed")
    public void checkNewNameGroup(String newNameGroup){
        $(id("tv__conversation_toolbar__title")).shouldHave(text(newNameGroup));
    }

}
