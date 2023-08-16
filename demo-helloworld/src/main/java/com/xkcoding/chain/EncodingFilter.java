package com.xkcoding.chain;

/**
 * <p>
 * <a href="EncodingFilter.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/2/17 10:00
 */
public class EncodingFilter implements MyFilter{
    @Override
    public void doFilter(Request request, Reponse reponse, MyFilterChain filterChain) {
        String msg = request.getMsg();
        msg += "===========";
        System.out.println("开始执行EncodingFilter之前....");
        filterChain.doFilter(request,reponse,filterChain);
        System.out.println("开始执行EncodingFilter之后....");
    }
}
