package com.devstack.ecom.upscale.service;

import com.devstack.ecom.upscale.dto.request.RequestSignsDto;
import com.devstack.ecom.upscale.dto.response.ResponseSignsDto;
import com.devstack.ecom.upscale.dto.response.paginate.SignsPaginateDto;


public interface SignsService {
    public void create(RequestSignsDto dto);
    public ResponseSignsDto findById(String id);
    public void update(String id,RequestSignsDto dto);
    public SignsPaginateDto findAll(String searchText, int page, int size);
    public void delete(String id);
}
