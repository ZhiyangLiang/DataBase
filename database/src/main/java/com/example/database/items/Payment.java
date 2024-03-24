package com.example.database.items;
import lombok.Data;

@Data
public class Payment {
    private String loan_number;
    private String payment_number;
    private String payment_datetime;
    private Integer payment_amount;
}
