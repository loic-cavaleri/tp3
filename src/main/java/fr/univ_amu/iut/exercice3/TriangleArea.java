package fr.univ_amu.iut.exercice3;


import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TriangleArea {

    private IntegerProperty x1 = new SimpleIntegerProperty(0);
    private IntegerProperty y1 = new SimpleIntegerProperty(0);

    private IntegerProperty x2 = new SimpleIntegerProperty(0);
    private IntegerProperty y2 = new SimpleIntegerProperty(0);

    private IntegerProperty x3 = new SimpleIntegerProperty(0);
    private IntegerProperty y3 = new SimpleIntegerProperty(0);

    private DoubleProperty area = new SimpleDoubleProperty(0);

    public TriangleArea() {
        createBinding();


    }

    public static void main(String[] args) {
        TriangleArea triangleArea = new TriangleArea();

        triangleArea.printResult();

        triangleArea.setP1(0, 1);
        triangleArea.setP2(6, 0);
        triangleArea.setP3(4, 3);

        triangleArea.printResult();

        triangleArea.setP1(1, 0);
        triangleArea.setP2(2, 2);
        triangleArea.setP3(0, 1);

        triangleArea.printResult();
    }

    public void setP1(int x1, int y1) {
        this.x1.set(x1);
        this.y1.set(y1);
    }

    public void setP2(int x2, int y2) {
        this.x2.set(x2);
        this.y2.set(y2);
    }

    public void setP3(int x3, int y3) {
        this.x3.set(x3);
        this.y3.set(y3);
    }

    public int getX1() {
        return x1.get();
    }

    public void setX1(int x1) {
        this.x1.set(x1);
    }

    public IntegerProperty x1Property() {
        return x1;
    }

    public int getY1() {
        return y1.get();
    }

    public void setY1(int y1) {
        this.y1.set(y1);
    }

    public IntegerProperty y1Property() {
        return y1;
    }

    public int getX2() {
        return x2.get();
    }

    public void setX2(int x2) {
        this.x2.set(x2);
    }

    public IntegerProperty x2Property() {
        return x2;
    }

    public int getY2() {
        return y2.get();
    }

    public void setY2(int y2) {
        this.y2.set(y2);
    }

    public IntegerProperty y2Property() {
        return y2;
    }

    public int getX3() {
        return x3.get();
    }

    public void setX3(int x3) {
        this.x3.set(x3);
    }

    public IntegerProperty x3Property() {
        return x3;
    }

    public int getY3() {
        return y3.get();
    }

    public void setY3(int y3) {
        this.y3.set(y3);
    }

    public IntegerProperty y3Property() {
        return y3;
    }

    public double getArea() {
        return area.getValue();
    }

    public DoubleProperty areaProperty() {
        return area;
    }

    void printResult() {

        System.out.println("For P1("+x1.get()+","+y1.get()+"), P2("+x2.get()+","+y2.get()+"), P3("+x3.get()+","+y3.get()+"), the area of triangle ABC is "+area.get());
    }

    private void createBinding() {


        NumberBinding x1y2 = Bindings.multiply(x1,y2);
        NumberBinding x1y3 = Bindings.multiply(x1,y3);
        NumberBinding x2y3 = Bindings.multiply(x2,y3);
        NumberBinding x2y1 = Bindings.multiply(x2,y1);
        NumberBinding x3y1 = Bindings.multiply(x3,y1);
        NumberBinding x3y2 = Bindings.multiply(x3,y2);
        NumberBinding result =  (x1y2
                .subtract(x1y3)
                .add(x2y3)
                .subtract(x2y1)
                .add(x3y1)
                .subtract(x3y2)
                .divide(2.0));

        area.bind(result);



        area.bind(Bindings.when(result.lessThan(0))
                .then(result.multiply(-1))
                .otherwise(result));

    }
}
