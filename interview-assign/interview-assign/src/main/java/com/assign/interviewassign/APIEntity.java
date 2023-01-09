package com.assign.interviewassign;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Data
public class APIEntity {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @JsonProperty("title")
    String title;
    @JsonProperty("description")
    String description;
    @JsonProperty("auth")
    String auth;
    @JsonProperty("https")
    Boolean https;
    @JsonProperty("cors")
    String cors;
    @JsonProperty("category")
    String category;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}

