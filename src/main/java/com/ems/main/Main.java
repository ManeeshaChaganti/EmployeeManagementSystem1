package com.ems.main;

import java.util.List;
import java.util.Scanner;

import com.ems.dao.EmployeeDAO;
import com.ems.entity.Employee;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n========== Employee Management System ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee By ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Department: ");
                String dept = sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();

                Employee emp = new Employee(name, dept, salary);

                dao.saveEmployee(emp);

                System.out.println("Employee Added Successfully.");

                break;

            case 2:

                List<Employee> list = dao.getEmployees();

                if (list.isEmpty()) {
                    System.out.println("No Employee Records Found.");
                } else {

                    System.out.println("---------------------------------------------");

                    for (Employee e : list) {

                        System.out.println(
                                "ID : " + e.getId() +
                                " | Name : " + e.getName() +
                                " | Department : " + e.getDepartment() +
                                " | Salary : " + e.getSalary());

                    }

                    System.out.println("---------------------------------------------");
                }

                break;

            case 3:

                System.out.print("Enter Employee ID: ");
                int searchId = sc.nextInt();

                Employee employee = dao.getEmployeeById(searchId);

                if (employee != null) {

                    System.out.println("Employee Found");

                    System.out.println("ID : " + employee.getId());
                    System.out.println("Name : " + employee.getName());
                    System.out.println("Department : " + employee.getDepartment());
                    System.out.println("Salary : " + employee.getSalary());

                } else {

                    System.out.println("Employee Not Found.");

                }

                break;

            case 4:

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                System.out.print("Enter New Salary: ");
                double newSalary = sc.nextDouble();

                dao.updateEmployee(id, newSalary);

                System.out.println("Employee Updated Successfully.");

                break;

            case 5:

                System.out.print("Enter Employee ID: ");
                int deleteId = sc.nextInt();

                dao.deleteEmployee(deleteId);

                System.out.println("Employee Deleted Successfully.");

                break;

            case 6:

                System.out.println("Thank You!");

                sc.close();

                System.exit(0);

                break;

            default:

                System.out.println("Invalid Choice!");

            }

        }

    }

}