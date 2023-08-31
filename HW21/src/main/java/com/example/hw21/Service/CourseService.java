package com.example.hw21.Service;

import com.example.hw21.Api.ApiException;
import com.example.hw21.Model.Course;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repository.CourseRepository;
import com.example.hw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getTeacherCourses(Integer teacher_id) {
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if (teacher == null) throw new ApiException("teacher not exist");

        return courseRepository.findCoursesByTeacher(teacher);
    }
    public void addCourse(Integer teacher_id, Course course) {
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if (teacher == null) throw new ApiException("teacher not found");
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void updateCourse(Integer course_id, Course course) {
        Course oldCourse = courseRepository.findCourseById(course_id);
        if (oldCourse == null) throw new ApiException("course not exist");

        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer course_id) {
        Course oldCourse = courseRepository.findCourseById(course_id);
        if (oldCourse == null) throw new ApiException("course not exist");

        courseRepository.delete(oldCourse);
    }

    public String getTeacherName(Integer course_id) {
        Course course = courseRepository.findCourseById(course_id);

        if (course == null) throw new ApiException("course not exist");

        return course.getTeacher().getName();
    }


    public void assignTeacherToCourse(Integer teacher_id, Integer course_id) {
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);

        if (teacher == null || course == null) throw new ApiException("cannot assign teacher to course");

        course.setTeacher(teacher);
        courseRepository.save(course);
    }
}
