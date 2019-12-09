package com.nicekkong.springboot.domain.base;

import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Builder.Default
    private String dbsts = "O";

    private String creUser;

    @CreatedDate
    @Column(updatable = false)
    @Builder.Default
    private LocalDateTime creDate; //  = LocalDateTime.now();
    private String updUser;

    @LastModifiedDate
    private LocalDateTime updDate;


}
