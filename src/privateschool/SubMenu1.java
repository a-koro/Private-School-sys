/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool;

import database.Database;
import java.time.LocalDateTime;
import java.util.ArrayList;
import scannermethods.ScannerMethods;

/**
 *
 * @author korov
 */
public class SubMenu1 {
    
    //Print lists method for user to observe
    public static void printLists(ArrayList list){
            if (list.size()==0) {
                System.out.println("The list is empty");
            }
            else{
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
            }
            System.out.println("");
            ScannerMethods.enterToContinue();
            subMenu1();
    }
    
    //Print lists method for user to choose from
    public static void printListsToChoose(ArrayList list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1)+". "+list.get(i));
        }
    }
    
    public static void subMenu1(){
        ScannerMethods.clrscr();
        System.out.println("PRIVATE SCHOOL MENU");
        System.out.println("1. Print courses list");
        System.out.println("2. Print trainers list");
        System.out.println("3. Print students list");
        System.out.println("4. Print assignments list");
        System.out.println("5. Print students per course");
        System.out.println("6. Print trainers per course");
        System.out.println("7. Print assignments per course");
        System.out.println("8. Print assignments per student");
        System.out.println("9. Print students that belong to more than one course");
        System.out.println("10. Print students with assignment submission date on the same week as given date");
        System.out.println("11. Return to main menu");
        System.out.println("_____________________________________________");
        int userInput = ScannerMethods.scannerIntMethod();
        if (userInput==1) { //Print courses list
            printLists(Database.courseList);
        }
        else if (userInput==2) { //Print trainers list
            printLists(Database.trainerList);
        }
        else if (userInput==3) { //Print students list
            printLists(Database.studentList);
        }
        else if (userInput==4) { //Print assignments list
            printLists(Database.assignmentList);
        }
        else if (userInput==5) { //Print students per course
            if (Database.courseList.isEmpty()) {
                System.out.println("The list is empty!\n");
                ScannerMethods.enterToContinue();
                SubMenu1.subMenu1();
            }
            else{
                printListsToChoose(Database.courseList);
                System.out.println("Choose a course:");
                int userInput1 = ScannerMethods.scannerIntMethodWithLimit(Database.courseList.size());
                printLists(Database.courseList.get(userInput1-1).getCourseStudents());
                ScannerMethods.enterToContinue();
                SubMenu1.subMenu1();
            }
        }
        else if (userInput==6) { //Print trainers per course
            if (Database.courseList.isEmpty()) {
                System.out.println("The list is empty!\n");
                ScannerMethods.enterToContinue();
                SubMenu1.subMenu1();
            }
            else{
                printListsToChoose(Database.courseList);
                System.out.println("Choose a course:");
                int userInput1 = ScannerMethods.scannerIntMethodWithLimit(Database.courseList.size());
                printLists(Database.courseList.get(userInput1-1).getCourseTrainers());
                ScannerMethods.enterToContinue();
                SubMenu1.subMenu1();
            }
        }
        else if (userInput==7) { //Print assignments per course
            if (Database.courseList.isEmpty()) {
                System.out.println("The list is empty!\n");
                ScannerMethods.enterToContinue();
                SubMenu1.subMenu1();
            }
            else{
                printListsToChoose(Database.courseList);
                System.out.println("Choose a course:");
                int userInput1 = ScannerMethods.scannerIntMethodWithLimit(Database.courseList.size());
                printLists(Database.courseList.get(userInput1-1).getCourseAssignment());
                ScannerMethods.enterToContinue();
                SubMenu1.subMenu1();
            }
        }
        else if (userInput==8) { //Print assignments per student
            if (Database.studentList.isEmpty()) {
                System.out.println("The list is empty!\n");
                ScannerMethods.enterToContinue();
                SubMenu1.subMenu1();
            }
            else{
                printListsToChoose(Database.studentList);
                System.out.println("Choose a student:");
                int userInput1 = ScannerMethods.scannerIntMethodWithLimit(Database.studentList.size());
                printLists(Database.studentList.get(userInput1-1).getStudentAssign());
                ScannerMethods.enterToContinue();
                SubMenu1.subMenu1();
            }
        }
        else if (userInput==9) { //Print students that belong to more than one course
            boolean studentsWith2Courses = false;
            for (int i = 0; i < Database.studentList.size(); i++) {
                if (Database.studentList.get(i).getCoursesAttending()>1) {
                    System.out.println(Database.studentList.get(i));
                    studentsWith2Courses = true;
                }
            }
            if (!studentsWith2Courses) {
                System.out.println("There are no students with more than 1 courses\n");
            }
            ScannerMethods.enterToContinue();
            SubMenu1.subMenu1();
        }
        else if (userInput==10) { //Print students with assignment submition date on the same week as given date
            if (Database.studentList.isEmpty()) {
                System.out.println("The list is empty!\n");
                ScannerMethods.enterToContinue();
                SubMenu1.subMenu1();
            }
            else {
                System.out.println("Enter a date to print the students: (dd/MM/yyyy)");
                LocalDateTime inputDate = ScannerMethods.scannerLocalDateTime(Database.assignmentList.get(0).getSyntheticDates());
                searchMethods.searchStudentByAssignDate.checkDueDate(inputDate, Database.studentList);
                ScannerMethods.enterToContinue();
                SubMenu1.subMenu1();
            }
        }
        else if (userInput==11) { //Return to main menu
            MainMenu.mainMenu();
        }
        else {
            SubMenu1.subMenu1();
        }
    }
}
