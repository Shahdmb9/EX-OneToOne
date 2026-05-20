package org.example.exonetoone.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name cannot be empty")
    @Column(columnDefinition = "varchar(20)",nullable = false)
    private String name;

    @NotNull(message = "age cannot be empty")
    @Column(columnDefinition = "int",nullable = false)
    @Min(value = 28,message = "Age must be greater than 28")
    private Integer age;

    @Email(message = "Please enter a valid email address")
    @Column(columnDefinition = "varchar(50)",nullable = false,unique = true)
    private String email;

    @Positive
    @Column(columnDefinition = "Double ",nullable = false)
    private Double salary;

    @OneToOne(mappedBy = "teacherid", cascade =CascadeType.ALL)
    private Address address;

}
