package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Student extends Person implements Evaluation {

    float PASS_MIN_GRADE = 3.0f;
    private List<Course> enrolledCourses;
    private Map <String, Double> courseGrade;

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
        this.enrolledCourses = new ArrayList<>();
        this.courseGrade = new HashMap<>();
    }

    public void enrollToCourse( Course course )
    {
        //TODO------------
        this.enrolledCourses.add(course);
    }

    public void studentCourseGrade (String courseId, Double grade) {
        if (this.findCourseById(courseId) == null) {
            System.out.println("STUDENT NOT ENROLLED IN COURSE?");
                    return;

        }
        this.courseGrade.put(courseId, grade);
    }

    public double theCourseGrade (String courseId) {
        if (this.courseGrade.containsKey(courseId)) {
            Double grade = courseGrade.get(courseId);
            return grade;
        }
        return 0.0f;
    }

    @Override
    public List<Course> findPassedCourses() {
        List<Course> passedCourses = new ArrayList();
        for (Course course : this.enrolledCourses) {
            if (this.courseGrade.containsKey(course.getCode())) {
                Double grade = courseGrade.get(course.getCode());
                if (grade >= this.PASS_MIN_GRADE) {
                    passedCourses.add(course);
                }
            }
        }
        return passedCourses;
    }

    public Course findCourseById( String courseId ) {
        //TODO---------------
        for (int y = 0; y < this.enrolledCourses.size(); ++y) {
            if (((Course) this.enrolledCourses.get(y)).getCode().equals(courseId)) {
                return (Course) this.enrolledCourses.get(y);
            }
        }

        return null;
    }

    @Override
    public List<Course> getEnrolledCourses()
    {
        //TODO
        return this.enrolledCourses;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}
