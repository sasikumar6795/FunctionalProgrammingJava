package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
       // greetCustomer(new Customer("sasi", "900310"));
        Customer sasi =new Customer("sasi", "900310");
        //consumerFunction.accept(sasi);
        biConsumerFunction.accept(sasi,false);
    }

    static Consumer<Customer> consumerFunction= customer ->  System.out.println("Hello " +customer.customerName + " " + customer.phoneNumber);
    static BiConsumer<Customer, Boolean> biConsumerFunction= (customer,showNumber) -> System.out.println("Hello " +customer.customerName + " " + (showNumber?customer.phoneNumber:"********"));
    static void greetCustomer(Customer customer)
    {
        System.out.println("Hello " +customer.customerName + " " + customer.phoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String phoneNumber;

        Customer(String customerName, String phoneNumber)
        {
            this.customerName = customerName;
            this.phoneNumber = phoneNumber;
        }
    }
}
