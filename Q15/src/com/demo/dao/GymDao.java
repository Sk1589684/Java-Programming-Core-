package com.demo.dao;

import com.demo.model.GymMember;
import java.util.Collection;
import java.util.LinkedHashMap;

public class GymDao {
    
    // Our filing cabinet. It uses the ID Number as the label on the folder.
    // LinkedHashMap is special because it remembers the exact order we add things!
    private LinkedHashMap<Integer, GymMember> memberDatabase = new LinkedHashMap<>();

    // Put a new member folder into the cabinet
    public void saveMember(GymMember member) {
        memberDatabase.put(member.getMemberId(), member);
    }

    // Find a member's folder and throw it in the trash
    public void deleteMember(int memberId) {
        memberDatabase.remove(memberId);
    }

    // Grab ALL the members from the cabinet
    public Collection<GymMember> getAllMembers() {
        // .values() gives us just the members, not the ID labels
        return memberDatabase.values(); 
    }

    // Dig through the cabinet to find one specific member using their ID
    public GymMember getMemberById(int memberId) {
        // .get() instantly finds the member without having to search one by one!
        return memberDatabase.get(memberId); 
    }
}
