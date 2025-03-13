package repository;

import models.ClubMember;
import models.InventoryItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ClubMemberRepository {
    private static Map<Integer, ClubMember> itemTable = new HashMap<>();
    public void addMember(ClubMember member) {
        if (itemTable.values().stream().anyMatch(i -> i.getEmail().equals(member.getEmail()))){
            throw new IllegalArgumentException(String.format("Email %s already in DB", member.getEmail()));
        }
        itemTable.put(member.getId(), member);
    }
    public boolean deleteMemberById(Integer id) {
        if (itemTable.values().stream().noneMatch(i -> i.getId() == id)){
            return false;
        }
        else {
            itemTable.remove(id);
            return true;
        }
    }

    public Optional<ClubMember> getMemberById(Integer id) {
        return Optional.ofNullable(itemTable.get(id));
    }
    public List<ClubMember> getAllMembers() {
        return itemTable.values().stream().toList();
    }
    public ClubMember updateMemberById(Integer id, ClubMember updatedMember){
        if (itemTable.values().stream().noneMatch(i -> i.getId() == id)){
            throw new IllegalArgumentException(String.format("Member with id %s not found in DB", id));
        }
        return itemTable.put(id, updatedMember);
    }
}
