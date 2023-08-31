package com.example.hw21.Service;

import com.example.hw21.Api.ApiException;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repository.AddressRepository;
import com.example.hw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer teacher_id, Teacher teacher) {
        Teacher oldTeacher = teacherRepository.findTeacherById(teacher_id);
        if (oldTeacher == null) throw new ApiException("this teacher not exist");
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id) {
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (oldTeacher == null) throw new ApiException("this teacher not exist");
        teacherRepository.delete(oldTeacher);

        if (oldTeacher.getAddress() != null)
            addressRepository.delete(oldTeacher.getAddress());
    }

    public Teacher getTeacherDetails(Integer teacher_id) {
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if (teacher == null)
            throw new ApiException("teacher id is wrong");

        return teacher;
    }
}
