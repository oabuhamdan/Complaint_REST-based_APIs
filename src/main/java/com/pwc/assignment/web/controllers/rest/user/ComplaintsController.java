package com.pwc.assignment.web.controllers.rest.user;


import com.pwc.assignment.data.entities.Complaint;
import com.pwc.assignment.data.entities.ComplaintStatus;
import com.pwc.assignment.data.services.ComplaintService;
import com.pwc.assignment.security.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComplaintsController {
    @Autowired
    ComplaintService complaintService;

    @GetMapping(path = "/getCurrentUserComplaints")
    public List<Complaint> getCurrentUserComplaints(@RequestParam(required = false) String status) {
        String currentUserName = Utils.getLoggedInUsername();
        if (status != null) {
            return complaintService.getUserComplaintsByStatus(currentUserName, ComplaintStatus.valueOf(status));
        }
        return complaintService.getAllUserComplaints(currentUserName);
    }

    @PostMapping(path = "/createNewComplaint")
    public ResponseEntity<HttpStatus> createNewComplaint(@RequestParam String text) {
        complaintService.createNewComplaintForLoggedInUser(text);
        return ResponseEntity.status(200).build();
    }
}
