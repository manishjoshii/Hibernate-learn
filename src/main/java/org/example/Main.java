package org.example;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Alien a1 = new Alien();
//        a1.setA_id(101);
//        a1.setA_name("Manish");
//        a1.setA_tech("System design");
//
//        Alien a2 = new Alien();
//        a2.setA_id(102);
//        a2.setA_name("Nitesh");
//        a2.setA_tech("AI");
//
//        Laptop l1 = new Laptop();
//        l1.setLid(1);
//        l1.setBrand("Apple");
//        l1.setModel("MacBook Pro m3");
//        l1.setRam(64);
//
//        Laptop l2 = new Laptop();
//        l2.setLid(2);
//        l2.setBrand("Dell");
//        l2.setModel("XPS");
//        l2.setRam(128);
//
//        Laptop l3 = new Laptop();
//        l3.setLid(3);
//        l3.setBrand("MSI");
//        l3.setModel("Modern 14");
//        l3.setRam(8);


//        a1.setLaptops(Arrays.asList(l2, l3));
//        a2.setLaptops(Arrays.asList(l1));

        SessionFactory factory = new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
//        Insert data
//        session.persist(l1);
//        session.persist(l2);
//        session.persist(l3);
//        session.persist(a1);
//        session.persist(a2);
//        update data
//        session.merge(a1);
//        transaction.commit();
//        session.clear();  // clearing the session to make sure it runs select query on database and not take data from hibernate cache

//        Alien a4 = session.find(Alien.class, 101);
//        System.out.println(a4);

//        fetch data
//        Alien a2 = session.find(Alien.class, 102);  // eager loading it will run even if we don't use it
//        Alien a3 = session.getReference(Alien.class, 102);  // Lazy loading it will run only if used in code
//        System.out.println(a3);
//        System.out.println(a3.getA_id());
//        System.out.println(a3.getA_name());
//        System.out.println(a3.getA_tech());

//        to delete data fetch first then give that obj as ref to remove() and commit changes
//        Alien a4 = session.find(Alien.class, 102);
//        session.remove(a4);
//        transaction.commit();

//        SQL-> Select * from laptop;       HQL -> "from laptop" OR "select brand and model from laptop"
        String hql = "select brand, model from Laptop";
        Query query = session.createQuery(hql);
        List<Object[]> laptops = query.getResultList();

        for (Object[] laptop : laptops) {
            System.out.println((String) laptop[0] + " " + (String) laptop[1]);
        }

        session.close();
        factory.close();
    }
}