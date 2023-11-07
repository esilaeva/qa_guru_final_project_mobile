package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulationDriverConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class EmulationDriver implements WebDriverProvider {

    static EmulationDriverConfig config = ConfigFactory.create(EmulationDriverConfig.class, System.getProperties());
    public WebDriver driver;

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options
//                .setAutomationName(ANDROID_UIAUTOMATOR2)
//                .setPlatformName(ANDROID)
//                .setPlatformVersion("11.0")
//                .setDeviceName("Pix4")
//                .setApp(getAppPath())
//                .setAppPackage("org.telegram.messenger.web")
//                .setAppActivity("org.telegram.ui.LaunchActivity");


                .setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(config.getPlatformName())
                .setPlatformVersion(config.getPlatformVersion())
                .setDeviceName(config.getDevice())
                .setApp(getAppPath())
                .setAppPackage(config.getAppPackage())
                .setAppActivity(config.getAppActivity());


//        options.setCapability("platformName", "Android");
//        options.setCapability("deviceName", "Pix4");
//        options.setCapability("platformVersion", "11.0");
//        options.setCapability("appPath", getAppPath());
//        options.setCapability("AppPackage", config.getAppPackage());
//        options.setCapability("AppActivity", config.getAppActivity());

        driver = new AndroidDriver(getAppiumServerUrl(), options);
        return driver;
    }

    private String getAppPath() {

        String appVersion = "wire-prod-release-3.82.38.apk";

        String appUrl = "https://github.com/wireapp/wire-android/releases/download/3.82.38/" + appVersion;
        String appPath = "src/test/resources/apps/" + appVersion;

        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app.getAbsolutePath();
    }


}
