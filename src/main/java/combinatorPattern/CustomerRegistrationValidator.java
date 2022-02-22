package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import static  combinatorPattern.CustomerRegistrationValidator.*;
import static combinatorPattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid()
    {
        return customer -> customer.getEmailAddress().contains("@") ? SUCCESS : INVALID_EMAIL;
    }

    static CustomerRegistrationValidator isPhoneNumberValid()
    {
        return customer -> customer.getPhoneNumber().startsWith("+91") ? SUCCESS:INVALID_PHONE_NUMBER;
    }

    static CustomerRegistrationValidator isAdult()
    {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ? SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other)
    {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer):result;
        };
    }




    enum ValidationResult {
        SUCCESS,
        INVALID_EMAIL,
        INVALID_PHONE_NUMBER,
        IS_NOT_AN_ADULT
    }
}
