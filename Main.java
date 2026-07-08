import java.util.Scanner; // 사용자에게 값을 입력받기 위해 Scanner 기능을 가져옴

// =======================
// 실행 클래스
// =======================
public class Main { // 프로그램을 실행하는 메인 클래스 시작

    public static void main(String[] args) { // 프로그램 시작 지점(main 함수)

        Scanner sc = new Scanner(System.in); // 키보드 입력을 받기 위한 Scanner 객체 생성



        // -----------------------
        // 아기사자 정보 입력
        // -----------------------
        System.out.println("=== 아기사자 정보 입력 ==="); // 안내 문장 출력

        System.out.print("이름: "); // 이름 입력 요청
        String name1 = sc.nextLine(); // 한 줄 입력 받아 name1에 저장

        System.out.print("전공: "); // 전공 입력 요청
        String major1 = sc.nextLine(); // 전공 입력 받아 major1에 저장

        System.out.print("기수(숫자로): "); // 기수 입력 요청
        int generation1 = sc.nextInt(); // 숫자 입력 받아 generation1에 저장

        System.out.print("학번: "); // 학번 입력 요청
        String studentId1 = sc.next(); // 공백 전까지 입력 받아 저장

        System.out.print("파트: "); // 파트 입력 요청
        String part1 = sc.next(); // 공백 전까지 입력 받아 저장

        sc.nextLine(); // nextInt(), next() 후 남아있는 엔터 제거



        // Role 타입 변수에 BabyLion 객체 저장
        // 부모 타입으로 자식 객체를 담음
        Role lion1 = new BabyLion(name1, major1, generation1, studentId1, part1);



        // -----------------------
        // 운영진 정보 입력
        // -----------------------
        System.out.println("\n=== 운영진 정보 입력 ==="); // 줄 바꿈 후 안내 출력

        System.out.print("이름: ");
        String name2 = sc.nextLine();

        System.out.print("전공: ");
        String major2 = sc.nextLine();

        System.out.print("기수(숫자로): ");
        int generation2 = sc.nextInt();

        System.out.print("학번: ");
        String studentId2 = sc.next();

        System.out.print("파트: ");
        String part2 = sc.next();



        // Role 타입 변수에 ManagerLion 객체 저장
        // 부모 타입으로 자식 객체를 담는 다형성 사용
        Role lion2 = new ManagerLion(name2, major2, generation2, studentId2, part2);



        // =======================
        // 결과 출력
        // =======================
        System.out.println("\n===== 결과 출력 ====="); // 결과 안내



        // -----------------------
        // 오버로딩 확인
        // -----------------------
       //서 lion1.info();
        // info() 함수 실행 상속했기에 사용 가능
        // 매개변수가 없는 버전 호출 없어도 된다

        lion1.info("멋쟁이사자처럼");
        // info(String club) 실행 문자열 대입
        // 같은 이름 함수지만 매개변수(문자열)가 다름
        // 이것이 오버로딩



        // -----------------------
        // 오버라이딩 확인
        // -----------------------
        lion1.introduce();
        // lion1 변수 타입은 Lion이지만
        // 실제 객체는 BabyLion
        // 그래서 BabyLion의 introduce() 실행

        lion2.introduce();
        // 실제 객체는 ManagerLion
        // 그래서 ManagerLion의 introduce() 실행



        // -----------------------
        // 인터페이스 다형성
        // -----------------------
        Submit s1 = (Submit) lion1;
        // lion1 객체(BabyLion)는 Submit 인터페이스 구현함
        // 따라서 Submit 타입으로 사용 가능

        Submit s2 = (Submit) lion2;
        // lion2 객체(ManagerLion)도 Submit 구현함



        s1.submitTask();
        // 실제 객체는 BabyLion
        // BabyLion의 submitTask() 실행

        s2.submitTask();
        // 실제 객체는 ManagerLion
        // ManagerLion의 submitTask() 실행



        sc.close(); // 입력 기능 종료
    }
}





