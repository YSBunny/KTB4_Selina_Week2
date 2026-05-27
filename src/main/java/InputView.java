import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public void wantService() {
        while (true) {
            System.out.println("원하시는 서비스의 번호를 입력해주시길 바랍니다.");
            System.out.print("이용하기(1) / 종료하기(2): ");
            int service = scanner.nextInt();
            scanner.nextLine();
            System.out.println("----------------------");

            if (service == 1) { // 이용
                use();
            } else if (service == 2) {  // 종료
                break;
            } else {    // 잘못된 입력
                System.out.println("올바른 번호를 입력해주시길 바랍니다.");
                System.out.println("----------------------");
            }
        }
    }

    private void use() {
        System.out.println("이름을 입력해주시길 바랍니다.");
        System.out.print("이름: ");
        String name = scanner.nextLine();

        while (true) {
            System.out.println("원하시는 서비스의 번호를 입력해주시길 바랍니다.");
            System.out.print("교사(1) / 학생(2) / 게스트 학생(3): ");
            int roll = scanner.nextInt();
            scanner.nextLine();
            System.out.println("----------------------");

            // 교사
            if (roll == 1) {
                Teacher teacher = new Teacher(name, roll);
                createCourseView(teacher); // 강의 등록
                break;
            }
            // 학생
            else if (roll == 2) {
                Student student = new Student(name, roll);
                enrollCourseView(student); // 강의 신청
                break;
            }
            // 게스트 학생
            else if (roll == 3) {
                GuestStudent guestStudent = new GuestStudent(name, roll);
                enrollCourseView(guestStudent); // 강의 신청
                break;
            }
            else {
                System.out.println("올바른 번호를 입력해주시길 바랍니다.");
                System.out.println("----------------------");
            }
        }
    }

    private void createCourseView(Teacher teacher) {
        while (true) {
            System.out.println("등록하실 강의명을 입력해주시길 바랍니다.");
            System.out.println("강의를 등록하고 싶지 않으시다면 '없음'을 입력해주시길 바랍니다.");
            System.out.print("강의명: ");
            String courseName = scanner.nextLine();
            System.out.println("----------------------");

            // 등록 없음
            if (courseName.equals("없음")) {
                return;
            }
            // 등록 있음
            else {
                guestAllowedView(teacher, courseName); // 게스트 신청 가능 여부
            }
        }
    }

    private void enrollCourseView(Student student) {
        while (true) {
            // 강의 목록
            Main.getAllCourses();

            System.out.println("신청하실 강의의 번호를 입력해주시길 바랍니다.");
            System.out.println("강의를 신청하고 싶지 않으시다면 '0'을 입력해주시길 바랍니다.");
            System.out.print("강의 번호: ");
            int courseNum = scanner.nextInt();
            scanner.nextLine();
            System.out.println("----------------------");

            // 신청 없음
            if (courseNum == 0) {
                return;
            }
            // 신청 있음
            else if (courseNum <= Main.allCourses.size() && courseNum > 0) {
                student.enrollCourse(courseNum);
            }
            else {
                System.out.println("올바른 번호를 입력해주시길 바랍니다.");
                System.out.println("----------------------");
            }
        }
    }

    private void guestAllowedView(Teacher teacher, String courseName) {
        while (true) {
            System.out.println(courseName + "을/를 게스트 학생이 신청할 수 있도록 하시겠습니까?");
            System.out.println("신청 가능 여부를 번호로 입력해주시길 바랍니다.");
            System.out.print("예(1) / 아니오(2): ");
            int guestAllowed = scanner.nextInt();
            scanner.nextLine();
            System.out.println("----------------------");

            // 게스트 신청 가능/불가능
            if (guestAllowed == 1 || guestAllowed == 2) {
                teacher.createCourse(courseName, guestAllowed);
                return;
            }
            else {
                System.out.println("올바른 번호를 입력해주시길 바랍니다.");
                System.out.println("----------------------");
            }
        }
    }
}
