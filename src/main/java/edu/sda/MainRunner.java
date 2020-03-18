package edu.sda;

import edu.sda.service.MemberService;

public class MainRunner {
    public static void main(String[] args){

        MemberService memberService = new MemberService();
        memberService.initMembersList();



        System.out.println("Please fill the member attendance:");

        //memberService.takeAttendance();

        System.out.println("Repeat (y/n)");
    }
}
