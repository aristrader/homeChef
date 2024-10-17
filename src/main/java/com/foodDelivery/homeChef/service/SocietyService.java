package com.foodDelivery.homeChef.service;

import com.foodDelivery.homeChef.dto.SocietyDTO;
import com.foodDelivery.homeChef.exception.ServiceException;
import com.foodDelivery.homeChef.jpa.entity.SocietyEntity;
import com.foodDelivery.homeChef.jpa.repository.SocietyRepository;
import com.foodDelivery.homeChef.model.SocietyRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SocietyService {

    private final SocietyRepository societyRepository;

    public Integer addSociety(SocietyRequest request) throws ServiceException {
        try {
            SocietyEntity entity = convertRequestToEntity(request);
            return societyRepository.save(entity).getSocietyId();
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException("[SocietyServiceV2] Data integrity violation: " + e.getMessage(),
                    ServiceException.HomeChefServiceErrorCodes.DATA_PERSISTENCE_ERROR);
        } catch (Exception e) {
            throw new ServiceException("[SocietyServiceV2] Failed to add society: " + e.getMessage(),
                    ServiceException.HomeChefServiceErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }

    public SocietyDTO getSocietyById(int societyId) throws ServiceException {
        try {
            SocietyEntity entity = societyRepository.findById(societyId).orElseThrow(
                    () -> new ServiceException("[SocietyServiceV2] Society not found for ID: " + societyId,
                            ServiceException.HomeChefServiceErrorCodes.SOCIETY_DETAILS_NOT_FOUND));
            return convertEntityToDTO(entity);
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("[SocietyServiceV2] Failed to retrieve society: " + e.getMessage(),
                    ServiceException.HomeChefServiceErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }

    public List<SocietyDTO> getAllSocieties() throws ServiceException {
        try {
            List<SocietyEntity> entities = societyRepository.findAll();

            if (entities.isEmpty()) {
                throw new ServiceException("[SocietyServiceV2] No societies found.",
                        ServiceException.HomeChefServiceErrorCodes.REQUESTED_DETAILS_NOT_FOUND);
            }

            return entities.stream()
                    .map(this::convertEntityToDTO)
                    .toList();
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new ServiceException("[SocietyServiceV2] Failed to retrieve societies: " + e.getMessage(),
                    ServiceException.HomeChefServiceErrorCodes.INTERNAL_SERVER_ERROR);
        }
    }


    private SocietyDTO convertEntityToDTO(SocietyEntity entity) {
        SocietyDTO dto = new SocietyDTO();
        dto.setSocietyId(entity.getSocietyId());
        dto.setSocietyName(entity.getSocietyName());
        dto.setAddress(entity.getSocietyAddress());
        return dto;
    }

    private SocietyEntity convertRequestToEntity(SocietyRequest request) {
        SocietyEntity entity = new SocietyEntity();
        entity.setSocietyName(request.getSocietyName());
        entity.setSocietyAddress(request.getAddress());
        return entity;
    }
}
