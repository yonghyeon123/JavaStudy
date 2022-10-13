package dbboard.viewer;

import java.util.Scanner;
import connector.DBConnector;
import connector.MySqlConnector;
import dbboard.controller.UserController;
import dbboard.model.UserDTO;
import util.ScannerUtil;

public class UserViewer {
    private Scanner scanner;
    private DBConnector dbConnector;
    private UserDTO logIn;

    public UserViewer(){
        scanner = new Scanner(System.in);
        dbConnector = new MySqlConnector();
    }

    //인덱스 화면
    public void showIndex(){
        String message = "1. 로그인 2. 회원가입 3. 종료";

        while(true){
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1){
                logIn();

                if(logIn != null){
                    showMenu();
                }
            }
            else if(userChoice == 2){
                register();
            }
            else if(userChoice == 3){
                System.out.println("사용해주셔서 갑사합니다.");
                break;
            }
        }

    }

    private void register(){
        //회원 가입에 필요한 정보를 저장할 UserDtO 객체
        UserDTO u = new UserDTO();

        String message;

        message = "사용하실 아이디를 입력해주세요.";
        u.setUsername(ScannerUtil.nextLine(scanner, message));

        message = "사용하실 아이디를 입력해주세요.";
        u.setPassword(ScannerUtil.nextLine(scanner, message));

        message = "사용하실 아이디를 입력해주세요.";
        u.setNickname(ScannerUtil.nextLine(scanner, message));

        UserController userController = new UserController(dbConnector);
        //회원가입이 제대로 되지 않았을 경우
        if(!userController.insert(u)){
            System.out.println("잘못된 정보가 존재하여 회원가입을 하지 못하였습니다.");
            message = "다시 가입을 진행하시겠습니까? Y/N";
            String yesNo = ScannerUtil.nextLine(scanner, message);

            if(yesNo.equalsIgnoreCase("Y")){
                //만약 회원가입을 다시 진행시키고 싶다면 자신을 다시 호출
                register();
            }
        }
    }

    private void logIn(){
        String message;

        message = "아이디를 입력해주세요.";
        String username = ScannerUtil.nextLine(scanner, message);

        message = "비밀번호를 입력해주세요.";
        String password = ScannerUtil.nextLine(scanner, message);

        UserController userController = new UserController(dbConnector);
        logIn = userController.auth(username, password);

        if(logIn == null){
            System.out.println("로그인하지 못하였습니다.");
            message = "다시 로그인을 시도하시겠습니까? Y/N";
            String yesNo = ScannerUtil.nextLine(scanner, message);

            if(yesNo.equalsIgnoreCase("Y")){
                logIn();
            }
        }
    }

    private void showMenu(){
        String message = "1. 게시판 이름 2. 회원 정보 보기 3. 로그아웃";
        while(logIn != null){
            int userchoice = ScannerUtil.nextInt(scanner, message);

            if(userchoice == 1){

            }
            else if(userchoice == 2){
                printOne();
            }
            else if(userchoice == 3){
                System.out.println("정삭적으로 로그아웃하였습니다.");
                logIn = null;
            }
        }
    }

    private void printOne(){
        System.out.println("회원 아이디 : " + logIn.getUsername());
        System.out.println("회원 닉네임 : " + logIn.getNickname());

        String message = "1. 정보 수정 2. 회원 탈퇴 3. 뒤로가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if(userChoice == 1){
            update();
        }
        else if(userChoice == 2){
            delete();
        }
    }

    private void update(){
        String message;

        message = "새로운 닉네임을 입력해주세요.";
        String nickname = ScannerUtil.nextLine(scanner, message);

        message = "새로운 비밀번호를 입력해주세요.";
        String password = ScannerUtil.nextLine(scanner, message);

        logIn.setNickname(nickname);
        logIn.setPassword(password);

        UserController userController = new UserController(dbConnector);
        userController.update(logIn);
    }

    private void delete(){
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if(yesNo.equalsIgnoreCase("Y")){
            UserController userController = new UserController(dbConnector);
            userController.delete(logIn.getId());
            logIn = null;
        }
    }
}
