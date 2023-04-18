package org.example.function;

import org.example.model.Address;
import org.example.model.Employee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionExample {

    public static void main(String[] args) {
        Supplier<Stream<Employee>> empStreamSupplier = () -> Stream.of(
                new Employee(11122, "vinit", "test@gmail.com", Arrays.asList("1234567891", "1234567891"), new Address(1, "123 test road", "abdcd", "PA", 123495)),
                new Employee(11133, "reema", "test1@gmail.com", Arrays.asList("1235567891", "1234564891"), new Address(2, "1234 test road", "abcfgd", "PA", 123645)),
                new Employee(11144, "ram", "test2@gmail.com", Arrays.asList("1234537891", "1234567851"), new Address(3, "1235 test road", "hvgdg", "PA", 127345))
        );

        Stream<Employee> employeeStream = empStreamSupplier.get();

        Function<Employee, String> empNameFunction = Employee::name;
        Function<Employee, String> empLocationFunction = (emp) -> emp.address().city() + "-" + emp.address().pin();
        printEmpWithLocation(employeeStream, empNameFunction, empLocationFunction);
    }

    private static void printEmpWithLocation(Stream<Employee> employeeStream, Function<Employee, String> empNameFunction, Function<Employee, String> empLocationFunction) {
        Map<String, String> map = employeeStream.collect(Collectors.toMap(empNameFunction, empLocationFunction, (r, r2) -> r, HashMap::new));
        map.entrySet().forEach(System.out::println);
    }
}
