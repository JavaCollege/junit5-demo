# junit5-demo

#### 介绍

#### UserService1Test：测试几种不同方式下的测试类和属性的作用范围
常规测试01，包含三种测试模式：

1. 不带TestInstance注解，默认使用TestInstance.Lifecycle.PER_METHOD，此时每个测试方法执行时，都会重新创建一个测试类，所以测试类UserSerivceTest1和属性userService对于每个方法都是新的。两个对象都不保持状态。
2. 不带TestInstance注解，但是把属性userService改成static，此时每次测试方法是新的，但是属性userService是同一个。测试方法类不保持状态，但是属性保持状态。
3. 带TestInstance(TestInstance.Lifecycle.PER_CLASS)注解，此时当前类里的所有测试方法，都复用同一个测试对象实例，都保持状态。

#### UserService1Test：测试BeforeEach和AfterEach
复杂测试02：

1. 情况1，在TestInstance.Lifecycle.PER_CLASS情况下，实际上我们可以让userService每次在测试方法内部去初始化。但是这样做会有大量的重复代码逻辑，并且准备工作和测试放到了一起。为了对其解耦，我们可以通过添加BeforeEach和AfterEach注解，从而在每次方法调用之前，进行一个特殊的初始化或资源销毁操作，从而避免了维护重复代码。

#### UserService1Test：测试BeforeAll和AfterAll。
复杂测试03：

1. 使用BeforeAll/AfterAll时，如果是TestInstance.Lifecycle.PER_CLASS，则方法不需要是static的，否则（即TestInstance.Lifecycle.PER_METHOD），必须使用static的方法（操作的字段也需要时static）。

