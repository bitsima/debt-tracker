package bitsima.debttracker.service;

import org.springframework.stereotype.Service;

import bitsima.debttracker.repository.SystemAdminRepository;

@Service
public class SystemAdminService {
    private final SystemAdminRepository systemAdminRepository;

    /**
     * @param systemAdminRepository
     */
    public SystemAdminService(SystemAdminRepository systemAdminRepository) {
        this.systemAdminRepository = systemAdminRepository;
    }

}
