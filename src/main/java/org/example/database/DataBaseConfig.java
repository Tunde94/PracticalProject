package org.example.database;

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
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

}
