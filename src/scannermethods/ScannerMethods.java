/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scannermethods;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author korov
 */
public class ScannerMethods {
    
    //LocalDateTime scanner method only used in SUBMENU at 10. CHOISE
    //so the user can print students based on assignment submission date
    public static LocalDateTime scannerLocalDateTime(String[] dates) {
        LocalDateTime date;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.nextLine();
            if (!userInput.equals("")) {
                try {
                    date = LocalDateTime.parse(userInput+" 00:00", dateFormatter.withResolverStyle(ResolverStyle.STRICT));
                    break;
                }
                catch(Exception e) {
                    System.out.println("Wrong input, try again.");
                }
            } else {
                date = LocalDateTime.parse(dates[new Random().nextInt(dates.length-1)], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                break;
            }
        }
        return date;
    }
    
    //LocalDateTime scanner method with a ability to parse synthetic data
    //if the user decides not to enter any data
    public static LocalDateTime scannerLocalDateTimeForAssignment(String[] dates){
        LocalDateTime date;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.nextLine();
            if (!userInput.equals("")) {
                try {
                    if (!LocalDate.parse(userInput, dateFormatter.withResolverStyle(ResolverStyle.STRICT)).getDayOfWeek().toString().equals("SATURDAY") && !LocalDate.parse(userInput, dateFormatter.withResolverStyle(ResolverStyle.STRICT)).getDayOfWeek().toString().equals("SUNDAY")) {
                        date = LocalDateTime.parse(userInput, dateFormatter.withResolverStyle(ResolverStyle.STRICT));
                        break;
                    }
                    else {
                        System.out.println("Assignment due dates are from Monday to Friday.\nEnter due date:");
                    }
                }
                catch(Exception e) {
                    System.out.println("Wrong input, try again.");
                }
            } else {
                date = LocalDateTime.parse(dates[new Random().nextInt(dates.length-1)], DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                break;
            }
        }
        return date;
    }
    
    //LocalDateTime formatter method only used by Assignment Class
    public static String LocalDateTimeFormatter(LocalDateTime date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");
        return date.format(dateFormatter);
    }
    
    //A method for local date objects for validating user input of end date of course
    public static LocalDate scannerLocalDate4ValidatingEndDate(String[] dates, LocalDate startDate) {
        LocalDate date;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.nextLine();
            if (!userInput.equals("")) {
                try {
                    date = LocalDate.parse(userInput, dateFormatter.withResolverStyle(ResolverStyle.STRICT));
                    if (date.isAfter(startDate)) {
                        break;
                    }
                    else{
                        System.out.println("Enter a date after course starting date:");
                        continue;
                    }
                }
                catch(Exception e) {
                    System.out.println("Wrong input, try again.");
                }
            } else {
                date = LocalDate.parse(dates[new Random().nextInt(dates.length-1)], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            }
        }
        return date;
    }

