package com.vrpowerz.ServeBetR.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Venkataraghavan Yanamandram
 *
 */

@Entity
@Table(name = "vrpowerz_user_roles")
public class UserRole {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "role", length = 20, nullable = false)
    private String role;

    @Column(name = "role_key", length = 20, nullable = false)
    private String roleKey;

    @Column(name = "timestamp", nullable = false)
    private Date timeStamp;

    @Column(name = "description", length = 500)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserRole() {
    }

    public UserRole(String role, String roleKey, Date timeStamp, String description) {
        this.role = role;
        this.roleKey = roleKey;
        this.timeStamp = timeStamp;
        this.description = description;
    }
}
