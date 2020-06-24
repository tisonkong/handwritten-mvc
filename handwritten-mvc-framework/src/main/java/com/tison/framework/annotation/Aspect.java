package com.tison.framework.annotation;

import java.lang.annotation.*;

/**
 * @author tison
 * 切面注解 类级别的控制
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 包名
     */
    String pkg() default "";

    /**
     * 类名
     */
    String cls() default "";
}