package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//STEP 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기
//Enum에서 정의한 내용을 가지고 ArithmeticCalculator에서 활용.
public class ArithmeticCalculator<T extends Number> {

    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private static final ArrayList<Double> resultsList = new ArrayList<>();

    //사칙연산 수행 후, 컬렉션에 저장 && 결과값 반환 메서드
    //세터 - Enum에서 계산 후, 값을 전달 받아 resultsList 컬렉션에 저장
    //// 제네릭 활용
    public double calculation(T num1, T num2, OperatorType operatorType) {
        //모든 타입으로 num1, num2 값을 받아오고
        //double 타입으로 num1, num2를 저장
        double n1 = num1.doubleValue();
        double n2 = num2.doubleValue();

        double result = operatorType.calculation(n1, n2);
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
    public ArrayList<Double> getResultsList() {
        return resultsList;
    }

    //저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
    //Lambda & Stream을 활용
    public void bigResultPrint(double inputValue){
        List<Double> bigResults = resultsList.stream()
                .filter(result -> result > inputValue)
                .collect(Collectors.toList());
        System.out.println(inputValue + "보다 더 큰 결과값 조회: "+ bigResults);
    }


}
