package com.nhnacademy.exam.model.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name = "member")
public class Member {

    @Id
    @NonNull
    private String id;

    @NonNull
    private String name;

}
