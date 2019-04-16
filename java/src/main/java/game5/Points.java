package game5;

public enum Points {
    LOVE("Love"),
    FIFTEEN("Fifteen"),
    THIRTY("Thirty"),
    FORTY("Forty");

    private final String str;

    Points(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
    }
}
