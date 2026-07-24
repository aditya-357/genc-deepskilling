package com.aditya.gym_managment_system.controller;

import com.aditya.gym_managment_system.entity.Plan;
import com.aditya.gym_managment_system.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/plans")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService){
        this.planService=planService;
    }

    @PostMapping
    public Plan createPlan(@RequestBody Plan plan){
        return planService.createPlan(plan);
    }

    @GetMapping
    public List<Plan>  getAllPlans(){
        return planService.getAllPlans();
    }

    @GetMapping("/{id}")
    public Plan getById(@PathVariable Long id){
        return planService.getPlanById(id);
    }

    @PutMapping("/{id}")
    public Plan updatePlan(@PathVariable Long id , @RequestBody Plan plan){

    return planService.updatePlan(id, plan);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long  id){
        planService.deletePlan(id);
    }
}
