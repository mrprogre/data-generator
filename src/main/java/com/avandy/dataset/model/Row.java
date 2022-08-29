package com.avandy.dataset.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Row {
    private int num;
    private int intData;
    private long longData;
    private String human;
    private byte age;
    private double doubleData;
    private String car;
    private String color;
    private String country;
    private byte orderCount;
    private double orderAmountSum;
    private LocalDate lastOrder;
    private String post;
}
