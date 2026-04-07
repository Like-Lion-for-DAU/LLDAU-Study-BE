package package1;

public class Lion {

    public String name; //어디서든 접근가능
    String major; //같은 패키지 내에서만 접근 가능(default)
    private int generation; //Lion 클래스 내부에서만 접근 가능

    //생성자: 이름 전공 기수를 받아 초기화
    public Lion(String name, String major, int generation){
        this.name=name;
        this.major=major;
        this.generation=generation;

    }

    //유효성 검증 메소드 (Step2 에서 활용)
    public boolean isValid(){
        System.out.println("객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");

        // 이름 검증: null이거나 빈 문자열("")인지 확인
        if (name == null || name.isEmpty()) {
            System.out.println("이름이 비어 있습니다.");
            return false;
        }

        // 전공 검증: null이거나 빈 문자열인지 확인
        if (major == null || major.isEmpty()) {
            System.out.println("전공이 비어 있습니다.");
            return false;
        }

        // 기수 검증: 정수형이므로 1보다 작은지 숫자 비교
        if (generation < 1 ) {
            System.out.println("기수는 1보다 작을 수 없습니다.");
            return false;
        }

        // 모든 조건 통과 시 true 반환
        return true;
    }

    // 정보 출력 메서드
    public void printInfo() {
        System.out.println("아기사자 정보를 출력합니다.");
        System.out.print("이름: " + name + " | ");
        System.out.print("전공: " + major + " | ");
        System.out.print("기수: " + generation + " | ");
    }
}
