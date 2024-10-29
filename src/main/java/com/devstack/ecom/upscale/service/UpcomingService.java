package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestUpcomingDto;
import com.devstack.ecom.upscale.dto.response.ResponseUpcomingDto;
import com.devstack.ecom.upscale.dto.response.paginate.UpcomingPaginateDto;


public interface UpcomingService {
    public void create(RequestUpcomingDto dto);
    public ResponseUpcomingDto findById(String id);
    public void update(String id,RequestUpcomingDto dto);
    public UpcomingPaginateDto findAll(String searchText, int page, int size);
    public void delete(String id);
}
