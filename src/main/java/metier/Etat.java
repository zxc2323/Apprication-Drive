package metier;

public enum Etat {
	EN_ATTENTE,  // Commande en attente de traitement
    EN_PREPARATION,    // Commande en cours de préparation
    LIVREE,      // Commande livrée au client
    ANNULEE      // Commande annulée
}
