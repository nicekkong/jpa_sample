package com.nicekkong.springboot.domain.base;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "jpa_board")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@AttributeOverride(name="id", column = @Column(name = "board_id"))
//@AttributeOverrides({
//        @AttributeOverride( name="id", column = @Column(name = "board_id"))
//        })
public class Board extends BaseEntity {

    String title;
    String contents;
}


