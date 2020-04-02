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
public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees;
    private int coursesAttending = 0;
    private ArrayList<Assignment> studentAssign = new ArrayList<>();
    
    //Synthetic Data
    private String[] syntheticFirstNames = new String[]{"Maria","George","Michael","Julie","John","Donald","Alex"};
    private String[] syntheticLastNames = new String[]{"Stevens","Smith","Williams","Jones","Brown","Trump","Peters"};
    private String[] syntheticDates = new String[]{"07/12/1987","22/05/1985","16/09/1982","30/08/1980","01/09/1989"};
    private int[] syntheticTuitionFees = new int[]{2000,2500,2250,1500,1800,1900};

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    //Getter for the array list of each student
    public ArrayList<Assignment> getStudentAssign() {
        return studentAssign;
    }

    //Setter for the array list of each student
    public void setStudentAssign(Assignment studentAssign) {
        this.studentAssign.add(studentAssign);
    }

    public int getCoursesAttending() {
        return coursesAttending;
    }

    public void setCoursesAttending() {
        this.coursesAttending++;
    }

    public String[] getSyntheticDates() {
        return syntheticDates;
    }

    public int[] getSyntheticTuitionFees() {
        return syntheticTuitionFees;
    }

    public String[] getSyntheticFirstNames() {
        return syntheticFirstNames;
    }

    public String[] getSyntheticLastNames() {
        return syntheticLastNames;
    }

    @Override
    public String toString() {
        return "First Name= " + firstName + ", Last Name= " + lastName + ", Birthday= " + ScannerMethods.LocalDateFormatter(dateOfBirth) + ", Fees= " + tuitionFees + "$";
    }
}
