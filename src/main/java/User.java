import java.util.ArrayList;

public class User {
    String name;
    int roll;
    ArrayList<String> courseList = new ArrayList<>();

    User(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    void getCourseList() {
        for (int i = 0; i < this.courseList.size(); i++) {
            System.out.print(courseList.get(i));
            if (i < this.courseList.size() - 1) {
                System.out.print(", ");
            } else if (i == this.courseList.size() - 1) {
                System.out.println("입니다.");
                System.out.println("----------------------");
            }
        }
    }
}
