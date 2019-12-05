package com.nicekkong.springboot.domain.compound;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter @ToString @EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
@Builder
@Embeddable
public class EmbeddedParentId implements Serializable {

    @Column(name = "parent_id1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id1;

    @Column(name = "parent_id2")
    private String id2;

}
