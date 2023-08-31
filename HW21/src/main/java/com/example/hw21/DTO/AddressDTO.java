package com.example.hw21.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class AddressDTO {
    @NotEmpty(message = "area should not be empty")
    private String area;

    @NotEmpty(message = "street should not be empty")
    private String street;

    @Length(min = 4, message = "building number should be 4 numbers")
    private String buildingNumber;

    private Integer teacher_id;

}
