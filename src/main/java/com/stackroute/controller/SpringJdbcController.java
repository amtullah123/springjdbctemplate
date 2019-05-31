package com.stackroute.controller;

import com.stackroute.domain.Movie;
import com.stackroute.repository.SpringJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringJdbcController {
    @Autowired
    private SpringJdbcRepository springJdbcRepository;
    public ResponseEntity<String> executeShow() {
        Movie entity = springJdbcRepository.get("1");
        return new ResponseEntity("Movie: " + entity.getMovie_id()
                + ", " + entity.getMovie_name()+ " ," +entity.getRelease_year()+ ", " +entity.getRating(),HttpStatus.OK);
    }

    public ResponseEntity<String> insert() {
        Movie entity = new Movie(3, "hey baby" ,2019,6);
        springJdbcRepository.add(entity);
        return new ResponseEntity("Student Add: "+ entity.getMovie_id()
                + ", " + entity.getMovie_name()+ " ," +entity.getRelease_year()+ ", " +entity.getRating(),HttpStatus.OK);  }

    public ResponseEntity<String> read() {
        Movie entity = springJdbcRepository.get("2");
        return new ResponseEntity("Student Get: " + entity.getMovie_id()
                + ", " + entity.getMovie_name()+ " ," +entity.getRelease_year()+ ", " +entity.getRating(),HttpStatus.OK); }

    public ResponseEntity<String> update() {
        Movie entity = new Movie(1, "wonder",2018,7);
        springJdbcRepository.update(entity);
        return new ResponseEntity("Student Update: " + entity.getMovie_id()
                + ", " + entity.getMovie_name()+ " ," +entity.getRelease_year()+ ", " +entity.getRating(),HttpStatus.OK);  }

    public ResponseEntity<String> delete() {
        Movie entity = new Movie(3,"hey baby",2019,6);
        springJdbcRepository.delete(entity);
        return new ResponseEntity("Student Delete: " + entity.getMovie_id()
                + ", " + entity.getMovie_name()+ " ," +entity.getRelease_year()+ ", " +entity.getRating(),HttpStatus.OK);}
    public ResponseEntity<?> getAll() {
        List<Movie> movieList =springJdbcRepository.getAll();
        return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
    }}
