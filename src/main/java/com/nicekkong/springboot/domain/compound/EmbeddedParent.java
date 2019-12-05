package com.nicekkong.springboot.domain.compound;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class EmbeddedParent {

    @EmbeddedId
    private EmbeddedParentId id;

    private String nickName;

}
