package com.vrpowerz.ServeBetR.model;

import com.vrpowerz.ServeBetR.enums.Genders;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Venkataraghavan Yanamandram
 *
 */

@Entity
@Table(name = "vrpowerz_users")
public class User {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", length = 25, nullable = false)
    private String username;

    @Column(name = "firstname", length = 25, nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 25)
    private String lastname;

    @Column(name = "gender", length = 6)
    @Enumerated
    private Genders gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "vrpowerz_user_emails", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "email", length = 50)
    private Set<String> email;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "vrpowerz_user_phones", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "phone", length = 20)
    private Set<String> phone;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "vrpowerz_user_addresses", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "address", length = 50)
    private Set<String> address;

    @Column(name = "password", length = 1000, nullable = false)
    private String password;

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "role")
    private UserRole role;

    @Column(name = "timestamp")
    private Date timeStamp;

    @Column(name = "description", length = 5000)
    private String description;

    @Transient
    private String retypePassword;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<String> getEmail() {
        return email;
    }

    public void setEmail(Set<String> email) {
        this.email = email;
    }

    public Set<String> getPhone() {
        return phone;
    }

    public void setPhone(Set<String> phone) {
        this.phone = phone;
    }

    public Set<String> getAddress() {
        return address;
    }

    public void setAddress(Set<String> address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
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

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    public User() {
    }

    public User(String username, String firstname, String lastname, Genders gender, Date dateOfBirth, Set<String> email, Set<String> phone, Set<String> address, String password, boolean active, UserRole role, Date timeStamp, String description, String retypePassword) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.active = active;
        this.role = role;
        this.timeStamp = timeStamp;
        this.description = description;
        this.retypePassword = retypePassword;
    }
}
