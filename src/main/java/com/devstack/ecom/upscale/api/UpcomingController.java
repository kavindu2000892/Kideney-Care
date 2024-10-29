package com.devstack.ecom.upscale.api;

import com.devstack.ecom.upscale.dto.request.RequestDoctorDto;
import com.devstack.ecom.upscale.dto.request.RequestUpcomingDto;
import com.devstack.ecom.upscale.service.DoctorService;
import com.devstack.ecom.upscale.service.UpcomingService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/upcomings")
@RequiredArgsConstructor
@CrossOrigin
public class UpcomingController {

    private final UpcomingService upcomingService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> create(@RequestBody RequestUpcomingDto dto) {
        upcomingService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Upcoming was created!..",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(
                new StandardResponse(200,"Upcoming data!..",upcomingService.findById(id)),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> update(@PathVariable String id,
                         @RequestBody RequestUpcomingDto dto) {
        upcomingService.update(id,dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Upcoming was updated!..",null),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {
       upcomingService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Upcoming was deleted!..",null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ) {

        return new ResponseEntity<>(
                new StandardResponse(200,"Upcoming list!..",
                        upcomingService.findAll(searchText, page, size)),
                HttpStatus.OK
        );
    }
}
