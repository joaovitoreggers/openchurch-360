package com.adqpsystem.api.worker.entities;


import com.adqpsystem.api.member.entities.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Entity
@Getter
@Table(name = "worker")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Worker {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private boolean active;

    @OneToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false, unique = true)
    private Member member;

    private Worker(String title, Member member) {
        this.title = title;
        this.active = true;
        this.member = member;
    }

    public static @NonNull Worker create(String title, Member member) {
        return new Worker(title, member);
    }

    public void updateTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

}
