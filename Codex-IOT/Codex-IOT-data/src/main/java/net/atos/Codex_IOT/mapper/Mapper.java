/**
 * 
 */
package net.atos.Codex_IOT.mapper;

import java.util.ArrayList;
import java.util.List;

import net.atos.Codex_IOT.model.ProjectDto;
import net.atos.Codex_IOT.model.RoleModel;
import net.atos.Codex_IOT.model.UserData;
import net.atos.Codex_IOT.pojo.Project;
import net.atos.Codex_IOT.pojo.Role;
import net.atos.Codex_IOT.pojo.User;

import org.springframework.stereotype.Component;

/**
 * @author A622693
 *
 */
@Component
public class Mapper {

	public User mapUserModelToUserPojo(UserData userData) {
		if (userData != null) {
			User user = new User();
			user.setFirstname(userData.getFirstname());
			user.setLastname(userData.getLastname());
			user.setPassword(userData.getPassword());
			user.setUsername(userData.getUsername());
			user.setRole(mapToRolePojo(userData.getRoleModel()));
			return user;
		}
		return null;

	}

	public List<Role> mapRoleModelListToUserList(List<RoleModel> roleModels) {

		final List<Role> roles = new ArrayList<Role>();
		for (final RoleModel roleModel : roleModels) {
			roles.add(mapToRolePojo(roleModel));
		}
		return roles;

	}

	private Role mapToRolePojo(RoleModel roleModel) {
		final Role role = new Role();
		role.setRoleId(roleModel.getRoleId());
		role.setRolename(roleModel.getRolename());
		role.setRoletype(roleModel.getRoletype());
		return role;
	}

	public UserData mapUserToUserModel(User user) {
		if (user != null) {
			UserData userData = new UserData();
			userData.setFirstname(user.getFirstname());
			userData.setLastname(user.getLastname());
			userData.setUserId(user.getUserId());
			userData.setUsername(user.getUsername());
			userData.setRoleModel(mapToRoleModel(user.getRole()));
			return userData;
		}
		return null;

	}

	public List<RoleModel> mapRoleListToUserModelList(List<Role> roles) {

		final List<RoleModel> roleModels = new ArrayList<RoleModel>();
		for (final Role role : roles) {
			roleModels.add(mapToRoleModel(role));
		}
		return roleModels;

	}
	
	public ProjectDto mapProjectToProjectDto(Project project){
		ProjectDto projectDto= new ProjectDto();
		projectDto.setProjectId(project.getProjectId());
		projectDto.setProjectName(project.getProjectName());
		projectDto.setProjectDescription(project.getProjectDescription());
		projectDto.setProjectLocation(project.getProjectLocation());
		projectDto.setActive(project.isActive());
		projectDto.setCustomer(project.getCustomer());
		projectDto.setLatitude(project.getLatitude());
		projectDto.setLongitude(project.getLongitude());
		projectDto.setCreatedDate(project.getCreatedDate());
		projectDto.setUpdatedDate(project.getUpdatedDate());
		
		return projectDto;
	}

	private RoleModel mapToRoleModel(Role role) {
		final RoleModel roleModel = new RoleModel();
		roleModel.setRoleId(role.getRoleId());
		return roleModel;
	}
}