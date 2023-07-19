package com.wellsfargo.portfoliorecommendationengine.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecommendedSecurities {

    private String tickerSymbol;
    private String security;
    private String secFilings;
    private String gicsSector;
    private String gicsSubIndustry;
    private String dateFirstAdded;
    private String addressOfHeadQuarters;
    private String cik;
}
