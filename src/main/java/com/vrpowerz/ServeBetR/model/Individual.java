package com.vrpowerz.ServeBetR.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Venkataraghavan Yanamandram
 *
 */

@Entity
@DiscriminatorValue("INDIVIDUAL")
public class Individual extends Customer {

    @Column(name = "firstname", length = 25, nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 25)
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;

    @Column(name = "job_position", length = 50)
    private String jobPosition;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Individual() {
    }

    public Individual(String profileImageURL, Set<String> email, Set<String> phone, Set<String> address, Date timestamp, String description, String firstname, String lastname, Company company, String jobPosition) {
        super(profileImageURL, email, phone, address, timestamp, description);
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.jobPosition = jobPosition;
    }
}
