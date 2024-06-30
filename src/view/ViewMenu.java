package view;


import domain.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import service.UserService;
import service.UserServiceImpl;


public class ViewMenu {

    UserRepository userRepository = new UserRepositoryImpl();
    UserService userService = new UserServiceImpl();
    AccountView accountView = new AccountView();

    public void showMenu() {
        String[] options = {"회원가입", "로그인", "종료"};
        while (true) {
            PrintUtil.println("은행 관리 시스템");
            PrintUtil.displayMenu(options);
            int choice = PrintUtil.readInt("메뉴를 선택해주세요: ");
            switch (choice) {
                case 1:
                    signup();
                    break;
                case 2:
                    loginMenu();
                    break;
                case 3:
                    return;
                default:
                    PrintUtil.println("잘못된 입력입니다.");
                    PrintUtil.println("");
            }
        }
    }

    public void signup() {
        String name = PrintUtil.readLine("이름: ");
        String phoneNumber = PrintUtil.readLine("전화번호: ");
        String id = PrintUtil.readLine("아이디: ");;

        /** 무한반복문을 통해 비밀번호가 6자리가 아닐경우 다시 설정하고, 6자리가 맞으면 break 를 통해 회원가입이 성공.*/
        String password;

        while (true) {
            password = PrintUtil.readLine("비밀번호(6자리): ");
            if(password.length() == 6) {
                break;
            } else {
                PrintUtil.println("비밀번호 6자리로 설정해주세요.");
            }
        }

        User newuser = new User(name, phoneNumber, id, password);

        /** 새로운 사용자 데이터를 입력받고 리스트에 저장하여 사용자 등록 */
        if(userService.registerUser(newuser)) {
            PrintUtil.println("회원가입에 성공하셨습니다.");
        } else  {
            PrintUtil.println("회원가입에 실패하셨습니다. 아이디가 이미 존재합니다.");
        }

    }

    public void loginMenu() {


        String id = PrintUtil.readLine("아이디: ");
        String password = PrintUtil.readLine("비밀번호: ");

        /** 입력받은 id와 password 를 통해 로그인 성공 실패 확인. */
        /** 로그인에 성공하면 계좌관련 메뉴로 이동, 로그인에 실패하면 return 되어 menu 로 돌아감.*/
        User user = userService.login(id, password);
        if(user == null) {
            PrintUtil.println("로그인에 실패하였습니다. 아이디나 비밀번호가 일치하지 않습니다.");
            return;
        } else
            PrintUtil.println("로그인에 성공하였습니다.");
            accountView.showAccount();
    }

}
