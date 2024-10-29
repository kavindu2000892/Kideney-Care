package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestVisitsDto;
import com.devstack.ecom.upscale.dto.response.ResponseVisitsDto;
import com.devstack.ecom.upscale.dto.response.paginate.VisitsPaginateDto;
import com.devstack.ecom.upscale.entity.Visits;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.VisitsRepo;
import com.devstack.ecom.upscale.service.VisitsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VisitsServiceImpl implements VisitsService {

    private final VisitsRepo visitsRepo;


    @Override
    public void create(RequestVisitsDto dto) {
        System.out.println(dto.getPatientId());
        System.out.println(dto.getPreDialysisAssesments());
        System.out.println(dto.getPostDialysisAssesments());
        System.out.println(dto.getActions());
        System.out.println(dto.getHealthcareTeam());

        Visits visits = Visits.builder()
                .patientId(dto.getPatientId())
                .preDialysisAssesments(dto.getPreDialysisAssesments())
                .postDialysisAssesments(dto.getPostDialysisAssesments())
                .actions(dto.getActions())
                .healthcareTeam(dto.getHealthcareTeam())
                .visitId(UUID.randomUUID().toString())
                .build();
        visitsRepo.save(visits);
    }

    @Override
    public ResponseVisitsDto findById(String id) {
        Optional<Visits> selectedVisits = visitsRepo.findById(id);
        if (selectedVisits.isEmpty()) {
            throw new EntryNotFoundException("Visits not found");
        }
        return createResponseVisitsDto(selectedVisits.get());
    }

    @Override
    public void update(String id, RequestVisitsDto dto) {
        Optional<Visits> selectedVisits = visitsRepo.findById(id);
        if (selectedVisits.isEmpty()) {
            throw new EntryNotFoundException("Visits not found");
        }

        Visits visits = Visits.builder()
                .patientId(dto.getPatientId())
                .preDialysisAssesments(dto.getPreDialysisAssesments())
                .postDialysisAssesments(dto.getPostDialysisAssesments())
                .actions(dto.getActions())
                .healthcareTeam(dto.getHealthcareTeam())
                .visitId(id)
                .build();
        visitsRepo.save(visits);

    }

    @Override
    public VisitsPaginateDto findAll(String searchText, int page, int size) {
        return VisitsPaginateDto.builder()
                .dataList(visitsRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::createResponseVisitsDto).toList())
                .count(
                        visitsRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {visitsRepo.deleteById(id);
    }

    private ResponseVisitsDto createResponseVisitsDto(Visits visits) {



        return ResponseVisitsDto.builder()
                .visitId(visits.getVisitId())
                .patientId(visits.getPatientId())
                .preDialysisAssesments(visits.getPreDialysisAssesments())
                .postDialysisAssesments(visits.getPostDialysisAssesments())
                .actions(visits.getActions())
                .healthcareTeam(visits.getHealthcareTeam())
                .build();
    }


}
