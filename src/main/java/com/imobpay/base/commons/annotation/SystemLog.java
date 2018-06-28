package com.imobpay.base.commons.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    public String module()       default "";
    public String methods()      default "";
    public String description()  default "";
    public boolean isReadParam() default true;
}


//~ Formatted by Jindent --- http://www.jindent.com
