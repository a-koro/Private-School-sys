/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool;

import database.Database;
import models.Assignment;
import models.Trainer;
import models.Student;
import models.Course;
import java.time.LocalDate;
import java.util.ArrayList;
import scannermethods.ScannerMethods;

/**
 *
 * @author korov
 */
public class MainMenu {
    public static void mainMenu(){
        ScannerMethods.clrscr();
        System.out.println("PRIVATE SCHOOL MENU");
        System.out.println("1. Print lists");
        System.out.println("2. Create course");
        System.out.println("3. Add trainer");
        System.out.println("4. Add student");
        System.out.println("5. Add assignment");
        System.out.println("6. Edit student assignment marks");
        System.out.println("7. Exit");
        System.out.println("________________________________");
        int userInput = ScannerMethods.scannerIntMethod();
        if (userInput==1) { //PRINT LISTS MENU
            SubMenu1.subMenu1();
        }
        else if (userInput==2) { //CREATE COURSE
            Course newCourse = Course.createCourse();
            Database.courseList.add(newCourse);
            mainMenu();
        }
        else if (userInput==3) { //CREATE TRAINER
            Trainer trainer = new Trainer();
            System.out.println("Trainers First name:");
            String trainerFirstName = ScannerMethods.scannerSyntheticString(trainer.getSyntheticFirstNames());
            trainer.setFirstName(trainerFirstName);
            System.out.println("Trainers Last name:");
            String trainerLastName = ScannerMethods.scannerSyntheticString(trainer.getSyntheticLastNames());
            trainer.setLastName(trainerLastName);
            System.out.println("Trainers Subject:");
            String trainerSubject = ScannerMethods.scannerSyntheticString(trainer.getSyntheticSubjects());
            trainer.setSubject(trainerSubject);
            //Connect the trainer to a course
            String userInputYorN = "Y";
            while(userInputYorN.equals("Y")){
                if (Database.courseList.isEmpty()) {
                    System.out.println("Create a new course and connect it to the trainer:");
                    Course newCourse = Course.createCourse();
                    newCourse.setCourseTrainers(trainer);
                    Database.courseList.add(newCourse);
                }
                else{
                    System.out.println("Choose an existing course or create a new one:");
                    printLists(Database.courseList);
                    int userInput1 = ScannerMethods.scannerIntMethodWithLimit(Database.courseList.size());
                    if (userInput1>Database.courseList.size()) {
                        Course newCourse = Course.createCourse();
                        newCourse.setCourseTrainers(trainer);
                        Database.courseList.add(newCourse);
                    }
                    else{
                        if (!Database.courseList.get(userInput1-1).getCourseTrainers().contains(trainer)) {
                            Database.courseList.get(userInput1-1).setCourseTrainers(trainer);
                        }
                        else{
                            System.out.println("Trainer already teaches in this course\n");
                        }
                    }
                }
                System.out.println("Do you wan't to choose another course? (Y/N) ");
                userInputYorN = ScannerMethods.scannerYesOrNo();
            }
            Database.trainerList.add(trainer);
            mainMenu();
        }
        else if (userInput==4) { //CREATE STUDENT
            Assignment newAssignment;
            Student student = new Student();
            System.out.println("Students First name:");
            String studentFirstName = ScannerMethods.scannerSyntheticString(student.getSyntheticFirstNames());
            student.setFirstName(studentFirstName);
            System.out.println("Students Last name:");
            String studentLastName = ScannerMethods.scannerSyntheticString(student.getSyntheticLastNames());
            student.setLastName(studentLastName);
            System.out.println("Students Date of birth: (dd/MM/yyyy) ");
            LocalDate studentBday = ScannerMethods.scannerLocalDate(student.getSyntheticDates());
            student.setDateOfBirth(studentBday);
            System.out.println("Students Tuition fees:");
            int tuitionFees = ScannerMethods.scannerSyntheticInt(student.getSyntheticTuitionFees());
            student.setTuitionFees(tuitionFees);
            //At this point the user is asked to attach the student to a course
            String userInputYorN = "Y";
            while(userInputYorN.equals("Y")){
                //If List of courses is empty
                if (Database.courseList.isEmpty()) {
                    System.out.println("Create a new course and connect it to the student:");
                    Course newCourse = Course.createCourse();
                    newCourse.setCourseStudents(student);
                    //In this part the user is asked to add assignments to the course and the student
                    System.out.println("Create a new assignment and connect it to the student:");
                    //A while loop so the user can create more than one assignments to connect to the course and student
                    String userInputYorN4assignment = "Y";
                    while(userInputYorN4assignment.equals("Y")){
                        newAssignment = Assignment.createAssignment();
                        Database.assignmentList.add(newAssignment);
                        newCourse.setCourseAssignment(newAssignment);
                        student.setStudentAssign(new Assignment(newAssignment));
                        System.out.println("Do you wan't to create another assignment? (Y/N)");
                        userInputYorN4assignment = ScannerMethods.scannerYesOrNo();
                    }
                    Database.courseList.add(newCourse);
                }
                //If list of courses in not empty
                else{
                    System.out.println("Choose an existing course or create a new one:");
                    printLists(Database.courseList);
                    int userInput1 = ScannerMethods.scannerIntMethodWithLimit(Database.courseList.size());
                    if (userInput1>Database.courseList.size()) {
                        Course newCourse = Course.createCourse();
                        newCourse.setCourseStudents(student);
                        //In this part the user is asked to add assignments to the course and the student
                        System.out.println("Create a new assignment and connect it to the student:");
                        //A while loop so the user can create more than one assignments to connect to the course and student
                        String userInputYorN4assignment = "Y";
                        while(userInputYorN4assignment.equals("Y")){
                            newAssignment = Assignment.createAssignment();
                            Database.assignmentList.add(newAssignment);
                            newCourse.setCourseAssignment(newAssignment);
                            student.setStudentAssign(new Assignment(newAssignment));
                            System.out.println("Do you wan't to create another assignment? (Y/N)");
                            userInputYorN4assignment = ScannerMethods.scannerYesOrNo();
                        }
                        Database.courseList.add(newCourse);
                    }
                    else{
                        if (!Database.courseList.get(userInput1-1).getCourseStudents().contains(student)) {
                            if (Database.courseList.get(userInput1-1).getCourseAssignment().isEmpty()) {
                                System.out.println("Create a new assignment to connect to the student and the course");
                                //A while loop so the user can create more than one assignments to connect to the course and student
                                String userInputYorN4assignment = "Y";
                                while(userInputYorN4assignment.equals("Y")){
                                    newAssignment = Assignment.createAssignment();
                                    Database.courseList.get(userInput1-1).setCourseAssignment(newAssignment);
                                    Database.assignmentList.add(newAssignment);
                                    student.setStudentAssign(new Assignment(newAssignment));
                                    System.out.println("Do you wan't to create another assignment? (Y/N)");
                                    userInputYorN4assignment = ScannerMethods.scannerYesOrNo();
                                }
                            }
                            else {
                                //A while loop so the user can create or choose more than one assignments to connect to the course and student
                                String userInputYorN4assignment = "Y";
                                while(userInputYorN4assignment.equals("Y")){
                                    System.out.println("Choose an existing assignment or create a new one:");
                                    printLists(Database.courseList.get(userInput1-1).getCourseAssignment());
                                    int userInput2 = ScannerMethods.scannerIntMethodWithLimit(Database.courseList.get(userInput1-1).getCourseAssignment().size());
                                    if (userInput2>Database.courseList.get(userInput1-1).getCourseAssignment().size()) {
                                        newAssignment = Assignment.createAssignment();
                                        Database.courseList.get(userInput1-1).setCourseAssignment(newAssignment);
                                        Database.assignmentList.add(newAssignment);
                                        student.setStudentAssign(new Assignment(newAssignment));
                                    }
                                    else{
                                        if (!Assignment.compareAssignment(student.getStudentAssign(), Database.courseList.get(userInput1-1).getCourseAssignment().get(userInput2-1))) {
                                            student.setStudentAssign(new Assignment(Database.courseList.get(userInput1-1).getCourseAssignment().get(userInput2-1)));
                                        }
                                        else{
                                            System.out.println("Student already has this assignment\n");
                                        }
                                    }
                                    System.out.println("Do you wan't to choose or create another assignment? (Y/N)");
                                    userInputYorN4assignment = ScannerMethods.scannerYesOrNo();
                                }
                            }
                            Database.courseList.get(userInput1-1).setCourseStudents(student);
                        }
                        else{
                            System.out.println("Student already attends to this course\n");
                        }
                    }
                }
                student.setCoursesAttending();
                System.out.println("Do you wan't to choose another course? (Y/N) ");
                userInputYorN = ScannerMethods.scannerYesOrNo();
            }
            Database.studentList.add(student);
            mainMenu();
        }
        else if (userInput==5) { //CREATE ASSIGNMENT
            Assignment newAssignment = Assignment.createAssignment();
            Database.assignmentList.add(newAssignment);
            //Asks the user to connect the assignment to a course
            if (Database.courseList.isEmpty()) {
                System.out.println("Create a new course and connect the assignment to it:");
                Course newCourse = Course.createCourse();
                newCourse.setCourseAssignment(newAssignment);
                Database.courseList.add(newCourse);
            }
            else{
                System.out.println("Choose an existing course or create a new one:");
                printLists(Database.courseList);
                int userInput1 = ScannerMethods.scannerIntMethodWithLimit(Database.courseList.size());
                if (userInput1>Database.courseList.size()) {
                    Course newCourse = Course.createCourse();
                    newCourse.setCourseAssignment(newAssignment);
                    Database.courseList.add(newCourse);
                }
                else{
                    Database.courseList.get(userInput1-1).setCourseAssignment(newAssignment);
                    if(!Database.courseList.get(userInput1-1).getCourseStudents().isEmpty()) {
                        System.out.println("Do you wan't to assign this assignment to every student under this course? (Y/N)");
                        String userYesOrNo = ScannerMethods.scannerYesOrNo();
                        if (userYesOrNo.equals("Y")) {
                            for (int i = 0; i < Database.courseList.get(userInput1-1).getCourseStudents().size(); i++) {
                                Database.courseList.get(userInput1-1).getCourseStudents().get(i).setStudentAssign(new Assignment(newAssignment));
                            }
                        }
                    }
                }
            }
            mainMenu();
        }
        else if (userInput==6) { //EDIT STUDENT MARKS
            if (Database.studentList.isEmpty()) {
                System.out.println("Empty List");
                ScannerMethods.enterToContinue();
                mainMenu();
            }
            else {
                SubMenu1.printListsToChoose(Database.studentList);
                System.out.println("Choose a student:");
                int userInputOfStudent = ScannerMethods.scannerIntMethodWithLimit(Database.studentList.size());
                SubMenu1.printListsToChoose(Database.studentList.get(userInputOfStudent-1).getStudentAssign());
                System.out.println("Choose a assignment:");
                int userInputOfStudent2 = ScannerMethods.scannerIntMethodWithLimit(Database.studentList.get(userInputOfStudent-1).getStudentAssign().size());
                System.out.println("Enter oral mark:");
                int userMarkInput = ScannerMethods.scannerIntMethod();
                Database.studentList.get(userInputOfStudent-1).getStudentAssign().get(userInputOfStudent2-1).setOralMark(userMarkInput);
                System.out.println("Enter total mark:");
                userMarkInput = ScannerMethods.scannerIntMethod();
                Database.studentList.get(userInputOfStudent-1).getStudentAssign().get(userInputOfStudent2-1).setTotalMark(userMarkInput);
                mainMenu();
            }
        }
        else if (userInput==7) { //EXIT PROGRAM
            ScannerMethods.clrscr();
            System.out.println("Good bye.");
            System.exit(0);
        }
        else {
            mainMenu();
        }
    }
    
    //Prints lists so the user can choose to append
    //an existing object to another object
    public static void printLists(ArrayList list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1)+". "+list.get(i));
        }
        System.out.println((list.size()+1)+". Create new");
    }
}
