package com.example.hrbackend.service;

import com.example.hrbackend.model.Meeting;
import com.example.hrbackend.model.User;
import com.example.hrbackend.repository.meetingRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class meetingService {
    public final meetingRepository meetingrepository;

    public List<Meeting> get_meeting(){
        return meetingrepository.findAll();
    }
    public void add_meeting(Meeting meeting, User user){
        meeting.setUserId(user.getId());
        meetingrepository.save(meeting);

    }
            public void update_meeting (Meeting meeting, Integer id){
        Meeting oldm=meetingrepository.findMeetingById(id);
        oldm.setTime(meeting.getTime());
        meetingrepository.save(oldm);
    }

    public void delete_order(Integer id){
        Meeting meeting=meetingrepository.getById(id);
        meetingrepository.delete(meeting);
    }


}