package com.example.hw21.Service;

import com.example.hw21.Api.ApiException;
import com.example.hw21.DTO.AddressDTO;
import com.example.hw21.Model.Address;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repository.AddressRepository;
import com.example.hw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public void addTeacherAddress(Integer teacher_id, AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);

        if (teacher == null)
            throw new ApiException("teacher id is wrong");

        Address address =  new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    public void updateTeacherAddress(Integer address_id, AddressDTO addressDTO) {
        Address oldAddress = addressRepository.findAddressById(address_id);
        Teacher teacher = teacherRepository.findTeacherById(oldAddress.getTeacher().getId());
        if (teacher == null)
            throw new ApiException("teacher id is wrong");
        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(oldAddress);
    }

    public void deleteTeacherAddress(Integer teacher_id) {
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if (teacher == null)
            throw new ApiException("teacher id is wrong");

        teacherRepository.delete(teacher);
        addressRepository.delete(teacher.getAddress());
    }



}
