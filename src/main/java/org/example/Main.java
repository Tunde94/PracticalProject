package org.example;

import org.example.dao.AddressDao;
import org.example.dao.PersonDao;
import org.example.entities.Address;
import org.example.entities.AddressId;
import org.example.entities.BuildingType;
import org.example.entities.Person;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static AddressDao addressDao = new AddressDao();
    private static PersonDao personDao = new PersonDao();


    public static void main(String[] args) {
        AddressId addressId = new AddressId("Primaverii", 14, "Cluj-Napoca");
        Address address = new Address(addressId,150, BuildingType.PRIVATE_HOUSE);
        addressDao.createAddress(address);

        AddressId addressId1 = new AddressId("Principala", 78,"Ceuasu de Campie");
        Address address1 = new Address(addressId1,250,BuildingType.DUPLEX);
        addressDao.createAddress(address1);

        AddressId addressId2 = new AddressId("Matei Corvin", 12,"Targu Mures");
        Address address2 = new Address(addressId2,98,BuildingType.OFFICE);
        addressDao.createAddress(address2);

        Person person = new Person("5201218260026","Paula",2000,address);
        personDao.createPerson(person);

        Person ion = new Person("193040567842345", "Ion", 1993, address);
        Person vlad = new Person("177040567842345", "Vlad", 1977, address2);
        Person mihai = new Person("186040567842345", "Mihai", 1986, address1);
        Person dorin = new Person("168040567842345", "Dorin", 1968, address1);
        Person maria = new Person("289121298983556", "Maria", 1989, address);
        Person ioana = new Person("299121298983556", "Ioana", 1999, address2);
        Person simona = new Person("278121298983556", "Simona", 1978, address);

        personDao.createPerson(ion);
        personDao.createPerson(vlad);
        personDao.createPerson(mihai);
        personDao.createPerson(dorin);
        personDao.createPerson(maria);
        personDao.createPerson(ioana);
        personDao.createPerson(simona);

        personDao.readAllPerson().forEach(p -> System.out.println(p));//lambda=finctie anonime- fara nume
//ce-i in stanga sageticai este o metoda

        simona.setName("Irina");
        personDao.updatePerson(simona);

        personDao.removePerson(maria);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");

        personDao.readAllPerson();

        System.out.println("Young person list: \n");
        personDao.young(1990).forEach(System.out::println);

        System.out.println("Same address \n");
        personDao.sameAddress("Cluj-Napoca").forEach(System.out::println);

/*

        personDao.readAllPerson().forEach((p) -> {
            prettyDisplayOfPerson(p);
        });

        // v1
        personDao.readAllPerson().forEach((p) -> {
            prettyDisplayOfPerson(p);
        });

// v2
        personDao.readAllPerson().forEach(p -> prettyDisplayOfPerson(p));

// v3
        personDao.readAllPerson().forEach(Main::prettyDisplayOfPerson);
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(11, "unsprezece");
        numbers.put(100, "o sută");
        numbers.put(-2, "minus doi");

        numbers.forEach((k, v) -> {
            System.out.println("Numărul " + k + " se pronunță " + v);
        });

        numbers.forEach((k,v) -> prettyPrint(k,v));

        numbers.forEach(Main::prettyPrint);

        */
System.out.println(addressDao.readAddress(addressId));
        System.out.println(personDao.readPerson("5201218260026"));
        System.out.println(personDao.readAllPerson());


    }
    static void prettyDisplayOfPerson(Person p) {
        System.out.println(
                p.getName() +
                        " născut în " + p.getYearOfBirth() +
                        " locuiește în " + p.getAddress().getId().getCity());
    }

    static void prettyPrint(Integer nr, String traducere) {
        System.out.println("+++ Numărul " + nr + " se pronunță " + traducere + " ++++");

    }
}
