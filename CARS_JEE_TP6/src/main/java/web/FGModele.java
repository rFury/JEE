package web;

import java.util.ArrayList;
import java.util.List;
import metier.Family_Group;

public class FGModele {
    List<Family_Group> familyGroups = new ArrayList<>();

    public List<Family_Group> getFamilyGroups() {
        return familyGroups;
    }

    public void setFamilyGroups(List<Family_Group> familyGroups) {
        this.familyGroups = familyGroups;
    }
}
