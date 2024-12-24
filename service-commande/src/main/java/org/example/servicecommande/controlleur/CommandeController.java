package org.example.servicecommande.controlleur;

import org.example.servicecommande.entity.Commande;
import org.example.servicecommande.service.CommandeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public Commande creerCommande(@RequestBody Commande commande) {
        Commande nouvelleCommande = commandeService.creerCommande(commande);
        kafkaTemplate.send("commande_topic", String.valueOf(nouvelleCommande.getId()));
        return nouvelleCommande;
    }

    @GetMapping
    public List<Commande> obtenirToutesLesCommandes() {
        return commandeService.obtenirToutesLesCommandes();
    }

    @GetMapping("/{id}")
    public Commande obtenirCommandeParId(@PathVariable Long id) {
        return commandeService.obtenirCommandeParId(id);
    }
}

