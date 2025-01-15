package com.IW.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/available")
    public List<Room> getAllRooms(@RequestParam(value = "people", required = true) int people,
                                  @RequestParam(value = "beds", required = true) int beds,
                                  @RequestParam(value = "start_date", required = true) String start_date,
                                  @RequestParam(value = "end_date", required = true) String end_date) {

        List<String> type = new ArrayList<String>();

        if (beds != 0) {
            if (beds == 1) {
                type.add("Simple");
                type.add("Doble (una cama)");
            }
            if (beds == 2) {
                type.add("Doble (dos camas)");
                type.add("Triple");
            }
        }

        List<Room> availableRooms = roomRepository.findAvailableRooms(start_date, end_date);

        if (people != 0) {
            List<Room> rooms = new ArrayList<Room>();
            for (Room room : availableRooms) {
                if (room.getPeople() == people && type.contains(room.getType())) {
                    rooms.add(room);
                }
            }
            return rooms;
        }
        else {
            List<Room> rooms = new ArrayList<Room>();
            for (Room room : availableRooms) {
                if (type.contains(room.getType())) {
                    rooms.add(room);
                }
            }
            return rooms;
        }
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

    @PutMapping("/updateActive/{id}")
    public Room updateActive(@PathVariable Long id){
        Room room = roomRepository.findById(id).orElse(null);
        if(room != null){
            room.setActive(!room.getActive());
            return roomRepository.save(room);
        }
        return null;
    }

}

