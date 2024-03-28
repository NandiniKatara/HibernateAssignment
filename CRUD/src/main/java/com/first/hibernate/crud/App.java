package com.first.hibernate.crud;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Display Details!" );

        Employee employee1 = new Employee();
        employee1.setEmpName("Nandini Katara");
        employee1.setEmpEmail("kataranandini16@gmail.com");

        
        Employee employee2 = new Employee();
        employee2.setEmpName("Pranav Katara");
        employee2.setEmpEmail("katarayash21@gmail.com");
        
        Employee employee3 = new Employee();
        employee3.setEmpName("Gaurav Sharma");
        employee3.setEmpEmail("sharmagaurav11@accolite.com");
        
        
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        //create
        session.beginTransaction();
 
        session.persist(employee1);
        session.persist(employee2);
        session.persist(employee3);
        session.getTransaction().commit();
       
        //read
        session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
        session.beginTransaction();
        Employee savedEmployee = session.get(Employee.class, 1L);
        System.out.println(savedEmployee);
        session.getTransaction().commit();
        
        
        //updating the email id of emp1
        session.beginTransaction();
        employee1.setEmpEmail("nandini.katara@accolitedigital.com");
        session.merge(employee1);
        session.getTransaction().commit();
        session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
        
        
        //Delete
        session.beginTransaction();
        session.remove(employee3);
        session.getTransaction().commit();
        session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
         
         
        session.close();
        
       
        
    }
}

