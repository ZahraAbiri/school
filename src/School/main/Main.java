package School.main;


import School.model.Course;
import School.model.School;
import School.model.Teacher;
import School.service.CourseService;
import School.service.SchoolService;
import School.service.TeacherService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static  void main(String[] args) {

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("math", 1));
        courses.add(new Course("computer", 2));
        courses.add(new Course("physic", 3));
        courses.add(new Course("history", 4));
        courses.add(new Course("art", 5));

        List<School> schools = new ArrayList<>();
        schools.add(new School("maktab", 1));
        schools.add(new School("madani", 2));
        schools.add(new School("alavi", 3));
        schools.add(new School("razavi", 3));
        schools.add(new School("jalal", 1));
        schools.add(new School("diba", 1));

        TeacherService teacherService = new TeacherService();
        SchoolService schoolService = new SchoolService();
        CourseService courseService = new CourseService();
        List<Teacher> teachers = teacherService.getTeachers();

        Teacher t1 = teachers.get(0);
        try {
            schoolService.addNewSchool(t1, schools.get(2));
            schoolService.addNewSchool(t1, schools.get(3));
            courseService.addNewCourse(t1, courses.get(2));
            courseService.addNewCourse(t1, courses.get(1));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            printStar();
        }

        try {
            courseService.addNewCourse(t1, courses.get(1));
            courseService.addNewCourse(t1, courses.get(2));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            printStar();
        }

        System.out.println("all schools for " + t1 + " is:");
        t1.getSchool().forEach(System.out::println);
        System.out.println("and courses:");
        t1.getCourse().forEach(System.out::println);
        printStar();

        System.out.println("AVG of full time : " + teacherService.getFullTimeAvrSalary() + "\nmore than avg:");
        teacherService.getTeachersWithHigherThanAverageFullTimeTeachersSalaries().forEach(System.out::println);
        printStar();

        teacherService.getTeachersWithTenExperienceYear().forEach((i, j) -> System.out.println(i + ":" + j));
        printStar();


        t1.getSchool().add(schools.get(0));
        t1.getSchool().add(schools.get(4));
        t1.getSchool().add(schools.get(5));


        Teacher t2 = teachers.get(1);
        t2.getSchool().add(schools.get(2));
        t2.getSchool().add(schools.get(0));


        Teacher t3 = teachers.get(3);
        t3.getSchool().add(schools.get(1));
        t3.getSchool().add(schools.get(4));
        t3.getSchool().add(schools.get(5));


        teacherService.getPartTimeTeachersWithBSDegreeAndMoreThanTwoSchoolDegree().forEach(System.out::println);
        printStar();




        teacherService.getSchoolsWithTeacherInSystem().forEach(System.out::println);
        printStar();

        teacherService.returnPairsArrangedSchoolNameAndTeacherList(schools).forEach((i, j) -> System.out.println(i + ":" + j));
    }

    private static void printStar() {
        System.err.println("***************************************************************");
    }
}
