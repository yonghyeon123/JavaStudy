package day1006;
// 자바에서는 기본적으로 시간을 관리하는 클래스를 여러 가지를 제공해주고 있는데
// 그중에서 Date은 가장 조상님격인 클래스로써
// 지금은 deprecated(=형용사 신조어 중요도가 떨어져 더 이상 사용되지 않고 앞으로는 사라지게 될 (컴퓨터 시스템 기능 등))된
// 클래스이지만 기본적인 사용법을 알아야 다른 클래스를 사용할 때에도 편하다.
// Date은 내부 필드로 long time 이라는 친구가 있는데
// 그리니치 표준시 기준 1900년 1월 1일 0시 0분 0.00초를 기준으로 하여 이후는 + 이전은 -로 long 값을 가지고 있고
// 그걸 토대로 해서 시간을 표시하게 된다.

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Ex01DateTime {
    public static void main(String[] args) {
        // Date 객체 선언 및 초기화
        Date d = new Date();
        System.out.println(d);

        // Date 객체에 우리가 새로운 날짜를 저장할 때에는
        // 연월일시분초에 대한 setter 메소드를 실행시키면 된다.
        d.setYear(2002);
        System.out.println(d);

        d.setMonth(-1);
        System.out.println(d);
        // 결국 개발자가 헷갈리게 됨으로써 Date는 deprecated 클래스가 되었읍니다... ㅠㅠ

        // 그 다음으로 나온 시간 관련 클래스가 바로 Calendar 클래스이다.
        // 캘린더 클래스 객체는 캘린더 클래스의 static 메소드인 getInstance() 라는 메소드를 통해서 초기화가 된다.
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

        // 캘린더 객체에 시간을 저장할 때에는?
        cal.set(Calendar.YEAR, 2002);
        System.out.println(cal);

        // Date 객체나 Calendar 객체의 시간을 우리가 원하는 형식으로 출력할 때에는
        // SimpleDateFormat 클래스 객체를 사용해서 우리가 특정 형식으로 출력이 가능해진다.
        SimpleDateFormat sdf = new SimpleDateFormat("yy년 M월 d일 H시 m분 s초");

        // 이 SimpleDateFormat 객체를 사용하면 날짜를 우리가 지정한 형식대로 바꾼 String 값을 얻거나
        // 반대로 String 값을 Date 객체로 변환도 가능하다.
        // Date나 Calendar 객체를 특정 형식으로 변환해서 출력해보자
        System.out.println(sdf.format(d));
        System.out.println(sdf.format(cal.getTime()));

        // 결론적으로 가장 마지막에는 우리가 LocalDateTime 이라는 클래스 객체를 사용하여 시간을 관리하여 하지만
        // 웹 프로그래밍에서는 상대적으로 사용빈도가 적다.

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        // LocalDateTime의 시간을 우리가 원하는 형식으로 뽑아낼 때에는
        // DateTimeFormatter 라는 클래스 객체를 사용하게 된다!
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH:mm:ss.SSS");
        System.out.println(formatter.format(ldt));

        // LocalDateTime을 특정 시간으로 초기화할 때에는 우리가
        // LocalDateTime 클래스의 of() 스태틱 메소드를 통하여 시간을 초기화한다.
        ldt = LocalDateTime.of(2002, 3, 4, 0, 0);
        System.out.println(formatter.format(ldt));


    }
}














