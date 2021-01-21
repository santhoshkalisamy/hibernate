package com.accolite.hibernateau.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date issuedDate;

    @Column
    private String description;

    @OneToOne
    private Movie movie;

}
