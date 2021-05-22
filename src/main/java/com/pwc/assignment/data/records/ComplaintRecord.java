package com.pwc.assignment.data.records;

import com.pwc.assignment.data.entities.ComplaintStatus;
import com.pwc.assignment.data.entities.User;

public interface ComplaintRecord {
    User getUser();

    void setUser(User user);

    String getText();

    void setText(String text);

    ComplaintStatus getStatus();

    void setStatus(ComplaintStatus status);

}
