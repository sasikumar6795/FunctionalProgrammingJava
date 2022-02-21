package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("sasikumar", MALE),
                new Person("pavithra", FEMALE),
                new Person("abhi", MALE),
                new Person("phorani", FEMALE)
        );


        //imperative approach

        List<Person> female = new ArrayList<Person>();
        for(Person p: people)
        {
            if (FEMALE.equals(p.gender))
            {
                female.add(p);
            }
        }
        for(Person p:female)
        {
            System.out.println(p);
        }
        //Declarative Approach
        people.stream().filter(person -> MALE.equals(person.gender)).collect(Collectors.toList()).forEach(System.out::println);
    }



    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
