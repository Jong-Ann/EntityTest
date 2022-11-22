package com.Jong.Pilot.Entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    private String username;
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member(String username) {
        this.username = username;
    }

    //연관관계 설정
    public void setTeam(Team team) {
        this.team = team;
    }
}




