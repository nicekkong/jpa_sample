package com.nicekkong.springboot.domain.compound;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
@Getter @Setter
public class ParentId implements Serializable {

    private String id1;
    private String id2;

    @Builder
    public ParentId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }
}
