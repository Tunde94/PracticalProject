package org.example.dao;

import org.example.database.DataBaseConfig;
import org.example.entities.Address;
import org.example.entities.AddressId;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AddressDao {
    //CRUD Adress
    //create
    //read
    //update
    //delete
    public Address createAddress(Address address){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(address);
        transaction.commit();

        session.close();
        return address;
    }


    public Address readAddress(AddressId addressId){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        //nu mai avem nevoie de tranzactie, pentru ca nu modificam, doar afisam ceva
        Address address = session.find(Address.class,addressId);

        session.close();
        return address;

    }

    public List<Address> readAllAddress(){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        //cauta in entitate
        //Address este numele (clasei) - entitatii
        List<Address> addresses = session.createQuery("select a from Address a", Address.class).getResultList();//aici punem hibernate query

        session.close();
        return addresses;
    }

    public Address updateAddress(Address address){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(address);
        transaction.commit();

        session.close();
        return address;
    }

    public void removeAddress(Address address){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(address);
        transaction.commit();

        session.close();
    }
}
