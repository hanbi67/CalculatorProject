package step1;

import java.util.Scanner;

//STEP 1.  클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기
public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //양의 정수 2개(0포함) 입력 받기 - 음수는 입력받을 수 없도록 제한
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

        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);


    }
}
