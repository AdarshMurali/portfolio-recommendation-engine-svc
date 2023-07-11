package com.wellsfargo.portfoliorecommendationengine.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name="StockTimeSeriesDetails")
@Table(name="StockTimeSeriesDetails")
@AllArgsConstructor
@NoArgsConstructor
public class StockTimeSeriesData {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name="Id", nullable=false)
    private Integer ID;
    @Column(name="SNo", nullable=false)
    private Integer S_No;

    @Column(name="Symbol", nullable=false)
    private String Symbol;

    @Column(name="openPrice", nullable=false)
    private String open;

    @Column(name="high", nullable=false)
    private String high;

    @Column(name="low", nullable=false)
    private String low;

    @Column(name="closePrice", nullable=false)
    private String close;

    @Column(name="refreshed", nullable=false)
    private String refreshed;

    @Column(name="adjusted_close", nullable=false)
    private String adjusted_close;

    @Column(name="volume", nullable=false)
    private String volume ;

    @Column(name="dividend_amount", nullable=false)
    private String dividend_amount ;

    @Column(name="split_coefficient", nullable=false)
    private String split_coefficient;
}
