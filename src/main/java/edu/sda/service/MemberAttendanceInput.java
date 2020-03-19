package edu.sda.service;

import com.sun.jdi.DoubleValue;
import edu.sda.data.Member;

import java.util.Scanner;

public class MemberAttendanceInput {

    private static int timesCounter = 0;

    public static void fillIfMemberAttend(Member member) {

        System.out.println("> Is " + member.getName() + " present today? (y/n)");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("y")) {
            member.setAttendanceDays(member.getAttendanceDays() + 1);
        }
        member.setAttendanceRate(Double.valueOf(member.getAttendanceDays()) / timesCounter);
    }

    public static void incrementTimeCounter() {
        timesCounter++;
    }

    public static int getTimesCounter() {
        return timesCounter;
    }
}
