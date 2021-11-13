package School.service;


import School.model.School;
import School.model.Teacher;

import java.util.*;
import java.util.stream.Stream;

public class SchoolService {

    List<School> schools = new ArrayList<>();
    public SchoolService() {
        School school =  new School("maktab", 1);
        School school1 = new School("madani", 2);
        School school2 = new School("alavi", 3);
        School school3 = new School("razavi", 3);
        School school4 = new School("jalal", 1);
        School school5 = new School("diba", 1);
    }

    public Set<School> addNewSchool(Teacher teacher, School school) {
        Set<School> teacherSchools = teacher.getSchool();
        if (teacherSchools.contains(school))
            throw new RuntimeException("this teacher already has this school");
        teacherSchools.add(school);
        return teacherSchools;
    }

    public Optional<School> findByName(String name) {
        return schools.stream().filter(i -> i.getName().
                equalsIgnoreCase(name)).findAny();
    }

    public Set<School> add(School school) {
        Set<School> foundedSchool = new HashSet<>();
        foundedSchool.add(school);
        return foundedSchool;
    }
    public Stream<School> findByDegree() {
        return schools.stream().filter(i -> i.getDegree()<=2);
    }

    public School getSchoolBySchoolName(String schoolName){
        Optional<School> schoolOptional=schools.stream().filter(i -> i.getName().equalsIgnoreCase(schoolName)).findFirst();
        return schoolOptional.orElse(null);
    }
}
