package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestSignsDto;
import com.devstack.ecom.upscale.dto.response.ResponseSignsDto;
import com.devstack.ecom.upscale.dto.response.paginate.SignsPaginateDto;
import com.devstack.ecom.upscale.entity.Signs;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.SignsRepo;
import com.devstack.ecom.upscale.service.SignsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SignsServiceImpl implements SignsService {

    private final SignsRepo signsRepo;


    @Override
    public void create(RequestSignsDto dto) {
        System.out.println(dto.getPatientId());
        System.out.println(dto.getDate());
        System.out.println(dto.getBloodPressure());
        System.out.println(dto.getHeartRate());
        System.out.println(dto.getRespiratoryRate());
        System.out.println(dto.getBloodOxygenSaturation());
        System.out.println(dto.getBodyTemperature());
        System.out.println(dto.getBodyWeight());
        System.out.println(dto.getPatientSymptoms());

        Signs signs = Signs.builder()
                .patientId(dto.getPatientId())
                .date(dto.getDate())
                .bloodPressure(dto.getBloodPressure())
                .heartRate(dto.getHeartRate())
                .respiratoryRate(dto.getRespiratoryRate())
                .bloodOxygenSaturation(dto.getBloodOxygenSaturation())
                .bodyTemperature(dto.getBodyTemperature())
                .bodyWeight(dto.getBodyWeight())
                .patientSymptoms(dto.getPatientSymptoms())
                .recordId(UUID.randomUUID().toString())
                .build();
        signsRepo.save(signs);
    }

    @Override
    public ResponseSignsDto findById(String id) {
        Optional<Signs> selectedSigns = signsRepo.findById(id);
        if (selectedSigns.isEmpty()) {
            throw new EntryNotFoundException("Signs not found");
        }
        return createResponseSignsDto(selectedSigns.get());
    }

    @Override
    public void update(String id, RequestSignsDto dto) {
        Optional<Signs> selectedSigns = signsRepo.findById(id);
        if (selectedSigns.isEmpty()) {
            throw new EntryNotFoundException("Signs not found");
        }

        Signs signs = Signs.builder()
                .patientId(dto.getPatientId())
                .date(dto.getDate())
                .bloodPressure(dto.getBloodPressure())
                .heartRate(dto.getHeartRate())
                .respiratoryRate(dto.getRespiratoryRate())
                .bloodOxygenSaturation(dto.getBloodOxygenSaturation())
                .bodyTemperature(dto.getBodyTemperature())
                .bodyWeight(dto.getBodyWeight())
                .patientSymptoms(dto.getPatientSymptoms())
                .recordId(id)
                .build();
        signsRepo.save(signs);

    }

    @Override
    public SignsPaginateDto findAll(String searchText, int page, int size) {
        return SignsPaginateDto.builder()
                .dataList(signsRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::createResponseSignsDto).toList())
                .count(
                        signsRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {signsRepo.deleteById(id);
    }

    private ResponseSignsDto createResponseSignsDto(Signs signs) {



        return ResponseSignsDto.builder()
                .recordId(signs.getRecordId())
                .patientId(signs.getPatientId())
                .date(signs.getDate())
                .bloodPressure(signs.getBloodPressure())
                .heartRate(signs.getHeartRate())
                .respiratoryRate(signs.getRespiratoryRate())
                .bloodOxygenSaturation(signs.getBloodOxygenSaturation())
                .bodyTemperature(signs.getBodyTemperature())
                .bodyWeight(signs.getBodyWeight())
                .patientSymptoms(signs.getPatientSymptoms())
                .build();
    }


}
