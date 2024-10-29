package org.campus.numerique.client.web.dao;

import org.campus.numerique.client.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

// Interface ClientDao : définit les méthodes d'accès aux données pour l'entité Client.
// Elle ne contient que des signatures de méthodes, sans implémentation, ce qui permet
// de séparer la logique métier de la logique de persistance.
public interface ClientDao {

    // Méthode pour récupérer la liste de tous les clients
    // Retourne une liste contenant tous les objets Client.
    List<Client> findAll();

    // Méthode pour récupérer un client spécifique par son ID
    // Prend un entier id comme paramètre et retourne l'objet Client correspondant.
    Client findById(int id);

    // Méthode pour sauvegarder un nouveau client
    // Prend un objet Client en paramètre et retourne le client après l'avoir sauvegardé.
    Client save(Client client);

    // Méthode pour mettre à jour un client existant
    // Prend un entier id pour identifier le client à mettre à jour, et un objet Client avec les nouvelles informations.
    // Retourne le client mis à jour.
    Client updateClient(int id, Client client);

    // Méthode pour supprimer un client par son ID
    // Prend un entier id comme paramètre et retourne le client supprimé.
    Client deleteClient(int id);
}
