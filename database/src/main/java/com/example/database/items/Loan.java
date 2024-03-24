package com.example.database.items;
import lombok.Data;

@Data
public class Loan {
    private String loan_number;
    private String branch_name;
    private Integer amount;
    private Integer pay_remain;
    private String payover_date;
}
