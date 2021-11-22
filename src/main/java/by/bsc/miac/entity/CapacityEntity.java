package by.bsc.miac.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "capacity")
public class CapacityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "capacity")
    private float capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_organization")
    private OrganizationEntity organizationEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_material")
    private MaterialEntity materialEntity;
}