package com.aditya.gym_managment_system.service;

import java.util.List;
import com.aditya.gym_managment_system.entity.Plan;

public interface PlanService {
     Plan createPlan(Plan plan);
     List<Plan>  getAllPlans();
     Plan getPlanById(Long id);
     Plan updatePlan(Long id, Plan plan);
     void deletePlan(Long id);


}
