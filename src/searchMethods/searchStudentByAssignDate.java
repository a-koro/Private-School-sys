/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchMethods;

import models.Student;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author korov
 */
public class searchStudentByAssignDate {
    
    public static void checkDueDate(LocalDateTime date, ArrayList<Student> list) {
        switch (date.getDayOfWeek().toString()) {
            case "MONDAY":
                betweenWeekChecker(date, date.plusDays(6), list);
                break;
            case "TUESDAY":
                betweenWeekChecker(date.minusDays(1), date.plusDays(5), list);
                break;
            case "WEDNESDAY":
                betweenWeekChecker(date.minusDays(2), date.plusDays(4), list);
                break;
            case "THURSDAY":
                betweenWeekChecker(date.minusDays(3), date.plusDays(3), list);
                break;
            case "FRIDAY":
                betweenWeekChecker(date.minusDays(4), date.plusDays(2), list);
                break;
            case "SATURDAY":
                betweenWeekChecker(date.minusDays(5), date.plusDays(1), list);
                break;
            case "SUNDAY":
                betweenWeekChecker(date.minusDays(6), date, list);
                break;
        }
    }
    
//        public static void checkDueDate(LocalDate date, ArrayList<Student> list) {
//        switch (date.getDayOfWeek().toString()) {
//            case "MONDAY":
//                betweenWeekChecker(date, date.plusDays(6), list);
//                break;
//            case "TUESDAY":
//                betweenWeekChecker(date.minusDays(1), date.plusDays(5), list);
//                break;
//            case "WEDNESDAY":
//                betweenWeekChecker(date.minusDays(2), date.plusDays(4), list);
//                break;
//            case "THURSDAY":
//                betweenWeekChecker(date.minusDays(3), date.plusDays(3), list);
//                break;
//            case "FRIDAY":
//                betweenWeekChecker(date.minusDays(4), date.plusDays(2), list);
//                break;
//            case "SATURDAY":
//                betweenWeekChecker(date.minusDays(5), date.plusDays(1), list);
//                break;
//            case "SUNDAY":
//                betweenWeekChecker(date.minusDays(6), date, list);
//                break;
//        }
//    }
        
    public static void betweenWeekChecker(LocalDateTime date1, LocalDateTime date2, ArrayList<Student> list) {
        int studentsFound = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getStudentAssign().size(); j++) {
                if (list.get(i).getStudentAssign().get(j).getSubDateTime().isAfter(date1) && list.get(i).getStudentAssign().get(j).getSubDateTime().isBefore(date2)) {
                    System.out.println(list.get(i));
                    studentsFound++;
                    break;
                }
            }
        }
        if (studentsFound==0) {
            System.out.println("No students with the same assignment submit week as given date found");
        }
    }
    
//    public static void betweenWeekChecker(LocalDate date1, LocalDate date2, ArrayList<Student> list) {
//        int studentsFound = 0;
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).getStudentAssign().size(); j++) {
//                if (list.get(i).getStudentAssign().get(j).getSubDateTime().isAfter(date1) && list.get(i).getStudentAssign().get(j).getSubDateTime().isBefore(date2)) {
//                    System.out.println(list.get(i));
//                    studentsFound++;
//                    break;
//                }
//            }
//        }
//        if (studentsFound==0) {
//            System.out.println("No students with the same assignment submit week as given date found");
//        }
//    }
}
