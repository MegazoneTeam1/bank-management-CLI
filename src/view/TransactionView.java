package view;

import domain.Transaction;
import service.TransactionServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionView {

    public void transactionHistoryPrint(Transaction transaction) {
        PrintUtil.print("[ 입금 또는 출금 유형 : " + transaction.getType());
        PrintUtil.print("    거래한 금액 : " + (transaction.getAmount()));
        PrintUtil.print("    거래한 날짜 : " + (transaction.getDate()));
        PrintUtil.print("    거래 후 잔액 : " + (transaction.getBalance()) + "] \n");
    }

    public String getAccountNumberByClient() {
        return PrintUtil.readLine("조회할 계좌 번호를 입력해주세요 :");
    }
}

