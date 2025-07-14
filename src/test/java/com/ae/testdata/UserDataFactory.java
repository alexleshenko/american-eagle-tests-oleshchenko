package com.ae.testdata;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class UserDataFactory {

    public static UserData generateRandomUser() {
        String email = "ol" + UUID.randomUUID() + "@testmail.com";
        String firstName = "John";
        String lastName = "Doe";
        String password = "StrongPass123!";
        String zip = "90210";

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        String birthMonth = months[ThreadLocalRandom.current().nextInt(months.length)];
        String birthDay = String.valueOf(ThreadLocalRandom.current().nextInt(1, 29));

        return new UserData(email, firstName, lastName, password, birthMonth, birthDay, zip);
    }
}
