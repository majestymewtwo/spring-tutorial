package com.example.student;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "students")
/*
    @Data annotation is used to add getter() and setter() methods
    @Document annotation is used to indicate that this is a collection
    in the database. We specify the collection name inside the
    parenthesis (collection = "students"). Here 'students' is the collection name.
    Collection just basically means "Table" in SQL Terminology.
*/
public class Student {
    /*
        @Id is the main attribute used for identifying each document
        of the collection differently
    */
    @Id
    private String id;
    private String name;
    private String phone;
    private Integer age;
}
