package answer;

import answer.viewer.BoardViewer;
import answer.viewer.UserViewer;

import java.util.ArrayList;

public class BoardMain {
    public static void main(String[] args) {
        UserViewer userViewer = new UserViewer();
        BoardViewer boardViewer = new BoardViewer();

        userViewer.setBoardViewer(boardViewer);
        boardViewer.setUserViewer(userViewer);

        userViewer.showIndex();

    }
}


















