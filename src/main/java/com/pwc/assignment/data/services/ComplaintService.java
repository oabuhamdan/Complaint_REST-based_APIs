package com.pwc.assignment.data.services;

import com.pwc.assignment.data.entities.Complaint;
import com.pwc.assignment.data.entities.ComplaintStatus;

import java.util.List;

public interface ComplaintService {
    List<Complaint> getUserComplaintsByStatus(String username, ComplaintStatus status);

    void changeComplaintStatusById(String complaintId, ComplaintStatus newStatus);

    List<Complaint> getAllUserComplaints(String username);

    List<Complaint> getAllComplaints();

    Complaint getComplaintById(String complaintId);

    void createNewComplaintForLoggedInUser(String text);
}
