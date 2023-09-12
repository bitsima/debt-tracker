package bitsima.debttracker.service;

import org.springframework.stereotype.Service;

import bitsima.debttracker.repository.MunicipalityAdminRepository;

@Service
public class MunicipalityAdminService {
    private final MunicipalityAdminRepository municipalityAdminRepository;

    /**
     * @param municipalityAdminRepository
     */
    public MunicipalityAdminService(MunicipalityAdminRepository municipalityAdminRepository) {
        this.municipalityAdminRepository = municipalityAdminRepository;
    }

}
