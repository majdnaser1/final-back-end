package com.example.hrbackend.controller;

import com.example.hrbackend.dto.ApiResponse;
import com.example.hrbackend.model.Meeting;
import com.example.hrbackend.model.User;
import com.example.hrbackend.service.meetingService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/meet")
public class meetingController {
    public final meetingService meetingservice;

    @GetMapping
    public ResponseEntity<List> getMeeting(){
        List <Meeting> meeting= meetingservice.get_meeting();
        return ResponseEntity.status(200).body(meeting);
    }
    @PostMapping
    public ResponseEntity<ApiResponse> addMeeting(@RequestBody Meeting meeting, @AuthenticationPrincipal User user){
        meetingservice.add_meeting(meeting,user);
        return ResponseEntity.status(200).body(new ApiResponse("Meeting added",200));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateMeeting(@RequestBody Meeting meeting, @PathVariable Integer id){
        meetingservice.update_meeting(meeting,id);
        return ResponseEntity.status(200).body(new ApiResponse("Meeting updated",200));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable Integer id){
        meetingservice.delete_order(id);
        return ResponseEntity.status(200).body(new ApiResponse("Meeting deleted",200));
    }






}
