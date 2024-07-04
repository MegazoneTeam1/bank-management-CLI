package view;



public class Banking {
    public int bankingService() {

        String[] options = {"계좌 생성", "계좌 조회", "잔액 조회", "입금", "출금", "로그아웃"};
        PrintUtil.println("");
        PrintUtil.println("계좌 관리 시스템");
        PrintUtil.displayMenu(options);
        return PrintUtil.readInt("뭐할거임?");

    }


}
