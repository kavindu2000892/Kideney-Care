package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestVisitsDto;
import com.devstack.ecom.upscale.dto.response.ResponseVisitsDto;
import com.devstack.ecom.upscale.dto.response.paginate.VisitsPaginateDto;


public interface VisitsService {
    public void create(RequestVisitsDto dto);
    public ResponseVisitsDto findById(String id);
    public void update(String id,RequestVisitsDto dto);
    public VisitsPaginateDto findAll(String searchText, int page, int size);
    public void delete(String id);
}
