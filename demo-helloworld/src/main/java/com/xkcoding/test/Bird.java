package com.xkcoding.test;

import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * <a href="Bird.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/8/14 17:55
 */
@Data
@SuperBuilder
public class Bird extends Fly{

  private String color;
}
