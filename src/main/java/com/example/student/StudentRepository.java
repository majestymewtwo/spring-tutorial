package com.example.student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
    This @Repository annotation is used to indicate that
    this will be the class that we will be using to perform
    CRUD (Create, Read, Update, Delete) operations
*/
@Repository
/*
    This is an interface not a class. And we need to put the
    class of the model (T) and data type of the id (V)
    in the form <T, V>.
    Here we put <Student, String>, Student is the class and
    String is the data type of Student class's id attribute
*/
public interface StudentRepository extends MongoRepository<Student, String> {
}
