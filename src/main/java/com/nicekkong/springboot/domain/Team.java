/*
 * Copyright (c) 2019.
 * nicekkong JE Foundation
 */

package com.nicekkong.springboot.domain;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
@Entity
@Table(name="team")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String teamName;

    @OneToMany(mappedBy = "team")
    @Builder.Default
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        // 객체 기준 양방향 관계를 모두 맺어 준다.
        this.members.add(member);
        member.setTeam(this);
    }
}
