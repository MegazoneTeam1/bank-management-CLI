package view;

public class DepositeView {

    // 입금 시작
    public void startDeposite (){
        PrintUtil.println("입금을 시작합니다.");
    }

    // 출금 시작
    public void startWithdraw(){
        PrintUtil.println("출금을 시작합니다");
    }

    // 입금 계좌 입력
    public String depositeAccount (){
       return PrintUtil.readLine("입금할 계좌번호를 입력하세요 :");
    }

    // 입금 금액 입력
    public int depositeAmount(){
        return PrintUtil.readInt("입금할 금액을 입력하세요");
    }

    // 출금 계좌 입력
    public String withdrawAccount (){
        return PrintUtil.readLine("출금할 계좌번호를 입력하세요: ");
    }
    // 출금 계좌 비밀번호
    public String withdrawPassword(){
        return PrintUtil.readLine("출금 비밀번호를 입력하세요:");
    }
    //출금 금액 입력
    public int withdrawAmount(){
        return PrintUtil.readInt("출금할 금액을 입력하세요");
    }
    // 입금 성공
    public void depositsuccess(){
         PrintUtil.println("입금이 성공적으로 되었습니다.");

    }

    // 출금 성공
    public void withdrawSuccess(){
        PrintUtil.println("출금이 성공적으로 되었습니다.");
    }
    }









