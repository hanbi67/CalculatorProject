package step1;

import java.util.Scanner;

//STEP 1.  클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기
public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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

        //2. 사칙연산 기호 입력받기
        System.out.print("사칙연산 기호를 입력하세요: ");
        Character operator = scanner.next().charAt(0); //문자열의 0번째 문자를 char 타입으로 변환

        System.out.println("입력 받은 기호: " + operator);

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
                if (num2==0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    break;
                }
                result = num1 / num2;
                System.out.println("결과: " + result);
                break;
            default:
                System.out.println("입력하신 기호는 사칙연산 기호가 아닙니다.");
                break;
        }


    }

}
