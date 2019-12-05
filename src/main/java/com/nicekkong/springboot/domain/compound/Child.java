package com.nicekkong.springboot.domain.compound;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "p_child")
@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "parent_id1", referencedColumnName = "parent_id1"),
            @JoinColumn(name = "parent_id2", referencedColumnName = "parent_id2")
    })
    private Parent parent;

    private String name;
}
