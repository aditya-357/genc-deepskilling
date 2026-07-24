package com.aditya.gym_managment_system.service;

import com.aditya.gym_managment_system.entity.Plan;
import com.aditya.gym_managment_system.exception.ResourceNotFoundException;
import com.aditya.gym_managment_system.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlanServiceImp implements PlanService {

    private  final PlanRepository planrepository;

    public PlanServiceImp( PlanRepository planrepository){
        this.planrepository=planrepository;
    }

    @Override
    public Plan createPlan(Plan plan){
       return  planrepository.save(plan);
    }

    @Override
    public List<Plan> getAllPlans(){
       return planrepository.findAll();
    }

    @Override
    public Plan getPlanById(Long id){
        return planrepository.findById(id).orElseThrow(( ()-> new ResourceNotFoundException("plan not found with " + id) ));
    }

    @Override
    public Plan updatePlan(Long id, Plan plan) {

        Plan existingPlan = getPlanById(id);
        existingPlan.setPlanName(plan.getPlanName());
        existingPlan.setPrice(plan.getPrice());
        existingPlan.setDiscount(plan.getDiscount());
        existingPlan.setDurationMonth(plan.getDurationMonth());

        return planrepository.save(existingPlan);
    }

    @Override
    public void deletePlan(Long id){
        getPlanById(id);   // ensure user exists
        planrepository.deleteById(id);
    }
}
