package com.example.database.controller;
import com.example.database.items.*;
import com.example.database.service.RootService;
import com.example.database.utils.response.UniversalResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/")
public class RootController {
    @Resource
    private RootService rootService;

    @GetMapping("/borrower")
    @ResponseBody
    public UniversalResponse<List<Borrower>> getBorrower() {
        for (Borrower borrower : rootService.getBorrower().getData()) {
            System.out.println(borrower);
        }
        return rootService.getBorrower();
    }

    @GetMapping("/loan")
    @ResponseBody
    public UniversalResponse<List<Loan>> getLoan() {
        for (Loan loan : rootService.getLoan().getData()) {
            System.out.println(loan);
        }
        return rootService.getLoan();
    }

    @GetMapping("/payment")
    @ResponseBody
    public UniversalResponse<List<Payment>> getPayment() {
        for (Payment payment : rootService.getPayment().getData()) {
            System.out.println(payment);
        }
        return rootService.getPayment();
    }

    @PostMapping("/insert")
    @ResponseBody
    public UniversalResponse<?> insertPayment(@RequestBody Payment payment) {
//        System.out.println(payment.getLoan_number());
//        System.out.println(payment.getPayment_number());
//        System.out.println(payment.getPayment_datetime());
//        System.out.println(payment.getPayment_amount());

        return rootService.insertPayment(payment);
    }
}
