package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestPatientDto;
import com.devstack.ecom.upscale.dto.response.ResponsePatientDto;
import com.devstack.ecom.upscale.dto.response.paginate.PatientPaginateDto;
import com.devstack.ecom.upscale.entity.Patient;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.PatientRepo;
import com.devstack.ecom.upscale.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepo patientRepo;


    @Override
    public void create(RequestPatientDto dto) {
        System.out.println(dto.getFullName());
        System.out.println(dto.getBirthDay());
        System.out.println(dto.getGender());
        System.out.println(dto.getContact());
        System.out.println(dto.getDiagnosisType());
        System.out.println(dto.getSurgicalHistory());
        System.out.println(dto.getAllergies());

        Patient patient = Patient.builder()
                .fullName(dto.getFullName())
                .birthDay(dto.getBirthDay())
                .gender(dto.getGender())
                .contact(dto.getContact())
                .diagnosisType(dto.getDiagnosisType())
                .surgicalHistory(dto.getSurgicalHistory())
                .allergies(dto.getAllergies())
                .patientId(UUID.randomUUID().toString())
                .build();
        patientRepo.save(patient);
    }

    @Override
    public ResponsePatientDto findById(String id) {
        Optional<Patient> selectedPatient = patientRepo.findById(id);
        if (selectedPatient.isEmpty()) {
            throw new EntryNotFoundException("Patient not found");
        }
        return createResponsePatientDto(selectedPatient.get());
    }

    @Override
    public void update(String id, RequestPatientDto dto) {
        Optional<Patient> selectedPatient = patientRepo.findById(id);
        if (selectedPatient.isEmpty()) {
            throw new EntryNotFoundException("Patient not found");
        }

        Patient patient = Patient.builder()
                .fullName(dto.getFullName())
                .birthDay(dto.getBirthDay())
                .gender(dto.getGender())
                .contact(dto.getContact())
                .diagnosisType(dto.getDiagnosisType())
                .surgicalHistory(dto.getSurgicalHistory())
                .allergies(dto.getAllergies())
                .patientId(id)
                .build();
        patientRepo.save(patient);

    }

    @Override
    public PatientPaginateDto findAll(String searchText, int page, int size) {
        return PatientPaginateDto.builder()
                .dataList(patientRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::createResponsePatientDto).toList())
                .count(
                        patientRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {patientRepo.deleteById(id);
    }

    private ResponsePatientDto createResponsePatientDto(Patient patient) {



        return ResponsePatientDto.builder()
                .patientId(patient.getPatientId())
                .fullName(patient.getFullName())
                .birthDay(patient.getBirthDay())
                .gender(patient.getGender())
                .contact(patient.getContact())
                .diagnosisType(patient.getDiagnosisType())
                .surgicalHistory(patient.getSurgicalHistory())
                .allergies(patient.getAllergies())
                .build();
    }


}
