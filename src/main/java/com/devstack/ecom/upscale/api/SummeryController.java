package com.devstack.ecom.upscale.api;

import com.devstack.ecom.upscale.dto.request.RequestSummeryDto;
import com.devstack.ecom.upscale.service.SummeryService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/summeries")
@RequiredArgsConstructor
@CrossOrigin
public class SummeryController {

    private final SummeryService summeryService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> create(@RequestBody RequestSummeryDto dto) {
        summeryService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Summery was created!..",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(
                new StandardResponse(200,"Summery data!..",summeryService.findById(id)),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> update(@PathVariable String id,
                         @RequestBody RequestSummeryDto dto) {
        summeryService.update(id,dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Summery was updated!..",null),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {
       summeryService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Summery was deleted!..",null),
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
                new StandardResponse(200,"Summery list!..",
                        summeryService.findAll(searchText, page, size)),
                HttpStatus.OK
        );
    }
}
