package com.nobroker.service.impl;

import com.nobroker.entity.OwnerPlan;
import com.nobroker.payload.OwnerPlanDto;
import com.nobroker.repository.OwnerPlanRepositroy;
import com.nobroker.service.OwnerPlanService;
import org.modelmapper.ModelMapper;

public class OwnerPlanServiceImpl implements OwnerPlanService {
    private OwnerPlanRepositroy ownerPlanRepositroy;
    private ModelMapper modelMapper;

    public OwnerPlanServiceImpl(OwnerPlanRepositroy ownerPlanRepositroy,ModelMapper modelMapper) {
        this.modelMapper=modelMapper;
        this.ownerPlanRepositroy = ownerPlanRepositroy;
    }

    @Override
    public OwnerPlanDto createOwnerPlans(OwnerPlanDto ownerPlanDto) {
        OwnerPlan ownerPlan = mapToEntity(ownerPlanDto);
        OwnerPlan saveedOwnerPlan = ownerPlanRepositroy.save(ownerPlan);
        OwnerPlanDto ownerPlanDto1 = mapToDto(saveedOwnerPlan);
        return ownerPlanDto1;
    }

    OwnerPlan mapToEntity(OwnerPlanDto ownerPlanDto){
        OwnerPlan map = modelMapper.map(ownerPlanDto, OwnerPlan.class);
        return map;
    }
    OwnerPlanDto mapToDto(OwnerPlan ownerPlan){
        OwnerPlanDto ownerPlanDto = modelMapper.map(ownerPlan, OwnerPlanDto.class);
        return ownerPlanDto;
    }
}
