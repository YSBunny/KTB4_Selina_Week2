import java.util.ArrayList;
import java.util.Scanner;

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
        TimeOut timeOut = new TimeOut();
        Scanner scanner = new Scanner(System.in);
        OutputView outputView = new OutputView();

        timeOut.start();
        outputView.running(); // 시작

        scanner.close();

        if (timeOut.isAlive()) {
            System.exit(0);
        }
    }
}
