package view;

public class DepositView {

    // 입금 시작
    public void startDeposit (){
        PrintUtil.println("입금을 시작합니다.");
    }

    // 출금 시작
    public void startWithdraw(){
        PrintUtil.println("출금을 시작합니다");
    }

    // 입금 계좌 입력
    public String depositAccount (){return PrintUtil.readLine("입금할 계좌번호를 입력하세요 : ");}

    // 입금 금액 입력
    public int depositAmount(){return PrintUtil.readInt("입금할 금액을 입력하세요 : ");}

    // 출금 계좌 입력
    public String withdrawAccount (){return PrintUtil.readLine("출금할 계좌번호를 입력하세요 : ");}
    // 출금 계좌 비밀번호
    public String withdrawPassword(){return PrintUtil.readLine("출금 비밀번호를 입력하세요 : ");}
    //출금 금액 입력
    public int withdrawAmount(){
        return PrintUtil.readInt("출금할 금액을 입력하세요 : ");
    }
    // 계좌 번호 불일치
    public void nonSuccessDeposit(){
        PrintUtil.println("계좌가 존재하지 않습니다.");
    }
    // 계좌번호의 비밀번호 불일치
    public void nonEqualPassword(){
        PrintUtil.println("비밀번호가 일치하지 않습니다");
    }
    // 입금 성공
    public void depositSuccess(){PrintUtil.println("입금이 성공적으로 되었습니다.");}
    //잔액부족
    public void insufficientBalance() {PrintUtil.println("잔액이 부족합니다");}
    // 출금 성공
    public void withdrawSuccess(){
        PrintUtil.println("출금이 성공적으로 되었습니다.");
    }
    }










