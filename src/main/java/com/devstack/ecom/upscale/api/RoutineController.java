package com.devstack.ecom.upscale.api;

import com.devstack.ecom.upscale.dto.request.RequestRoutineDto;
import com.devstack.ecom.upscale.service.RoutineService;
import com.devstack.ecom.upscale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/routines")
@RequiredArgsConstructor
@CrossOrigin
public class RoutineController {

    private final RoutineService routineService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> create(@RequestBody RequestRoutineDto dto) {
        routineService.create(dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Routine was created!..",null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> get(@PathVariable String id) {
        return new ResponseEntity<>(
                new StandardResponse(200,"Routine data!..",routineService.findById(id)),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> update(@PathVariable String id,
                         @RequestBody RequestRoutineDto dto) {
        routineService.update(id,dto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Routine was updated!..",null),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id) {
       routineService.delete(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Routine was deleted!..",null),
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
                new StandardResponse(200,"Routine list!..",
                        routineService.findAll(searchText, page, size)),
                HttpStatus.OK
        );
    }
}
