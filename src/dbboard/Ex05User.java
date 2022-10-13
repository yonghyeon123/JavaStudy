package dbboard;
// 6시까지
// MySql을 사용하여 사용자를 관리하는 프로그램을 작성하시오.
// 단, 기존 MVC 패턴을 사용한 프로그램을 보지 않고 만드시오.

import dbboard.controller.UserController;
import dbboard.viewer.UserViewer;

public class Ex05User {
    public static void main(String[] args) {
        UserViewer userViewer = new UserViewer();
        userViewer.showIndex();
    }
}
