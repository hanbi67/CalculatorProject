package step3;

import java.util.ArrayList;

//STEP 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기
//Enum에서 정의한 내용을 가지고 ArithmeticCalculator에서 활용.
public class ArithmeticCalculator {

    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private static ArrayList<Integer> resultsList = new ArrayList<>();

    //사칙연산 수행 후, 컬렉션에 저장 && 결과값 반환 메서드
    //세터 - Enum에서 계산 후, 값을 전달 받아 resultsList 컬렉션에 저장
    public int calculation(int num1, int num2, OperatorType operatorType) {
        int result = operatorType.calculation(num1, num2);
        resultsList.add(result);
        return result;
    }

    //세터
    /// resultsList에 가장 먼저 저장된 데이터를 삭제하는 기능
    public void removeFirstValue(String removeFirstValue){
        //만약 resultsList 내에 값이 존재한다면
        if (resultsList.size() > 0){
            //0번째 인덱스 값 삭제
            resultsList.remove(0);
            System.out.println("resultList: " + resultsList);

        } else {
            //만약 resultsList 내에 값이 존재하지않는다면 메세지 출력
            System.out.println("resultsList에 값이 존재하지 않습니다.");
        }
    }

    //게터 - 요청 시 resultsList 컬렉션 값 조회
    public ArrayList<Integer> getResultsList() {
        return resultsList;
    }

}
