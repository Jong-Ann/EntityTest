package com.Jong.Pilot;

import com.Jong.Pilot.Entity.Member;
import com.Jong.Pilot.Entity.Team;
import com.Jong.Pilot.Repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class TeamEntityTests {


    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void TeamSetMemberTest(){

        Member member = entityManager.find(Member.class,9);
        Team team = entityManager.find(Team.class,7);

        team.addMember(member);
        teamRepository.save(team);

    }

}
