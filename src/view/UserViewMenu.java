package view;

import domain.User;
import service.UserService;
import service.UserServiceImpl;

// 회원정보 수정 기능
public class UserViewMenu {
    private UserService userService = new UserServiceImpl();
    private User user;

    public void showUserMenu() {
        String[] options = {"회원가입", "로그인", "회원정보 수정 (1. 전화번호 수정  2.비밀번호 수정)", "종료"};
        while (true) {
            PrintUtil.println("은행 관리 시스템");
            PrintUtil.displayMenu(options);
            int choice = PrintUtil.readInt("메뉴 선택 ㄱㄱ");
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    return;
                default:
                    PrintUtil.println("잘못된 입력입니다");
                    PrintUtil.println("");
            }
        }
    }
    
    private void updateUser(){
        String[] updateOptions = {"전화 번호 수정", "비밀 번호 수정"};
        int updateChoice = PrintUtil.readInt("수정할 항목을 선택해주세요");
        switch (updateChoice) {
            case 1:
                String newPhoneNumber = PrintUtil.readLine("새 전화번호를 입력: ");
                userService.updatePhoneNumber(user, newPhoneNumber);
                PrintUtil.println("전화번호가 업데이트 되었습니다. ");
                break;
            case 2:
                String newPassword = PrintUtil.readLine("새 비밀번호를 입력: ");
                userService.updatePassword(user, newPassword);
                PrintUtil.println("비밀번호가 업데이트 되었습니다. ");
                break;
            default:
                PrintUtil.println("잘못된 입력입니다.");
        }
    }
}