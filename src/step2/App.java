package step2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        //exit 문자열 입력 전까지 무한 반복
        while (true) {
            System.out.println("==========================================");

            //1. 양의 정수 2개(0포함) 입력 받기 - 음수는 입력받을 수 없도록 제한
            //예외처리 추가 : 숫자가 아닌 문자가 입력되었을 경우
            Integer num1;
            while (true) {
                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = scanner.nextInt();
                    if (num1 < 0) {
                        System.out.println("0을 포함한 양의 정수만 입력 가능합니다. 다시 입력해주세요.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
                    scanner.nextLine(); //잘못 입력한 값 제거
                }
            }

            Integer num2;
            while (true) {
                try {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = scanner.nextInt();
                    if (num2 < 0) {
                        System.out.println("0을 포함한 양의 정수만 입력 가능합니다. 다시 입력해주세요.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
                    scanner.nextLine(); //잘못 입력한 값 제거
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

            // 3. 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기

            switch (operator) {
                case '+':
                    calculator.sum(num1, num2);
                    break;
                case '-':
                    calculator.minus(num1, num2);
                    break;
                case '*':
                    calculator.multiply(num1, num2);
                    break;
                case '/':
                    calculator.divide(num1, num2);
                    break;
            }

            //저장된 resultsList 값 호출
            System.out.println("저장된 resultsList 값: " + calculator.getResultsList());

//            ///저장된 resultsList에서 원하는 값 삭제
//            System.out.print("resultsList에서 삭제할 값 입력: ");
//            Integer removeValue = scanner.nextInt();
//            calculator.removeResultsList(removeValue);

            ///4. resultsList에서 가장 먼저 저장된 값을 삭제할지 여부 선택
            //while 반복문으로 잘못 입력 시 다시 반복
            while (true){
                System.out.print("resultsList에서 가장 먼저 저장된 값을 삭제하시겠습니까?(y/n) ");
                String removeFirstValue = scanner.next();
                if (removeFirstValue.equals("y")) {
                    //가장 첫 번째 값 삭제 메서드 불러오기
                    calculator.removeFirstValue(removeFirstValue);
                    break;
                } else if (removeFirstValue.equals("n")) {
                    break;
                } else {
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                }
            }//while()

            System.out.print("계산을 계속 진행하시겠습니까?(exit 입력 시 종료) ");

            // ❗nextInt() 뒤에 남아있는 개행 제거
            scanner.nextLine();

            String continueProcess = scanner.nextLine();

            if (continueProcess.equals("exit")) {
                break;
            }

        }//while()

    }//main()
}
