package io.github.kimmking.junit5.demo;

import org.junit.jupiter.api.*;
import org.junit.platform.launcher.core.ConfigParams;

/**
 * 复杂测试03：
 * 1、使用BeforeAll/AfterAll时，如果是TestInstance.Lifecycle.PER_CLASS，则方法不需要是static的，
 * 否则（即TestInstance.Lifecycle.PER_METHOD），必须使用static的方法（操作的字段也需要时static）。
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/4/9 14:55
 */

@DisplayName("04.复杂单元测试")
@Tag("user-service-04")
//@Order(4)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class UserService04Test {

    public UserService04Test(){
        System.out.println(" =========== new UserService04Test 类实例 =========== ");
    }

    @Test
    @DisplayName("04.测试注入参数")
    @Tag("04.04")
    public void test04(TestInfo info) {
        System.out.println("test info => " + info);
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this);
    }

    @Test
    @DisplayName("05.测试注入参数")
    @Tag("04.05")
    public void test05(TestInfo info) {
        System.out.println("test info => " + info);
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this);

        System.out.println(" =========== System.getProperty ============ ");
        printProperty("AAA");
        printProperty("printAll");
        printProperty("junit.jupiter.testclass.order.default");
        printProperty("junit.jupiter.testinstance.lifecycle.default");
        System.out.println(" =========== System.getProperty ============ ");

        System.out.println(" =========== readConfigurationParameters ============ ");
        printConfig("AAA");
        printConfig("printAll");
        printConfig("junit.jupiter.testclass.order.default");
        printConfig("junit.jupiter.testinstance.lifecycle.default");
        System.out.println(" =========== readConfigurationParameters ============ ");
    }

    public static void printProperty(String key){
        System.out.println(" ====>>>> " + key + " = " + System.getProperty(key));
    }

    public static void printConfig(String key){
        System.out.println(" ====>>>> " + key + " = " + ConfigParams.get(key));
    }

}
