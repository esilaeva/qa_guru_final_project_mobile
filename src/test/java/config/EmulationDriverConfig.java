package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:/properties/${env}.properties"
})
public interface EmulationDriverConfig extends Config {

    @Key("platformName")
    @DefaultValue("android")
    String getPlatformName();

    @Key("platformVersion")
    @DefaultValue("11.0")
    String getPlatformVersion();

    @Key("device")
    @DefaultValue("Pixel4")
    String getDevice();

    @Key("appPackage")
    @DefaultValue("com.wire")
    String getAppPackage();

    @Key("appActivity")
    @DefaultValue("com.waz.zclient.LaunchActivity")
    String getAppActivity();

    @Key("deviceHost")
    @DefaultValue("emulation")
    String getDeviceHost();
}
