package com.devstack.ecom.upscale.service.impl;

import com.devstack.ecom.upscale.dto.request.RequestRoutineDto;
import com.devstack.ecom.upscale.dto.response.ResponseRoutineDto;
import com.devstack.ecom.upscale.dto.response.paginate.RoutinePaginateDto;
import com.devstack.ecom.upscale.entity.Routine;
import com.devstack.ecom.upscale.exception.EntryNotFoundException;
import com.devstack.ecom.upscale.repo.RoutineRepo;
import com.devstack.ecom.upscale.service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoutineServiceImpl implements RoutineService {

    private final RoutineRepo routineRepo;


    @Override
    public void create(RequestRoutineDto dto) {
        System.out.println(dto.getPatientId());
        System.out.println(dto.getDate());
        System.out.println(dto.getDuration());
        System.out.println(dto.getDialysisSite());
        System.out.println(dto.getDaialysisMachineSetting());
        System.out.println(dto.getTreatmentAdjustment());

        Routine routine = Routine.builder()
                .patientId(dto.getPatientId())
                .date(dto.getDate())
                .duration(dto.getDuration())
                .dialysisSite(dto.getDialysisSite())
                .daialysisMachineSetting(dto.getDaialysisMachineSetting())
                .treatmentAdjustment(dto.getTreatmentAdjustment())
                .sessionId(UUID.randomUUID().toString())
                .build();
        routineRepo.save(routine);
    }

    @Override
    public ResponseRoutineDto findById(String id) {
        Optional<Routine> selectedRoutine = routineRepo.findById(id);
        if (selectedRoutine.isEmpty()) {
            throw new EntryNotFoundException("Routine not found");
        }
        return createResponseRoutineDto(selectedRoutine.get());
    }

    @Override
    public void update(String id, RequestRoutineDto dto) {
        Optional<Routine> selectedRoutine = routineRepo.findById(id);
        if (selectedRoutine.isEmpty()) {
            throw new EntryNotFoundException("Routine not found");
        }

        Routine routine = Routine.builder()
                .patientId(dto.getPatientId())
                .date(dto.getDate())
                .duration(dto.getDuration())
                .dialysisSite(dto.getDialysisSite())
                .daialysisMachineSetting(dto.getDaialysisMachineSetting())
                .treatmentAdjustment(dto.getTreatmentAdjustment())
                .sessionId(id)
                .build();
        routineRepo.save(routine);

    }

    @Override
    public RoutinePaginateDto findAll(String searchText, int page, int size) {
        return RoutinePaginateDto.builder()
                .dataList(routineRepo.findAllWithSearchText(searchText, PageRequest.of(page, size))
                        .stream().map(this::createResponseRoutineDto).toList())
                .count(
                        routineRepo.countAllWithSearchText(searchText)
                )
                .build();
    }

    @Override
    public void delete(String id) {routineRepo.deleteById(id);
    }

    private ResponseRoutineDto createResponseRoutineDto(Routine routine) {



        return ResponseRoutineDto.builder()
                .sessionId(routine.getSessionId())
                .patientId(routine.getPatientId())
                .date(routine.getDate())
                .duration(routine.getDuration())
                .dialysisSite(routine.getDialysisSite())
                .daialysisMachineSetting(routine.getDaialysisMachineSetting())
                .treatmentAdjustment(routine.getTreatmentAdjustment())
                .build();
    }


}
