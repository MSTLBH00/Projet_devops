public class LivraisonRateeException extends Exception {
    private final CauseEchec cause;
    public LivraisonRateeException(CauseEchec cause, String msg) {
        super(msg);
        this.cause = cause;
    }
    public CauseEchec getCauseEchec() { return cause; }
}