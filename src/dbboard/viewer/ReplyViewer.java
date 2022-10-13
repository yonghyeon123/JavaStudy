package dbboard.viewer;

import connector.DBConnector;
import connector.MySqlConnector;

import java.util.Scanner;

public class ReplyViewer {
    private Scanner scanner;
    private DBConnector connector;

    public ReplyViewer(){
        scanner = new Scanner(System.in);
        connector = new MySqlConnector();
    }

    public void showMenu(){
        String message = "1. 댓글쓰기 2. 댓글 목록 3. 뒤로가기";
    }
}
