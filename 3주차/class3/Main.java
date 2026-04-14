package class3;

import class3.role.Lion;
import class3.role.Member;
import class3.role.Staff;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========= 아기사자 정보 입력 =========");
        System.out.print("이름: "); String lName = sc.nextLine();
        System.out.print("전공: "); String lMajor = sc.nextLine();
        System.out.print("기수: "); int lOrdinal = Integer.parseInt(sc.nextLine());
        System.out.print("파트: "); String lPart = sc.nextLine();
        System.out.print("학번: "); String lId = sc.nextLine();
        Member lion = new Lion(lName, lMajor, lOrdinal, lPart, lId);

        System.out.println("\n========= 운영진 정보 입력 =========");
        System.out.print("이름: "); String mName = sc.nextLine();
        System.out.print("전공: "); String mMajor = sc.nextLine();
        System.out.print("기수: "); int mOrdinal = Integer.parseInt(sc.nextLine());
        System.out.print("파트: "); String mPart = sc.nextLine();
        System.out.print("직책: "); String mPos = sc.nextLine();
        Member staff = new Staff(mName, mMajor, mOrdinal, mPart, mPos);

        System.out.println("\n========= 결과 출력 =========");
        lion.printInfo();
        staff.printInfo();
    }
}