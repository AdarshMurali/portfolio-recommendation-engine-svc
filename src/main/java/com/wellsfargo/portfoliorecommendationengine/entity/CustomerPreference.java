package com.wellsfargo.portfoliorecommendationengine.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name="CustomerPreference")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPreference {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long customerpreferenceid;

    private BigInteger investment_amount;

    private Integer age;

    private Integer investment_duration;

    private String investment_sector;

    private String market_capitalization;

    private String portfolio_rate_of_return;

    private Long userid;


}
