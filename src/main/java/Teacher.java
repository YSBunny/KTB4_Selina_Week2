public class Teacher extends User {
    Teacher(String name, int roll) {
        super(name, roll);
    }

    void createCourse(String course, int guestAllowed) {
        this.courseList.add(course);
        Main.allCourses.add(course);

        // 게스트 신청 가능
        if (guestAllowed == 1) {
            Main.guestAllowedList.add(true);
        }
        // 게스트 신청 불가능
        else if (guestAllowed == 2){
            Main.guestAllowedList.add(false);
        }

        getCourseList();
    }

    @Override
    void getCourseList() {
        System.out.print(this.name + "님이 등록하신 강의는 ");
        super.getCourseList();
    }
}
