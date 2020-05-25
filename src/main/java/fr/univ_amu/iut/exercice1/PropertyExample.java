package fr.univ_amu.iut.exercice1;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;

public class PropertyExample {
    private ChangeListener changeListener;
    private InvalidationListener invalidationListener;

    private IntegerProperty anIntProperty;

    public static void main(String[] args) {
        PropertyExample propertyExample = new PropertyExample();
        propertyExample.createProperty();
        propertyExample.addAndRemoveInvalidationListener();
        propertyExample.addAndRemoveChangeListener();
    }

    void createProperty() {

        anIntProperty = new SimpleIntegerProperty(1024);

        System.out.println();
        System.out.println("anIntProperty = "+ anIntProperty);
        System.out.println("anIntProperty.get() = " + anIntProperty.get());
        System.out.println("anIntProperty.getValue() = "+ anIntProperty.getValue());

        ChangeListener changelistener = ((observableValue, oldValue, newValue) ->{
            System.out.println("The observableValue has changed: oldValue = "+ oldValue + ", newValue = "+ newValue);
        } );

    }

    void addAndRemoveInvalidationListener() {

        System.out.println();

    }

    void addAndRemoveChangeListener() {
        throw new RuntimeException("Not yet implemented !");
    }


    public int getAnInt() {
        return anIntProperty.get();
    }

    public void setAnInt(int anInt) {
        if (anIntProperty == null)
            anIntProperty = new SimpleIntegerProperty();
        this.anIntProperty.set(anInt);
    }

    public IntegerProperty anIntProperty() {
        return anIntProperty;
    }

}