package com.Jong.Pilot.Entity;


import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    private String name;

    @OneToMany(mappedBy = "team")
    List<Member> members = new ArrayList<>();

    public void addMember(Member members){
        this.members.add(members);
    }

    public Team(String name) {
        this.name = name;
    }


}
