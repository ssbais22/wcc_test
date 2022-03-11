package com.test.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "postcodelatlng")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public final class PostCode {
    private static final long serialVersionUID = 10000L;

    @Id
    @Column(name = "postcode")
    @NotBlank(message = "post code is mandatory")
    @Size(min = 8,max = 8, message = "should be 8 char only")
    private String postalCode;

    @Column(name = "latitude")
    @Range(min = -90,max = 90,message = "Invalid value for longitude")
    private double latitude;

    @Column(name = "longitude")
    @Range(min = -180,max = 180,message = "Invalid value for longitude")
    private double longitude;

    @Override
    public String toString() {
        return this.postalCode;
    }

}
