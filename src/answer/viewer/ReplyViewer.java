package answer.viewer;

import answer.controller.ReplyController;
import answer.model.ReplyDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ReplyViewer {
    private ReplyController replyController;
    private Scanner scanner;
    private UserViewer userViewer;

    public ReplyViewer() {
        replyController = new ReplyController();
        scanner = new Scanner(System.in);
    }

    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }

    public void showReplyUI(int boardId) {
        printList(boardId);

    }

    private void printList(int boardId) {
        ArrayList<ReplyDTO> list = replyController.selectList(boardId);

        if (list.isEmpty()) {
            System.out.println("아직 등록된 댓글이 없습니다.");
        } else {
            for (ReplyDTO r : list) {
                printOne(r);
            }
        }
    }

    private void printOne(ReplyDTO replyDTO) {
        System.out.printf("%d. ", replyDTO.getId());
        userViewer.printNickname(replyDTO.getWriterId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd H:m");
        String formattedTime;
        if (replyDTO.getWrittenDate().compareTo(replyDTO.getUpdatedDate()) == 0) {
            formattedTime = sdf.format(replyDTO.getWrittenDate());
        } else {
            formattedTime = sdf.format(replyDTO.getUpdatedDate());
        }

        System.out.printf(": %s - %s\n", replyDTO.getContent(), formattedTime);
    }

}










