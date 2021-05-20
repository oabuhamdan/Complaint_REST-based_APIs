package com.pwc.assignment.data.entities;

import com.pwc.assignment.data.records.UserRecord;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = "complaints")
public class User implements UserRecord  {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String username;
    @NonNull
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
