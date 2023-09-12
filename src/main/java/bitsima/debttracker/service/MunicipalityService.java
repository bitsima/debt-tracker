package bitsima.debttracker.service;

import org.springframework.stereotype.Service;

import bitsima.debttracker.repository.MunicipalityRepository;

@Service
public class MunicipalityService {
    private final MunicipalityRepository municipalityRepository;

    /**
     * @param municipalityRepository
     */
    public MunicipalityService(MunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }

}
