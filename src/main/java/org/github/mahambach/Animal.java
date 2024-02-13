package org.github.mahambach;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@AllArgsConstructor
public class Animal {
    private String name;
    private LocalDate birthDate;

    public long daysToNextBirthday() {
        LocalDate now = LocalDate.now();
        if(birthDate.withYear(LocalDate.now().getYear()).isBefore(LocalDate.now())){
            return LocalDate.now().until(birthDate.withYear(LocalDate.now().getYear() + 1), ChronoUnit.DAYS);
        }
        return LocalDate.now().until(birthDate.withYear(LocalDate.now().getYear()), ChronoUnit.DAYS);
    }
}
