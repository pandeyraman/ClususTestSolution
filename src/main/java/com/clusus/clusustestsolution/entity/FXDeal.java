package com.clusus.clusustestsolution.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_fxdeal")
public class FXDeal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dealId;
    @Column(nullable = false)
    private String fromCurrencyIsoCode;
    private String toCurrencyIsoCode;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dealTimeStamp;
    private double dealAmount;


}
