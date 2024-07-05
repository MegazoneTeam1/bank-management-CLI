package view;

public class UserView {

    public void reEnter() {
        PrintUtil.println("빈칸으로 입력하셨습니다. 다시 입력해주세요.");
    }

    public String inputName() {
        return PrintUtil.readLine("이름: ");
    }

    public String inputPhoneNumber() {
        return PrintUtil.readLine("전화번호: ");
    }

    public String inputId() {
        return PrintUtil.readLine("아이디: ");
    }

    public String inputPassword() {
        return PrintUtil.readLine("비밀번호(6자리): ");
    }

    public void duplicateId() {
        PrintUtil.println("아이디가 중복이되었습니다. 다시 입력해주세요.");
    }

    public void reEnterPassword() {
        PrintUtil.println("비밀번호 6자리로 설정해주세요.");
    }

    public void successSignup() {
        PrintUtil.println("회원가입에 성공하셨습니다.");
    }

    public void failSignup() {
        PrintUtil.println("회원가입에 실패하셨습니다.");
    }

    public void successLogin() {
        PrintUtil.println("로그인에 성공하였습니다.");
    }

    public void failLogin() {
        PrintUtil.println("로그인에 실패했습니다. 아이디나 비밀번호가 일치하지 않습니다.");
    }

    public String updatePhoneNumberPrint() {
        return PrintUtil.readLine("새 전화번호를 입력 : ");
    }

    public String updatePasswordPrint() {
        return PrintUtil.readLine("새 비밀번호를 입력 : ");
    }
    public void updateUserPrint() {PrintUtil.println("업데이트 완료되었습니다."); }

    public void wrongInput() {
        PrintUtil.println("잘못된 입력입니다.");
        PrintUtil.println("");
    }
}
