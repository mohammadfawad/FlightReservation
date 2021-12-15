package com.passengerManagement.flightReservation.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;


/**
 *
 * @author spring
 */
@Entity
@Table(catalog = "flightreservation", schema = "")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByRoleId", query = "SELECT r FROM Role r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "Role.findByRoleName", query = "SELECT r FROM Role r WHERE r.roleName = :roleName")})
public class Role implements Serializable, GrantedAuthority {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer roleId;
    @Column(length = 20)
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public Role(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }
    
    @Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.getRoleName();
	}

    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
		builder.append("Role [roleId=");
		builder.append(this.getRoleId());
		builder.append(", roleName=");
		builder.append(this.getRoleName());
		builder.append("]");
		return builder.toString();
    }

}
