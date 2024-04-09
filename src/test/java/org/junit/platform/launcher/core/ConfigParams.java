package org.junit.platform.launcher.core;

import org.junit.platform.engine.ConfigurationParameters;

import java.util.HashMap;
import java.util.Map;

/**
 * Description for this class.
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/4/9 23:56
 */
public class ConfigParams {

    public static final Map<String, String> PARAMS = readConfigurationParameters();

    public static String get(String key) {
        return PARAMS.get(key);
    }

    public static Map<String, String> readConfigurationParameters() {
        System.out.println(" ===> read ConfigurationParameters for junit-platform.properties");
        ConfigurationParameters config = ConfigParams.config();
        Boolean printAll = config.getBoolean("printAll").orElse(false);
        Map<String, String> map = new HashMap<>();
        config.keySet().forEach(
                key -> {
                    if(printAll) System.out.println(key + " = " + config.get(key));
                    map.put(key, config.get(key).orElse(""));
                }
        );
        return map;
    }

    public static ConfigurationParameters config() {
        return LauncherConfigurationParameters.builder()
                .explicitParameters(new HashMap<>())
                .enableImplicitProviders(true)
                .build();
    }

}
