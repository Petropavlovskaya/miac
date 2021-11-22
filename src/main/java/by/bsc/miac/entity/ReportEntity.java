package by.bsc.miac.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "report")
public class ReportEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "produce_all")
    private float produceAll;

    @Column(name = "produce_month")
    private float produceMonth;

    @Column(name = "onvr_all")
    private float onvrAll;

    @Column(name = "onvr_month")
    private float onvrMonth;

    @Column(name = "export_unit_all")
    private float exportUnitAll;

    @Column(name = "export_unit_month")
    private float exportUnitMonth;

    @Column(name = "export_money_all")
    private float exportMoneyAll;

    @Column(name = "export_money_month")
    private float exportMoneyMonth;

    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_organization")
    private OrganizationEntity organizationEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_material")
    private MaterialEntity materialEntity;

}
