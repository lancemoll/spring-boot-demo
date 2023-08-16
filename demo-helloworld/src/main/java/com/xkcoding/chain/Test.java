package com.xkcoding.chain;


/**
 * <p>
 * <a href="Test.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/2/17 9:38
 */
public class Test {
    public static void main(String[] args) {
        MyFilterChain myFilterChain = new MyFilterChain();
        MyTarget myTarget = new MyTarget();
        HttpFilter httpFilter = new HttpFilter();
        EncodingFilter encodingFilter = new EncodingFilter();
        myFilterChain.addFilter(httpFilter);
        myFilterChain.addFilter(encodingFilter);
        myFilterChain.setMyTarget(myTarget);

        myFilterChain.doFilter(new Request("test"),new Reponse(),myFilterChain);
    }
}
