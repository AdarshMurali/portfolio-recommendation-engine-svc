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
import java.math.BigInteger;

@Getter
@Setter
@Entity(name="CustomerPreference")
@Table(name="CustomerPreference")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPreference {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name="Customer_Preference_Id", nullable=false)
    private Long customerPreferenceId;

    @Column(name="Investment_Amount", nullable=false)
    private BigInteger investmentAmount;

    @Column(name="Investment_Duration", nullable=false)
    private Integer investmentDuration;

    @Column(name="Investment_Sector", nullable=false)
    private String investmentSector;

    @Column(name="Volatility", nullable=false)
    private String volatility;

    @Column(name="Portfolio_Name", nullable=false)
    private String portfolioName;

    @Column(name="User_Id", nullable=false)
    private Long userId;


}
