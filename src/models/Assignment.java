/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import scannermethods.ScannerMethods;

/**
 *
 * @author korov
 */
public class Assignment {
    
    private String title;
    private String description;
    private LocalDateTime subDateTime;
    private int oralMark;
    private int totalMark;
    
    //Synthetic Data
    private String[] syntheticTitles = new String[]{"BMI calc","Print Diamond","Miles to Kilometers","Weather app","Quiz app","Contacts app"};
    private String[] syntheticDescription = new String[]{"Create a programm","Create an algorith","Develop a mobile app","Command line application"};
    private String[] syntheticDates = new String[]{"01/04/2020 23:59","05/06/2020 13:00","08/09/2020 17:00","11/12/2020 09:30","31/03/2020 23:59"};
    private int[] syntheticOralMk = new int[]{20,40,30,10};
    private int[] syntheticTotalMk = new int[]{100,80,200,150};

    //Created this default constructor because of the constructor below
    public Assignment() {
    }

    //This constructor makes a DEEP COPY of a assignment object
    public Assignment(Assignment assignment) {
        this.title = assignment.title;
        this.description = assignment.description;
        this.subDateTime = assignment.subDateTime;
        this.oralMark = 0;
        this.totalMark = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDateTime subDateTime) {
        this.subDateTime = subDateTime;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public String[] getSyntheticDates() {
        return syntheticDates;
    }

    @Override
    public String toString() {
        return "Title= " + title + ", Description= " + description + ", Due date= " + ScannerMethods.LocalDateTimeFormatter(subDateTime) + ", Oral Mark= " + oralMark + ", Total Mark= " + totalMark;
    }

    //STATIC create assignment method, called each time the user decides to create an assignment
    public static Assignment createAssignment(){
            Assignment assignment = new Assignment();
            System.out.println("Assignment Title:");
            String assignmentTitle = ScannerMethods.scannerSyntheticString(assignment.syntheticTitles);
            assignment.setTitle(assignmentTitle);
            System.out.println("Assignment Description:");
            String assignmentDescription = ScannerMethods.scannerSyntheticString(assignment.syntheticDescription);
            assignment.setDescription(assignmentDescription);
            System.out.println("Assignment Due date: (dd/MM/yyyy HH:mm) ");
            LocalDateTime dueDate = ScannerMethods.scannerLocalDateTimeForAssignment(assignment.syntheticDates);
            assignment.setSubDateTime(dueDate);
            System.out.println("Assignment Oral mark:");
            int oralMark = ScannerMethods.scannerSyntheticInt(assignment.syntheticOralMk);
            assignment.setOralMark(oralMark);
            System.out.println("Assignment Total mark:");
            int totalMark = ScannerMethods.scannerSyntheticInt(assignment.syntheticTotalMk);
            assignment.setTotalMark(totalMark);
            return assignment;
    }
    
    //STATIC Compare method that checks if an assignment has the same data as another assignment
    public static boolean compareAssignment(ArrayList<Assignment> list, Assignment assignment) {
        if(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getTitle().equals(assignment.title) && list.get(i).getDescription().equals(assignment.description) && list.get(i).getSubDateTime().isEqual(assignment.subDateTime)) {
                    return true;
                }
            }
        }
        return false;
    }
}
