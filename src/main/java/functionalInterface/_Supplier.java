package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getConnection.get());
        System.out.println(getConnectionList.get());
    }

    static Supplier<String> getConnection = () -> "jdbc://localhost:8080/users";

    static Supplier<List<String>> getConnectionList = ()
            -> List.of("jdbc://localhost:8080/users",
            "jdbc://localhost:8080/employees"
            );
}
