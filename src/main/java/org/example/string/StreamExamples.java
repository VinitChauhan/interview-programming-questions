package org.example.string;

import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

public class StreamExamples {

    public static void main(String[] args) {
        // Sample data for demonstrations
        List<Employee> employees = createEmployeeData();
        List<Product> products = createProductData();
        List<Order> orders = createOrderData();
        List<Student> students = createStudentData();

        System.out.println("=== JAVA STREAM API - REAL-LIFE EXAMPLES ===\n");

        // 1. FILTERING OPERATIONS
        filteringExamples(employees, products);

        // 2. MAPPING OPERATIONS
        mappingExamples(employees, products);

        // 3. COLLECTING OPERATIONS
        collectingExamples(employees, products, orders);

        // 4. GROUPING AND PARTITIONING
        groupingExamples(employees, products, students);

        // 5. REDUCTION OPERATIONS
        reductionExamples(employees, orders);

        // 6. SORTING AND LIMITING
        sortingExamples(employees, products);

        // 7. ADVANCED OPERATIONS
        advancedExamples(employees, orders, students);

        // 8. PARALLEL PROCESSING
        parallelProcessingExamples();
    }

    // 1. FILTERING OPERATIONS - Real-life scenarios
    public static void filteringExamples(List<Employee> employees, List<Product> products) {
        System.out.println("1. FILTERING OPERATIONS:\n");

        // HR Use Case: Find employees eligible for promotion (>3 years experience, salary < 80000)
        System.out.println("Employees eligible for promotion:");
        employees.stream()
                .filter(emp -> emp.getYearsOfExperience() > 3)
                .filter(emp -> emp.getSalary() < 80000)
                .forEach(emp -> System.out.println("- " + emp.getName() + " (" + emp.getDepartment() + ")"));

        // E-commerce: Filter products in stock and under budget
        System.out.println("\nProducts under $50 and in stock:");
        products.stream()
                .filter(Product::isInStock)
                .filter(p -> p.getPrice() < 50.0)
                .forEach(p -> System.out.println("- " + p.getName() + ": $" + p.getPrice()));

        // Database query equivalent: Find senior developers
        System.out.println("\nSenior developers (experience >= 5 years):");
        employees.stream()
                .filter(emp -> emp.getDepartment().equals("Engineering"))
                .filter(emp -> emp.getYearsOfExperience() >= 5)
                .map(Employee::getName)
                .forEach(name -> System.out.println("- " + name));

        System.out.println();
    }

    // 2. MAPPING OPERATIONS - Real-life scenarios
    public static void mappingExamples(List<Employee> employees, List<Product> products) {
        System.out.println("2. MAPPING OPERATIONS:\n");

        // Payroll: Calculate annual salary with bonus
        System.out.println("Annual salaries with 10% bonus:");
        employees.stream()
                .map(emp -> emp.getName() + ": $" + (emp.getSalary() * 12 * 1.1))
                .forEach(System.out::println);

        // E-commerce: Apply discount to all products
        System.out.println("\nProducts with 20% discount:");
        products.stream()
                .map(p -> new Product(p.getId(), p.getName(), p.getPrice() * 0.8,
                        p.getCategory(), p.isInStock()))
                .forEach(p -> System.out.println("- " + p.getName() + ": $" +
                        String.format("%.2f", p.getPrice())));

        // Data transformation: Extract email domains
        List<String> emails = Arrays.asList("john@gmail.com", "jane@company.com",
                "bob@yahoo.com", "alice@company.com");
        System.out.println("\nEmail domains:");
        emails.stream()
                .map(email -> email.substring(email.indexOf('@') + 1))
                .distinct()
                .forEach(domain -> System.out.println("- " + domain));

        // flatMap example: Get all skills from all employees
        System.out.println("\nAll unique skills in the company:");
        employees.stream()
                .flatMap(emp -> emp.getSkills().stream())
                .distinct()
                .sorted()
                .forEach(skill -> System.out.println("- " + skill));

        System.out.println();
    }

