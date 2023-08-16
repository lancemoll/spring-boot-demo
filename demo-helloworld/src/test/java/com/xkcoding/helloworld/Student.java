package com.xkcoding.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * <a href="Student.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/3/14 14:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    Integer id;
    String day;
    String pwd;
}
