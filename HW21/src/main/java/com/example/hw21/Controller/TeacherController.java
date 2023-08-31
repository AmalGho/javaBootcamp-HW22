package com.example.hw21.Controller;

import com.example.hw21.Api.ApiResponse;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/getAll")
    public ResponseEntity getAllTeachers() {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("teacher added"));
    }

    @PutMapping("/update/{teacher_id}")
    public ResponseEntity updateTeacher(@PathVariable Integer teacher_id, @RequestBody @Valid Teacher teacher) {
        teacherService.updateTeacher(teacher_id, teacher);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("teacher updated"));
    }


    @DeleteMapping("/delete/{teacher_id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer teacher_id) {
        teacherService.deleteTeacher(teacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("teacher deleted"));
    }


    @GetMapping("/getDetail/{teacher_id}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer teacher_id) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeacherDetails(teacher_id));
    }
}
