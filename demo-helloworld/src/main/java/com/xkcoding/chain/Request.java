package com.xkcoding.chain;

import lombok.Data;

/**
 * <p>
 * <a href="Request.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/2/17 9:33
 */
@Data
public class Request {

    private String msg ;

    Request(String msg ){
        this.msg = msg;
    }
}
