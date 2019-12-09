package com.nicekkong.springboot.domain.embedded;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@NoArgsConstructor
public class Period {

    @CreatedDate
    private LocalDateTime startDate;

    @LastModifiedDate
    private LocalDateTime endDate;
}
