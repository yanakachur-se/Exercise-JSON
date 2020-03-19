package edu.sda.service;

import edu.sda.data.Member;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestMemberService {

    @Test
    public void testMemberIdIdentical() {
        MemberService memberService = new MemberService();
        Member member1 = new Member("Name One","sameId");
        Member member2 = new Member("Name Two","sameId");
        boolean result = memberService.areMemberIdIdentical(member1,member2);

        assertTrue(result);
    }

    @Test
    public void testMemberIdNotIdentical() {
        MemberService memberService = new MemberService();
        Member member1 = new Member("Name One","one id");
        Member member2 = new Member("Name Two","other id");
        boolean result = memberService.areMemberIdIdentical(member1,member2);

        assertFalse(result);
    }

    @Test
    public void testIfSomeIdsRepeatableWithRepeatableIdInList() {
        MemberService memberService = new MemberService();
        Member member1 = new Member("Name One","one id");
        Member member2 = new Member("Name Two","same id");
        Member member3 = new Member("Name Three","same id");
        Member member4 = new Member("Name Four","other id");
        Member [] membersList  = {member1, member2, member3, member4};
        boolean result = memberService.ifSomeIdsRepeatable(membersList);

        assertTrue(result);
    }

    @Test
    public void testIfSomeIdsRepeatableWithIdUniqueInList() {
        MemberService memberService = new MemberService();
        Member member1 = new Member("Name One","one id");
        Member member2 = new Member("Name Two","two id");
        Member member3 = new Member("Name Three","three id");
        Member member4 = new Member("Name Four","4 id");
        Member [] membersList  = {member1, member2, member3, member4};
        boolean result = memberService.ifSomeIdsRepeatable(membersList);

        assertFalse(result);
    }


}
