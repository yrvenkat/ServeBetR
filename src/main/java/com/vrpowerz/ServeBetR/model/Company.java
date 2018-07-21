package com.vrpowerz.ServeBetR.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

/**
 * @author Venkataraghavan Yanamandram
 *
 */

@Entity
@DiscriminatorValue("COMPANY")
public class Company extends Customer {

    @Column(name = "company_name", length = 100, nullable = false)
    private String companyName;

    @Column(name = "website", length = 50)
    private String website;

    @Column(name = "contact_person", length = 50)
    private String contactPerson;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Company() {
    }

    public Company(String profileImageURL, Set<String> email, Set<String> phone, Set<String> address, Date timestamp, String description, String companyName, String website, String contactPerson) {
        super(profileImageURL, email, phone, address, timestamp, description);
        this.companyName = companyName;
        this.website = website;
        this.contactPerson = contactPerson;
    }
}
