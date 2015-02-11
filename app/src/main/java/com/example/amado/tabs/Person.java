package com.example.amado.tabs;

/**
 * Created by Amado on 07/02/2015.
 */
public class Person {
    private String mName;

    public Person(String name){
        mName= name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
