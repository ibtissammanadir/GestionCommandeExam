package org.example.serviceproduit.controlleur;

import org.example.serviceproduit.entity.Produit;
import org.example.serviceproduit.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produits")
public class ProduitControlleur {

    @Autowired
    private ProduitService produitService;

    @PostMapping
    public Produit ajouterProduit(@RequestBody Produit produit) {
        return produitService.ajouterProduit(produit);
    }

    @GetMapping
    public List<Produit> obtenirTousLesProduits() {
        return produitService.obtenirTousLesProduits();
    }

    @GetMapping("/{id}")
    public Optional<Produit> obtenirProduitParId(@PathVariable Long id) {
        return produitService.obtenirProduitParId(id);
    }

    @PutMapping("/{id}")
    public Produit modifierProduit(@PathVariable Long id, @RequestBody Produit produitDetails) {
        return produitService.modifierProduit(id, produitDetails);
    }

    @DeleteMapping("/{id}")
    public void supprimerProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
    }
}

