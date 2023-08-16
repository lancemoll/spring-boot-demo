package com.xkcoding.chain;

import javax.servlet.FilterChain;

/**
 * <p>
 * <a href="HttpFilter.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/2/17 9:39
 */
public class HttpFilter implements MyFilter{

    @Override
    public void doFilter(Request request, Reponse reponse, MyFilterChain filterChain) {
        String msg = request.getMsg();
        msg += ">>>";
        System.out.println("开始执行httpFilter之前....");
        filterChain.doFilter(request,reponse,filterChain);
        System.out.println("开始执行httpFilter之后....");
    }
}
