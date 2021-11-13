package School.service;

import School.enums.Degree;
import School.enums.TeacherType;
import School.model.*;


import java.util.*;
import java.util.stream.Collectors;


public class TeacherService {
    List<Teacher> teachers = new ArrayList<>();

    public TeacherService() {
        teachers.add(new PartTimeTeacher("sara", "ahmadi", "0021899436", Degree.BS, new HashSet<School>(),
                2, new HashSet<Course>(), 22, 120000, 120,TeacherType.PART_TIME));
        teachers.add(new PartTimeTeacher("tara", "asadi", "0021234567", Degree.BS, new HashSet<>(),
                0, new HashSet<>(), 14, 40000, 50,TeacherType.PART_TIME));
        teachers.add(new PartTimeTeacher("ali", "alavi", "1131234567", Degree.PHD, new HashSet<>(),
                10, new HashSet<>(), 35, 150000, 29,TeacherType.PART_TIME));
        teachers.add(new FullTimeTeacher("ali", "ahmadi", "1111234567", Degree.MA, new HashSet<>(),
                28, new HashSet<>(), 6200000,20,TeacherType.FULL_TIME));
        teachers.add(new FullTimeTeacher("asad", "alavi", "1121234567", Degree.BS, new HashSet<>(),
                15, new HashSet<>(), 5200000, 38,TeacherType.FULL_TIME));

    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addNewTeacher(Teacher teacher) {
        teachers.add(teacher);
    }



    public Double getAllAvrSalary() {
        Double sum = teachers.stream().map(Teacher::calculateSalary).reduce(0D, Double::sum);
        int count = teachers.size();
        return sum / count;
    }

    public Double getFullTimeAvrSalary() {
        Double sum = teachers.stream().filter(t -> t.getType().equals(TeacherType.FULL_TIME)).map(Teacher::calculateSalary)
                .reduce(0D, Double::sum);
        int count = (int) teachers.stream().filter(t -> t.getType().equals(TeacherType.FULL_TIME)).count();
        return sum / count;
    }

    public List<Teacher> getTeachersWithHigherThanAverageFullTimeTeachersSalaries() {
        return teachers.stream().filter(t -> t.calculateSalary() > getFullTimeAvrSalary()).collect(Collectors.toList());
    }

    public Map<TeacherType, List<Teacher>> getTeachersWithTenExperienceYear() {
        return teachers.stream().filter(t -> t.getExperienceYear() == 10).collect(Collectors.groupingBy(Teacher::getType));
    }

    public List<Teacher> getPartTimeTeachersWithBSDegreeAndMoreThanTwoSchoolDegree() {
        return teachers.stream().filter(t -> t.getType().equals(TeacherType.PART_TIME))
                .filter(t -> t.getDegree().equals(Degree.BS))
                .filter(t -> t.getSchool().stream().anyMatch(school -> school.getDegree() >= 2)).collect(Collectors.toList());
    }

    public Set<School> getSchoolsWithTeacherInSystem() {
        Set<Set<School>> schoolsSet = teachers.stream().map(Teacher::getSchool).filter(school -> !school.isEmpty()).collect(Collectors.toSet());
        Set<School> schools = new HashSet<>();
        for (Set<School> schoolSet : schoolsSet) {
            schools.addAll(schoolSet);
        }
        return schools;
    }

    public Map<School, List<Teacher>> returnPairsArrangedSchoolNameAndTeacherList(List<School> schools) {
        Map<School, List<Teacher>> map = new HashMap<>();
        for (School school : schools) {
            List<Teacher> schoolTeachers = teachers.stream().filter(t -> t.getSchool().contains(school)).collect(Collectors.toList());
            map.put(school, schoolTeachers);
        }
        return map;
    }
}
