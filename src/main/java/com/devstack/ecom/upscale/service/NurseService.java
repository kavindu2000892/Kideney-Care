package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestNurseDto;
import com.devstack.ecom.upscale.dto.response.ResponseNurseDto;
import com.devstack.ecom.upscale.dto.response.paginate.NursePaginateDto;


public interface NurseService {
    public void create(RequestNurseDto dto);
    public ResponseNurseDto findById(String id);
    public void update(String id,RequestNurseDto dto);
    public NursePaginateDto findAll(String searchText, int page, int size);
    public void delete(String id);
}
