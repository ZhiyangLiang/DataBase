package com.example.database.service;
import com.example.database.items.*;
import java.util.List;
import com.example.database.utils.response.UniversalResponse;


public interface RootService {
    UniversalResponse<List<Borrower>> getBorrower();

    UniversalResponse<List<Loan>> getLoan();

    UniversalResponse<List<Payment>> getPayment();

    UniversalResponse<?> insertPayment(Payment payment);
}
