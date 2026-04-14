import java.nio.charset.Charset;
import java.util.Scanner;

import role.Lion;
import role.Role;
import role.Staff;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, Charset.forName(System.getProperty("native.encoding", "UTF-8")));
        Role lion = Lion.scanLion(sc);
        Role staff = Staff.scanStaff(sc);

        System.out.println(lion.describeSelf());
        System.out.println(staff.describeSelf());
    }
}
