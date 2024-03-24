package com.example.database.mapper;
import com.example.database.utils.response.UniversalResponse;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.example.database.items.*;

@Mapper
public interface RootMapper {
    @Select("select * from borrower")
    List<Borrower> getBorrower();

    @Select("select * from loan")
    List<Loan> getLoan();

    @Select("select * from payment")
    List<Payment> getPayment();

    @Insert("insert into payment values (#{loan_number}, #{payment_number}, #{payment_datatime}, #{payment_amount})")
    UniversalResponse<?> insertPayment(String loan_number, String payment_number, String payment_datatime, Integer payment_amount);
}
