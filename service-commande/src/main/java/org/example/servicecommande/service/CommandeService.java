package org.example.servicecommande.service;

import org.example.servicecommande.entity.Commande;
import org.example.servicecommande.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    public Commande creerCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public List<Commande> obtenirToutesLesCommandes() {
        return commandeRepository.findAll();
    }
}
