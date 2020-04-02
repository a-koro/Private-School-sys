/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import java.util.ArrayList;
import scannermethods.ScannerMethods;
/**
 *
 * @author korov
 */
public class Course {
    
    private String title;
    private String stream;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<Trainer> courseTrainers = new ArrayList<>();
    private ArrayList<Student> courseStudents = new ArrayList<>();
    private ArrayList<Assignment> courseAssignment = new ArrayList<>();
    
    //Synthetic Data
    private String[] syntheticTitle = new String[]{"CS50","CB06","Machine Learning","Artificial Intelligence","CB10"};
    private String[] syntheticStream = new String[]{"Java","C#","Javascript"};
    private String[] syntheticType = new String[]{"Part-time","Full-time"};
    private String[] syntheticStartDates = new String[]{"31/01/2020","15/03/2020","01/02/2020","04/04/2020","17/02/2020"};
    private String[] syntheticEndDates = new String[]{"01/06/2020","18/09/2020","29/10/2020","12/11/2020","28/08/2020"};

    public Course() {
    }

    public Course(String title, String stream, String type, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
            this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
            this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
            this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Trainer> getCourseTrainers() {
        return courseTrainers;
    }

    public void setCourseTrainers(Trainer courseTrainers) {
        this.courseTrainers.add(courseTrainers);
    }

    public ArrayList<Student> getCourseStudents() {
        return courseStudents;
    }

    public void setCourseStudents(Student courseStudents) {
        this.courseStudents.add(courseStudents);
    }

    public ArrayList<Assignment> getCourseAssignment() {
        return courseAssignment;
    }

    public void setCourseAssignment(Assignment courseAssignment) {
        this.courseAssignment.add(courseAssignment);
    }

    @Override
    public String toString() {
        return "Title= " + title + ", Stream= " + stream + ", Type= " + type + ", Start Date= " + ScannerMethods.LocalDateFormatter(startDate) + ", End Date= " + ScannerMethods.LocalDateFormatter(endDate);
    }

    //STATIC create course method called each time user wants to create a course
    public static Course createCourse() {
            Course course = new Course();
            System.out.print("Course title: ");
            String courseTitle = ScannerMethods.scannerSynthSymbolStr(course.syntheticTitle);
            course.setTitle(courseTitle);
            System.out.print("Course stream: (Java/C#) ");
            String courseStream = ScannerMethods.scannerSynthSymbolStr(course.syntheticStream);
            course.setStream(courseStream);
            System.out.print("Course type: (Part-time/Full-time) ");
            String courseType = ScannerMethods.scannerSynthSymbolStr(course.syntheticType);
            course.setType(courseType);
            System.out.print("Course start date: (dd/MM/yyyy) ");
            LocalDate startDate = ScannerMethods.scannerLocalDate(course.syntheticStartDates);
            course.setStartDate(startDate);
            System.out.print("Course end date: (dd/MM/yyyy) ");
            LocalDate endDate = ScannerMethods.scannerLocalDate4ValidatingEndDate(course.syntheticEndDates, startDate);
            course.setEndDate(endDate);
            return course;
    }
    
}
