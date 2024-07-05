package view;

public class BankingView {
    public int bankingService() {

        String[] options = {"계좌 생성", "계좌 조회", "거래내역조회", "입금", "출금","회원 정보 수정" ,"로그아웃"};
        PrintUtil.println("");
        PrintUtil.println("계좌 관리 시스템");
        PrintUtil.displayMenu(options);
        return PrintUtil.readInt("메뉴를 선택해주세요: ");


    }

}

