package com.devstack.ecom.upscale.api;

import com.devstack.ecom.upscale.dto.request.RequestDoctorDto;
import com.devstack.ecom.upscale.service.DoctorService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
@CrossOrigin
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> create(@RequestBody RequestDoctorDto dto) {
        doctorService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Doctor was created!..",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(
                new StandardResponse(200,"Doctor data!..",doctorService.findById(id)),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> update(@PathVariable String id,
                         @RequestBody RequestDoctorDto dto) {
        doctorService.update(id,dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Doctor was updated!..",null),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {
       doctorService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Doctor was deleted!..",null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> getAll(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ) {

        return new ResponseEntity<>(
                new StandardResponse(200,"Doctor list!..",
                        doctorService.findAll(searchText, page, size)),
                HttpStatus.OK
        );
    }
}
