package com.thoughtworks.bookshelf.controller;

import org.junit.Before;
import org.junit.Test;

public class PersonControllerTest {
    private PersonController personController;

    @Before
    public void setUp() throws Exception {
        personController = new PersonController();
    }

    @Test
    public void should_get_json_response_from_profile() {
        String url = "http://localhost:8081/spring-json/json/person/profile/100/sownWolf/true";
    }
}