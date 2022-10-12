package day0921;
// 가위바위보 게임
// 가위: 1
// 바위: 2
// 보: 3
// 으로 정하고 사용자와 컴퓨터가 대결을 한다.
// 대결이 끝나면 승리, 무승부, 패배를 계산하여
// 그 판까지의 기록을 출력해준다.
// 또한, 현재 기록 보기 기능을 선택할 경우
// ####전 ####승 ####무 ####패 (승률: ##.##%) 의 형식으로
// 현재 기록을 출력한다.
import java.util.Scanner;
import java.util.Random;
public class Ex11RSP {
    public static void main(String[] args){
        // 상수
        final int OPTION_SCISSOR = 1;
        final int OPTION_ROCK = 2;
        final int OPTION_PAPER = 3;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int win = 0;
        int lose = 0;
        int draw = 0;

        while(true){
            System.out.println("1. 가위바위보 하기 2. 기록 보기 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if(userChoice == 1){
                // 컴퓨터 숫자 결정
                int computerNum = random.nextInt(OPTION_PAPER) + OPTION_SCISSOR;
                // 사용자로부터 1~3 까지의 값을 입력 받는다.
                System.out.println("1. 가위 2. 바위 3. 보");
                System.out.print("> ");
                int userNum = scanner.nextInt();

                while(userNum < OPTION_SCISSOR || userNum > OPTION_PAPER){
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("1. 가위 2. 바위 3. 보");
                    System.out.println("> ");
                    userNum = scanner.nextInt();
                }

                // 각각의 선택을 보여준다.
                if(userNum == OPTION_SCISSOR){
                    System.out.println("사용자의 선택: 가위");
                } else if(userNum == OPTION_ROCK){
                    System.out.println("사용자의 선택: 바위");
                } else if(userNum == OPTION_PAPER){
                    System.out.println("사용자의 선택: 보");
                }

                if(computerNum == OPTION_SCISSOR){
                    System.out.println("컴퓨터의 선택: 가위");
                } else if(computerNum == OPTION_ROCK){
                    System.out.println("컴퓨터의 선택: 바위");
                } else if(computerNum == OPTION_PAPER){
                    System.out.println("컴퓨터의 선택: 보");
                }

                // 결과 계산
                // 1. 사용자가 가위를 골랐을 경우
                // 1-1. 컴퓨터가 가위를 골랐을 경우
                // 1-2. 컴퓨터가 바위를 골랐을 경우
                // 1-3. 컴퓨터가 보를 골랐을 경우
                // 2. 사용자가 바위를 골랐을 경우
                // 2-1. 컴퓨터가 가위를 골랐을 경우
                // 2-2. 컴퓨터가 바위를 골랐을 경우
                // 2-3. 컴퓨터가 보를 골랐을 경우
                // 3. 사용자가 보를 골랐을 경우
                // 3-1. 컴퓨터가 가위를 골랐을 경우
                // 3-2. 컴퓨터가 바위를 골랐을 경우
                // 3-3. 컴퓨터가 보를 골랐을 경우
                
                // vs
                
                // 1. 사용자와 컴퓨터가 같은것을 골랐을 경우
                // 2. 사용자와 컴퓨터가 다른 것을 골랐을 경우
                // 2-1. 사용자가 가위를 골랐을 경우
                // 2-1-1. 컴퓨터가 바위를 골랐을 경우
                // 2-1-2. 컴퓨터가 보를 골랐을 경우
                // 2-2. 사용자가 바위를 골랐을 경우
                // 2-2-1. 컴퓨터가 가위를 골랐을 경우
                // 2-2-2. 컴퓨터가 보를 골랐을 경우
                // 2-3. 사용자가 보를 골랐을 경우
                // 2-3-1. 컴퓨터가 가위를 골랐을 경우
                // 2-3-2. 컴퓨터가 바위를 골랐을 경우

                if(userNum == computerNum){
                    System.out.println("비겼습니다!!");
                    draw++;
                } else {
                    if(userNum == OPTION_SCISSOR){
                        if(computerNum == OPTION_ROCK){
                            lose++;
                            System.out.println("졌습니다. ㅠㅠ");
                        } else if(computerNum == OPTION_PAPER){
                            win++;
                            System.out.println("이겼습니다!!!");
                        }
                    } else if(userNum == OPTION_ROCK){
                        if(computerNum == OPTION_SCISSOR){
                            win++;
                            System.out.println("이겼습니다!!!");
                        } else if(computerNum == OPTION_PAPER){
                            lose++;
                            System.out.println("졌습니다. ㅠㅠ");
                        }
                    } else if(userNum == OPTION_PAPER){
                        if(computerNum == OPTION_SCISSOR){
                            lose++;
                            System.out.println("졌습니다. ㅠㅠ");
                        } else if(computerNum == OPTION_ROCK){
                            win++;
                            System.out.println("이겼습니다!!!");
                        }
                    }
                }


            } else if(userChoice == 2){
                int total = win + lose + draw;

                if(total != 0){
                    double winRate = (double)win / total * 100;
                    System.out.printf("%d전 %d승 %d무 %d패 (승률: %.2f%%)\n", total, win, draw, lose, winRate);
                } else {
                    System.out.println("아직 플레이 기록이 존재하지 않습니다.");
                }

            } else if(userChoice == 3){
                System.out.println("플레이해주셔서 감사합니다.");
                break;
            }

        }
    }
}




















