package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.OrganizerService;
import se331.lab.rest.util.LabMapper;

import java.util.List;

@RestController
public class OrganizationController {
    @Autowired
    OrganizerService organizerService;
    @GetMapping("/organizers")
    ResponseEntity<?> getOrganizers(){
        return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDTO(organizerService.getAllOrganizer()));
    }
}
