package com.pwc.assignment.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pwc.assignment.data.records.UserRecord;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "complaints")
public class User implements UserRecord {
    @Id
    @NonNull
    private String username;
    @NonNull
    private String name;
    @NonNull
    @JsonIgnore
    private String password;
    @NonNull
    private UserRoles authority;
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "user",
            fetch = FetchType.EAGER
    )
    List<Complaint> complaints = new ArrayList<>();
}
