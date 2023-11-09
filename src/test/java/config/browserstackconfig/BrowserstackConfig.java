package config.browserstackconfig;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${deviceHost}.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("platformName")
    @DefaultValue("android")
    String getPlatformName();

    @Key("device")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String getDevice();

    @Key("os_version")
    @DefaultValue("12.0")
    String getPlatformVersion();

    @Key("app")
    @DefaultValue("bs://a43271109d15afee89307b02523f1e6bf6499e0d")
    String getApp();

    @Key("deviceHost")
    @DefaultValue("browserstack")
    String getDeviceHost();

    @Key("projectName")
    @DefaultValue("Wire Project")
    String getProject();

    @Key("build")
    @DefaultValue("browserstack-build-1")
    String getBuild();

    @Key("testName")
    @DefaultValue("android_wire_tests")
    String getTestName();
}