package step1;

import java.util.Scanner;

//STEP 1.  클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기
public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //exit 문자열 입력 전까지 무한 반복
        while (true) {

            //1. 양의 정수 2개(0포함) 입력 받기 - 음수는 입력받을 수 없도록 제한
            Integer num1;
            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = scanner.nextInt();
                if (num1 < 0) {
                    System.out.println("0을 포함한 양의 정수만 입력 가능합니다. 다시 입력해주세요.");
                } else {
                    break;
                }
            }

            Integer num2;
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = scanner.nextInt();
                if (num2 < 0) {
                    System.out.println("0을 포함한 양의 정수만 입력 가능합니다. 다시 입력해주세요.");
                } else {

                    break;
                }
            }

            //2. 사칙연산 기호 입력 -> 입력 및 검증 받기 (수정)

            Character operator;
            while (true) {
                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = scanner.next().charAt(0); //문자열의 0번째 문자를 char 타입으로 변환

                if (operator.equals('+') || operator.equals('-') || operator.equals('*') || operator.equals('/')) {

                    //나눗셈 기호이면서 num2가 0인 경우, 사칙연산 기호 입력 반복
                    if (operator.equals('/') && num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    }
                    else break; //해당하지 않으면 while문 종료

                } else {
                    //사칙연산 기호가 아닌 경우
                    System.out.println("입력하신 기호는 사칙연산 기호가 아닙니다.");
                    continue;
                }
            }


            //3. 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
            int result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.println("결과: " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println("결과: " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println("결과: " + result);
                    break;
                case '/':
                    result = num1 / num2;
                    System.out.println("결과: " + result);
                    break;
            }

            // 4. 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지
            //    무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기

            System.out.print("계산을 계속 진행하시겠습니까?(exit 입력 시 종료) ");

            // ❗nextInt() 뒤에 남아있는 개행 제거
            scanner.nextLine();

            String continueProcess = scanner.nextLine();

            if (continueProcess.equals("exit")) {
                break;
            }

        }//while()

        scanner.close();

    }//main()

}
