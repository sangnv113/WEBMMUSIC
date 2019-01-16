
package com.example.WebProject.validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.WebProject.entity.Producer;


@Component
public class EditProducerValidator implements Validator {
 
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Producer.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
    	//Producer producer = (Producer) target;
 
        // Kiểm tra các trường (field) của CustomerForm.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.producer.name");

    }
 
}