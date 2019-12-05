/*
 * Copyright (c) 2019.
 * nicekkong JE Foundation
 */

package com.nicekkong.springboot.service;

import com.nicekkong.springboot.domain.Member;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class MemberService {

    @PersistenceContext
    private EntityManager em;

    public Member saveMember(String name, int age) {

        Member member = Member.builder()
                .userName(name)
                .age(age)
                .build();

        em.persist(member);

        return member;

    }

}
