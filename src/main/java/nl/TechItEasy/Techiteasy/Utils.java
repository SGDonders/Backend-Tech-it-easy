package nl.TechItEasy.Techiteasy;


import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import javax.validation.ValidationException;

public class Utils {
    public static void reportErrors(BindingResult br) {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            throw new ValidationException(sb.toString());
        }
    }
}


