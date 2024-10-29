package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestSummeryDto;
import com.devstack.ecom.upscale.dto.response.ResponseSummeryDto;
import com.devstack.ecom.upscale.dto.response.paginate.SummeryPaginateDto;
import com.devstack.ecom.upscale.entity.Summery;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.SummeryRepo;
import com.devstack.ecom.upscale.service.SummeryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SummeryServiceImpl implements SummeryService {

    private final SummeryRepo summeryRepo;


    @Override
    public void create(RequestSummeryDto dto) {
        System.out.println(dto.getPatientId());
        System.out.println(dto.getReportDate());
        System.out.println(dto.getDoctorInCharge());
        System.out.println(dto.getTreatmentHistory());
        System.out.println(dto.getDialysisSessionHistory());
        System.out.println(dto.getSymptms());

        Summery summery = Summery.builder()
                .patientId(dto.getPatientId())
                .reportDate(dto.getReportDate())
                .doctorInCharge(dto.getDoctorInCharge())
                .treatmentHistory(dto.getTreatmentHistory())
                .dialysisSessionHistory(dto.getDialysisSessionHistory())
                .symptms(dto.getSymptms())
                .reportId(UUID.randomUUID().toString())
                .build();
        summeryRepo.save(summery);
    }

    @Override
    public ResponseSummeryDto findById(String id) {
        Optional<Summery> selectedSummery = summeryRepo.findById(id);
        if (selectedSummery.isEmpty()) {
            throw new EntryNotFoundException("Summery not found");
        }
        return createResponseSummeryDto(selectedSummery.get());
    }

    @Override
    public void update(String id, RequestSummeryDto dto) {
        Optional<Summery> selectedSummery = summeryRepo.findById(id);
        if (selectedSummery.isEmpty()) {
            throw new EntryNotFoundException("Summery not found");
        }

        Summery summery = Summery.builder()
                .patientId(dto.getPatientId())
                .reportDate(dto.getReportDate())
                .doctorInCharge(dto.getDoctorInCharge())
                .treatmentHistory(dto.getTreatmentHistory())
                .dialysisSessionHistory(dto.getDialysisSessionHistory())
                .symptms(dto.getSymptms())
                .reportId(id)
                .build();
        summeryRepo.save(summery);

    }

    @Override
    public SummeryPaginateDto findAll(String searchText, int page, int size) {
        return SummeryPaginateDto.builder()
                .dataList(summeryRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::createResponseSummeryDto).toList())
                .count(
                        summeryRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {summeryRepo.deleteById(id);
    }

    private ResponseSummeryDto createResponseSummeryDto(Summery summery) {



        return ResponseSummeryDto.builder()
                .reportId(summery.getReportId())
                .patientId(summery.getPatientId())
                .reportDate(summery.getReportDate())
                .doctorInCharge(summery.getDoctorInCharge())
                .treatmentHistory(summery.getTreatmentHistory())
                .dialysisSessionHistory(summery.getDialysisSessionHistory())
                .symptms(summery.getSymptms())
                .build();
    }


}
