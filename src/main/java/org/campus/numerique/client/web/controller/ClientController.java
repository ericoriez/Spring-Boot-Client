package org.campus.numerique.client.web.controller;


import org.campus.numerique.client.web.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.campus.numerique.client.model.Client;
import org.campus.numerique.client.web.dao.ClientDao;

import java.util.List;

// Annotation RestController indique que cette classe est un contrôleur REST,
// ce qui signifie que les méthodes de cette classe gèrent les requêtes HTTP
// et renvoient les réponses sous forme de JSON ou XML.
@RestController
public class ClientController {

    private final LicenseService licenseService;
    private final ClientDao clientDao;

    public ClientController(ClientDao clientDao, LicenseService licenseService) {
        this.clientDao = clientDao;
        this.licenseService = licenseService;
    }

    // Endpoint pour créer un nouveau client avec vérification du permis
    @PostMapping(value = "/Clients")
    public Client createClient(@RequestBody Client client) {
        System.out.println("Tentative de création du client : " + client);

        try {
            boolean isLicenseValid = licenseService.isLicenseValid(client.getNumeroPermis());
            System.out.println("Validation du numéro de permis : " + isLicenseValid);

            if (!isLicenseValid) {
                throw new RuntimeException("Le numéro de permis est invalide. Client non ajouté.");
            }

            return clientDao.save(client);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la création du client : " + e.getMessage());
        }
    }

    // Méthode pour vérifier la validité du numéro de permis d'un client existant par ID
    @GetMapping("/Clients/{id}/verify-license")
    public boolean verifyClientLicense(@PathVariable int id) {
        Client client = clientDao.findById(id);
        if (client == null) {
            throw new RuntimeException("Client avec l'ID " + id + " introuvable");
        }
        int licenseNumber = client.getNumeroPermis();
        return licenseService.isLicenseValid(licenseNumber);
    }

    // Autres méthodes CRUD
    @GetMapping("/Clients")
    public List<Client> listeClients() {
        return clientDao.findAll();
    }

    @GetMapping(value = "/Clients/{id}")
    public Client afficherUnClient(@PathVariable int id) {
        return clientDao.findById(id);
    }

    @PutMapping(value= "/Clients/{id}" )
    public Client updateClient(@PathVariable int id, @RequestBody Client client) {
        return clientDao.updateClient(id, client);
    }

    @DeleteMapping(value= "/Clients/{id}")
    public Client deleteClient(@PathVariable int id) {
        return clientDao.deleteClient(id);
    }
}
