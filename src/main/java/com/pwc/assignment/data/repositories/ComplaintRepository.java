package com.pwc.assignment.data.repositories;

import com.pwc.assignment.data.entities.Complaint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComplaintRepository extends CrudRepository<Complaint, String> {
    Optional<Complaint> findById(String complaintId);

    List<Complaint> findAllByUser_username(String username);

    List<Complaint> findAll();
}
