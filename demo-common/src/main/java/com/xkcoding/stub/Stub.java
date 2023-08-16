package com.xkcoding.stub;

import org.aspectj.lang.ProceedingJoinPoint;

public interface Stub {
     Object stub(Object[] args, String stubParam, ProceedingJoinPoint pjp) ;
}
