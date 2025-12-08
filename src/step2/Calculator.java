package step2;

import java.util.ArrayList;
import java.util.Scanner;


//STEP 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
//1. 사칙연산을 수행 후, 결과값 반환 메서드 구현 & 연산 결과를 저장하는 컬렉션 타입 필드를 가진 Calculator 클래스를 생성
public class Calculator {

    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    ArrayList<Integer> resultsList = new ArrayList<>();

    //사칙연산 수행 후, 컬렉션에 저장 && 결과값 반환 메서드
    //세터 - 값을 전달 받아 resultsList 컬렉션에 저장
    public void sum(int num1, int num2) {
        int sumResult = num1 + num2;
        resultsList.add(sumResult);
        //return sumResult;
    }
    public void minus(int num1, int num2) {
        int minusResult = num1 - num2;
        resultsList.add(minusResult);
        //return minusResult;
    }
    public void multiply(int num1, int num2) {
        int mulResult = num1 * num2;
        resultsList.add(mulResult);
        //return mulResult;
    }
    public void divide(int num1, int num2) {
        int divResult = num1 / num2;
        resultsList.add(divResult);
        //return divResult;
    }
    
    //게터 - 요청 시 resultsList 컬렉션 값 조회
    public ArrayList<Integer> getResultsList() {
        return resultsList;
    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        //양의 정수(0 포함)와 연산 기호를 매개변수로 받아 사칙연산 기능 수행
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

        // 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기

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



        
    }//main()
}
