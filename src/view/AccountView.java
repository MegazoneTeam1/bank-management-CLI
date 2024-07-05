package view;

import domain.Account.Account;

public class AccountView {

    public void startPrint() {
        PrintUtil.println("계좌를 생성하겠습니다.");
    }

    public String startGetAccountNumber() {
        return PrintUtil.readLine("변경하고 싶은 게좌번호를 입력해주세요 : ");
    }

    public void printAccount(int accountNumber) {
        PrintUtil.println("생성된 계좌번호는 " + accountNumber + " 입니다.");
    }

    public String printPassword() {
        return PrintUtil.readLine("비밀번호 설정 (4자리) :");
    }

    public String printPasswordAgain() {
        return PrintUtil.readLine("4자리가 아닙니다.\n다시 입력해주세요. : ");
    }

    public String printCheckPassword() {
        return PrintUtil.readLine("비밀번호 재확인 : ");
    }

    public void printAccountCreateSuccess() {
        PrintUtil.println("계좌 생성이 완료 되었습니다. ");
    }

    public void wrongPassword() {
        PrintUtil.println("설정한 비밀번호와 일치하지 않습니다.");
    }

    public void startBalancePrint(String userId) {
        PrintUtil.println(userId + "의 잔액조회입니다.");
    }

    public void printBalance(String accountNumber, Double balance) {
        PrintUtil.println(accountNumber + "의 잔액은 " + balance);
    }

    public void printTotalBalance(Double totalBalance) {
        PrintUtil.println("  총 액은 " + totalBalance + "입니다.");
    }

    public String printSetName() {
        return PrintUtil.readLine("계좌의 이름을 적어주세요 : ");
    }

    public void printNullError() {
        PrintUtil.println("NULL : 없습니다.");
    }

    public void printAccountList(Account account) {
        PrintUtil.println("---------------------------------");
        PrintUtil.println("         " + account.getName() + "(" + account.getAccountNumber() + ")"
            + "\n         잔액 : " + account.getBalance());
    }
}
