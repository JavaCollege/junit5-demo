package io.github.kimmking.junit5.demo;

/**
 * Description for this class.
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/4/9 14:50
 */
public class UserServiceImpl implements UserService{
    public UserServiceImpl() {
        System.out.println(" =========== >> new UserServiceImpl实例 =========== ");
    }

    @Override
    public User findById(int id) {
        return new User(id,"KK" + id, GenderEnum.Male,
                169.0f, "the no.${id} use");
    }
}
