import java.util.*;

record Point(int x, int y) {}

class Carte {
    private final int largeur;
    private final int hauteur;
    private final boolean[][] bloque; // true = obstacle

    public Carte(int largeur, int hauteur) {
        this.largeur = largeur; this.hauteur = hauteur;
        this.bloque = new boolean[hauteur][largeur];
    }

    public void ajouterObstacle(int x, int y) { bloque[y][x] = true; }
    public boolean estBloque(int x, int y) { return bloque[y][x]; }
    public boolean dedans(int x, int y) { return x>=0 && x<largeur && y>=0 && y<hauteur; }
}

class PlanificateurTrajet {
    public List<Point> calculerTrajet(Carte carte, Point depart, Point arrivee) {
        Map<Point, Point> parent = new HashMap<>();
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.add(depart);
        parent.put(depart, null);

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        while(!q.isEmpty()) {
            Point p = q.poll();
            if (p.equals(arrivee)) break;

            for(int i=0;i<4;i++){
                int nx = p.x()+dx[i], ny = p.y()+dy[i];
                Point np = new Point(nx, ny);
                if (!carte.dedans(nx, ny)) continue;
                if (carte.estBloque(nx, ny)) continue;
                if (parent.containsKey(np)) continue;
                parent.put(np, p);
                q.add(np);
            }
        }

        if (!parent.containsKey(arrivee)) return List.of(); // aucun chemin

        // reconstruire chemin
        List<Point> chemin = new ArrayList<>();
        for(Point cur = arrivee; cur != null; cur = parent.get(cur)) chemin.add(cur);
        Collections.reverse(chemin);
        return chemin;
    }
}
