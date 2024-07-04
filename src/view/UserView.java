package view;

// 회원정보 수정 기능
public class UserView {
    public String updatePhoneNumberPrint(){
        String newPhoneNumber = PrintUtil.readLine("새 전화번호를 입력: ");
        return newPhoneNumber;
    }

    public String updatePasswordPrint(){
    String newPassword = PrintUtil.readLine("새 비밀번호를 입력: ");
    return newPassword ;
    }
    public void updateUserPrint() {
        PrintUtil.println("업데이트 완료 되었습니다. ");
    }

}