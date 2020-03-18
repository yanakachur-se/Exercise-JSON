package edu.sda.service;

import edu.sda.data.Member;
import edu.sda.parser.MemberAttendanceInput;
import edu.sda.parser.MemberJsonReader;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MemberService {

    Member[] membersList;

    public void initMembersList() {
        MemberJsonReader reader = new MemberJsonReader();
        membersList = reader.readValues();
        checkRepeatableIds();
    }

    public void checkRepeatableIds() {
        boolean ifSomeIdsNonUnique = false;
        for (int i = 0; i < membersList.length; i++) {
            for (int j = i + 1; j < membersList.length; j++) {
                if (areMemberIdIdentical(membersList[i], membersList[j])) {
                    System.out.println("Users " + membersList[i].getName() + " and " + membersList[j].getName() + " have identical id.");
                    ifSomeIdsNonUnique = true;
                }
            }
        }

        if (!ifSomeIdsNonUnique){
            System.out.println("All member id's in the list are unique");
        }
    }

    private boolean areMemberIdIdentical(Member member, Member nextMember) {
        if (member.getId().equals(nextMember.getId())) {
            return true;
        } else {
            return false;
        }
    }

    public void takeAttendance() {

        for (Member member : membersList) {
            MemberAttendanceInput.fillIfMemberAttend(member);
        }

    }
}
