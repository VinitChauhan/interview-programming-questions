package org.example.list;

import org.example.model.Employee2;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FindMaxSalaryInEachDepartment {
    public static void main(String[] args) {
        Supplier<Stream<Employee2>> empStreamSupplier = () -> Stream.of(
                new Employee2(1, "vinit", "dev", 10000),
                new Employee2(2, "reema", "dev", 20000),
                new Employee2(3, "ram", "account", 30000),
                new Employee2(4, "shyam", "account", 10000),
                new Employee2(5, "mohan", "hr", 40000),
                new Employee2(6, "ravi", "hr", 50000),
                new Employee2(7, "Asutosh", "tester", 25000)
        );

        List<Employee2> list = empStreamSupplier.get().toList();
        Map<String, List<Employee2>> empMap = new HashMap<>();
        for ( Employee2 employee2 : list ) {
            if (empMap.containsKey(employee2.department())) {
                List<Employee2> localList = empMap.get(employee2.department());
                localList.add(employee2);
                empMap.put(employee2.department(), localList);
            } else empMap.put(employee2.department(), new ArrayList<>(Collections.singleton(employee2)));
        }

        List<Map.Entry<String, List<Employee2>>> collect = empMap.entrySet().stream().toList();
        HashMap<String, String> depWiseHighSalaryEmp = new HashMap<>();
        for ( Map.Entry<String, List<Employee2>> listEntry : collect ) {
            Employee2 employee2 = listEntry.getValue().stream().max(Comparator.comparing(Employee2::salary)).get();
            depWiseHighSalaryEmp.put(listEntry.getKey(), employee2.name() + "-" + employee2.salary());
        }
        depWiseHighSalaryEmp.entrySet().forEach(System.out::println);
    }
}
