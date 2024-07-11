package com.javatechie.controller;

import com.javatechie.dto.Course;
import com.javatechie.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        Optional<Course> course = courseService.getCourseById(id);
        return course.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course newCourse) {
        boolean updated = courseService.updateCourse(id, newCourse);
        if (updated) {
            return new ResponseEntity<>(newCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        boolean deleted = courseService.deleteCourse(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "UP";
    }


    @GetMapping("/welcome")
    public String greetings() {
        return "Hello Techie , AWS CICD Example working fine !";
    }


}
