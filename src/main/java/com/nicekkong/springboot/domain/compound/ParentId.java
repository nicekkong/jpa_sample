package com.nicekkong.springboot.domain.compound;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter @Setter
public class ParentId implements Serializable {

    private String id1;
    private String id2;
}
