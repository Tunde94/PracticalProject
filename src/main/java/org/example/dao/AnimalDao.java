package org.example.dao;

import org.example.database.DataBaseConfig;
import org.example.entities.Animal;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AnimalDao {
    public Animal createAnimal(Animal animal){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(animal);

        transaction.commit();

        session.close();
        return animal;
    }
}