// =======================
// 부모 클래스
// =======================
class Role { // 모든 구성원의 공통 정보를 담는 부모 클래스

    String name; // 이름 저장 변수
    String major; // 전공 저장 변수
    int generation; // 기수 저장 변수
    String studentId; // 학번 저장 변수
    String part; // 파트 저장 변수



    Role(String name, String major, int generation,
         String studentId, String part) {
        // 생성자
        // 객체가 만들어질 때 값을 넣어주는 함수

        this.name = name;
        // 현재 객체의 name 변수에 전달받은 name 저장

        this.major = major;
        // 현재 객체의 major 저장

        this.generation = generation;
        // 현재 객체의 generation 저장

        this.studentId = studentId;
        // 현재 객체의 studentId 저장

        this.part = part;
        // 현재 객체의 part 저장
    }



    // -----------------------
    // 오버로딩 1
    // -----------------------
    void info() {
        // 매개변수 없는 info 함수 정보 한번에 프린트

        System.out.println("\n이름: " + name);
        System.out.println("전공: " + major);
        System.out.println("기수: " + generation);
        System.out.println("학번: " + studentId);
        System.out.println("파트: " + part);
    }



    // -----------------------
    // 오버로딩 2
    // -----------------------
    void info(String club) {
        // 매개변수 있는 info 함수
        // 같은 이름이지만 입력값이 다름

        System.out.println(name + " / 소속: " + club);
    }



    // 자식 클래스가 다시 만들 함수
    void introduce() {
        System.out.println("멋쟁이사자처럼 구성원입니다.");
    }
}





// =======================
// 인터페이스 Submit라는 인터페이스 생성
// =======================
interface Submit {

    void submitTask();
    // submitTask라는 함수 이름만 약속함
    // 내용은 없음

    // 이 인터페이스를 사용하는 클래스는
    // 반드시 submitTask()를 만들어야 함
}





// =======================
// 아기사자 클래스
// =======================
class BabyLion extends Role implements Submit {
    // 동시에 써도 되는 extends와 implements
    // extends Role
    // Role 클래스를 상속받음
    // Role의 변수(name 등)와 함수(info 등)를 물려받음
    //그게 그말이다.

    // implements Submit
    // Submit 인터페이스 사용 선언
    // submitTask() 반드시 작성해야 함(정의가 안됐다 값이 필요)



    BabyLion(String name, String major, int generation,
             String studentId, String part) {

        super(name, major, generation, studentId, part);
        // 부모 클래스 Role의 생성자 호출
        // 부모가 가진 변수들을 초기화함(되돌리는 느낌)
    }



    @Override
    void introduce() {
        // 부모의 introduce()를 다시 작성
        // 이것이 오버라이딩

        System.out.println(name + "은(는) 아기사자입니다.");
    }



    @Override
    public void submitTask() {
        // 인터페이스 Submit의 함수 구현(함수 생성)

        System.out.println(name + "이(가) 과제를 제출 할수 있습니다.");
    }
}





// =======================
// 운영진 클래스
// =======================
class ManagerLion extends Role implements Submit {

    // Lion 상속
    // Submit 인터페이스 구현



    ManagerLion(String name, String major, int generation,
                String studentId, String part) {

        super(name, major, generation, studentId, part);
        // 부모 Lion 클래스 가리키기 오버라이딩 당하기 전의 함수 사용을 위해
    }



    @Override
    void introduce() {
        // 부모 함수 재작성(오버라이딩)

        System.out.println(name + "은(는) 운영진입니다.");
    }



    @Override
    public void submitTask() {
        // 인터페이스 함수 구현

        System.out.println(name + "은(는) 운영진이라 제출 대상이 아닙니다.");
    }
}
//한 코드에 다 집어 넣고 보니 더 복잡해 보이긴 하지만 수정 시와 필요 할때 쓸수 있는게 좋은 것 같다.
//인터페이스는 아직 잘 모르겠다.
//오버라이딩 하기 전 함수 쓸라면 super.함수명()으로 부모 함수 호출해야 한다.
//오버로딩에서 매개변수 유무차이