    // 3. COLLECTING OPERATIONS - Real-life scenarios
    public static void collectingExamples(List<Employee> employees, List<Product> products, List<Order> orders) {
        System.out.println("3. COLLECTING OPERATIONS:\n");

        // HR: Collect employee names by department
        Map<String, List<String>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
        System.out.println("Employees by department:");
        employeesByDept.forEach((dept, names) ->
                System.out.println("- " + dept + ": " + names));

        // Sales: Calculate total revenue by product category
        Map<String, Double> revenueByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.summingDouble(Product::getPrice)
                ));
        System.out.println("\nTotal value by category:");
        revenueByCategory.forEach((category, total) ->
                System.out.println("- " + category + ": $" + String.format("%.2f", total)));

        // Statistics: Get salary statistics
        DoubleSummaryStatistics salaryStats = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("\nSalary Statistics:");
        System.out.println("- Average: $" + String.format("%.2f", salaryStats.getAverage()));
        System.out.println("- Min: $" + salaryStats.getMin());
        System.out.println("- Max: $" + salaryStats.getMax());
        System.out.println("- Total: $" + salaryStats.getSum());

        // Custom collector: Join employee names with titles
        String employeeList = employees.stream()
                .map(emp -> emp.getName() + " (" + emp.getDepartment() + ")")
                .collect(Collectors.joining(", ", "Team: ", "."));
        System.out.println("\n" + employeeList);

        System.out.println();
    }

    // 4. GROUPING AND PARTITIONING - Real-life scenarios
    public static void groupingExamples(List<Employee> employees, List<Product> products, List<Student> students) {
        System.out.println("4. GROUPING AND PARTITIONING:\n");

        // HR: Group employees by salary range
        Map<String, List<Employee>> employeeBySalaryRange = employees.stream()
                .collect(Collectors.groupingBy(emp -> {
                    if (emp.getSalary() < 50000) return "Entry Level";
                    else if (emp.getSalary() < 80000) return "Mid Level";
                    else return "Senior Level";
                }));

        System.out.println("Employees by salary range:");
        employeeBySalaryRange.forEach((range, empList) -> {
            System.out.println("- " + range + ":");
            empList.forEach(emp -> System.out.println("  * " + emp.getName() +
                    " ($" + emp.getSalary() + ")"));
        });

        // Education: Partition students by pass/fail
        Map<Boolean, List<Student>> passFailStudents = students.stream()
                .collect(Collectors.partitioningBy(student -> student.getGrade() >= 60));

        System.out.println("\nStudent Results:");
        System.out.println("Passed (" + passFailStudents.get(true).size() + " students):");
        passFailStudents.get(true).forEach(s ->
                System.out.println("- " + s.getName() + ": " + s.getGrade()));

        System.out.println("Failed (" + passFailStudents.get(false).size() + " students):");
        passFailStudents.get(false).forEach(s ->
                System.out.println("- " + s.getName() + ": " + s.getGrade()));

        // Inventory: Group products by availability and category
        Map<String, Map<Boolean, List<Product>>> productGrouping = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.groupingBy(Product::isInStock)
                ));

        System.out.println("\nProducts by category and availability:");
        productGrouping.forEach((category, stockMap) -> {
            System.out.println("- " + category + ":");
            System.out.println("  In Stock: " + stockMap.get(true).size());
            System.out.println("  Out of Stock: " + stockMap.getOrDefault(false, Collections.emptyList()).size());
        });

        System.out.println();
    }

    // 5. REDUCTION OPERATIONS - Real-life scenarios
    public static void reductionExamples(List<Employee> employees, List<Order> orders) {
        System.out.println("5. REDUCTION OPERATIONS:\n");

        // Finance: Calculate total payroll
        double totalPayroll = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total monthly payroll: $" + String.format("%.2f", totalPayroll));

        // Sales: Find highest order value
        OptionalDouble maxOrderValue = orders.stream()
                .mapToDouble(Order::getTotalAmount)
                .max();
        maxOrderValue.ifPresent(max ->
                System.out.println("Highest order value: $" + String.format("%.2f", max)));

        // HR: Find most experienced employee
        Optional<Employee> mostExperienced = employees.stream()
                .max(Comparator.comparing(Employee::getYearsOfExperience));
        mostExperienced.ifPresent(emp ->
                System.out.println("Most experienced: " + emp.getName() +
                        " (" + emp.getYearsOfExperience() + " years)"));

        // Custom reduction: Calculate average experience by department
        Map<String, Double> avgExperienceByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingInt(Employee::getYearsOfExperience)
                ));

        System.out.println("\nAverage experience by department:");
        avgExperienceByDept.forEach((dept, avg) ->
                System.out.println("- " + dept + ": " + String.format("%.1f", avg) + " years"));

        // Complex reduction: Build a summary report
        String departmentSummary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .map(entry -> {
                    String dept = entry.getKey();
                    List<Employee> deptEmployees = entry.getValue();
                    double avgSalary = deptEmployees.stream()
                            .mapToDouble(Employee::getSalary).average().orElse(0);
                    return dept + ": " + deptEmployees.size() + " employees, " +
                            "avg salary $" + String.format("%.0f", avgSalary);
                })
                .collect(Collectors.joining("\n- ", "Department Summary:\n- ", ""));

        System.out.println("\n" + departmentSummary);

        System.out.println();
    }

    // 6. SORTING AND LIMITING - Real-life scenarios
    public static void sortingExamples(List<Employee> employees, List<Product> products) {
        System.out.println("6. SORTING AND LIMITING:\n");

        // HR: Top 3 highest paid employees
        System.out.println("Top 3 highest paid employees:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .forEach(emp -> System.out.println("- " + emp.getName() +
                        ": $" + emp.getSalary()));

        // E-commerce: Most expensive products in each category
        System.out.println("\nMost expensive product in each category:");
        products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getPrice))
                ))
                .forEach((category, product) ->
                        product.ifPresent(p -> System.out.println("- " + category +
                                ": " + p.getName() + " ($" + p.getPrice() + ")")));

        // Pagination: Skip and limit for data pagination
        System.out.println("\nEmployees page 2 (3 per page):");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .skip(3)  // Skip first page
                .limit(3) // Take second page
                .forEach(emp -> System.out.println("- " + emp.getName()));

        // Multi-level sorting: Sort by department, then by salary
        System.out.println("\nEmployees sorted by department, then salary:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getSalary))
                .forEach(emp -> System.out.println("- " + emp.getDepartment() +
                        ": " + emp.getName() + " ($" + emp.getSalary() + ")"));

        System.out.println();
    }

    // 7. ADVANCED OPERATIONS - Real-life scenarios
    public static void advancedExamples(List<Employee> employees, List<Order> orders, List<Student> students) {
        System.out.println("7. ADVANCED OPERATIONS:\n");

        // Quality Assurance: Check if all employees have required skills
        boolean allHaveJava = employees.stream()
                .filter(emp -> emp.getDepartment().equals("Engineering"))
                .allMatch(emp -> emp.getSkills().contains("Java"));
        System.out.println("All engineers know Java: " + allHaveJava);

        // Customer Service: Check if any order needs urgent attention
        boolean hasHighValueOrder = orders.stream()
                .anyMatch(order -> order.getTotalAmount() > 1000);
        System.out.println("Has high-value orders (>$1000): " + hasHighValueOrder);

        // Education: Find first student who failed
        Optional<Student> firstFailedStudent = students.stream()
                .filter(student -> student.getGrade() < 60)
                .findFirst();
        firstFailedStudent.ifPresent(student ->
                System.out.println("First failed student: " + student.getName() +
                        " (Grade: " + student.getGrade() + ")"));


        // Data Pipeline: Complex transformation chain
        System.out.println("\nDepartment Performance Report:");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .map(entry -> {
                    String dept = entry.getKey();
                    List<Employee> deptEmps = entry.getValue();

                    double avgSalary = deptEmps.stream()
                            .mapToDouble(Employee::getSalary).average().orElse(0);
                    double avgExperience = deptEmps.stream()
                            .mapToInt(Employee::getYearsOfExperience).average().orElse(0);

                    return new DepartmentStats(dept, deptEmps.size(), avgSalary, avgExperience);
                })
                .sorted(Comparator.comparing(DepartmentStats::getAvgSalary).reversed())
                .forEach(stats -> System.out.println("- " + stats));

        // Stream debugging with peek
        System.out.println("\nDebugging stream operations:");
        long engineerCount = employees.stream()
                .peek(emp -> System.out.println("Processing: " + emp.getName()))
                .filter(emp -> emp.getDepartment().equals("Engineering"))
                .peek(emp -> System.out.println("Engineer found: " + emp.getName()))
                .count();
        System.out.println("Total engineers: " + engineerCount);

        System.out.println();
    }

    // 8. PARALLEL PROCESSING - Real-life scenarios
    public static void parallelProcessingExamples() {
        System.out.println("8. PARALLEL PROCESSING:\n");

        // Big Data: Process large dataset in parallel
        List<Integer> largeDataset = IntStream.range(1, 1000000)
                .boxed()
                .collect(Collectors.toList());

        // Sequential processing
        long startTime = System.currentTimeMillis();
        long sumSequential = largeDataset.stream()
                .mapToLong(i -> i * i)
                .sum();
        long sequentialTime = System.currentTimeMillis() - startTime;

        // Parallel processing
        startTime = System.currentTimeMillis();
        long sumParallel = largeDataset.parallelStream()
                .mapToLong(i -> i * i)
                .sum();
        long parallelTime = System.currentTimeMillis() - startTime;

        System.out.println("Large dataset processing (sum of squares):");
        System.out.println("Sequential result: " + sumSequential + " (Time: " + sequentialTime + "ms)");
        System.out.println("Parallel result: " + sumParallel + " (Time: " + parallelTime + "ms)");
        System.out.println("Speedup: " + String.format("%.2fx", (double)sequentialTime / parallelTime));

        // Image Processing simulation
        List<String> imageFiles = Arrays.asList("img1.jpg", "img2.jpg", "img3.jpg",
                "img4.jpg", "img5.jpg", "img6.jpg");

        System.out.println("\nProcessing images in parallel:");
        imageFiles.parallelStream()
                .map(filename -> processImage(filename))
                .forEach(result -> System.out.println("- " + result));

        System.out.println();
    }

    // Helper method to simulate image processing
    private static String processImage(String filename) {
        try {
            Thread.sleep(100); // Simulate processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Processed " + filename + " on thread: " + Thread.currentThread().getName();
    }

    // Sample data creation methods
    private static List<Employee> createEmployeeData() {
        return Arrays.asList(
                new Employee(1, "Alice Johnson", "Engineering", 75000, 4,
                        Arrays.asList("Java", "Spring", "React")),
                new Employee(2, "Bob Smith", "Marketing", 55000, 2,
                        Arrays.asList("SEO", "Analytics", "Content")),
                new Employee(3, "Charlie Brown", "Engineering", 85000, 6,
                        Arrays.asList("Python", "Django", "AWS")),
                new Employee(4, "Diana Ross", "Sales", 65000, 3,
                        Arrays.asList("CRM", "Negotiation", "Presentations")),
                new Employee(5, "Eve Adams", "Engineering", 70000, 3,
                        Arrays.asList("JavaScript", "Node.js", "MongoDB")),
                new Employee(6, "Frank Miller", "HR", 60000, 5,
                        Arrays.asList("Recruitment", "Training", "Policy")),
                new Employee(7, "Grace Lee", "Engineering", 90000, 8,
                        Arrays.asList("Java", "Microservices", "Kubernetes")),
                new Employee(8, "Henry Ford", "Operations", 50000, 1,
                        Arrays.asList("Logistics", "Planning", "Excel"))
        );
    }

    private static List<Product> createProductData() {
        return Arrays.asList(
                new Product(1, "Laptop", 999.99, "Electronics", true),
                new Product(2, "Mouse", 25.99, "Electronics", true),
                new Product(3, "Desk Chair", 149.99, "Furniture", false),
                new Product(4, "Coffee Mug", 12.99, "Kitchen", true),
                new Product(5, "Smartphone", 699.99, "Electronics", true),
                new Product(6, "Desk Lamp", 39.99, "Furniture", true),
                new Product(7, "Keyboard", 79.99, "Electronics", false),
                new Product(8, "Water Bottle", 15.99, "Kitchen", true)
        );
    }

    private static List<Order> createOrderData() {
        return Arrays.asList(
                new Order(1, LocalDate.of(2024, 1, 15), 1299.98, "Alice"),
                new Order(2, LocalDate.of(2024, 1, 16), 25.99, "Bob"),
                new Order(3, LocalDate.of(2024, 1, 17), 162.98, "Charlie"),
                new Order(4, LocalDate.of(2024, 1, 18), 1549.97, "Diana"),
                new Order(5, LocalDate.of(2024, 1, 19), 95.98, "Eve")
        );
    }

    private static List<Student> createStudentData() {
        return Arrays.asList(
                new Student("John Doe", 85),
                new Student("Jane Smith", 92),
                new Student("Mike Johnson", 58),
                new Student("Sarah Wilson", 76),
                new Student("Tom Brown", 45),
                new Student("Lisa Davis", 88)
        );
    }
}

