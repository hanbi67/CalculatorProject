package step3;
//연산자 타입에 대한 정보를 관리, switch문으로 연산자를 이용한 계산 관리
public enum OperatorType {
    //enum: 여러 개의 미리 정해진 상수 집합.

    SUM('+'), MINUS('-'), MUL('*'), DIV('/');

    //final인 이유: 연산자 타입을 다른 값으로 바꿀 필요가 없으니 final
    private final char opSymbol;

    //생성자
    OperatorType(char opSymbol) {
        this.opSymbol = opSymbol;
    }

    //게터
    public char getOpSymbol() {
        return opSymbol;
    }

    //enum OperatorType은 연산자 타입의 정보를 정의하는 역할이라 세터는 필요없어보임.

    //App에서 입력받은 문자와 같은 Enum 값이 있는지 반복하며 찾기
    public static OperatorType getOperatorType(char opSymbol) {
        for (OperatorType opType : OperatorType.values()) {
            if (opType.getOpSymbol() == opSymbol) {
                return opType;
            }
        }
        //동일한 값이 Enum에 없다면 예외처리 메세지 출력
        throw new IllegalArgumentException("연산자가 아닙니다: " + opSymbol);
    }

    //사칙연산 수행 기능
    //ArithmeticCalculator 클래스에서 사용됨
    public double calculation(double num1, double num2) {
        switch (this) {
            case SUM:
                return num1 + num2;
            case MINUS:
                return num1 - num2;
            case MUL:
                return num1 * num2;
            case DIV:
                return num1 / num2;
            default:
                throw new IllegalStateException("예상치 못한 값입니다: " + this);
        }
    }


}
