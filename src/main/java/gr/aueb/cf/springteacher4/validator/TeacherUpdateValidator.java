package gr.aueb.cf.springteacher4.validator;

import gr.aueb.cf.springteacher4.dto.TeacherInsertDTO;
import gr.aueb.cf.springteacher4.dto.TeacherUpdateDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TeacherUpdateValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return TeacherUpdateDTO.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        TeacherUpdateDTO teacherUpdateDto = (TeacherUpdateDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "empty");
        if (teacherUpdateDto.getFirstname().length() < 3 || teacherUpdateDto.getFirstname().length() > 512) {
            errors.rejectValue("firstname", "size");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "empty");
        if (teacherUpdateDto.getLastname().length() < 3 || teacherUpdateDto.getLastname().length() > 512) {
            errors.rejectValue("lastname", "size");
        }
    }
}
