package config.browserstackconfig;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/auth.properties"
})
public interface AuthBrowserstackConfig extends Config {

    @Key("userName")
    @DefaultValue("ilanaqa_QPZ6wX")
    String getUserName();

    @Key("accessKey")
    @DefaultValue("WWhqxuxVJhB7A72Rxdk7")
    String getAccessKey();

    @Key("remoteUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getRemoteUrl();
}