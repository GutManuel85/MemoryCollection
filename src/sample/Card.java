package sample;

import javafx.scene.image.Image;

import java.awt.*;
import java.util.Objects;

public class Card {

    private javafx.scene.image.Image image;

    public Card(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card) obj;
        return (this.getImage().getPixelReader().getColor(100, 100).equals(other.getImage().
                getPixelReader().getColor(100, 100)) && getImage().getPixelReader().
                getColor(10, 10).equals(other.getImage().getPixelReader().getColor(10, 10))) &&
                this.getImage().getPixelReader().getColor(50, 50).equals(other.getImage().
                        getPixelReader().getColor(50, 50)) && this.getImage().getPixelReader().getColor(40, 40).
                equals(other.getImage().getPixelReader().getColor(40, 40));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.image.getPixelReader().getColor(0, 0));
    }

    @Override
    public String toString() {
        return "" + hashCode();
    }
}
