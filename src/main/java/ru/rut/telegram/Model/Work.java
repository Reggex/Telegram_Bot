package ru.rut.telegram.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "WORK")
public class Work {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "WORK_DATE")
    private Date workDate;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToMany
    @JoinTable(
            name = "WORK_REGION",
            joinColumns = @JoinColumn(name = "WORK_ID"),
            inverseJoinColumns = @JoinColumn(name = "REGION_ID")
    )
    private Set<Region> regions = new HashSet<>();


}
