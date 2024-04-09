package io.github.kimmking.junit5.demo;

import org.junit.jupiter.api.*;
import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.launcher.core.ConfigParams;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂测试03：
 * 1、使用BeforeAll/AfterAll时，如果是TestInstance.Lifecycle.PER_CLASS，则方法不需要是static的，
 * 否则（即TestInstance.Lifecycle.PER_METHOD），必须使用static的方法（操作的字段也需要时static）。
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/4/9 14:55
 */

@DisplayName("04.复杂单元测试")
@Tag("user-service-4")
@Order(4)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class UserService4Test {

    public UserService4Test(){
        System.out.println(" =========== new UserService4Test 类实例 =========== ");
    }

    @Test
    @DisplayName("测试注入参数")
    @Tag("4.04")
    public void test04(TestInfo info) {
        System.out.println(" ===> test4.04");
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this);
        System.out.println("test info => " + info);
    }

    @Test
    @DisplayName("测试注入参数")
    @Tag("4.05")
    public void test05(TestInfo info) {
        System.out.println(" ===> test4.05");
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this);
        System.out.println("test info => " + info);

        System.out.println(" =========== System.getProperty ============ ");
        System.out.println(" ====>>>> AAA = " + System.getProperty("AAA"));
        System.out.println(" ====>>>> printAll = " + System.getProperty("printAll"));
        System.out.println(" ====>>>> junit.jupiter.testclass.order.default == "
                +System.getProperty("junit.jupiter.testclass.order.default"));
        System.out.println(" ====>>>> junit.jupiter.testinstance.lifecycle.default == "
                +System.getProperty("junit.jupiter.testinstance.lifecycle.default"));
        System.out.println(" =========== System.getProperty ============ ");

        System.out.println(" =========== readConfigurationParameters ============ ");
        System.out.println(" ====>>>> AAA = " +ConfigParams.get("AAA"));
        System.out.println(" ====>>>> junit.jupiter.testclass.order.default == "
                +ConfigParams.get("junit.jupiter.testclass.order.default"));
        System.out.println(" ====>>>> junit.jupiter.testinstance.lifecycle.default == "
                +ConfigParams.get("junit.jupiter.testinstance.lifecycle.default"));
        System.out.println(" =========== readConfigurationParameters ============ ");
    }

}
