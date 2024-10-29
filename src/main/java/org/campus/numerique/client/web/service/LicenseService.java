package org.campus.numerique.client.web.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.campus.numerique.client.model.LicenseResponse;
@Service
public class LicenseService {

    private final RestTemplate restTemplate;

    @Autowired
    public LicenseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isLicenseValid(int licenseNumber) {
        String url = "http://localhost:8081/licenses/" + licenseNumber;
        Boolean response = restTemplate.getForObject(url, Boolean.class);
        return response != null && response;
    }
}
