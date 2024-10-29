package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestNurseDto;
import com.devstack.ecom.upscale.dto.response.ResponseNurseDto;
import com.devstack.ecom.upscale.dto.response.paginate.NursePaginateDto;
import com.devstack.ecom.upscale.entity.Nurse;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.NurseRepo;
import com.devstack.ecom.upscale.service.NurseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NurseServiceImpl implements NurseService {

    private final NurseRepo nurseRepo;


    @Override
    public void create(RequestNurseDto dto) {
        System.out.println(dto.getFullName());
        System.out.println(dto.getContact());
        System.out.println(dto.getLisenceNumber());
        System.out.println(dto.getOnCallStatus());
        System.out.println(dto.getSpecialization());

        Nurse nurse = Nurse.builder()
                .fullName(dto.getFullName())
                .contact(dto.getContact())
                .lisenceNumber(dto.getLisenceNumber())
                .onCallStatus(dto.getOnCallStatus())
                .specialization(dto.getSpecialization())
                .nurseId(UUID.randomUUID().toString())
                .build();
        nurseRepo.save(nurse);
    }

    @Override
    public ResponseNurseDto findById(String id) {
        Optional<Nurse> selectedNurse = nurseRepo.findById(id);
        if (selectedNurse.isEmpty()) {
            throw new EntryNotFoundException("Nurse not found");
        }
        return createResponseNurseDto(selectedNurse.get());
    }

    @Override
    public void update(String id, RequestNurseDto dto) {
        Optional<Nurse> selectedNurse = nurseRepo.findById(id);
        if (selectedNurse.isEmpty()) {
            throw new EntryNotFoundException("Nurse not found");
        }

        Nurse nurse = Nurse.builder()
                .fullName(dto.getFullName())
                .contact(dto.getContact())
                .lisenceNumber(dto.getLisenceNumber())
                .onCallStatus(dto.getOnCallStatus())
                .specialization(dto.getSpecialization())
                .nurseId(id)
                .build();
        nurseRepo.save(nurse);

    }

    @Override
    public NursePaginateDto findAll(String searchText, int page, int size) {
        return NursePaginateDto.builder()
                .dataList(nurseRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::createResponseNurseDto).toList())
                .count(
                        nurseRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {nurseRepo.deleteById(id);
    }

    private ResponseNurseDto createResponseNurseDto(Nurse nurse) {



        return ResponseNurseDto.builder()
                .nurseId(nurse.getNurseId())
                .fullName(nurse.getFullName())
                .contact(nurse.getContact())
                .lisenceNumber(nurse.getLisenceNumber())
                .onCallStatus(nurse.getOnCallStatus())
                .specialization(nurse.getSpecialization())
                .build();
    }


}
