package step2;

import java.util.ArrayList;

//STEP 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
//2. 사칙연산 수행 & 결과값 반환 메서드 구현 & 연산 결과 저장은 Calculator 클래스가 담당.
public class Calculator {

    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    ArrayList<Integer> resultsList = new ArrayList<>();

    //사칙연산 수행 후, 컬렉션에 저장 && 결과값 반환 메서드
    //세터 - 값을 전달 받아 resultsList 컬렉션에 저장
    public void sum(int num1, int num2) {
        int sumResult = num1 + num2;
        resultsList.add(sumResult);
    }
    public void minus(int num1, int num2) {
        int minusResult = num1 - num2;
        resultsList.add(minusResult);
    }
    public void multiply(int num1, int num2) {
        int mulResult = num1 * num2;
        resultsList.add(mulResult);
    }
    public void divide(int num1, int num2) {
        int divResult = num1 / num2;
        resultsList.add(divResult);
    }
    
    //게터 - 요청 시 resultsList 컬렉션 값 조회
    public ArrayList<Integer> getResultsList() {
        return resultsList;
    }


}
