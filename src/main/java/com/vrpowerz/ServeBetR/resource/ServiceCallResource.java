package com.vrpowerz.ServeBetR.resource;

import com.vrpowerz.ServeBetR.model.ServiceCall;
import com.vrpowerz.ServeBetR.repository.ServiceCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

/**
 * @author Venkataraghavan Yanamandram
 *
 */

@RestController
@RequestMapping("/api/calls/")
public class ServiceCallResource {

    @Autowired
    private ServiceCallRepository serviceCallRepository;

    @GetMapping("/{page}/{size}")
    public Response viewAll(@PathVariable("page") final Integer page, @PathVariable("size") final Integer size){
        try {
            Page<ServiceCall> serviceCalls = serviceCallRepository.findAll(PageRequest.of(page,size));
            return new Response(serviceCalls);
        }catch (Exception e){
            return new Response(null, "Unable to get Service Call list.", false, e.toString());
        }
    }

    @GetMapping("/{id}")
    public Response view(@PathVariable("id") final  Long id){
        try {
            return new Response(serviceCallRepository.findById(id).orElse(null));
        }catch (Exception e){
            return new Response(null, "Unable to get Service Call.", false, e.toString());
        }
    }

    @PostMapping("/save")
    public Response createCall(@RequestBody final ServiceCall serviceCall){
        try {
            serviceCall.setTimestamp(Calendar.getInstance().getTime());
            serviceCallRepository.save(serviceCall);
            return new Response(serviceCall);
        }catch (Exception e){
            return new Response(null, "Unable to create Service Call.", false, e.toString());
        }
    }

    @PutMapping("/update")
    public Response updateCall(@RequestBody final ServiceCall serviceCall){
        try {
            ServiceCall serviceCall1 = serviceCallRepository.findById(serviceCall.getId()).orElse(null);
            serviceCall1.setSubject(serviceCall.getSubject());
            serviceCall1.setDetails(serviceCall.getDetails());
            serviceCall1.setCustomer(serviceCall.getCustomer());
            serviceCall1.setSchedule(serviceCall.getSchedule());
            serviceCall1.setCompleted(serviceCall.getCompleted());
            serviceCall1.setAddress(serviceCall.getAddress());
            serviceCall1.setRescheduleHistories(serviceCall.getRescheduleHistories());
            serviceCall1.setStatus(serviceCall.getStatus());
            serviceCall1.setDescription(serviceCall.getDescription());

            serviceCallRepository.save(serviceCall1);

            return new Response(serviceCall1);
        }catch (Exception e){
            return new Response(null, "Unable to update Service Call.", false, e.toString());
        }
    }

    @PutMapping("/update/status")
    public Response updateSttus(@RequestBody final ServiceCall serviceCall){
        try {
            ServiceCall serviceCall1 = serviceCallRepository.findById(serviceCall.getId()).orElse(null);
            serviceCall1.setStatus(serviceCall.getStatus());
            serviceCallRepository.save(serviceCall1);
            return new Response(serviceCall1);
        }catch (Exception e){
            return new Response(null, "Unable to update Service Call Status.", false, e.toString());
        }
    }


}
