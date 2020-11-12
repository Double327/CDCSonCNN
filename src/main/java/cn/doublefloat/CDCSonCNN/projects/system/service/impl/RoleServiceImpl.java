package cn.doublefloat.CDCSonCNN.projects.system.service.impl;

import cn.doublefloat.CDCSonCNN.projects.system.domain.Role;
import cn.doublefloat.CDCSonCNN.projects.system.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author 李广帅
 * @date 2020/11/12 2:04 下午
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public List<Role> selectRoleList(Role role) {
        return null;
    }

    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Role> selectRoleAll() {
        return null;
    }

    @Override
    public List<Integer> selectRoleListByUserId(Long userId) {
        return null;
    }

    @Override
    public Role selectRoleById(Long roleId) {
        return null;
    }

    @Override
    public String checkRoleNameUnique(Role role) {
        return null;
    }

    @Override
    public String checkRoleKeyUnique(Role role) {
        return null;
    }

    @Override
    public void checkRoleAllowed(Role role) {

    }

    @Override
    public int insertRole(Role role) {
        return 0;
    }

    @Override
    public int updateRole(Role role) {
        return 0;
    }

    @Override
    public int updateRoleStatus(Role role) {
        return 0;
    }

    @Override
    public int authDataScope(Role role) {
        return 0;
    }

    @Override
    public int deleteRoleByIds(String roleId) {
        return 0;
    }
}
