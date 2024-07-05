package view;

import domain.Transaction;
import service.TransactionServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionView {

    public void transactionHistoryPrint(Transaction transaction) {
        PrintUtil.print("[ 입금 또는 출금 : " + transaction.getType());
        PrintUtil.print(String.valueOf("거래한 금액 : " + (transaction.getAmount())));
        PrintUtil.print(String.valueOf("거래한 날짜 : " + (transaction.getDate()))+ "]");
    }
}

