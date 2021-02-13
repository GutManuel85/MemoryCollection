package sample;

public enum Level {

    EASY("Leicht",3000), INTERMEDIATE("Mittel", 2000), DIFFICULT("Schwer", 600);

    private final String text;
    private final int milliSec;

    private Level(String text, int milliSec){
        this.text = text;
        this.milliSec = milliSec;
    }

    public String getText() {
        return text;
    }

    public int getMilliSec() {
        return milliSec;
    }
}
