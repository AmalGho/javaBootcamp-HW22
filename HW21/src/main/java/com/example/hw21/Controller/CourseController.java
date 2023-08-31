package com.example.hw21.Controller;

import com.example.hw21.Api.ApiResponse;
import com.example.hw21.Model.Course;
import com.example.hw21.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/getAll")
    public ResponseEntity getAllCourses(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getAllCourses());
    }

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity addCourse(@PathVariable Integer teacher_id, @RequestBody @Valid Course course) {
        courseService.addCourse(teacher_id, course);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{course_id}")
    public ResponseEntity updateCourse(@PathVariable Integer course_id, @RequestBody @Valid Course course) {
        courseService.updateCourse(course_id,course);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{course_id}")
    public ResponseEntity deleteCourse(@PathVariable Integer course_id) {
        courseService.deleteCourse(course_id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("deleted"));
    }

    @GetMapping("/getTeacherName/{course_id}")
    public ResponseEntity getTeacherName(@PathVariable Integer course_id) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getTeacherName(course_id));
    }

    @GetMapping("/getByTeacher/{teacher_id}")
    public ResponseEntity getTeacherCourses(@PathVariable Integer teacher_id) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getTeacherCourses(teacher_id));
    }

}
