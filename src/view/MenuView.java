package view;

public class MenuView {

    public int showMenu() {
        String[] options = {"회원가입", "로그인", "종료"};
        PrintUtil.println("은행 관리 시스템");
        PrintUtil.displayMenu(options);
        return PrintUtil.readInt("메뉴를 선택해주세요: ");
    }

}
