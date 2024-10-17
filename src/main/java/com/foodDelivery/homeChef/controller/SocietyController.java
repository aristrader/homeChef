package com.foodDelivery.homeChef.controller;

import com.foodDelivery.homeChef.constant.PathConstants;
import com.foodDelivery.homeChef.dto.SocietyDTO;
import com.foodDelivery.homeChef.exception.ServiceException;
import com.foodDelivery.homeChef.model.SocietyRequest;
import com.foodDelivery.homeChef.rest.RestResponse;
import com.foodDelivery.homeChef.service.SocietyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PathConstants.SOCIETY)
@Slf4j
@RequiredArgsConstructor
public class SocietyController {

    private final SocietyService societyService;

    @PostMapping(PathConstants.ADD)
    public ResponseEntity<RestResponse> addSociety(@Valid @RequestBody SocietyRequest request)
            throws ServiceException {
        log.info("[SocietyControllerV2] Received request to add society: {}", request);
        Integer societyIdCreated = societyService.addSociety(request);
        RestResponse response = RestResponse.successResponse(
                String.format("The society has been successfully inserted with id : %d", societyIdCreated));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(PathConstants.GET_BY_ID)
    public ResponseEntity<RestResponse> getSocietyById(@PathVariable("id") int societyId)
            throws ServiceException {
        log.info("[SocietyControllerV2] Received request to get society by ID: {}", societyId);
        SocietyDTO result = societyService.getSocietyById(societyId);
        RestResponse response = RestResponse.successResponse(result);
        return ResponseEntity.ok(response);
    }

    @GetMapping(PathConstants.GET_ALL)
    public ResponseEntity<RestResponse> getAllSocieties() throws ServiceException {
        log.info("[SocietyControllerV2] Received request to get all societies");
        List<SocietyDTO> result = societyService.getAllSocieties();
        RestResponse response = RestResponse.successResponse(result);
        return ResponseEntity.ok(response);
    }
}
