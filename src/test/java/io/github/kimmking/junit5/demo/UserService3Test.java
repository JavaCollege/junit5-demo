package io.github.kimmking.junit5.demo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 复杂测试03：
 * 1、使用BeforeAll/AfterAll时，如果是TestInstance.Lifecycle.PER_CLASS，则方法不需要是static的，
 * 否则（即TestInstance.Lifecycle.PER_METHOD），必须使用static的方法（操作的字段也需要时static）。
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/4/9 14:55
 */

@DisplayName("03.复杂单元测试")
@Tag("user-service-3")
@Order(3)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class UserService3Test {

    public UserService3Test(){
        System.out.println(" =========== new UserService3Test 类实例 =========== ");
    }

    private static UserService userService;

    @BeforeAll
    public static void beforeAll(TestInfo info) {
        System.out.println(" ===> beforeAll ...");
        userService = new UserServiceImpl();
//        System.out.println(this.getClass().getClassLoader());
//        System.out.println(this);
        System.out.println("userService => "+userService);
        System.out.println("test info => " + info);
    }

    @AfterAll
    public static void afterAll() {
        System.out.println(" ===> afterAll ...");
        userService = null;
    }

    @Test
    @DisplayName("测试用户ID-100")
    public void test01() {
        System.out.println(ClassOrderer.DisplayName.class.getCanonicalName());
        System.out.println(" ===> test3.01");
        User user = userService.findById(100);
        assertNotNull(user);
        assertEquals(user.getId(),100);
        assertEquals(user.getName(), "KK100");
        assertEquals(user.getGender(), GenderEnum.Male);
        assertEquals(user.getLength(), 169.0f);
    }

    @Test
    @DisplayName("测试用户ID-200")
    public void test02() {
        System.out.println(" ===> test3.02");
        User user = userService.findById(200);
        assertNotNull(user);
        assertEquals(user.getId(),200);
        assertEquals(user.getName(), "KK200");
        assertEquals(user.getGender(), GenderEnum.Male);
        assertEquals(user.getLength(), 169.0f);
    }

    @Test
    @DisplayName("测试注入参数")
    @Tag("3.03")
    public void test03(TestInfo info) {
        System.out.println(" ===> test3.03");
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this);
        System.out.println("test info => " + info);
    }


}
