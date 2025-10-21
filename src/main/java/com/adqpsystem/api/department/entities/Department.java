package com.adqpsystem.api.department.entities;

import com.adqpsystem.api.member.entities.Member;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@ToString
@Getter
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue()
    private UUID id;

    private String  name;
    private String  description;
    private boolean active;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "department_member",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Member> members = new HashSet<>();

    protected Department() {}

    private Department(String name, String description) {
        this.name = name;
        this.description = description;
        this.active = true;
    }

    public static @NonNull Department create(String name, String description) {
        return new Department(name, description);
    }

    public void updateName(String newName) {
        if (newName == null || newName.isEmpty()) {
            throw new IllegalArgumentException("New name cannot be null or empty");
        }
        this.name = newName;
    }

    public void updateDescription(String newDescription) {
        this.description = newDescription;
    }

    public void addMember(Member member) {
        members.add(member);
        member.getDepartments().add(this);
    }

    public void removeMember(Member member) {
        members.remove(member);
        member.getDepartments().remove(this);
    }

    public void active() {
        this.active = true;
    }

    public void inactive() {
        this.active = false;
    }
}
