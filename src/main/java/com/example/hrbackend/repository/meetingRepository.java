package com.example.hrbackend.repository;

import com.example.hrbackend.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface meetingRepository extends JpaRepository<Meeting,Integer> {
    Meeting findMeetingById(Integer id);

}
