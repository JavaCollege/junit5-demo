package io.github.kimmking.junit5.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description for this class.
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/4/9 14:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    int id;
    String name;
    GenderEnum gender;
    float length;
    String desc;

}
