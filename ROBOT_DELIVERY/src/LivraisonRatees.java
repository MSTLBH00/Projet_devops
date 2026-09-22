public class LivraisonRatees extends Exception {
    private final CauseEchec cause;
    public LivraisonRatees(CauseEchec cause, String msg) {
        super(msg);
        this.cause = cause;
    }
    public CauseEchec getCauseEchec() { return cause; }
}
