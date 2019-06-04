package com.eddie.annotationprocessor;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/**
 * 对注解了的类所有field判断是否有get方法
 */
public @interface CheckGetAnnotation {
}
