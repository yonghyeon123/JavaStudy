package day1005;

import answer.viewer.UserViewer;

// 사용자 관리하는 프로그램을 작성하시오.
// 사용자는
// 사용자 번호(id), 사용자 아이디(username), 사용자 비밀번호(password), 사용자 닉네임(nickname)의 정보가 필요합니다.
// 로그인 기능은 필수적으로 구현되어, 로그인 성공시 자기 자신의 정보를 볼수 있어야 합니다!
public class Ex04User {
    public static void main(String[] args) {
        UserViewer userViewer = new UserViewer();
        userViewer.showIndex();
    }
}
