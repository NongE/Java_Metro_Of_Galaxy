package com.levelup.mog.annotation;


import com.levelup.mog.validator.DateCheckValidator;
import org.jboss.jandex.AnnotationTarget;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = DateCheckValidator.class)
@Target({
        ElementType.FIELD,
        ElementType.METHOD
})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateCheck {
    String message() default  "잘못된 date 형식입니다. date 형식: yyyy-MM";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
