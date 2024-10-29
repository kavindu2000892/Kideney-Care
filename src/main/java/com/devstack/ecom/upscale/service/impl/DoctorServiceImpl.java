package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestDoctorDto;
import com.devstack.ecom.upscale.dto.response.ResponseDoctorDto;
import com.devstack.ecom.upscale.dto.response.paginate.DoctorPaginateDto;
import com.devstack.ecom.upscale.entity.Doctor;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.DoctorRepo;
import com.devstack.ecom.upscale.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;


    @Override
    public void create(RequestDoctorDto dto) {
        System.out.println(dto.getFullName());
        System.out.println(dto.getContact());
        System.out.println(dto.getLisenceNumber());
        System.out.println(dto.getCurrentCaseload());
        System.out.println(dto.getSpecialization());

        Doctor doctor = Doctor.builder()
                .fullName(dto.getFullName())
                .contact(dto.getContact())
                .lisenceNumber(dto.getLisenceNumber())
                .currentCaseload(dto.getCurrentCaseload())
                .specialization(dto.getSpecialization())
                .doctorId(UUID.randomUUID().toString())
                .build();
        doctorRepo.save(doctor);
    }

    @Override
    public ResponseDoctorDto findById(String id) {
        Optional<Doctor> selectedDoctor = doctorRepo.findById(id);
        if (selectedDoctor.isEmpty()) {
            throw new EntryNotFoundException("Doctor not found");
        }
        return createResponseDoctorDto(selectedDoctor.get());
    }

    @Override
    public void update(String id, RequestDoctorDto dto) {
        Optional<Doctor> selectedDoctor = doctorRepo.findById(id);
        if (selectedDoctor.isEmpty()) {
            throw new EntryNotFoundException("Doctor not found");
        }

        Doctor doctor = Doctor.builder()
                .fullName(dto.getFullName())
                .contact(dto.getContact())
                .lisenceNumber(dto.getLisenceNumber())
                .currentCaseload(dto.getCurrentCaseload())
                .specialization(dto.getSpecialization())
                .doctorId(id)
                .build();
        doctorRepo.save(doctor);

    }

    @Override
    public DoctorPaginateDto findAll(String searchText, int page, int size) {
        return DoctorPaginateDto.builder()
                .dataList(doctorRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::createResponseDoctorDto).toList())
                .count(
                        doctorRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {doctorRepo.deleteById(id);
    }

    private ResponseDoctorDto createResponseDoctorDto(Doctor doctor) {



        return ResponseDoctorDto.builder()
                .doctorId(doctor.getDoctorId())
                .fullName(doctor.getFullName())
                .contact(doctor.getContact())
                .lisenceNumber(doctor.getLisenceNumber())
                .currentCaseload(doctor.getCurrentCaseload())
                .specialization(doctor.getSpecialization())
                .build();
    }


}
