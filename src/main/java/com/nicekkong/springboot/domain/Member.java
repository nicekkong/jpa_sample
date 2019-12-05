package com.nicekkong.springboot.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Accessors(chain = true)
@Entity
@Table(name = "MEMBER")
@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Member {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String userName;

    private Integer age;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

    public void setTeam(Team team) {

        // 현재 관계를 먼저 끊어준다.
        if(this.team != null) {
            this.team.getMembers().remove(this);
        }

        // 객체 기준 양방향 관계를 모두 맺어 준다.
        this.team = team;
        team.getMembers().add(this);
    }
}
