/*
 * Copyright (c) 2019.
 * nicekkong JE Foundation
 */

package com.nicekkong.springboot.domain.embedded;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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


    @ElementCollection(fetch = FetchType.LAZY) // default = FetchType.LAZY (1:N 관계 이므로...)
    @CollectionTable(name="favorite_foods", joinColumns = @JoinColumn(name="worker_id"))
    @Column(name="food_name")
    private Set<String> favoriteFoods = new HashSet<>();
}
