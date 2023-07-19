package com.wellsfargo.portfoliorecommendationengine.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name="StockBasicDetails")
@Table(name="StockBasicDetails")
@AllArgsConstructor
@NoArgsConstructor
public class StockBasicDetails {

    @Id
    private Integer SNO;
    private String  Symbol;
    private String   AssetType;
    private String  StockName;
    private String StockDescription  ;
    private String Exchange  ;
    private String Currency  ;
    private String Country  ;
    private String Sector  ;
    private String Industry  ;
    private String MarketCapitalization  ;
    private String EBITDA  ;
    private String PERatio  ;
    private String PEGRatio  ;
    private String BookValue  ;
    private String DividendPerShare  ;
    private String DividendYield  ;
    private String EPS  ;
    private String RevenuePerShareTTM  ;
    private String ProfitMargin  ;
    private String OperatingMarginTTM  ;
    private String ReturnOnAssetsTTM  ;
    private String ReturnOnEquityTTM  ;
    private String RevenueTTM  ;
    private String GrossProfitTTM  ;
    private String DilutedEPSTTM  ;
    private String QuarterlyEarningsGrowthYOY  ;
    private String QuarterlyRevenueGrowthYOY  ;
    private String AnalystTargetPrice  ;
    private String TrailingPE  ;
    private String ForwardPE  ;
    private String PriceToSalesRatioTTM  ;
    private String PriceToBookRatio  ;
    private String EVToRevenue  ;
    private String EVToEBITDA  ;
    private String _52WeekHigh  ;
    private String _52WeekLow  ;
    private String _50DayMovingAverage  ;
    private String _200DayMovingAverage  ;

}
