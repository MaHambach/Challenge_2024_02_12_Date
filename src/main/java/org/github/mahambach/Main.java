package org.github.mahambach;

import java.time.format.DateTimeFormatter;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, dd.MM.yyyy");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE dd.MM.yyyy HH:mm");

        //Step 1: Write code to output the current date and time.
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now:          " + now.format(dateTimeFormatter));
        System.out.println();

        //Step 2: Add a timespan of 2 weeks to the current date and output the new date.
        LocalDateTime inTwoWeeks = now.plusWeeks(2);
        System.out.println("In two weeks: " + inTwoWeeks.format(dateTimeFormatter));
        System.out.println();

        //Step 3: Compare the current date with a specified future date and output whether the current date is before or after the specified date.
        LocalDate currentDate = LocalDate.now();
        LocalDate randomDate = LocalDate.of(2030, 12, 24);
        if(currentDate.isBefore(randomDate)){
            System.out.println(currentDate.format(dateFormatter) + " ist vor " + randomDate.format(dateFormatter));
        } else {
            System.out.println(currentDate.format(dateFormatter) + " ist nach " + randomDate.format(dateFormatter));
        }
        System.out.println();

        //Step 4: Calculate the difference in days between two arbitrary dates and output the result.
        LocalDate randomDate1 = LocalDate.of(2001, 1, 27);
        LocalDate randomDate2 = LocalDate.of(2051, 3, 4);
        long daysBetween = ChronoUnit.DAYS.between(randomDate1, randomDate2);
        System.out.println("Tage zwischen " + randomDate1.format(dateFormatter) + " und " + randomDate2.format(dateFormatter) + ": " + daysBetween);
        System.out.println();



        LocalDateTime inTwoWeeksAtNoon = inTwoWeeks.withHour(12).withMinute(0);
        System.out.println("Mittags in zwei Wochen:      " + inTwoWeeksAtNoon.format(dateTimeFormatter));
        System.out.println();

        //Bonus 1: Choosing Data Types
        /*
        Which data format would you choose in Java for these different pieces of information? Name the data type and provide a justification if you want.

            the departure time of an airplane: Instant. Daraus kann sich dann sowohl der Start, als auch der Zielort
                                                die für sich relevante Zeit berechnen, ohne auf die Besonderheiten des
                                                anderen Ortes eingehen zu müssen.

            the times on a bus schedule: LocalTime. Die Zeiten sind unabhängig von einem Datum und können so in einer Liste gespeichert werden.

            when the emergency call arrives at the central office: LocalDateTime. Die Zeit ist in diesem Fall wichtig, aber auch das Datum.

            when Easter takes place in the year 2022: LocalDate. Das Datum ist in diesem Fall wichtig, aber die Zeit nicht.

            how long a ticket with a 1-day validity lasts: LocalDateTime als Endzeitpunkt oder freundlicher LocalDate wenn es unabhängig von der Uhrzeit bis zum Ende des nächsten Tages gelten soll.

            the date next to a signature (contract management software): LocalDate. Die Zeit ist in diesem Fall nicht wichtig.

            when New Year's Eve is (on January 1st at 00:00, regardless of location): LocalDate. Die Zeit ist in diesem Fall nicht wichtig.

            when the video call is: Kommt darauf an, ob es ein internationaler video call sein kann. Wenn ja, dann Instant. Wenn nicht, dann LocalDateTime.

         */

        //Bonus 2:
        Animal animal1 = new Animal("Rocko", LocalDate.of(2019, 12, 24));
        Animal animal2 = new Animal("Ricko", LocalDate.of(2023, 2, 12));
        Animal animal3 = new Animal("Rucko", LocalDate.of(2021, 1, 24));
        Animal animal4 = new Animal("Racko", LocalDate.of(2021, 5, 24));
        System.out.println("Rocko hat in " + animal1.daysToNextBirthday() + " Tagen Geburtstag.");
        System.out.println("Ricko hat in " + animal2.daysToNextBirthday() + " Tagen Geburtstag.");
        System.out.println("Rucko hat in " + animal3.daysToNextBirthday() + " Tagen Geburtstag.");
        System.out.println("Racko hat in " + animal4.daysToNextBirthday() + " Tagen Geburtstag.");
        }
}