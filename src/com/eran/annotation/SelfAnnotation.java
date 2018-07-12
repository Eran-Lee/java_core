package com.eran.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface SelfAnnotation {
	public int id() default -1;
	
	public String msg() default "ok";
}
