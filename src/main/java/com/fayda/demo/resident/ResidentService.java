package com.fayda.demo.resident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentService {

    @Autowired
    private ResidentRepository residentRepository;

    public Resident createResident(ResidentDTO residentDTO) {
        Resident resident = new Resident();
        // Map DTO fields to Entity fields
        resident.setFullName(residentDTO.getFullName());
        resident.setEmail(residentDTO.getEmail());
        resident.setNationality(residentDTO.getNationality());
        resident.setWereda(residentDTO.getWereda());
        resident.setZone(residentDTO.getZone());
        resident.setPhoneNumber(residentDTO.getPhoneNumber());
        // ... map other fields
        return residentRepository.save(resident);
    }

    public Resident updateResident(Long id, ResidentDTO residentDTO) {
        Optional<Resident> residentOptional = residentRepository.findById(id);
        if (residentOptional.isPresent()) {
            Resident resident = residentOptional.get();
            resident.setFullName(residentDTO.getFullName());
            resident.setEmail(residentDTO.getEmail());
            resident.setNationality(residentDTO.getNationality());
            resident.setWereda(residentDTO.getWereda());
            resident.setZone(residentDTO.getZone());
            resident.setPhoneNumber(residentDTO.getPhoneNumber());
            return residentRepository.save(resident);
        } else {
            throw new RuntimeException("Resident not found with ID: " + id);
        }
    }

    public void deleteResident(Long id) {
        residentRepository.deleteById(id);
    }

    public Resident getResidentById(Long id) {
        Optional<Resident> residentOptional = residentRepository.findById(id);
        return residentOptional.orElse(null);
    }

    public Page<Resident> getAllResidents(Pageable pageable) {
        return residentRepository.findAll(pageable);
    }

    public List<Resident> getAllResidents() {
        return residentRepository.findAll();
    }
}