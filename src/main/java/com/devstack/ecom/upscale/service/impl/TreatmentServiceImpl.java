package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestTreatmentDto;
import com.devstack.ecom.upscale.dto.response.ResponseTreatmentDto;
import com.devstack.ecom.upscale.dto.response.paginate.TreatmentPaginateDto;
import com.devstack.ecom.upscale.entity.Treatment;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.TreatmentRepo;
import com.devstack.ecom.upscale.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentRepo treatmentRepo;


    @Override
    public void create(RequestTreatmentDto dto) {
        System.out.println(dto.getPatientId());
        System.out.println(dto.getFullName());
        System.out.println(dto.getPrimaryDiagnosis());
        System.out.println(dto.getSecondaryDiagnosis());
        System.out.println(dto.getFrequencyOfDialysis());
        System.out.println(dto.getDialyzerType());
        System.out.println(dto.getPreDialysisMedications());
        System.out.println(dto.getPostDialysisMedications());

        Treatment treatment = Treatment.builder()
                .patientId(dto.getPatientId())
                .fullName(dto.getFullName())
                .primaryDiagnosis(dto.getPrimaryDiagnosis())
                .secondaryDiagnosis(dto.getSecondaryDiagnosis())
                .frequencyOfDialysis(dto.getFrequencyOfDialysis())
                .dialyzerType(dto.getDialyzerType())
                .preDialysisMedications(dto.getPreDialysisMedications())
                .postDialysisMedications(dto.getPostDialysisMedications())
                .planId(UUID.randomUUID().toString())
                .build();
        treatmentRepo.save(treatment);
    }

    @Override
    public ResponseTreatmentDto findById(String id) {
        Optional<Treatment> selectedTreatment = treatmentRepo.findById(id);
        if (selectedTreatment.isEmpty()) {
            throw new EntryNotFoundException("Treatment not found");
        }
        return createResponseTreatmentDto(selectedTreatment.get());
    }

    @Override
    public void update(String id, RequestTreatmentDto dto) {
        Optional<Treatment> selectedTreatment = treatmentRepo.findById(id);
        if (selectedTreatment.isEmpty()) {
            throw new EntryNotFoundException("Treatment not found");
        }

        Treatment treatment = Treatment.builder()
                .patientId(dto.getPatientId())
                .fullName(dto.getFullName())
                .primaryDiagnosis(dto.getPrimaryDiagnosis())
                .secondaryDiagnosis(dto.getSecondaryDiagnosis())
                .frequencyOfDialysis(dto.getFrequencyOfDialysis())
                .dialyzerType(dto.getDialyzerType())
                .preDialysisMedications(dto.getPreDialysisMedications())
                .postDialysisMedications(dto.getPostDialysisMedications())
                .planId(id)
                .build();
        treatmentRepo.save(treatment);

    }

    @Override
    public TreatmentPaginateDto findAll(String searchText, int page, int size) {
        return TreatmentPaginateDto.builder()
                .dataList(treatmentRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::createResponseTreatmentDto).toList())
                .count(
                        treatmentRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {treatmentRepo.deleteById(id);
    }

    private ResponseTreatmentDto createResponseTreatmentDto(Treatment treatment) {



        return ResponseTreatmentDto.builder()
                .planId(treatment.getPlanId())
                .patientId(treatment.getPatientId())
                .fullName(treatment.getFullName())
                .primaryDiagnosis(treatment.getPrimaryDiagnosis())
                .secondaryDiagnosis(treatment.getSecondaryDiagnosis())
                .frequencyOfDialysis(treatment.getFrequencyOfDialysis())
                .dialyzerType(treatment.getDialyzerType())
                .preDialysisMedications(treatment.getPreDialysisMedications())
                .postDialysisMedications(treatment.getPostDialysisMedications())
                .build();
    }


}
