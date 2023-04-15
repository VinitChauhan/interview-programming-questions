package org.example.map;

import org.example.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMapExample {

    public static void main(String[] args) {

        Supplier<Stream<Employee>> supplierStream = () -> Stream.of(new Employee(1, "Vinit", "test@gmail.com", Arrays.asList("9876567651", "9876567656")),
                new Employee(2, "Reema", "test1@gmail.com", Arrays.asList("9876567652", "9876567657")),
                new Employee(3, "Aarohi", "test2@gmail.com", Arrays.asList("9876567653", "9876567658")),
                new Employee(4, "Aahana", "test3@gmail.com", Arrays.asList("9876567654", "9876567659")),
                new Employee(5, "Reema", "test4@gmail.com", Arrays.asList("9876567655", "9876567610"))
        );

//        Stream<Employee> employeeStream = Stream.of(new Employee(1, "Vinit", "test@gmail.com", Arrays.asList("9876567651", "9876567656")),
//                new Employee(2, "Reema", "test1@gmail.com", Arrays.asList("9876567652", "9876567657")),
//                new Employee(3, "Aarohi", "test2@gmail.com", Arrays.asList("9876567653", "9876567658")),
//                new Employee(4, "Aahana", "test3@gmail.com", Arrays.asList("9876567654", "9876567659")),
//                new Employee(5, "Ram", "test4@gmail.com", Arrays.asList("9876567655", "9876567610"))
//        );
        printStream(supplierStream.get());
        collectAllEmailId(supplierStream.get());
        collectAllPhoneNumbers(supplierStream.get());
        collectMapOfEmpAndPhoneNumber(supplierStream.get());
    }

    private static void printStream(Stream<Employee> employeeStream) {
        employeeStream.toList().forEach(System.out::println);
    }

    private static void collectAllEmailId(Stream<Employee> employeeStream) {
        employeeStream.map(Employee::email).toList().forEach(System.out::println);
    }

    private static void collectAllPhoneNumbers(Stream<Employee> employeeStream) {
//        employeeStream.map(Employee::phoneNumbers).toList().forEach(System.out::println);
        employeeStream.flatMap(employee -> employee.phoneNumbers().stream()).toList().forEach(System.out::println);
    }

    private static void collectMapOfEmpAndPhoneNumber(Stream<Employee> employeeStream) {
        employeeStream.collect(Collectors.toMap(Employee::name, Employee::phoneNumbers, (val1, val2) -> {
                    ArrayList<String> mergePhoneNumberList = new ArrayList<>(val1);
                    mergePhoneNumberList.addAll(val2);
                    return mergePhoneNumberList;
                }
                , LinkedHashMap::new)).entrySet().forEach(System.out::println);
    }
}
