package com.vrpowerz.ServeBetR.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Venkataraghavan Yanamandram
 *
 */


@Entity
@Table(name = "vrpowerz_sc_reschedule_history")
public class ServiceCallRescheduleHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "old_scheduled_date", nullable = false)
    private Date oldScheduledDate;

    @Column(name = "reason", length = 1000, nullable = false)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "rescheduled_by")
    private User rescheduledBy;

    @Column(name = "timestamp", nullable = false)
    private Date timestamp;

    @ManyToOne
    @JoinColumn(name = "service_call")
    private ServiceCall serviceCall;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOldScheduledDate() {
        return oldScheduledDate;
    }

    public void setOldScheduledDate(Date oldScheduledDate) {
        this.oldScheduledDate = oldScheduledDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User getRescheduledBy() {
        return rescheduledBy;
    }

    public void setRescheduledBy(User rescheduledBy) {
        this.rescheduledBy = rescheduledBy;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ServiceCall getServiceCall() {
        return serviceCall;
    }

    public void setServiceCall(ServiceCall serviceCall) {
        this.serviceCall = serviceCall;
    }

    public ServiceCallRescheduleHistory() {
    }

    public ServiceCallRescheduleHistory(Date oldScheduledDate, String reason, User rescheduledBy, Date timestamp, ServiceCall serviceCall) {
        this.oldScheduledDate = oldScheduledDate;
        this.reason = reason;
        this.rescheduledBy = rescheduledBy;
        this.timestamp = timestamp;
        this.serviceCall = serviceCall;
    }
}
