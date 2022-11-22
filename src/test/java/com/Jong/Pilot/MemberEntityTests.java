package com.Jong.Pilot;


import com.Jong.Pilot.Entity.Member;
import com.Jong.Pilot.Entity.Team;
import com.Jong.Pilot.Repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class MemberEntityTests {


    @Autowired
    private MemberRepository memberRepository;


    @Autowired
    private EntityManager entityManager;

    @Test
    public void firstMemberTest(){
        Team teamFirst = entityManager.find(Team.class,7);
        Member member = new Member("Hope");
        member.setTeam(teamFirst);
        Member saveMember = memberRepository.save(member);

    }

    @Test
    public void anotherTest(){

        Team teamFind = entityManager.find(Team.class,7);
        Member member = entityManager.find(Member.class,9);

        member.setTeam(teamFind);
        Member saveMember = memberRepository.save(member);

    }

}
