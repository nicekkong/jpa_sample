/*
 * Copyright (c) 2019.
 * nicekkong JE Foundation
 */

package com.nicekkong.springboot.domain.order;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rcvName;
}
