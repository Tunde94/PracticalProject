package org.example.database;

import org.example.entities.Address;
import org.example.entities.AddressId;
import org.example.entities.Animal;
import org.example.entities.Person;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataBaseConfig {
    private static SessionFactory sessionFactory;

    private DataBaseConfig(){//constructorul ne ajuta sa nu lasam pe nimeni sa instanteze DataBaseConfig

    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            sessionFactory = new Configuration()
                    .configure("hibernate.configuration.xml")
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(AddressId.class)
                    .addAnnotatedClass(Animal.class)
                    .addAnnotatedClass(Person.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

}
