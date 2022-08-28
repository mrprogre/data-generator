package com.avandy.dataset.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Row {
    private int num;
    private int intData;
    private long longData;
    private String human;
    private int age;
    private double doubleData;
    private String car;
    private String color;
    private String country;
    private int orderCount;
    private double orderAmountSum;
    private LocalDate lastPurchaseDate;
}
