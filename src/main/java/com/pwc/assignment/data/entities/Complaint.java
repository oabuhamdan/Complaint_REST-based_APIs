package com.pwc.assignment.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pwc.assignment.data.records.ComplaintRecord;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(indexes = {
        @Index(
                name = "user_complaint",
                columnList = "user_id,status,text",
                unique = true
        )
})
public class Complaint implements ComplaintRecord {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;
    @ManyToOne
    @NonNull
    @JsonIgnore
    User user;
    @NonNull
    ComplaintStatus status;
    @NonNull
    String text;
}
