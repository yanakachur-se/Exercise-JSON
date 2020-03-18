package edu.sda.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.sda.data.JObject;
import edu.sda.data.Member;

import java.io.File;
import java.io.IOException;

public class JsonReader {

    public Member[] readValues() {
        Member[] membersList = null;
        try{
          ObjectMapper mapper = new ObjectMapper();
          membersList = mapper.readValue(
                new File("example-member-list.json"),
                JObject.class)
                .getMembers();

    }catch (IOException e){
        System.out.println(e.getCause());
    }
      return membersList;
    }
}
