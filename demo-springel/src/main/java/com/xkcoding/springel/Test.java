package com.xkcoding.springel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <a href="Test.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/3/3 15:02
 */
public class Test {
//    public static void main(String[] args) {
////        AbstractRequest<Student> studentAbstractRequest = new AbstractRequest<>();
////        System.out.println(studentAbstractRequest.getClass().getTypeParameters()[0].getName());
//
//        //类型参数只能是变量类型
//        TypeVariable<Class<ClassDecl>>[] typeParameters = ClassDecl.class.getTypeParameters();
////获取父类的只能是ParameterizedType类型或者是Class类型
//        Type parameterizedType = ClassDecl.class.getGenericSuperclass();
////父类的参数类型可以有变量类型，参数类型，通配符类型
//        parameterizedType =(ParameterizedType) parameterizedType;
////如例子，
////types[0] = C<? extends A> 为ParameterizedType类型
////types[1] = C<? super A> 为ParameterizedType类型
////types[2] = C<Integer>[] 为GeneraticArrayType
////types[3] = T1 为TypeVariable类型
//        Type[] types = parameterizedType.getActualTypeArguments();
////? extends A 为WildcardType类型
//        Type actualTypeArgument = ((ParameterizedType) types[0]).getActualTypeArguments()[0];
//    }
//
//    class A{}
//    class B<T,R,Q,P>{}
//    class C<T>{}
//    class D{}
//    class ClassDecl<T1,T2 extends A> extends B<C<? extends A>,C<? super A>,C<Integer>[],T1>{}
}
//场景一：
//public class MainEntry{
//    class B{}
////    public static void main(String [] args){
////        List<String> source = new ArrayList<>();
////        source.add("sdf");
////        List<B> target = (List<B>)source;
////    }
//}
