package com.pwc.assignment.data.services.impl;

import com.pwc.assignment.data.entities.Complaint;
import com.pwc.assignment.data.entities.ComplaintStatus;
import com.pwc.assignment.data.entities.User;
import com.pwc.assignment.data.repositories.ComplaintRepository;
import com.pwc.assignment.data.services.ComplaintService;
import com.pwc.assignment.data.services.UserService;
import com.pwc.assignment.security.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    ComplaintRepository complaintRepository;
    @Autowired
    UserService userService;

    public List<Complaint> getUserComplaintsByStatus(String username, ComplaintStatus status) {
        return complaintRepository.findAllByUser(userService.getUser(username)).stream()
                .filter(c -> c.getStatus() == status)
                .collect(Collectors.toList());
    }

    public Complaint getComplaintById(String complaintId) {
        return complaintRepository.findById(complaintId).orElseThrow(() -> new RuntimeException("Complaint not found"));
    }

    public void createNewComplaintForLoggedInUser(String text) {
        String username = Utils.getLoggedInUsername();
        User user = userService.getUser(username);
        complaintRepository.save(new Complaint(user, ComplaintStatus.PENDING_RESOLUTION, text));
    }

    public void changeComplaintStatusById(String complaintId, ComplaintStatus newStatus) {
        complaintRepository.findById(complaintId).ifPresent(c -> c.setStatus(newStatus));
    }

    public List<Complaint> getAllUserComplaints(String username) {
        return complaintRepository.findAllByUser(userService.getUser(username));
    }
}
