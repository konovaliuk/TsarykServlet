package dao.interfaces;
import entity.Role;

import java.sql.Connection;
import java.util.List;
public interface IRoleDAO {
    List<Role> findRoles(Connection connObj);
    Role findRoleById(Connection connObj, int id);
    void updateRoleName(Connection connObj, int id, String name);
    void deleteRole(Connection connObj, int id);
}
