package answer.viewer;

import answer.controller.UserController;
import answer.model.UserDTO;
import util.ScannerUtil;

import java.util.Scanner;

public class UserViewer {
    private UserController userController;
    private Scanner scanner;
    private UserDTO logIn;
    private BoardViewer boardViewer;

    public UserViewer() {
        userController = new UserController();
        scanner = new Scanner(System.in);
    }

    public void setBoardViewer(BoardViewer boardViewer) {
        this.boardViewer = boardViewer;
    }

    public void showIndex() {
        String message = "1. 로그인 2. 회원가입 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                logIn();

                if (logIn != null) {
                    boardViewer.setLogIn(logIn);
                    showMenu();
                }


            } else if (userChoice == 2) {
                register();
            } else if (userChoice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    private void showMenu() {
        String message = "1. 게시판 2. 회원 정보 보기 3. 로그아웃";

        while (logIn != null) {
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                boardViewer.showMenu();
            } else if (userChoice == 2) {
                printOne();
            } else if (userChoice == 3) {
                System.out.println("인덱스 화면으로 돌아갑니다.");
                logIn = null;
            }
        }

    }

    private void printOne() {
        System.out.println("회원 번호: " + logIn.getId());
        System.out.println("회원 아이디: " + logIn.getUsername());
        System.out.println("회원 닉네임: " + logIn.getNickname());

        String message = "1. 회원 정보 수정 2. 회원 탈퇴 3. 뒤로 가기";
        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice == 1) {
            update();
        } else if (userChoice == 2) {
            delete();
        }
    }

    private void delete() {
        String message = "정말로 탈퇴하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            message = "비밀번호를 입력해주세요.";
            String password = ScannerUtil.nextLine(scanner, message);

            if (userController.auth(logIn.getUsername(), password) != null) {
                boardViewer.cleanUp(logIn.getId());
                userController.delete(logIn.getId());
                logIn = null;
            }
        }

        if (logIn != null) {
            printOne();
        }

    }

    private void update() {
        String message;

        message = "새로운 비밀번호를 입력해주세요.";
        String newPassword = ScannerUtil.nextLine(scanner, message);

        message = "새로운 닉네임을 입력해주세요.";
        String newNickname = ScannerUtil.nextLine(scanner, message);

        message = "기존 비밀번호를 입력해주세요.";
        String oldPassword = ScannerUtil.nextLine(scanner, message);

        if (userController.auth(logIn.getUsername(), oldPassword) != null) {
            logIn.setPassword(newPassword);
            logIn.setNickname(newNickname);

            userController.update(logIn);
        }
    }

    private void logIn() {
        String message;

        message = "아이디를 입력해주세요.";
        String username = ScannerUtil.nextLine(scanner, message);

        message = "비밀번호를 입력해주세요.";
        String password = ScannerUtil.nextLine(scanner, message);

        logIn = userController.auth(username, password);

        while (logIn == null) {
            System.out.println("잘못된 로그인 정보입니다. 다시 입력해주세요.");
            message = "아이디를 입력해주시거나 뒤로 가실려면 \"X\"를 입력해주세요.";
            username = ScannerUtil.nextLine(scanner, message);

            if (username.equalsIgnoreCase("X")) {
                break;
            }

            message = "비밀번호를 입력해주세요.";
            password = ScannerUtil.nextLine(scanner, message);

            logIn = userController.auth(username, password);
        }
    }

    private void register() {
        String message;

        message = "사용하실 아이디를 입력해주세요.";
        String username = ScannerUtil.nextLine(scanner, message);

        while (username.equalsIgnoreCase("X") || userController.validateUsername(username)) {
            System.out.println("해당 아이디는 사용하실 수 없습니다.");
            message = "다른 아이디나 뒤로 가실려면 \"X\"를 입력해주세요.";
            username = ScannerUtil.nextLine(scanner, message);

            if (username.equalsIgnoreCase("X")) {
                break;
            }
        }

        if (!username.equalsIgnoreCase("X")) {
            message = "비밀번호를 입력해주세요.";
            String password = ScannerUtil.nextLine(scanner, message);

            message = "닉네임을 입력해주세요.";
            String nickname = ScannerUtil.nextLine(scanner, message);

            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(username);
            userDTO.setPassword(password);
            userDTO.setNickname(nickname);

            userController.insert(userDTO);
        }
    }

    public void printNickname(int id) {
        UserDTO temp = userController.selectOne(id);
        System.out.print(temp.getNickname());
    }
}
