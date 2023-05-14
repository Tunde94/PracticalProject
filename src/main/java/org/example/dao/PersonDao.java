package org.example.dao;

import org.example.database.DataBaseConfig;
import org.example.entities.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDao {
    public Person createPerson(Person person){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.persist(person);

        transaction.commit();

        session.close();
        return person;
    }
    public Person readPerson(String cnp){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Person person = session.find(Person.class,cnp);

        session.close();
        return person;
    }

    public List<Person> readAllPerson(){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        List<Person> persons = session.createQuery("select p from Person p", Person.class).getResultList();//dupa tipul obiectului trebuie sa fie denumirea exact la fel ca dupa select
        session.close();
        return persons;
    }
    public Person updatePerson(Person person){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.merge(person);

        transaction.commit();

        session.close();
        return person;
    }

    public void removePerson(Person person){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(person);
        transaction.commit();
        session.close();
    }

    public List<Person> young(Integer year){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        List<Person> result = session.createQuery("select p from Person p where yearOfBirth > :yearParam", Person.class)
                .setParameter("yearParam",year)
                .getResultList();

        session.close();
        return result;
    }
    public List<Person> sameAddress(String city){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        List<Person> result = session.createQuery(
                "select p from Person p where p.address.id.city = :cityParam",Person.class)
                .setParameter("cityParam",city)
                .getResultList();
        session.close();
        return result;
    }
}
