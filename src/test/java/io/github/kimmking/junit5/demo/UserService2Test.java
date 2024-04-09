package io.github.kimmking.junit5.demo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 复杂测试02：
 * 1、情况1，在TestInstance.Lifecycle.PER_CLASS情况下，实际上我们可以让userService每次在测试方法内部去初始化。
 * 但是这样做会有大量的重复代码逻辑，并且准备工作和测试放到了一起。为了对其解耦，我们可以通过添加BeforeEach和AfterEach注解，
 * 从而在每次方法调用之前，进行一个特殊的初始化或资源销毁操作，从而避免了维护重复代码。
 * 2、情况2，
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/4/9 14:55
 */

@DisplayName("02.复杂单元测试")
@Tag("user-service-2")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserService2Test {

    public UserService2Test(){
        System.out.println(" =========== new UserService2Test 类实例 =========== ");
    }

    private UserService userService;

    @BeforeEach
    public void beforeEach(TestInfo info) {
        System.out.println(" ===> beforeEach ...");
        userService = new UserServiceImpl();
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this);
        System.out.println("userService => "+userService);
        System.out.println("test info => " + info);
    }

    @AfterEach
    public void afterEach() {
        System.out.println(" ===> afterEach ...");
        userService = null;
    }

    @Test
    @DisplayName("测试用户ID-100")
    public void test01() {
        System.out.println(" ===> test2.01");
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
        System.out.println(" ===> test2.02");
        User user = userService.findById(200);
        assertNotNull(user);
        assertEquals(user.getId(),200);
        assertEquals(user.getName(), "KK200");
        assertEquals(user.getGender(), GenderEnum.Male);
        assertEquals(user.getLength(), 169.0f);
    }

    @Test
    @DisplayName("测试注入参数")
    @Tag("2.03")
    public void test03(TestInfo info) {
        System.out.println(" ===> test2.03");
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this);
        System.out.println("test info => " + info);
    }


}
