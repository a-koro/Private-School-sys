/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author korov
 */
public class Trainer {
    
    private String firstName;
    private String lastName;
    private String subject;
    private String[] syntheticFirstNames = new String[]{"Maria","George","Michael","Julie","John","Donald","Jimmie"};
    private String[] syntheticLastNames = new String[]{"Stevens","Smith","Williams","Jones","Brown","Trump","Roberts"};
    private String[] syntheticSubjects = new String[]{"OOP","Databases","Spring BOOT","Django","Flask"};

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String[] getSyntheticFirstNames() {
        return syntheticFirstNames;
    }

    public String[] getSyntheticLastNames() {
        return syntheticLastNames;
    }

    public String[] getSyntheticSubjects() {
        return syntheticSubjects;
    }

    @Override
    public String toString() {
        return "First Name= " + firstName + ", Last Name= " + lastName + ", Subject= " + subject;
    }
    

}
