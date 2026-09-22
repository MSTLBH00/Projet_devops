

public class Main {
    public static void main(String[] args) {
        Carte carte = new Carte(10, 10);
        carte.ajouterObstacle(3,3);
        carte.ajouterObstacle(3,4);
        carte.ajouterObstacle(3,5);

        Client c = new Client("Saad", "0600000000", "saad@mail.com",
                new Adresse("Rue X", "Rabat", 8, 8));

        Pizza p = new PizzaFromage(Taille.M);
        p.ajouterGarniture(Garniture.OLIVES);
        p.setExtraFromage(true);

        Commande cmd = new Commande(c, p);

        RobotLivreur robot = new RobotLivreur(new PlanificateurTrajet(), new NotificationSMS());

        try {
            robot.livrer(cmd, carte, new Point(0,0));
            System.out.println("STATUT FINAL = " + cmd.getStatut());
        } catch (LivraisonRateeException e) {
            System.out.println("ECHEC (" + e.getCauseEchec() + ") : " + e.getMessage());
        }
    }
}
