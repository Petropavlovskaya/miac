package by.bsc.miac.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "material")
public class MaterialEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_unit")
    private UnitEntity unitEntity;
}
