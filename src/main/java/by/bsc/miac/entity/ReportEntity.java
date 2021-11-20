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
    private int id;

    @Column(name = "produce_all")
    private int produceAll;

    @Column(name = "produce_month")
    private int produceMonth;

    @Column(name = "onvr_all")
    private int onvrAll;

    @Column(name = "onvr_month")
    private int onvrMonth;

    @Column(name = "export_unit_all")
    private int exportUnitAll;

    @Column(name = "export_unit_month")
    private int exportUnitMonth;

    @Column(name = "export_money_all")
    private int exportMoneyAll;

    @Column(name = "export_money_month")
    private int exportMoneyMonth;

    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_organization")
    private OrganizationEntity organizationEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_material")
    private MaterialEntity materialEntity;

}
