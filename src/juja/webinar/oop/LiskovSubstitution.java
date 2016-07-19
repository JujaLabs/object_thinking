package juja.webinar.oop;

/**
 * Substitutability is a principle in object-oriented programming that states that,
 * in a computer program, if S is a subtype of T, then objects of type T may be replaced
 * with objects of type S (i.e., an object of the type T may be substituted with its subtype
 * object of the type S) without altering any of the desirable properties of that program
 * (correctness, task performed, etc.).
 *
 * @author viktor email kuchin.victor@gmail.com
 */
public class LiskovSubstitution {

    public static void main(String[] args) {
        Shape rect = new Quadrate(2);
        rect.setWidth(2);
        rect.setHeight(3);
        System.out.println(rect.square());
        rect.setWidth(4);
        System.out.println(rect.square());
    }
}

abstract class Shape{
    abstract float square();

    abstract void setWidth(float width);
    abstract void setHeight(float height);

}

final class Rectangle extends Shape{

    private float width;
    private float height;

    public float square() {
        return width * height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}

class Quadrate extends Shape {

    Rectangle rect = new Rectangle();

    public Quadrate(float a) {
        super();
    }

    @Deprecated
    public void setWidth(float width) {
        rect.setWidth(width);
        rect.setHeight(width);
    }

    @Deprecated
    public void setHeight(float height) {
        setWidth(height);
    }

    @Override
    float square() {
        return rect.square();
    }
}


