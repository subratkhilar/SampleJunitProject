package net.atos.Codex_IOT.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name="ProjectMapping",schema ="operationdb")
@NamedQuery(name="ProjectMapping.findAll", query="SELECT e FROM ProjectMapping e")
public class ProjectMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="projectmapping_Id")	
	private long projectmappingid;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "USER_ID")
	private User user;

	public long getProjectmappingid() {
		return projectmappingid;
	}

	public void setProjectmappingid(long projectmappingid) {
		this.projectmappingid = projectmappingid;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ProjectMapping [projectmappingid=" + projectmappingid
				+ ", project=" + project + ",  user="
				+ user + "]";
	}
	
	

}
