package com.pwc.assignment.data.records;

import com.pwc.assignment.data.entities.Complaint;

import java.util.List;

public interface UserRecord extends BaseRecord {
    String getName();

    void setName(String name);

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String username);

    List<Complaint> getComplaints();

    void setComplaints(List<Complaint> complaints);
}
