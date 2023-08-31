package com.example.hw21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private Integer id;

    @NotEmpty(message = "area should not be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String area;

    @NotEmpty(message = "street should not be empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String street;

    @Length(min = 4, message = "building number should be 4 numbers")
    @Column(columnDefinition = "varchar(5)")
    private String buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
