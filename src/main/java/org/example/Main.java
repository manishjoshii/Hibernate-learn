package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        AlienEntity a1 = new AlienEntity();
        a1.setA_id(102);
        a1.setA_name("Roger");
        a1.setA_tech("devops");

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(org.example.AlienEntity.class)
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

//        Transaction transaction = session.beginTransaction();
//        Insert data
//        session.persist(a1);
//        update data
//        session.merge(a1);
//        transaction.commit();

//        fetch data
//        AlienEntity a2 = session.find(AlienEntity.class, 102);  // eager loading it will run even if we don't use it
        AlienEntity a3 = session.getReference(AlienEntity.class, 102);  // Lazy loading it will run only if used in code
        System.out.println(a3);
        System.out.println(a3.getA_id());
        System.out.println(a3.getA_name());
        System.out.println(a3.getA_tech());

//        to delete data fetch first then give that obj as ref to remove() and commit changes
//        AlienEntity a4 = session.find(AlienEntity.class, 102);
//        session.remove(a4);
//        transaction.commit();


        session.close();
        factory.close();
    }
}