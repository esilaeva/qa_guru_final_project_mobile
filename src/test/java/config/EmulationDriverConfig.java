package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${deviceHost}.properties"
})
public interface EmulationDriverConfig extends Config {

    @Key("platformName")
    String getPlatformName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("device")
    String getDevice();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("deviceHost")
    String getDeviceHost();
}