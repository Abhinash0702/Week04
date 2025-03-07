package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class implementing Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee { ID: " + id + ", Name: " + name +
                ", Department: " + department + ", Salary: " + salary + " }";
    }
}

public class Problem04_EmployeeSerialization  {
    private static final String FILE_NAME = "index.txt";

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 70000));
        employees.add(new Employee(103, "Charlie", "Finance", 60000));

        // Serialize employees to file
        serializeEmployees(employees);

        // Deserialize and display employees
        List<Employee> deserializedEmployees = deserializeEmployees();
        System.out.println("Deserialized Employees:");
        for (Employee emp : deserializedEmployees) {
            System.out.println(emp);
        }
    }

    // Method to serialize a list of employees
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully.");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    // Method to deserialize employees from file
    @SuppressWarnings("unchecked")
    private static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
        return employees;
    }
}
