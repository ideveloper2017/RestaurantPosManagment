package uz.namangan.rest.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private long id;
	
	@Column(name="role", unique = true)
	private String role;
	
	@Column(name="name")
	private String name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Role) {
			if (obj != null) {
				Role role = (Role) obj;
				return role.getId() == getId();
			}
		}
		
		return false;
	}
}
