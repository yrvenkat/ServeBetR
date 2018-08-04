package com.vrpowerz.ServeBetR.enums;

/**
 * @author Venkataraghavan Yanamandram
 *
 */


public enum Status {

    CREATED("Created"),
    VERIFIED("Verified"),
    ON_SITE("On Site"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled");

    private String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }

    @Override public String toString() {
        return displayName;
    }
}
