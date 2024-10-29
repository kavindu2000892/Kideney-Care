package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestRoutineDto;
import com.devstack.ecom.upscale.dto.response.ResponseRoutineDto;
import com.devstack.ecom.upscale.dto.response.paginate.RoutinePaginateDto;


public interface RoutineService {
    public void create(RequestRoutineDto dto);
    public ResponseRoutineDto findById(String id);
    public void update(String id,RequestRoutineDto dto);
    public RoutinePaginateDto findAll(String searchText, int page, int size);
    public void delete(String id);
}
