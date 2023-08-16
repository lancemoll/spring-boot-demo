package com.xkcoding.helloworld;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <a href="StudentTest.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/3/14 14:52
 */
public class StudentTest {

    @Test
    public void test3() {

        Student student = new Student(1, "天数", "123456");
        List<Student> students = new ArrayList<>();
        students.add(student);

        Student student2 = new Student(1, "天数", "666666");
        List<Student> students2 = new ArrayList<>();
        students2.add(student2);

        Teacher t1 = new Teacher(1,"zhangsan",1,students);
        Teacher t2 = new Teacher(1,"lisi",1,students);
        DiffNode diff = ObjectDifferBuilder.buildDefault().compare(t1, t2);
        System.out.println(diff.isChanged());
        // 是否有属性改变
        System.out.println(diff.hasChanges());
        // 改变的属性数量
        //System.out.println(diff.childCount());
       DiffNode name = diff.getChild("name");
        System.out.println(name.childCount());

        // 如果没有修改属性
        // 或者只修改了一个属性,并且这个属性是name
//        if ((diff.childCount() == 0)||(diff.childCount() == 1 && diff.getChild("name") != null)) {
//            System.out.println("不修改共享状态");
//        } else {
//            //
//            System.out.println("修改共享状态");
//        }
    }

}
