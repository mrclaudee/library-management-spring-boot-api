package com.mrclaudee.librarymanagmentapi;

import org.springframework.boot.SpringApplication;

public class TestLibraryManagmentApiApplication {

    public static void main(String[] args) {
        SpringApplication.from(LibraryManagmentApiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
