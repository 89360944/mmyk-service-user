package com.feddon.mmykserviceuser.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Accessors(chain = true)
@DynamicInsert
@DynamicUpdate
@Entity
@Table(uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"name"})
})
@Data
public class Site extends AbstractEntity {

    private String name;

    private String description;

    private String url;

//    @JsonIgnore
//    @OneToMany(mappedBy = "site", cascade = {CascadeType.ALL})
//    private List<Account> account = new ArrayList<>();

}
