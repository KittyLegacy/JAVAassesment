package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        //TODO----------------
        if ( students.containsKey( studentId ) ) {
            return students.get( studentId );
        }
        return null;
    }

    public boolean showSummary()
    {
        //TODO--------------
        for (String x : students.keySet()) {
            System.out.println(students.get(x));
            System.out.println("Enrolled Courses: ");
            if (students.get(x).getEnrolledCourses().isEmpty()){
                System.out.println("NO COURSE?");
            }
            for (Course course : students.get(x).getEnrolledCourses()) {
                System.out.println(course + "Grade: " + students.get(x).theCourseGrade(course.getCode()));
            }

        }
        return !students.isEmpty();
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO-------------
        if ( students.containsKey( studentId ) ) {
            students.get( studentId ).enrollToCourse( course );
        }
    }
}

