package view;

public class ViewExample {

    public void showMenu() {
        String[] options = {"회원가입", "로그인", "종료"};
        while (true) {
            PrintUtil.println("은행 관리 시스템");
            PrintUtil.displayMenu(options);
            int choice = PrintUtil.readInt("메뉴를 선택해주세요: ");
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    PrintUtil.println("잘못된 입력입니다.");
                    PrintUtil.println("");
            }
        }
    }

}
