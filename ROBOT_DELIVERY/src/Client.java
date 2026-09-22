class Adresse {
    private final String rue;
    private final String ville;
    private final int x;   // pour simuler la carte
    private final int y;

    public Adresse(String rue, String ville, int x, int y) {
        this.rue = rue; this.ville = ville; this.x = x; this.y = y;
    }
    public int x() { return x; }
    public int y() { return y; }
    @Override public String toString() { return rue + ", " + ville + " ("+x+","+y+")"; }
}

class Client {
    private final String nom;
    private final String tel;
    private final String email;
    private final Adresse adresse;

    public Client(String nom, String tel, String email, Adresse adresse) {
        this.nom = nom; this.tel = tel; this.email = email; this.adresse = adresse;
    }
    public String getNom() { return nom; }
    public String getTel() { return tel; }
    public String getEmail() { return email; }
    public Adresse getAdresse() { return adresse; }
}
