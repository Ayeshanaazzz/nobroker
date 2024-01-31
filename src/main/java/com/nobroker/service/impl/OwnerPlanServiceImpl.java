package com.nobroker.service.impl;

import com.nobroker.entity.OwnerPlan;
import com.nobroker.payload.OwnerPlanDto;
import com.nobroker.repository.OwnerPlanRepositroy;
import com.nobroker.service.OwnerPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

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

    @Override
    public List<OwnerPlanDto> getOwnersPlan() {
        List<OwnerPlan> all = ownerPlanRepositroy.findAll();
        List<OwnerPlanDto> collect = all.stream().map(plan -> mapToDto(plan)).collect(Collectors.toList());
        return collect;
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
