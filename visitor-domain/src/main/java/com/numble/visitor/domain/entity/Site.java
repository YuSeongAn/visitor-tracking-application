package com.numble.visitor.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "Site")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String siteRootPath;

    @Builder
    public Site(String siteRootPath) {
        this.siteRootPath = siteRootPath;
    }
}
