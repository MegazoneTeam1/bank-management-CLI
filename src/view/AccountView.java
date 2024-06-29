package view;

import java.util.Scanner;

public class AccountView {

    public void startPrint(){
        PrintUtil.println("계좌를 생성하겠습니다.");
    }
    public void printAccount(int accountNumber){
        PrintUtil.println("생성된 계좌번호는 "+accountNumber +" 입니다.");
    }

    public String printPw(){
        return PrintUtil.readLine("비밀번호 입력 (4자리) :");
    }
    public String printPwAgain() {
        return PrintUtil.readLine("잘못입력하셨습니다.\n다시 입력해주세요. : ");
    }
    public String printCheckPw(){
        return PrintUtil.readLine("비밀번호 한번 더 입력해주세요 : ");
    }
    public void wrongPw() {
        PrintUtil.print("입력하신 비밀번호와 같지 않습니다.");
    }

}
