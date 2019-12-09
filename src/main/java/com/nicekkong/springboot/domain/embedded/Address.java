package com.nicekkong.springboot.domain.embedded;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Setter @Getter
public class Address {

    private String city;
    private String street;
    private String zipCode;
}
