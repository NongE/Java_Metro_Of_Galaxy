package com.levelup.mog.validator;

import com.levelup.mog.annotation.DateCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCheckValidator implements ConstraintValidator<DateCheck, String> {

    @Override
    public void initialize(DateCheck constraintAnnotation) {
        // ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try{
            String pattern = "yyyyMM";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(value);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
