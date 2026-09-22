import java.util.UUID;

class Commande {
    private final String id = UUID.randomUUID().toString();
    private final Client client;
    private final Pizza pizza;
    private StatutCommande statut = StatutCommande.CREEE;

    public Commande(Client client, Pizza pizza) {
        this.client = client;
        this.pizza = pizza;
    }

    public String getId() { return id; }
    public Client getClient() { return client; }
    public Pizza getPizza() { return pizza; }
    public StatutCommande getStatut() { return statut; }
    public void setStatut(StatutCommande statut) { this.statut = statut; }

    public double prixTotal() { return pizza.calculerPrix(); }
}
