package com.tison.basic.retention;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tison
 * (RetentionPolicy.RUNTIME) 策略为RUNTIME，编译器会将该 Annotation 信息保留在 .class 文件中，并且能被虚拟机读取。
 * (ElementType.TYPE)修饰"类、接口（包括注释类型）或枚举声明"的注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String key = "key";

    String value = "value";

}
