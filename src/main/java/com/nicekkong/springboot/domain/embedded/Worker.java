/*
 * Copyright (c) 2019.
 * nicekkong JE Foundation
 */

package com.nicekkong.springboot.domain.embedded;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="worker")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Period workPeriod;

    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column=@Column(name="company_city")),
            @AttributeOverride(name="street", column=@Column(name="company_street")),
            @AttributeOverride(name="zipCode", column=@Column(name="company_zip_code"))
    })
    private Address companyAddress;
}
