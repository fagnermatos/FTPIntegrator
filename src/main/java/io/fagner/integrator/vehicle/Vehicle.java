package io.fagner.integrator.vehicle;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "vehicle")
@EqualsAndHashCode
@ToString
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String plate;
    @Column
    private String modelBrand;
    @Column
    private Integer modelYear;

    public Vehicle() {
    }

    public Vehicle(String plate, String modelBrand, Integer modelYear) {
        this.plate = plate;
        this.modelBrand = modelBrand;
        this.modelYear = modelYear;
    }

    public static Vehicle of(String plate, String modelBrand, Integer modelYear) {
        return new Vehicle(plate, modelBrand, modelYear);
    }
}
