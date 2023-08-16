package com.xkcoding.springel;

import java.util.ArrayList;
import java.util.List;

public class MainEntry{
    class B{}
    public static void main(String [] args){
        List<String> source = new ArrayList<>();
        source.add("sdf");
        List<B> target = (List<B>)convert(source);
        System.out.println(target);
    }
    public static Object convert(Object source){
        return source;
    }
}
