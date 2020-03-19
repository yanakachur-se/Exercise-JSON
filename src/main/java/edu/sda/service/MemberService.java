package edu.sda.service;

import edu.sda.data.Member;
import edu.sda.parser.MemberJsonIOHandler;

public class MemberService {

    Member[] membersList;
    MemberJsonIOHandler reader = new MemberJsonIOHandler();

    public void initMembersList() {
        membersList = reader.readValues();
        checkRepeatableIds();
    }

    public void checkRepeatableIds() {
       if (!ifSomeIdsRepeatable(membersList)) {
           System.out.println("________________________________________");
            System.out.println("All member id's in the list are unique \n");
        }
    }

    boolean ifSomeIdsRepeatable(Member [] membersList) {
        boolean ifSomeIdsNonUnique = false;
        for (int i = 0; i < membersList.length; i++) {
            for (int j = i + 1; j < membersList.length; j++) {
                if (areMemberIdIdentical(membersList[i], membersList[j])) {
                    printNonUniqueIdMessage(membersList[i].getName(), membersList[j].getName());
                    ifSomeIdsNonUnique = true;
                }
            }
        }
        return ifSomeIdsNonUnique;
    }

    private void printNonUniqueIdMessage(String memberName, String secondMemberName) {
        System.out.println("Users " + memberName + " and " + secondMemberName + " have identical id.");
    }

    boolean areMemberIdIdentical(Member member, Member nextMember) {
        return member.getId().equals(nextMember.getId());
    }

    public void takeAttendance() {

        for (Member member : membersList) {
            MemberAttendanceInput.fillIfMemberAttend(member);
        }
    }

    public void saveAttendance() {
        reader.saveAttendanceListToFile(membersList);
    }

    public void printAttendanceSheet() {
        reader.printPrettyAttendanceList(membersList);
    }
}