    //A method to give the user time before continuing
    public static void enterToContinue() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    //Synthetic scanner date method
    public static Date scannerSyntheticDate(String[] dates) {
        Date date = new Date();
        SimpleDateFormat validation = new SimpleDateFormat("dd/MM/yyyy");
        validation.setLenient(false);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.nextLine();
            if (userInput.equals("")) {
                try {
                    date = validation.parse(dates[new Random().nextInt(dates.length)]);
                    break;
                } catch (ParseException e) {
                    System.out.print("Wrong input, try again: ");
                }
            } else {
                try {
                    date = validation.parse(userInput);
                    break;
                } catch (ParseException e) {
                    System.out.print("Wrong input, try again: ");
                }
            }
        }
        return date;
    }

    public static int scannerSyntheticInt(int[] range) {
        Scanner sc = new Scanner(System.in);
        int syntheticInput;
        while (true) {
            String userInput = sc.nextLine();
            if (userInput.equals("")) {
                syntheticInput = range[new Random().nextInt(range.length)];
                break;
            } else {
                try {
                    syntheticInput = Integer.parseInt(userInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input, try again.");
                }
            }
        }
        return syntheticInput;
    }

    public static void clrscr() {
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

    //Takes string user input and validates it to return the date object created
    public static Date scannerDateMethod() {
        Date date = new Date();
        SimpleDateFormat validation = new SimpleDateFormat("dd/MM/yyyy");
        validation.setLenient(false);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String inputDate = sc.nextLine();
            try {
                date = validation.parse(inputDate);
                break;
            } catch (ParseException e) {
                System.out.print("Wrong input, try again: ");
            }
        }
        return date;
    }

    public static String scannerStringMethod() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    //Takes user input of Y/N and validates it
    public static String scannerYesOrNo() {
        Scanner sc = new Scanner(System.in);
        boolean correctInput = false;
        String userInput;
        while (!correctInput) {
            userInput = sc.next();
            if (userInput.equals("Y") || userInput.equals("N")) {
                correctInput = true;
                return userInput;
            }
            System.out.println("Wrong input, try again.");
        }
        return null;
    }

    //Converts the date object to a simple to read string
    public static String dateFormatter(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String simpleDate = formatter.format(date);
        return simpleDate;
    }

    public static int scannerIntMethod() {
        Scanner sc = new Scanner(System.in);
        //The statement inside the while loop runs an scanner user input
        //at the time it checks the conditional
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("Wrong input, try again.");
        }
        return sc.nextInt();
    }
    
    //New scanner int method that checks with a parameter n if users input is bigger than list shown
    public static int scannerIntMethodWithLimit(int n) {
        int output;
        while(true) {
            int validatedUserIntInput = scannerIntMethod();
            if (validatedUserIntInput>(n+1)) {
                System.out.println("Enter a number inside menu range.");
            }
            else{
                output = validatedUserIntInput;
                break;
            }
        }
        return output;
    }
    
    public static String scannerSyntheticString(String[] range) {
        Scanner sc = new Scanner(System.in);
        String userInput;
        String output;
        while(true){
            userInput = sc.nextLine();
            if (userInput.equals("")) {
                output = range[new Random().nextInt(range.length)];
                break;
            }
            else{
                if (userInput.matches("^[a-zA-Z\\s]*$")) {
                    output = userInput;
                    break;
                }
                else{
                    System.out.println("Wrong input, try again.");
                }
            }
        }
        return output;
    }
    
    //String Scanner method only accepts a-z A-Z 0-9 #+- and speces
    //if user doesnt insert data on input method returns synthetic string
    public static String scannerSynthSymbolStr(String[] range) {
        Scanner sc = new Scanner(System.in);
        String userInput;
        String output;
        while(true){
            userInput = sc.nextLine();
            if (userInput.equals("")) {
                output = range[new Random().nextInt(range.length)];
                break;
            }
            else{
                if (userInput.matches("^[a-zA-Z0-9][a-zA-Z0-9\\#\\-\\s\\+]*$")) {
                    output = userInput;
                    break;
                }
                else{
                    System.out.println("Wrong input, try again.");
                }
            }
        }
        return output;
    }
    
    //LocalDate Scanner Method if input is empty method creates synthetic data and returns it
    public static LocalDate scannerLocalDate(String[] dates) {
        LocalDate date;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.nextLine();
            if (!userInput.equals("")) {
                try {
                    date = LocalDate.parse(userInput, dateFormatter.withResolverStyle(ResolverStyle.STRICT));
                    break;
                }
                catch(Exception e) {
                    System.out.println("Wrong input, try again.");
                }
            } else {
                date = LocalDate.parse(dates[new Random().nextInt(dates.length-1)], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            }
        }
        return date;
    }
    
    //Formats LocalDate Objects and returns them as a string
    public static String LocalDateFormatter(LocalDate date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        return date.format(dateFormatter);
    }
    
    //LocalDate Scanner Method if input is empty method creates synthetic data and returns it
    public static LocalDate scannerLocalDateForAssignment(String[] dates) {
        LocalDate date;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.nextLine();
            if (!userInput.equals("")) {
                if (!LocalDate.parse(userInput, dateFormatter.withResolverStyle(ResolverStyle.STRICT)).getDayOfWeek().toString().equals("SATURDAY") && !LocalDate.parse(userInput, dateFormatter.withResolverStyle(ResolverStyle.STRICT)).getDayOfWeek().toString().equals("SUNDAY")) {
                    try {
                        date = LocalDate.parse(userInput, dateFormatter.withResolverStyle(ResolverStyle.STRICT));
                        break;
                    }
                    catch(Exception e) {
                        System.out.println("Wrong input, try again.");
                    }
                }
                else {
                    System.out.println("Assignment due dates are from Monday to Friday.\nEnter due date:");
                }
            } else {
                date = LocalDate.parse(dates[new Random().nextInt(dates.length-1)], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            }
        }
        return date;
    }
    
}
