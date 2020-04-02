/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import models.Assignment;
import models.Trainer;
import models.Student;
import models.Course;
import java.util.ArrayList;

/**
 *
 * @author korov
 */
public class Database {
    public static ArrayList<Course> courseList = new ArrayList<>();
    public static ArrayList<Trainer> trainerList = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static ArrayList<Assignment> assignmentList = new ArrayList<>();
}
