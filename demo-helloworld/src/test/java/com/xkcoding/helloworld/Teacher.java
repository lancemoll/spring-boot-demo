package com.xkcoding.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 * <a href="Teacher.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/3/14 14:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    Integer id;

    String name;

    Integer classNum;

    List<Student> students;
}
