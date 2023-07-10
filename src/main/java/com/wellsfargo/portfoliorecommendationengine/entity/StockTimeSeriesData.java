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
    private Integer ID;
    private Integer S_No;
    private String Symbol;
    private String open;
    private String high;
    private String low;
    private String close;
    private String refreshed;
    private String adjusted_close;
    private String volume ;
    private String dividend_amount ;
    private String split_coefficient;
}
