package tests;

import annotations.Manual;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Manual
@Owner("Elena")
public class ManualTests {

    @Test
    @Tags({@Tag("positive"), @Tag("manual")})
    @DisplayName("Manual test. Positive login")
    @Feature("Authentication")
    public void manualSuccessfulLoginTest() {
        step("Log In", () -> {
            step("Click on the button 'Log In'");
            step("Fill in the Email field");
            step("Fill in the Password field");
            step("Click on the button next");
        });
        step("Verify: the message 'You've used Wire on this device before.' has appeared");
    }

    @Test
    @Tags({@Tag("positive"), @Tag("manual")})
    @DisplayName("Manual test. Positive logout")
    @Feature("Authentication")
    public void manualSuccessfulLogOutTest() {
        step("Log In", () -> {
            step("Click on the button 'Log In'");
            step("Fill in the Email field");
            step("Fill in the Password field");
            step("Click on the button next");
        });
        step("Click on the button 'OK'");
        step("Click on the button 'NO'");
        step("Log Out", () -> {
            step("Click on the button 'Profile'");
            step("Click on the button 'Settings'");
            step("Click on the button 'Account'");
            step("Scroll down list of settings");
            step("Click on the button 'Log out'");
            step("Click on the button 'LOG OUT' on popup window");
        });
        step("Verify: the button 'LOG IN' appeared");
    }

    @Test
    @Tags({@Tag("negative"), @Tag("manual")})
    @DisplayName("Manual test. Negative login with wrong email")
    @Feature("Authentication")
    public void manualNegativeLoginTest() {
        step("Log In", () -> {
            step("Click on the button 'Log In'");
            step("Fill in the Email field with wrong data");
            step("Fill in the Password field");
            step("Click on the button next");
        });
        step("Verify: the message 'PLEASE VERIFY YOUR DETAILS AND TRY AGAIN' appeared");
    }

    @Test
    @Tags({@Tag("positive"), @Tag("manual")})
    @DisplayName("Manual test. Change color")
    @Feature("Account")
    public void changeColorTest() {
        step("Log In", () -> {
            step("Click on the button 'Log In'");
            step("Fill in the Email field");
            step("Fill in the Password field");
            step("Click on the button next");
        });
        step("Click on the button 'OK'");
        step("Click on the button 'NO'");
        step("Change color", () -> {
            step("Click on the button 'Profile'");
            step("Click on the button 'Settings'");
            step("Click on the button 'Account'");
            step("Click on the button 'Color'");
        });
        step("Back to screen 'Settings'");
        step("Verify: the color of the button 'profile_invite' changed");
    }

    @Test
    @Tags({@Tag("positive"), @Tag("manual")})
    @DisplayName("Manual test. Change picture")
    @Feature("Account")
    public void changePictureTest() {
        step("Log In", () -> {
            step("Click on the button 'Log In'");
            step("Fill in the Email field");
            step("Fill in the Password field");
            step("Click on the button next");
        });
        step("Click on the button 'OK'");
        step("Click on the button 'NO'");
        step("Change color", () -> {
            step("Click on the button 'Profile'");
            step("Click on the button 'Settings'");
            step("Click on the button 'Account'");
            step("Click on the button 'Picture'");
            step("Change the picture");
        });
        step("Verify: the picture was changed");
    }
}