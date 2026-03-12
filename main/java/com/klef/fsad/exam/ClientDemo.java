
package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Department.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Department d = new Department("CSE","Computer Science Department","2026-03-11","Active");
        session.save(d);

        System.out.println("Department inserted successfully");

        tx.commit();

        Transaction tx2 = session.beginTransaction();

        Department dept = session.get(Department.class, 1);
        if(dept != null){
            session.delete(dept);
            System.out.println("Department deleted successfully");
        }

        tx2.commit();

        session.close();
        factory.close();
    }
}
