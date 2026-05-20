package org.example.exonetoone.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    private Integer id;

    @NotEmpty(message = "Phone cannot be empty")
    @Column(nullable = false,unique = true)
    private String area;

    @NotEmpty(message = "Address cannot be empty")
    @Column(nullable = false)
    private String street;

    @NotNull(message = "Building number cannot be empty")
    @Column(nullable = false,columnDefinition = "int")
    private Integer building_number;

    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_id")
    @JsonIgnore
    private Teacher teacherid;

//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "customer_id")
//    private T customer;
}
