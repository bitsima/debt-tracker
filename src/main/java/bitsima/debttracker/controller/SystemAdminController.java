package bitsima.debttracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitsima.debttracker.service.MunicipalityAdminService;
import bitsima.debttracker.service.MunicipalityService;

@RestController
@RequestMapping("/api/v1/system")
public class SystemAdminController {
    /*
     * /municipalities GET
     * /municipalities POST (create municipalities)
     * /municipalities/{municipalityId} PUT or PATCH (update name, address, contact
     * info)
     * /municipalities/{municipalityId} DELETE
     * /municipalities/admins GET -> view a municipality's admins
     */

    private final MunicipalityService municipalityService;
    private final MunicipalityAdminService municipalityAdminService;

    /**
     * @param municipalityService
     * @param municipalityAdminService
     */
    public SystemAdminController(MunicipalityService municipalityService,
            MunicipalityAdminService municipalityAdminService) {
        this.municipalityService = municipalityService;
        this.municipalityAdminService = municipalityAdminService;
    }
}
