package view;

import java.util.Scanner;

public class AccountView {

    public void startPrint(){
        PrintUtil.println("계좌를 생성하겠습니다.");
    }
    public void printAccount(int accountNumber){
        PrintUtil.println("생성된 계좌번호는 "+accountNumber +" 입니다.");
    }
    public String printPassword(){
        return PrintUtil.readLine("비밀번호 설정 (4자리) :");
    }
    public String printPasswordAgain() {
        return PrintUtil.readLine("4자리가 아닙니다.\n다시 입력해주세요. : ");
    }
    public String printCheckPassword(){
        return PrintUtil.readLine("비밀번호 재확인 : ");
    }
    public void wrongPassword() {
        PrintUtil.print("설정한 비밀번호와 일치하지 않습니다.");
    }

}
