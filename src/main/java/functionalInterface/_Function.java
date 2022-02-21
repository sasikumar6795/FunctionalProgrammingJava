package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = increment(1);
        //System.out.println(increment);

        System.out.println(incrementByOneFunction.apply(3));
        Function<Integer, Integer> combined = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(combined.apply(5));

        System.out.println(incrementAndMultiplyBiFunction.apply(1,50));


    }

    static Function<Integer,Integer> incrementByOneFunction= number -> number+1;
    static Function<Integer,Integer> multiplyBy10Function= number -> number * 10;

    static BiFunction<Integer,Integer,Integer> incrementAndMultiplyBiFunction=( number , multiplier) -> (number +1) * multiplier*50;
    static int increment(int number)
    {
        return number+1;
    }
}
