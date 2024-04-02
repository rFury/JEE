package dao;

import java.util.List;
import metier.Family_Group;

public interface IFGDao {
    public Family_Group save(Family_Group group);
    public Family_Group getFamily_Group(Long id);
    public Family_Group updateFamily_Group(Family_Group group);
    public void deleteFamily_Group(Long id);
    public List<Family_Group> getAllFamily_Groups();
}
