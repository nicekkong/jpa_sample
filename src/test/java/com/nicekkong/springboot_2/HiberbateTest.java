/*
 * Copyright (c) 2019.
 * nicekkong JE Foundation
 */

package com.nicekkong.springboot_2;


import com.nicekkong.springboot_2.domain.Member;
import com.nicekkong.springboot_2.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
//@DataJpaTest
public class HiberbateTest {

    @Autowired
    private MemberService memberService;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void testEm() {
        memberService.saveMember("nicekkong", 13);
    }


    @Test
    public void testEM2() {


        Member member = Member.builder()
                .userName("kbi").age(20).build();

        entityManager.persist(member);


        System.out.println(member.toString());

        Member mem1 = entityManager.find(Member.class, 8);
        System.out.println(mem1.toString());





//        Session session = entityManager.unwrap(Session.class);




    }


}
