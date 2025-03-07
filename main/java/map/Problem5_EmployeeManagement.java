package org.example.Map;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

enum Department {
    HR, IT, SALES, MARKETING
}

class Problem5_EmployeeManagement {

    public static Map<Department, List<Employee>> groupEmployeesByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR)
        );

        Map<Department, List<Employee>> groupedEmployees = groupEmployeesByDepartment(employees);

        groupedEmployees.forEach((department, employeeList) -> {
            System.out.println(department + ": " + employeeList);
        });
    }
}
