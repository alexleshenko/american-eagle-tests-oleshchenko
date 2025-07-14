package com.ae.testdata;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class UserDataFactory {

    private static final String[] FIRST_NAMES = {"Alex", "Emma", "John", "Lily", "Chris", "Sophie"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Taylor", "Brown", "Lee", "Wilson"};

    public static UserData generateRandomUser() {
        String shortUUID = UUID.randomUUID().toString().replace("-", "").substring(0, 6);
        String email = "alek" + shortUUID + "@test.com";
        String firstName = getRandomFromArray(FIRST_NAMES);
        String lastName = getRandomFromArray(LAST_NAMES);
        String password = "StrongPass123!";
        String zip = "90210";

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        String birthMonth = months[ThreadLocalRandom.current().nextInt(months.length)];
        String birthDay = String.valueOf(ThreadLocalRandom.current().nextInt(1, 29));

        return new UserData(email, firstName, lastName, password, birthMonth, birthDay, zip);
    }
    private static String getRandomFromArray(String[] array) {
        int index = ThreadLocalRandom.current().nextInt(array.length);
        return array[index];
    }
}
