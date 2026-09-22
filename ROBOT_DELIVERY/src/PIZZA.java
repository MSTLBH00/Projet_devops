import java.util.*;

abstract class Pizza {
    private final Taille taille;
    private final Set<Garniture> garnitures = new HashSet<>();
    private boolean extraFromage;

    protected Pizza(Taille taille) {
        this.taille = Objects.requireNonNull(taille);
    }

    public Taille getTaille() { return taille; }
    public Set<Garniture> getGarnitures() { return Collections.unmodifiableSet(garnitures); }
    public boolean isExtraFromage() { return extraFromage; }

    public void ajouterGarniture(Garniture g) { garnitures.add(g); }
    public void setExtraFromage(boolean extra) { this.extraFromage = extra; }

    public abstract String getNom();

    public double calculerPrix() {
        double base = switch (taille) {
            case S -> 35.0;
            case M -> 50.0;
            case L -> 65.0;
        };
        double supplGarnitures = garnitures.size() * 5.0;
        double supplFromage = extraFromage ? 7.0 : 0.0;
        return base + supplGarnitures + supplFromage;
    }
}

class PizzaFromage extends Pizza {
    public PizzaFromage(Taille taille) { super(taille); }
    @Override public String getNom() { return "Pizza Fromage"; }
}

class PizzaVegetarienne extends Pizza {
    public PizzaVegetarienne(Taille taille) { super(taille); }
    @Override public String getNom() { return "Pizza Végétarienne"; }
}

