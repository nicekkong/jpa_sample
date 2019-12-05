package com.nicekkong.springboot.domain.base;

import lombok.Builder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Builder.Default
    private String dbsts = "O";

    private String creUser;
    @Builder.Default
    private LocalDateTime creDate = LocalDateTime.now();
    private String updUser;
    private LocalDateTime updDate;


}
