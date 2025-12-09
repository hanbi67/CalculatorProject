package step2;

import java.util.ArrayList;

//STEP 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
//2. 사칙연산 수행 & 결과값 반환 메서드 구현 & 연산 결과 저장은 Calculator 클래스가 담당.
public class Calculator {

    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private static ArrayList<Integer> resultsList = new ArrayList<>();

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

//    //세터 - 원하는 resultsList 값 제거
//    public void removeResultsList(Integer removeValue) {
//        boolean removeFlag = false;
//
//        //리스트 배열 중에 내가 입력한 값과 같은 값이 있는지 반복하며 찾기
//        for(int i=0; i<resultsList.size(); i++){
//            //removeValue값과 비교하기 위해 resultsList에 들어있는 값을 findListValue에 넣기
//            int findListValue = resultsList.get(i);
//            //만약 동일한 값이 resultsList에 있다면, 해당 값 제거
//            if (findListValue == removeValue){
//                resultsList.remove(i);
//                removeFlag = true;
//                System.out.println("resultsList에서 " + removeValue + "이 삭제되었습니다.");
//                System.out.println("resultsList: " + resultsList);
//                break;
//            }
//        }
//        //만약 동일한 값이 resultsList에 없다면 메세지 출력
//        if (!removeFlag){
//            System.out.println("해당 값이 resultsList 내에 없습니다.");
//        }
//
//    }

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
