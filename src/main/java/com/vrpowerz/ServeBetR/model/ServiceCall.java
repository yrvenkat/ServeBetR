package com.vrpowerz.ServeBetR.model;

import com.vrpowerz.ServeBetR.enums.Status;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Venkataraghavan Yanamandram
 *
 */

@Entity
@Table(name = "vrpowerz_service_calls")
public class ServiceCall implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "subject", length = 100, nullable = false)
    private String subject;

    @Column(name = "details", length = 1000)
    private String details;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @Column(name = "schedule")
    private Date schedule;

    @ManyToOne
    @JoinColumn(name = "assignee")
    private User assignee;

    @ManyToOne
    @JoinColumn(name = "assigner")
    private User assigner;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "completed")
    private Date completed;

    @Column(name = "address", length = 300)
    private String address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "serviceCall", targetEntity = ServiceCallRescheduleHistory.class, orphanRemoval = true)
    @Fetch(FetchMode.SELECT)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<ServiceCallRescheduleHistory> rescheduleHistories;

    @Column(name = "status", nullable = false)
    @Enumerated
    private Status status;

    @Column(name = "timestamp", nullable = false)
    private Date timestamp;

    @Column(name = "description", length = 1000)
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public User getAssigner() {
        return assigner;
    }

    public void setAssigner(User assigner) {
        this.assigner = assigner;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCompleted() {
        return completed;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ServiceCallRescheduleHistory> getRescheduleHistories() {
        return rescheduleHistories;
    }

    public void setRescheduleHistories(List<ServiceCallRescheduleHistory> rescheduleHistories) {
        this.rescheduleHistories = rescheduleHistories;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public ServiceCall() {
    }

    public ServiceCall(String subject, String details, Customer customer, Date schedule, User assignee, User assigner, User createdBy, Date completed, String address, List<ServiceCallRescheduleHistory> rescheduleHistories, Status status, Date timestamp, String description) {
        this.subject = subject;
        this.details = details;
        this.customer = customer;
        this.schedule = schedule;
        this.assignee = assignee;
        this.assigner = assigner;
        this.createdBy = createdBy;
        this.completed = completed;
        this.address = address;
        this.rescheduleHistories = rescheduleHistories;
        this.status = status;
        this.timestamp = timestamp;
        this.description = description;
    }
}
