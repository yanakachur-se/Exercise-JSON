package edu.sda;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sda.service.MemberService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import static edu.sda.service.MemberAttendanceInput.getTimesCounter;
import static edu.sda.service.MemberAttendanceInput.incrementTimeCounter;

public class MainRunner {
    public static void main(String[] args) {

        MemberService memberService = new MemberService();
        memberService.initMembersList();

        boolean isContinue = true;
        while (isContinue) {

            incrementTimeCounter();

            System.out.println("Please fill the member attendance:");

            memberService.takeAttendance();
            memberService.saveAttendance();

            System.out.println("____________________________");
            System.out.println("To repeat attendance counting, type '1'");
            System.out.println("To print attendance list and quit, type '2");

            System.out.print("> ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();



            if (input.equals("2")) {
                System.out.println("You have checked attendance " + getTimesCounter() + " times");
                System.out.println("Here is attendance sheet:");
                System.out.println("____________________________");
                memberService.printAttendanceSheet();
                isContinue = false;
            }
        }
    }
}
