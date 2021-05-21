package com.pwc.assignment.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pwc.assignment.data.records.ComplaintRecord;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Complaint implements ComplaintRecord {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    String id;
    @ManyToOne
    @NonNull
    @JsonIgnoreProperties({"complaints", "password", "authority"})
    User user;
    @NonNull
    ComplaintStatus status;
    @NonNull
    String text;
}
