/**
 * 
 */
/**
 * Cette méthode "Ajax" affiche la liste des commandes.
 */
function preparerCommande(idCommande) {
    var xhr = new XMLHttpRequest();
    
    xhr.onload = function () {
        if (xhr.status === 200) {
            // Cacher le bouton "Préparer" et afficher "Terminer"
            document.getElementById("preparer-btn").style.display = "none";
            document.getElementById("terminer-btn").style.display = "inline-block";
        } else {
            alert("Erreur lors de la mise à jour de la commande.");
        }
    };

    // Envoi de la requête AJAX pour changer l'état à "PREPAREE"
    xhr.open("POST", "ServletEtatCommande", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("idCommande=" + idCommande + "&etat=EN_PREPARATION");
}

function terminerCommande(idCommande) {
    var xhr = new XMLHttpRequest();
    
    xhr.onload = function () {
        if (xhr.status === 200) {
            // Désactiver le bouton "Terminer" après mise à jour
            document.getElementById("terminer-btn").disabled = true;
            document.getElementById("terminer-btn").textContent = "Livrée";
        } else {
            alert("Erreur lors de la mise à jour de la commande.");
        }
    };

    // Envoi de la requête AJAX pour changer l'état à "LIVREE"
    xhr.open("POST", "ServletEtatCommande", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("idCommande=" + idCommande + "&etat=LIVREE");
}


/**
 * Lancement après le chargement du DOM.
 */
document.addEventListener("DOMContentLoaded", () => {});