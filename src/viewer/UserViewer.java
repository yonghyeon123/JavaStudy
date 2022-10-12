package viewer;

import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class UserViewer {
    private UserController userController;
    private Scanner scanner;

    public UserViewer(){
        userController = new UserController();
        scanner = new Scanner(System.in);
    }

    public void showMenu(){
        String message = "1. 로그인 2. 회원가입 3. 종료";

        while(true){
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if(userChoice == 1){
                logIn();
            }
            else if(userChoice == 2){
                signUp();
            }
            else if(userChoice == 3){
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private void logIn(){
        ArrayList<UserDTO> list = userController.selectAll();
        String message;

        if(list.isEmpty()){
            System.out.println("로그인하실 수 있는 아이디가 없습니다. 회언가입으로 넘어갑니다.");
            signUp();
        }
        else{
            System.out.println("\n--------------------------");
            System.out.println("로그인 가능한 아이디 목록");
            for(UserDTO u : list){
                System.out.printf("번호 : %d, 아이디 : %s\n", u.getId(), u.getUsername());
            }
            System.out.println("--------------------------\n");

            message = "로그인할 아이디의 번호를 입력하세요.";
            int userInput = ScannerUtil.nextInt(scanner, message);

            message = "해당 아이디의 비밀번호를 입력하시오.";
            int passwordInput = ScannerUtil.nextInt(scanner, message);

            //입력한 번호의 아이디의 비밀번호와 사용자가 입력한 비밀번호가 일치할 때까지
            while(userController.selectOne(userInput).getPassword() != passwordInput){

                message = "비밀번호를 틀리셨습니다. 다시 입력하세요.";
                passwordInput = ScannerUtil.nextInt(scanner, message);
            }

            System.out.println("로그인에 성공하셨습니다.");
            printOne(userInput);
        }
    }

    //회원가입 메소드
    private void signUp(){
        UserDTO userDTO = new UserDTO();
        String message;

        message = "사용하실 아이디를 입력하세요.";
        userDTO.setUsername(ScannerUtil.nextLine(scanner, message));

        message = "사용하실 비밀번호를 입력하세요.";
        userDTO.setPassword(ScannerUtil.nextInt(scanner, message));

        message = "사용하실 닉네임을 입력하세요.";
        userDTO.setNickname(ScannerUtil.nextLine(scanner, message));

        userController.insert(userDTO);
    }

    private void printOne(int id){
        UserDTO u = userController.selectOne(id);

        System.out.println("\n--------------------------");
        System.out.println(u.getNickname() + " 로그인 정보");
        System.out.println("--------------------------");
        System.out.println("사용자 아이디 : " + u.getUsername());
        System.out.println("사용자 패스워드 : " + u.getPassword());
        System.out.println("사용자 닉네임 : " + u.getNickname());
        System.out.println("--------------------------\n");

        String message = "1. 수정 2. 삭제 0. 로그아웃";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if(userChoice == 1){
            update(id);
        }
        if(userChoice == 2){
            delete(id);
        }
        else{
            showMenu();
        }
    }

    private void update(int id){
        UserDTO userDTO = userController.selectOne(id);

        String message = "새 아이디를 입력해주세요.";
        userDTO.setUsername(ScannerUtil.nextLine(scanner, message));

        message = "새 비밀번호를 입력해주세요.";
        userDTO.setPassword(ScannerUtil.nextInt(scanner, message));

        message = "새 닉네임을 입력해주세요.";
        userDTO.setNickname(ScannerUtil.nextLine(scanner, message));

        userController.update(userDTO);

        printOne(id);
    }

    private void delete(int id){
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);
        if(yesNo.equalsIgnoreCase("Y")){
            System.out.println("해당 아이디를 삭제합니다.");
            userController.delete(id);
            logIn();
        }
        else{
            printOne(id);
        }
    }
}
