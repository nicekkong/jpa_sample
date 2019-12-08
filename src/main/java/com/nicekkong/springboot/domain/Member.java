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

//    @Column(name = "NAME")
    private String userName;

    private Integer age;

    @ManyToOne
    private TeamInfo teamInfo;

    public void setTeamInfo(TeamInfo teamInfo) {

        // 현재 관계를 먼저 끊어준다.
        if(this.teamInfo != null) {
            this.teamInfo.getMembers().remove(this);
        }

        // 객체 기준 양방향 관계를 모두 맺어 준다.
        this.teamInfo = teamInfo;
        teamInfo.getMembers().add(this);
    }
}
