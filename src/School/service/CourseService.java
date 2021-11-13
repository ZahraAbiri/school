package School.service;


import School.model.Course;
import School.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CourseService {

    List<Course> courses = new ArrayList<>();
    public CourseService() {
        Course course = new Course("math", 1);
        Course course1 = new Course("computer", 2);
        Course course2 = new Course("physic", 3);
        Course course3 = new Course("history", 4);
        Course course4 = new Course("art", 5);
    }


    public Optional<Course> findByName(String name) {
        return courses.stream().filter(i -> i.getName().
                equalsIgnoreCase(name)).findAny();
    }

    public Course add(Course course) {
        Optional<Course> foundedcourse = findByName(course.getName());
        if (!foundedcourse.isPresent())
            throw new RuntimeException("duplicate school");

        courses.add(course);
        return course;
    }
    public void printCourseList(){
        courses.stream().map(i -> i.getCourseNumber()+") "+i.getName()).forEach(System.out::println);
    }

    public Course getCourseByCourseNumber(int courseNumber){

        Optional<Course> courseOptional = courses.stream().filter(i -> i.getCourseNumber()==courseNumber).findFirst();
        return courseOptional.orElse(null);
    }
    public Set<Course> addNewCourse(Teacher teacher, Course course) {
        Set<Course> teacherCourses = teacher.getCourse();
        if (teacherCourses.contains(course))
            throw new RuntimeException("this teacher already has this course");
        teacherCourses.add(course);
        return teacherCourses;
    }


}
