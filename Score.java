public class Score {
    private final int total ;
    private final int  yellow;

    public Score(int key, int value) {
        this.total = key;
        this.yellow = value;
    }

    public int getTotal() {
        return total;
    }

    public int getYellow() {
        return yellow;
    }
}
