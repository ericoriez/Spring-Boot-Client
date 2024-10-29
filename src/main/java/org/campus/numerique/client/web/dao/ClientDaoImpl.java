package org.campus.numerique.client.web.dao;

import org.campus.numerique.client.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// Annotation @Repository indique que cette classe est un composant DAO (Data Access Object).
// Elle est chargée de gérer les opérations de persistance pour l'entité Client.
@Repository
public class ClientDaoImpl implements ClientDao {
    // Liste statique contenant des objets Client. Utilisée comme stockage en mémoire pour les tests.
    public static List<Client> clients = new ArrayList<>();

    // Bloc statique pour initialiser la liste avec quelques clients de test
    static {
        clients.add(new Client(0, new String("Moumen"), new String("Bourmoilard"), new String("14/03/14"), 1020145014));
        clients.add(new Client(1, new String("Tristan"), new String("Chadeuf"), new String("15/04/15"), 1780145014));
        clients.add(new Client(2, new String("Anthoine"), new String("Donat"), new String("16/05/16"), 1046154814));
    }

    // Implémentation de la méthode findAll() pour récupérer tous les clients
    // Retourne la liste des clients.
    @Override
    public List<Client> findAll() {
        return clients;
    }

    // Implémentation de la méthode findById() pour récupérer un client par son ID
    // Parcourt la liste des clients pour trouver celui qui a l'ID correspondant.
    @Override
    public Client findById(int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;// Retourne le client si trouvé
            }
        }
        return null;// Retourne null si aucun client ne correspond à l'ID
    }

    // Implémentation de la méthode save() pour ajouter un nouveau client à la liste
    // Ajoute le client passé en paramètre à la liste et le retourne.
    @Override
    public Client save(Client client) {
        clients.add(client);
        return client;
    }

    // Implémentation de la méthode updateClient() pour mettre à jour un client par son ID
    // Met à jour le client dans la liste avec les nouvelles informations fournies et le retourne.
    @Override
    public Client updateClient(int id,Client client) {
        return clients.set(id, client);// Remplace l'élément à l'index id par le nouveau client et le retourne
    }

    // Implémentation de la méthode deleteClient() pour supprimer un client par son ID
    // Supprime le client dans la liste à l'index correspondant et le retourne.
    @Override
    public Client deleteClient(int id){
        return clients.remove(id);// Supprime et retourne le client supprimé
    }

}
