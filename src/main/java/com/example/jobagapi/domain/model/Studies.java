package com.example.jobagapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "studies")
public class Studies extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 30)
    private String name;

    @NotNull
    private Long degree;

    //Relación
    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@JoinColumn(name = "studies_id", nullable = false)
    //@JsonIgnore
    //private ProfessionalProfile professionalProfile;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "studies")
    private List<ProfessionalProfile> professionalprofiles;

    public Long getId() {
        return id;
    }

    public Studies setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Studies setName(String name) {
        this.name = name;
        return this;
    }

    public Long getDegree() {
        return degree;
    }

    public Studies setDegree(Long degree) {
        this.degree = degree;
        return this;
    }
}
