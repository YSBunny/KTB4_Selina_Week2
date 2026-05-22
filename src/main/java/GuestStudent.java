public class GuestStudent extends Student {
    GuestStudent(String name, int roll) {
        super(name, roll);
    }

    @Override
    void enrollCourse(int courseNum) {
        // 신청 가능
        if (Main.guestAllowedList.get(courseNum-1)) {
            super.enrollCourse(courseNum);
        }
        // 신청 불가능
        else {
            System.out.println(Main.allCourses.get(courseNum-1) + "은/는 게스트 학생이 신청하실 수 없습니다.");
            System.out.println("----------------------");
        }
    }
}
