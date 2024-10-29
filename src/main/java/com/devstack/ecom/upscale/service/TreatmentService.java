package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestTreatmentDto;
import com.devstack.ecom.upscale.dto.response.ResponseTreatmentDto;
import com.devstack.ecom.upscale.dto.response.paginate.TreatmentPaginateDto;


public interface TreatmentService {
    public void create(RequestTreatmentDto dto);
    public ResponseTreatmentDto findById(String id);
    public void update(String id,RequestTreatmentDto dto);
    public TreatmentPaginateDto findAll(String searchText, int page, int size);
    public void delete(String id);
}
