package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private  Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // 읽기 전용이 된다
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Member(String name, Address address, List<Order> orders) {
        this.name = name;
    }
}
