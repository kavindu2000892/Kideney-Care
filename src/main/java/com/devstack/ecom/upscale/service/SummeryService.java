package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestSummeryDto;
import com.devstack.ecom.upscale.dto.response.ResponseSummeryDto;
import com.devstack.ecom.upscale.dto.response.paginate.SummeryPaginateDto;


public interface SummeryService {
    public void create(RequestSummeryDto dto);
    public ResponseSummeryDto findById(String id);
    public void update(String id,RequestSummeryDto dto);
    public SummeryPaginateDto findAll(String searchText, int page, int size);
    public void delete(String id);
}
