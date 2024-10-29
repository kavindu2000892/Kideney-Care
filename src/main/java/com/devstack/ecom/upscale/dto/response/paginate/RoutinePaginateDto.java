package com.devstack.ecom.upscale.dto.response.paginate;

import com.devstack.ecom.upscale.dto.response.ResponseRoutineDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoutinePaginateDto {
    private long count;
    private List<ResponseRoutineDto> dataList;
}
