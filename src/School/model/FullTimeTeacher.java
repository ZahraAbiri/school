package School.model;

import School.enums.Degree;
import School.enums.TeacherType;

import java.util.Objects;
import java.util.Set;

public class FullTimeTeacher extends Teacher {
    private double baseSalary;

    public FullTimeTeacher(String name, String lastName, String personalCode, double baseSalary) {
        super(name, lastName, personalCode);
        this.baseSalary= baseSalary;
    }

    public FullTimeTeacher(String name, String lastName, Degree degree, String personalCode, double baseSalary, Set<Course> course
            , Integer experienceYear, Set<School> school, int age, TeacherType type) {
        super(name,lastName,personalCode,degree,school,experienceYear,course,age,type);

        this.baseSalary = baseSalary;

    }
    public FullTimeTeacher(String name, String lastName, String personalNumber, Degree degree, Integer experienceYear, int age, TeacherType type, double baseSalary) {
        super(name, lastName, personalNumber, degree, experienceYear, age, type);
        this.baseSalary = baseSalary;
    }
    public FullTimeTeacher(String name, String lastName, String personalCode, Degree degree, Set<School> school , int experienceYear, Set<Course> course,double baseSalary, int age,TeacherType type) {
        super(name,lastName,personalCode,degree,school,experienceYear,course,age,type);
        this.baseSalary = baseSalary;

    }
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public Double calculateSalary() {
        return baseSalary - super.calculateInsurance(baseSalary) - super.calculateTax(baseSalary);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FullTimeTeacher that = (FullTimeTeacher) o;
        return Double.compare(that.baseSalary, baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public String toString() {
        return "FullTimeTeacher{" +
                "baseSalary=" + baseSalary +
                "} " + super.toString();
    }
}
