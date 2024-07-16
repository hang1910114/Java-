package com.neu.api.utils;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CartItem implements Serializable {

    private long foodId;
    private String name;
    private String photo;
    private String description;
    private int count = 1;
    private BigDecimal price;

    private String flavorItem;
    private String flavorValue;
}
