package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestUpcomingDto;
import com.devstack.ecom.upscale.dto.response.ResponseUpcomingDto;
import com.devstack.ecom.upscale.dto.response.paginate.UpcomingPaginateDto;
import com.devstack.ecom.upscale.entity.Upcoming;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.UpcomingRepo;
import com.devstack.ecom.upscale.service.UpcomingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpcomingServiceImpl implements UpcomingService {

    private final UpcomingRepo upcomingRepo;


    @Override
    public void create(RequestUpcomingDto dto) {
        System.out.println(dto.getPatientId());
        System.out.println(dto.getDate());
        System.out.println(dto.getTime());
        System.out.println(dto.getSessionStatus());
        System.out.println(dto.getAssignedBed());

        Upcoming upcoming = Upcoming.builder()
                .patientId(dto.getPatientId())
                .date(dto.getDate())
                .time(dto.getTime())
                .sessionId(dto.getSessionStatus())
                .assignedBed(dto.getAssignedBed())
                .sessionId(UUID.randomUUID().toString())
                .build();
        upcomingRepo.save(upcoming);
    }

    @Override
    public ResponseUpcomingDto findById(String id) {
        Optional<Upcoming> selectedUpcoming = upcomingRepo.findById(id);
        if (selectedUpcoming.isEmpty()) {
            throw new EntryNotFoundException("Upcoming not found");
        }
        return createResponseUpcomingDto(selectedUpcoming.get());
    }

    @Override
    public void update(String id, RequestUpcomingDto dto) {
        Optional<Upcoming> selectedUpcoming = upcomingRepo.findById(id);
        if (selectedUpcoming.isEmpty()) {
            throw new EntryNotFoundException("Upcoming not found");
        }

        Upcoming upcoming = Upcoming.builder()
                .patientId(dto.getPatientId())
                .date(dto.getDate())
                .time(dto.getTime())
                .sessionStatus(dto.getSessionStatus())
                .assignedBed(dto.getAssignedBed())
                .sessionId(id)
                .build();
        upcomingRepo.save(upcoming);

    }

    @Override
    public UpcomingPaginateDto findAll(String searchText, int page, int size) {
        return UpcomingPaginateDto.builder()
                .dataList(upcomingRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::createResponseUpcomingDto).toList())
                .count(
                        upcomingRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {upcomingRepo.deleteById(id);
    }

    private ResponseUpcomingDto createResponseUpcomingDto(Upcoming upcoming) {



        return ResponseUpcomingDto.builder()
                .sessionId(upcoming.getSessionId())
                .patientId(upcoming.getPatientId())
                .date(upcoming.getDate())
                .time(upcoming.getTime())
                .sessionStatus(upcoming.getSessionStatus())
                .assignedBed(upcoming.getAssignedBed())
                .build();
    }


}
