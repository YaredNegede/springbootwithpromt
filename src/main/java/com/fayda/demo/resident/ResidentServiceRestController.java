package com.fayda.demo.resident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residents")
public class ResidentServiceRestController {

    @Autowired
    private ResidentService residentService;

    @PostMapping
    public ResponseEntity<Resident> createResident(@RequestBody ResidentDTO residentDTO) {
        Resident createdResident = residentService.createResident(residentDTO);
        return new ResponseEntity<>(createdResident, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resident> updateResident(@PathVariable Long id, @RequestBody ResidentDTO residentDTO) {
        Resident updatedResident = residentService.updateResident(id, residentDTO);
        return new ResponseEntity<>(updatedResident, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResident(@PathVariable Long id) {
        residentService.deleteResident(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resident> getResidentById(@PathVariable Long id) {
        Resident resident = residentService.getResidentById(id);
        if (resident != null) {
            return new ResponseEntity<>(resident, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Page<Resident>> getAllResidents(Pageable pageable) {
        Page<Resident> residents = residentService.getAllResidents(pageable);
        return new ResponseEntity<>(residents, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Resident>> getAllResidents() {
        List<Resident> residents = residentService.getAllResidents();
        return new ResponseEntity<>(residents, HttpStatus.OK);
    }
}