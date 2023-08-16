package com.xkcoding.chain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <a href="FilterChain.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/2/17 9:31
 */
public class MyFilterChain implements MyFilter{
    int cursor = 0;

    MyTarget myTarget;

    public void setMyTarget(MyTarget myTarget) {
        this.myTarget = myTarget;
    }

    List<MyFilter> filterList = new ArrayList<>();

    public void addFilter(MyFilter filter){
        filterList.add(filter);
    }


    @Override
    public void doFilter(Request request, Reponse reponse, MyFilterChain filterChain) {
        if (cursor < filterList.size()){
            MyFilter myFilter = filterList.get(cursor);
            cursor++;
            myFilter.doFilter(request,reponse,filterChain);
        }else {
            myTarget.doSomething();
        }

    }
}
