package com.thoughtworks.bookshelf.model;

import java.io.Serializable;

/**
 * Created by htp on 2015/5/7.
 */

public class Person implements Serializable {

    private int id;
    private String name;
    private boolean status;

    public Person(int id, String name, boolean status) {
        // do nothing
    }
}
