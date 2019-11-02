package com.zipcodewilmington.phonebook;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private Map<String, List<String>> phoneBook;

    public PhoneBook(Map<String, List<String>> map) {

        this.phoneBook = map;
    }

    public PhoneBook() {

        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        ArrayList<String> number = new ArrayList<>();
        number.add(phoneNumber);
        phoneBook.put(name, number);
    }

    public void addAll(String name, String... phoneNumbers) {
        phoneBook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phoneBook.remove(name);
    }

    public Boolean hasEntry(String name) {

        return (reverseLookup(name) != null | phoneBook.containsKey(name));
    }

    public List<String> lookup(String name) {
        return phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(String  each :phoneBook.keySet()){
            if(phoneBook.get(each).contains(phoneNumber)){
                return each;
            }
        }

        return null;
    }

    public List<String> getAllContactNames() {


        return new ArrayList<> (phoneBook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return this.phoneBook;
    }
}
