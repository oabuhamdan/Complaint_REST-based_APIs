package com.pwc.assignment.web.controllers.rest.admin;


import com.pwc.assignment.data.entities.Complaint;
import com.pwc.assignment.data.entities.ComplaintStatus;
import com.pwc.assignment.data.entities.User;
import com.pwc.assignment.data.entities.UserRoles;
import com.pwc.assignment.data.services.ComplaintService;
import com.pwc.assignment.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/admin")
public class AdminActionsController {
    @Autowired
    UserService userService;

    @Autowired
    ComplaintService complaintService;

    @PostMapping(path = "/changeUserRole")
    public ResponseEntity<HttpStatus> changeUserRole(@RequestParam String userName, @RequestParam String newRole) {
        userService.changeUserAuthority(userName, UserRoles.ofString(newRole));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(path = "/changeComplaintStatus")
    public ResponseEntity<HttpStatus> changeComplaintStatus(@RequestParam String complaintId, @RequestParam String newStatus) {
        complaintService.changeComplaintStatusById(complaintId, ComplaintStatus.ofString(newStatus));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "/listAllUserComplaints")
    public List<Complaint> listUserComplaints(@RequestParam String username) {
        return complaintService.getAllUserComplaints(username);
    }

    @GetMapping(path = "/listAllUsers")
    public List<User> listAllUsers() {
        return userService.listAllUsers();
    }

    @GetMapping(path = "/getUserInfo")
    public User getUserInfo(@RequestParam String username) {
        return userService.getUser(username);
    }
}
