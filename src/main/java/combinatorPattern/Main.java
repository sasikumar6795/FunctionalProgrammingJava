package combinatorPattern;

import java.time.LocalDate;
import static combinatorPattern.CustomerRegistrationValidator.ValidationResult.*;

public class Main {
    public static void main(String[] args) {

        CustomerValidatorService validatorService = new CustomerValidatorService();

        Customer customer =new Customer("sasi","sasi@gmail.com","+9290031", LocalDate.of(1995,07,06));
       // System.out.println(validatorService.isValid(customer));

        //Combinator Pattern

        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAdult())
                .apply(customer);

        System.out.println(result);

        if(result!= SUCCESS)
        {
            throw new IllegalStateException(result.name());
        }

    }
}
