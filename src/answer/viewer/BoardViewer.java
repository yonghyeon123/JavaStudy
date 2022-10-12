package answer.viewer;

import answer.controller.BoardController;
import answer.model.BoardDTO;
import answer.model.UserDTO;
import util.ScannerUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardViewer {
    private BoardController boardController;
    private Scanner scanner;
    private UserDTO logIn;
    private UserViewer userViewer;

    private final String DATE_FORMAT_STRING = "yy-MM-dd HH:mm:ss";
    private final SimpleDateFormat SDF = new SimpleDateFormat(DATE_FORMAT_STRING);

    public BoardViewer() {
        boardController = new BoardController();
        scanner = new Scanner(System.in);
    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void showMenu() {
        String message = "1. 새 글 작성 2. 글 목록 보기 3. 뒤로가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message);
            if (userChoice == 1) {
                writeBoard();
            } else if (userChoice == 2) {
                printList();
            } else if (userChoice == 3) {
                System.out.println("메인 화면으로 돌아갑니다.");
                break;
            }
        }
    }

    private void writeBoard() {
        BoardDTO b = new BoardDTO();

        String message;

        message = "글의 제목을 입력해주세요.";
        b.setTitle(ScannerUtil.nextLine(scanner, message));

        message = "글의 내용을 입력해주세요.";
        b.setContent(ScannerUtil.nextLine(scanner, message));

        b.setWriterId(logIn.getId());

        boardController.add(b);
    }

    private void printList() {
        ArrayList<BoardDTO> list = boardController.selectAll();

        if (list.isEmpty()) {
            System.out.println("아직 작성된 게시글이 없습니다.");
        } else {
            for (BoardDTO b : list) {
                System.out.printf("%d. %s - ", b.getId(), b.getTitle());
                userViewer.printNickname(b.getWriterId());
                System.out.println();
            }

            String message = "상세보기할 글의 번호나 뒤로 가실려면 0을 입력해주세요.";
            int userInput = ScannerUtil.nextInt(scanner, message);

            while (userInput != 0 && boardController.selectOne(userInput) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userInput = ScannerUtil.nextInt(scanner, message);
            }

            if (userInput != 0) {
                printOne(userInput);
            }
        }
    }

    private void printOne(int id) {
        BoardDTO b = boardController.selectOne(id);

        System.out.println("글 번호: " + b.getId());
        System.out.println("글 제목: " + b.getTitle());
        System.out.print("작성자: ");
        userViewer.printNickname(b.getWriterId());
        System.out.println();
        System.out.println("작성일: " + SDF.format(b.getWrittenDate()));
        System.out.println("수정일: " + SDF.format(b.getUpdatedDate()));
        System.out.println("내용");
        System.out.println("---------------------------");
        System.out.println(b.getContent());
        System.out.println("---------------------------\n");

        String message;
        if (b.getWriterId() == logIn.getId()) {
            message = "1. 수정 2. 삭제 3. 뒤로가기";
        } else {
            message = "1. 댓글 달기 2. 댓글 수정/삭제 3. 뒤로가기";
        }

        int userChoice = ScannerUtil.nextInt(scanner, message);

        if (userChoice == 1) {
            if (b.getWriterId() == logIn.getId()) {
                update(id);
            } else {
                // 댓글 작성 메소드 실행
            }
        } else if (userChoice == 2) {
            if (b.getWriterId() == logIn.getId()) {
                delete(id);
            } else {
                // 댓글 수정/삭제 메소드 실행
            }
        } else {
            printList();
        }

    }

    private void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            boardController.delete(id);
            printList();
        } else {
            printOne(id);
        }
    }

    private void update(int id) {
        BoardDTO b = boardController.selectOne(id);

        String message;

        message = "새로운 제목을 입력해주세요.";
        b.setTitle(ScannerUtil.nextLine(scanner, message));

        message = "새로운 내용을 입력해주세요.";
        b.setContent(ScannerUtil.nextLine(scanner, message));

        boardController.update(b);

        printOne(id);
    }

    public void cleanUp(int writerId) {
        System.out.println("회원님이 탈퇴하시면서 작성하셨던 모든 글은 삭제되었습니다.");
        boardController.deleteByWriterId(writerId);
    }
}
