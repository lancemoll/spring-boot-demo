package com.xkcoding.springel;

import lombok.Data;

/**
 * <p>
 * <a href="AbstractRequest.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/3/3 15:01
 */
@Data
public class AbstractRequest<T extends Person> {

    private T data;
}
