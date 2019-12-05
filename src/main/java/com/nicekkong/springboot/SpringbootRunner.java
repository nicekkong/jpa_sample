package com.nicekkong.springboot;

import com.nicekkong.springboot.domain.Member;
import com.nicekkong.springboot.domain.Team;
import com.nicekkong.springboot.domain.compound.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
@Transactional
public class SpringbootRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Team team = Team.builder()
                .teamName("IT팀").build();

        Team itTeam = entityManager.find(Team.class, 1);

        Member member = Member.builder()
                            .userName("nicekkong")
                            .age(30)
                            .team(team).build();

        Member member2 = Member.builder()
                .userName("kbi")
                .age(35)
                .team(itTeam).build();




//        Member itMember = entityManager.find(Member.class, 2);
//
//        System.out.println("팀이름 ===> " + itMember.getTeam().getTeamName());
//
//        String jpql = "select m from Member m join m.team t where t.teamName = :teamName";
//
//        List<Member> resultList = entityManager.createQuery(jpql, Member.class)
//                .setParameter("teamName", "IT팀").getResultList();
//
//        resultList.forEach(System.out::println);

        Team supportTeam = Team.builder().teamName("지원팀").build();
//        Team supportTeam = Team.builder().build();
//        Team supportTeam = new Team();
//        supportTeam.setTeamName("지원팀");
//        supportTeam.setTeamName("지원팀"); // Team.builder().teamName("지원팀").build();

        System.out.println("===================1====================");
        entityManager.persist(team);
        System.out.println("===================2====================");
        entityManager.persist(supportTeam);
        System.out.println("===================3====================");

        entityManager.persist(member);
        System.out.println("===================4====================");
        entityManager.persist(member2);
        System.out.println("===================5====================");
//        Member itMember = entityManager.find(Member.class, 2);
        System.out.println("===================6====================");
//        System.out.println("팀이름 ===> " + itMember.getTeam().getTeamName());


        String jpql = "select m from Member m join m.team t where t.teamName = :teamName";
        List<Member> resultList = entityManager.createQuery(jpql, Member.class)
                .setParameter("teamName", "IT팀").getResultList();
        System.out.println("===================7====================");
        resultList.forEach(System.out::println);

        System.out.println("member2.setTeam(supportTeam);");
        System.out.println("===================8====================");
        member2.setTeam(supportTeam);
        System.out.println("===================9====================");


        System.out.println("===================IdClass====================");
        Parent parent = Parent.builder().id1("id1").id2("id2").name("nicekkong").build();
        entityManager.persist(parent);

        ParentId parentId = new ParentId("id1", "id2");

        Parent p2 = entityManager.find(Parent.class, parentId);
        System.out.println(p2.getName());

        Child child = Child.builder().name("nicekkong's son").parent(p2).build();
        entityManager.persist(child);

        System.out.println(child.getParent().getName());
        System.out.println(child.getName());


        System.out.println("===================Embedded ID=======================");
        EmbeddedParentId eId = EmbeddedParentId.builder().id1(1).id2("nickname").build();
        EmbeddedParent ep = EmbeddedParent.builder().id(eId).nickName("nicekkong").build();

        entityManager.persist(ep);



    }
}
