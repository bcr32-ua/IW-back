package com.IW.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.IW.back.model.Room;
import com.IW.back.repository.RoomRepository;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room){
        return roomRepository.save(room);
    }

    @PutMapping
    public Room updateRoom(@RequestBody Room room){
        return roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id){
        roomRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id){
        return roomRepository.findById(id).orElse(null);
    }
}

