package School.model;

import School.enums.Degree;
import School.enums.TeacherType;

import java.util.Objects;
import java.util.Set;

public class PartTimeTeacher extends Teacher {

    private int hourlySalary;
    private int hourPerMonth;

    public PartTimeTeacher(String name, String lastName, Degree degree, String personalCode, int hourPerMonth, int hourlySalary, Set<Course> course
    , Integer experienceYear, Set<School> school, int age, TeacherType type) {
        super(name,lastName,personalCode,degree,school,experienceYear,course,age,type);

        this.hourlySalary = hourlySalary;
        this.hourPerMonth = hourPerMonth;
    }

    public PartTimeTeacher(String name, String lastName, String personalNumber, Degree degree, Integer experienceYear,
                           int age, TeacherType type, int hourlySalary, int hourPerMonth) {
        super(name, lastName, personalNumber, degree, experienceYear, age, type);
        this.hourlySalary = hourlySalary;
        this.hourPerMonth = hourPerMonth;
    }

    public PartTimeTeacher(String name, String lastName, String personalCode, Degree degree, Set<School> school , int experienceYear, Set<Course> course, int hourPerMonth, int hourlySalary, int age,TeacherType type) {
        super(name,lastName,personalCode,degree,school,experienceYear,course,age,type);
        this.hourlySalary = hourlySalary;
        this.hourPerMonth = hourPerMonth;

    }

    public int getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(int hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public int getHourPerMonth() {
        return hourPerMonth;
    }

    public void setHourPerMonth(int hourPerMonth) {
        this.hourPerMonth = hourPerMonth;
    }

    @Override
    public Double calculateSalary() {
        double baseSalary = hourlySalary * hourPerMonth;
        return baseSalary - super.calculateInsurance(baseSalary) - super.calculateTax(baseSalary);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PartTimeTeacher that = (PartTimeTeacher) o;
        return hourlySalary == that.hourlySalary && hourPerMonth == that.hourPerMonth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlySalary, hourPerMonth);
    }

    @Override
    public String toString() {
        return "PartTimeTeacher{" +
                "hourlySalary=" + hourlySalary +
                ", hourPerMonth=" + hourPerMonth +
                "} " + super.toString();
    }
}
