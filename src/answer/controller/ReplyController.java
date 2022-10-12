package answer.controller;

import answer.model.ReplyDTO;

import java.util.ArrayList;
import java.util.Date;

public class ReplyController {
    private ArrayList<ReplyDTO> list;
    private int nextId;

    public ReplyController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    public void add(ReplyDTO replyDTO) {
        replyDTO.setId(nextId++);
        replyDTO.setWrittenDate(new Date());
        replyDTO.setUpdatedDate(replyDTO.getWrittenDate());

        list.add(replyDTO);
    }

    public ArrayList<ReplyDTO> selectList(int boardId) {
        ArrayList<ReplyDTO> temp = new ArrayList<>();

        for (ReplyDTO r : list) {
            if (r.getBoardId() == boardId) {
                temp.add(new ReplyDTO(r));
            }
        }

        return temp;
    }

    public void update(ReplyDTO replyDTO) {
        replyDTO.setUpdatedDate(new Date());
        list.set(list.indexOf(replyDTO), replyDTO);
    }

    public void delete(int id) {
        list.remove(new ReplyDTO(id));
    }

    public void deleteByWriterId(int writerId) {
        ArrayList<ReplyDTO> temp = new ArrayList<>();
        for (ReplyDTO r : list) {
            if (r.getWriterId() != writerId) {
                temp.add(r);
            }
        }

        list = temp;
    }
}
