package com.vrpowerz.ServeBetR.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author Venkataraghavan Yanamandram
 *
 */


@Entity
@Table(name = "vrpowerz_customers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "customer_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "profile_image_url", length = 1500)
    private String profileImageURL;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "vrpowerz_customer_emails", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "email", length = 50)
    private Set<String> email;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "vrpowerz_customer_phones", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "phone", length = 20)
    private Set<String> phone;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "vrpowerz_customer_addresses", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "address", length = 50)
    private Set<String> address;

    @Column(name = "timestamp", nullable = false)
    private Date timestamp;

    @Column(name = "description", length = 5000)
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileImageURL() {
        return profileImageURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }

    public Customer(String profileImageURL, Set<String> email, Set<String> phone, Set<String> address, Date timestamp, String description) {
        this.profileImageURL = profileImageURL;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.timestamp = timestamp;
        this.description = description;
    }
}
