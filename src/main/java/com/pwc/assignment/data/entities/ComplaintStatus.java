package com.pwc.assignment.data.entities;

public enum ComplaintStatus {
    RESOLVED("Resolved"), PENDING_RESOLUTION("Pending Resolution"), DISMISSED("Dismissed");

    String status;

    ComplaintStatus(String status) {
        this.status = status;
    }

    public static ComplaintStatus ofString(String status){
        if (status.equalsIgnoreCase(ComplaintStatus.RESOLVED.status))
            return ComplaintStatus.RESOLVED;
        if (status.equalsIgnoreCase(ComplaintStatus.PENDING_RESOLUTION.status))
            return ComplaintStatus.RESOLVED;
        if (status.equalsIgnoreCase(ComplaintStatus.DISMISSED.status))
            return ComplaintStatus.RESOLVED;
        else throw new RuntimeException("No status with this name!");
    }
}