// Helper classes
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int yearsOfExperience;
    private List<String> skills;

    public Employee(int id, String name, String department, double salary,
                    int yearsOfExperience, List<String> skills) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
        this.skills = skills;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public List<String> getSkills() { return skills; }
}

class Product {
    private int id;
    private String name;
    private double price;
    private String category;
    private boolean inStock;

    public Product(int id, String name, double price, String category, boolean inStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public boolean isInStock() { return inStock; }
}

class Order {
    private int orderId;
    private LocalDate orderDate;
    private double totalAmount;
    private String customerName;

    public Order(int orderId, LocalDate orderDate, double totalAmount, String customerName) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.customerName = customerName;
    }

    // Getters
    public int getOrderId() { return orderId; }
    public LocalDate getOrderDate() { return orderDate; }
    public double getTotalAmount() { return totalAmount; }
    public String getCustomerName() { return customerName; }
}

class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Getters
    public String getName() { return name; }
    public int getGrade() { return grade; }
}

class DepartmentStats {
    private String department;
    private int employeeCount;
    private double avgSalary;
    private double avgExperience;

    public DepartmentStats(String department, int employeeCount, double avgSalary, double avgExperience) {
        this.department = department;
        this.employeeCount = employeeCount;
        this.avgSalary = avgSalary;
        this.avgExperience = avgExperience;
    }

    public double getAvgSalary() { return avgSalary; }

    @Override
    public String toString() {
        return department + ": " + employeeCount + " employees, " +
                "avg salary $" + String.format("%.0f", avgSalary) + ", " +
                "avg experience " + String.format("%.1f", avgExperience) + " years";
    }
}
