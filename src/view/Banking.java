package view;

public class Banking {
    public void bankingservice() {

        String[] options = {"계좌 생성", "계좌 조회", "잔액 조회", "입금", "출금","로그아웃"};

        while (true) {
            PrintUtil.displayMenu(options);
            int choice = PrintUtil.readInt("뭐할거임?");
            switch(choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    PrintUtil.println("잘못된 입력입니다.");
                    PrintUtil.println("");
            }

        }

    }

}

