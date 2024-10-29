package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestDoctorDto;
import com.devstack.ecom.upscale.dto.response.ResponseDoctorDto;
import com.devstack.ecom.upscale.dto.response.paginate.DoctorPaginateDto;


public interface DoctorService {
    public void create(RequestDoctorDto dto);
    public ResponseDoctorDto findById(String id);
    public void update(String id,RequestDoctorDto dto);
    public DoctorPaginateDto findAll(String searchText, int page, int size);
    public void delete(String id);
}
