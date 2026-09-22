import java.util.*;

class RobotLivreur {
    private final PlanificateurTrajet planificateur;
    private final Notification notification;
    private final Random random = new Random();

    public RobotLivreur(PlanificateurTrajet planificateur, Notification notification) {
        this.planificateur = planificateur;
        this.notification = notification;
    }

    public void livrer(Commande commande, Carte carte, Point positionPizzeria) throws LivraisonRateeException {
        commande.setStatut(StatutCommande.EN_ROUTE);

        notification.envoyer(commande.getClient(),
                "Votre " + commande.getPizza().getNom() + " est en route. Total = " + commande.prixTotal() + " DH");

        Point destination = new Point(commande.getClient().getAdresse().x(), commande.getClient().getAdresse().y());
        List<Point> chemin = planificateur.calculerTrajet(carte, positionPizzeria, destination);

        if (chemin.isEmpty()) {
            commande.setStatut(StatutCommande.ECHEC);
            throw new LivraisonRateeException(CauseEchec.INACCESSIBLE, "Aucun chemin trouvé (obstacles).");
        }

        // Simulation "chat vole pizza" avec probabilité
        if (random.nextDouble() < 0.15) {
            commande.setStatut(StatutCommande.ECHEC);
            throw new LivraisonRateeException(CauseEchec.CHAT_VOLE_PIZZA, "Un chat a volé la pizza");
        }

        // Sinon livrée
        commande.setStatut(StatutCommande.LIVREE);
        notification.envoyer(commande.getClient(), "Livraison effectuée ! Bon appétit 🍕");
    }
}
