package edu.sda.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sda.data.JObject;
import edu.sda.data.Member;

import java.io.File;
import java.io.IOException;

public class MemberJsonIOHandler {

    public Member[] readValues() {
        Member[] membersList = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            membersList = mapper.readValue(
                    new File("example-member-list.json"),
                    JObject.class)
                    .getMembers();

        } catch (IOException e) {
            System.out.println(e.getCause());
        }
        return membersList;
    }

    public void saveAttendanceListToFile(Member[] members) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("attendance-member-list.json"), members);

        } catch (IOException e) {
            System.out.println(e.getCause());
        }
    }

    public void printPrettyAttendanceList(Member[] members) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(members);
            System.out.println(json);

        } catch (IOException e) {
            System.out.println(e.getCause());
        }
    }
}
