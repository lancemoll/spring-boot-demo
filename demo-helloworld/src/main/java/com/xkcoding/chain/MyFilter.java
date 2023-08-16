package com.xkcoding.chain;

import javax.servlet.FilterChain;

/**
 * <p>
 * <a href="Filter.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/2/17 9:31
 */
public interface MyFilter {

    void doFilter(Request request, Reponse reponse, MyFilterChain filterChain);
}
