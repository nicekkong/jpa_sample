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
}
