public class Student extends User {
    Student(String name, int roll) {
        super(name, roll);
    }

    void enrollCourse(int courseNum) {
        this.courseList.add(Main.allCourses.get(courseNum-1));
        getCourseList();
    }

    @Override
    void getCourseList() {
        System.out.print(this.name + "님이 신청하신 강의는 ");
        super.getCourseList();
    }
}
