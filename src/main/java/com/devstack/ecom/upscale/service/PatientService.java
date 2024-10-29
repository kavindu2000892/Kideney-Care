package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestPatientDto;
import com.devstack.ecom.upscale.dto.response.ResponsePatientDto;
import com.devstack.ecom.upscale.dto.response.paginate.PatientPaginateDto;


public interface PatientService {
    public void create(RequestPatientDto dto);
    public ResponsePatientDto findById(String id);
    public void update(String id,RequestPatientDto dto);
    public PatientPaginateDto findAll(String searchText, int page, int size);
    public void delete(String id);
}
