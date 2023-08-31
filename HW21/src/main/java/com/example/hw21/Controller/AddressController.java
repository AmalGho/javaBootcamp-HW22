package com.example.hw21.Controller;

import com.example.hw21.Api.ApiResponse;
import com.example.hw21.DTO.AddressDTO;
import com.example.hw21.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/add/{teacher_id}")
    public ResponseEntity addTeacherAddress(@PathVariable Integer teacher_id, @RequestBody @Valid AddressDTO addressDTO) {
        addressService.addTeacherAddress(teacher_id, addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("address added "));
    }

    @PutMapping("/update/{address_id}")
    public ResponseEntity updateTeacherAddress(@PathVariable Integer address_id, @RequestBody @Valid AddressDTO addressDTO) {
        addressService.updateTeacherAddress(address_id, addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("address updated"));
    }

    @DeleteMapping("/delete/{teacher_id}")
    public ResponseEntity deleteTeacherAddress(@PathVariable Integer teacher_id) {
        addressService.deleteTeacherAddress(teacher_id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("address deleted"));
    }


}
