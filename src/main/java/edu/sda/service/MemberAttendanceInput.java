package edu.sda.parser;

import edu.sda.data.Member;

public class MemberAttendanceInput {

    public static void fillIfMemberAttend(Member member){
        System.out.println("Is " + member.getName() + "present today? (y/n)");

        boolean isAttend = false;

        member.setAttend(isAttend);
    }

}
