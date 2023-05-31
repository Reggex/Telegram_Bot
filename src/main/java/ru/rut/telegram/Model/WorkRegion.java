package ru.rut.telegram.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "WORK_REGION")
public class WorkRegion {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "WORK_ID")
    private Work work;

    @ManyToOne
    @JoinColumn(name = "REGION_ID")
    private Region region;

    @Column(name = "STATE")
    @Enumerated(value = EnumType.STRING)
    private RegionState state;
}
