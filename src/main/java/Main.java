import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

public class Main {
    static ArrayList<String> allCourses = new ArrayList<>();
    static ArrayList<Boolean> guestAllowedList = new ArrayList<>();

    static void getAllCourses() {
        // 등록된 강의 없음
        if (allCourses.isEmpty()) {
            System.out.println("현재 강의가 등록되지 않았습니다.");
            System.out.println("강의가 등록된 이후에 신청해주시길 바랍니다.");
            System.out.println("----------------------");
        }

        // 등록된 강의 있음
        else {
            System.out.println("강의 목록입니다.");

            for (int i = 0; i < allCourses.size(); i++) {
                System.out.println(i+1 + ". " + allCourses.get(i));
            }
            System.out.println("----------------------");
        }
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();
        TimeOutTask timeOutTask = new TimeOutTask();

        timer.schedule(timeOutTask, 10000);

        System.out.println("온라인 강의 시스템입니다.");

        while (true) {
            int service;
            String name;
            int roll;

            // 이용하기 or 종료하기 입력 받기
            System.out.println("원하시는 서비스의 번호를 입력해주시길 바랍니다.");
            System.out.print("이용하기(1) / 종료하기(2): ");
            service = scanner.nextInt();
            scanner.nextLine();
            System.out.println("----------------------");

            // 이용
            if (service == 1) {
                System.out.println("이름을 입력해주시길 바랍니다.");
                System.out.print("이름: ");
                name = scanner.nextLine();
                System.out.println("원하시는 서비스의 번호를 입력해주시길 바랍니다.");
                System.out.print("교사(1) / 학생(2) / 게스트 학생(3): ");
                roll = scanner.nextInt();
                scanner.nextLine();
                System.out.println("----------------------");

                switch (roll) {
                    // 교사
                    case 1:
                        Teacher teacher = new Teacher(name, roll);

                        while (true) {
                            String courseName;

                            // 강의 등록
                            System.out.println("등록하실 강의명을 입력해주시길 바랍니다.");
                            System.out.println("강의를 등록하고 싶지 않으시다면 '없음'을 입력해주시길 바랍니다.");
                            System.out.print("강의명: ");
                            courseName = scanner.nextLine();
                            System.out.println("----------------------");

                            // 등록 없음
                            if (courseName.equals("없음")) {
                                break;
                            }

                            // 등록 있음
                            else {
                                // 게스트 신청 가능 여부
                                while (true) {
                                    int guestAllowed;

                                    System.out.println(courseName + "을/를 게스트 학생이 신청할 수 있도록 하시겠습니까?");
                                    System.out.println("신청 가능 여부를 번호로 입력해주시길 바랍니다.");
                                    System.out.print("예(1) / 아니오(2): ");
                                    guestAllowed = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("----------------------");

                                    // 게스트 신청 가능/불가능
                                    if (guestAllowed == 1 || guestAllowed == 2) {
                                        teacher.createCourse(courseName, guestAllowed);
                                        break;
                                    }

                                    else {
                                        System.out.println("올바른 번호를 입력해주시길 바랍니다.");
                                        System.out.println("----------------------");
                                    }
                                }
                            }
                        }
                        break;

                    // 학생
                    case 2:
                        Student student = new Student(name, roll);

                        while (true) {
                            int courseNum;

                            // 강의 목록
                            getAllCourses();

                            // 강의 신청
                            System.out.println("신청하실 강의의 번호를 입력해주시길 바랍니다.");
                            System.out.println("강의를 신청하고 싶지 않으시다면 '0'을 입력해주시길 바랍니다.");
                            System.out.print("강의 번호: ");
                            courseNum = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("----------------------");

                            // 신청 없음
                            if (courseNum == 0) {
                                break;
                            }

                            // 신청 있음
                            else if (courseNum <= allCourses.size() && courseNum > 0) {
                                student.enrollCourse(courseNum);
                            }

                            else {
                                System.out.println("올바른 번호를 입력해주시길 바랍니다.");
                                System.out.println("----------------------");
                            }
                        }
                        break;

                    // 게스트 학생
                    case 3:
                        GuestStudent guestStudent = new GuestStudent(name, roll);

                        while (true) {
                            int courseNum;

                            // 강의 목록
                            getAllCourses();

                            // 강의 신청
                            System.out.println("신청하실 강의의 번호를 입력해주시길 바랍니다.");
                            System.out.println("강의를 신청하고 싶지 않으시다면 '0'을 입력해주시길 바랍니다.");
                            System.out.print("강의 번호: ");
                            courseNum = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("----------------------");

                            // 신청 없음
                            if (courseNum == 0) {
                                break;
                            }

                            // 신청 있음
                            else if (courseNum <= allCourses.size() && courseNum > 0) {
                                guestStudent.enrollCourse(courseNum);
                            }

                            else {
                                System.out.println("올바른 번호를 입력해주시길 바랍니다.");
                                System.out.println("----------------------");
                            }
                        }
                        break;

                    default:
                        System.out.println("올바른 번호를 입력해주시길 바랍니다.");
                        System.out.println("----------------------");
                        break;
                }
            }
            // 종료
            else if (service == 2) {
                System.out.println("서비스를 종료합니다.");
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }

            else {
                System.out.println("올바른 번호를 입력해주시길 바랍니다.");
                System.out.println("----------------------");
            }
        }

        scanner.close();
    }
}
