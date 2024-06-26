package io.github.kimmking.junit5.demo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 常规测试，包含三种测试模式：
 * 1、不带TestInstance注解，默认使用TestInstance.Lifecycle.PER_METHOD，此时每个测试方法执行时，
 * 都会重新创建一个测试类，所以测试类UserSerivceTest1和属性userService对于每个方法都是新的。
 * 两个对象都不保持状态。
 * 2、不带TestInstance注解，但是把属性userService改成static，此时每次测试方法是新的，但是属性
 * userService是同一个。测试方法类不保持状态，但是属性保持状态。
 * 3、带TestInstance(TestInstance.Lifecycle.PER_CLASS)注解，此时当前类里的所有测试方法，
 * 都复用同一个测试对象实例，都保持状态。
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/4/9 14:55
 */

@DisplayName("01.常规单元测试")
@Tag("user-service-01")
//@Order(1)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class UserService01Test {

    public UserService01Test(){
        System.out.println(" =========== new UserService01Test 类实例 =========== ");
    }

    private UserService userService = new UserServiceImpl();

    @Test
    @DisplayName("01.测试用户ID-100")
    @Tag("01.01")
    public void test01() {
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this);
        System.out.println(userService);
        User user = userService.findById(100);
        assertNotNull(user);
        assertEquals(user.getId(),100);
        assertEquals(user.getName(), "KK100");
        assertEquals(user.getGender(), GenderEnum.Male);
        assertEquals(user.getLength(), 169.0f);
    }

    @Test
    @DisplayName("02.测试用户ID-200")
    @Tag("01.02")
    public void test02() {
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this);
        System.out.println(userService);
        User user = userService.findById(200);
        assertNotNull(user);
        assertEquals(user.getId(),200);
        assertEquals(user.getName(), "KK200");
        assertEquals(user.getGender(), GenderEnum.Male);
        assertEquals(user.getLength(), 169.0f);
    }

    @Test
    @DisplayName("03.测试注入参数")
    @Tag("01.03")
    public void test03(TestInfo info) {
        System.out.println("test info => " + info);
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this);
    }


}
