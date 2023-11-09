package config.browserstackconfig;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${deviceHost}.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("platformName")
    String getPlatformName();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getPlatformVersion();

    @Key("app")
    String getApp();

    @Key("deviceHost")
    String getDeviceHost();

    @Key("projectName")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("testName")
    String getTestName();
}