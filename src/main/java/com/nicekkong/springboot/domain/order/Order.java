/*
 * Copyright (c) 2019.
 * nicekkong JE Foundation
 */

package com.nicekkong.springboot.domain.order;

import com.nicekkong.springboot.domain.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "order")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
