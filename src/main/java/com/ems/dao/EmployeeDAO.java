package com.ems.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ems.entity.Employee;
import com.ems.util.HibernateUtil;

public class EmployeeDAO {

    // Save
    public void saveEmployee(Employee employee) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(employee);

        tx.commit();
        session.close();
    }

    // Display All
    public List<Employee> getEmployees() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Employee> list =
                session.createQuery("from Employee", Employee.class).list();

        session.close();

        return list;
    }

    // Update
    public void updateEmployee(int id, double salary) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);

        if(emp != null){
            emp.setSalary(salary);
            session.merge(emp);
        }

        tx.commit();
        session.close();
    }

    // Delete
    public void deleteEmployee(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);

        if(emp != null){
            session.remove(emp);
        }
        
        tx.commit();
        session.close();
    }

    public Employee getEmployeeById(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Employee employee = session.get(Employee.class, id);

        session.close();

        return employee;
    }
}
