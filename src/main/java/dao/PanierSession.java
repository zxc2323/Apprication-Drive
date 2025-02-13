package dao;

import java.util.HashMap;
import java.util.Map;

public class PanierSession {
    private Integer userId; // Identifiant de l'utilisateur (peut être null si non connecté)
    private Map<Integer, Integer> produits; // Key: produitId, Value: quantité

    public PanierSession() {
        produits = new HashMap<>();
    }

    public PanierSession(Integer userId) {
        this.userId = userId;
        this.produits = new HashMap<>();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    // Ajouter un produit au panier
    public void ajouterProduit(int produitId, int quantite) {
        produits.put(produitId, produits.getOrDefault(produitId, 0) + quantite);
    }

    // Modifier la quantité d'un produit
    public void modifierQuantite(int produitId, int nouvelleQuantite) {
        if (produits.containsKey(produitId)) {
            if (nouvelleQuantite > 0) {
                produits.put(produitId, nouvelleQuantite);
            } else {
                produits.remove(produitId);
            }
        }
    }

    // Supprimer un produit du panier
    public void supprimerProduit(int produitId) {
        produits.remove(produitId);
    }

    // Récupérer le panier
    public Map<Integer, Integer> getProduits() {
        return produits;
    }

    // Vérifier si le panier est vide
    public boolean estVide() {
        return produits.isEmpty();
    }
}


