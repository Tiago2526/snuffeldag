package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

// Configuratieklasse voor het instellen van variabelen
class Config {
    // Tekst van de knop
    static String buttonText = "Klik op mij!";
    // Breedte en hoogte van het venster
    static int windowWidth = 600;
    static int windowHeight = 400;

    // Instellingen voor de eerste vorm (cirkel)
    static String shapeType1 = "circle";
    static Color shapeColor1 = Color.BLUE;
    static double shapeSize1 = 100;
    static double shapeXPosition1 = 100; // X-positie van de eerste vorm
    static double shapeYPosition1 = 100; // Y-positie van de eerste vorm

    // Instellingen voor de tweede vorm (rechthoek)
    static String shapeType2 = "rectangle";
    static Color shapeColor2 = Color.GREEN;
    static double shapeSize2 = 150;
    static double shapeXPosition2 = 200; // X-positie van de tweede vorm
    static double shapeYPosition2 = 200; // Y-positie van de tweede vorm

    // Instellingen voor de derde vorm (ellips)
    static String shapeType3 = "ellipse";
    static Color shapeColor3 = Color.YELLOW;
    static double shapeSize3 = 75;
    static double shapeXPosition3 = 300; // X-positie van de derde vorm
    static double shapeYPosition3 = 300; // Y-positie van de derde vorm

    // Instellingen voor de vierde vorm (veelhoek)
    static String shapeType4 = "polygon";
    static Color shapeColor4 = Color.ORANGE;
    static double shapeSize4 = 120;
    static double shapeXPosition4 = 400; // X-positie van de vierde vorm
    static double shapeYPosition4 = 100; // Y-positie van de vierde vorm

    // Instellingen voor de vijfde vorm (lijn)
    static String shapeType5 = "line";
    static Color shapeColor5 = Color.PURPLE;
    static double shapeSize5 = 50;
    static double shapeXPosition5 = 500; // X-positie van de vijfde vorm
    static double shapeYPosition5 = 200; // Y-positie van de vijfde vorm

    // Kleur van de knop
    static Color buttonColor = Color.RED;
    // Lettergrootte van de knop
    static double buttonSize = 20;
    // Zichtbaarheid van de vormen
    static boolean isShapeVisible = true;
    // Titel van het venster
    static String windowTitle = "Verbeterde JavaFX App";
    // Achtergrondkleur van het venster
    static Color backgroundColor = Color.LIGHTGRAY;
    // X- en Y-positie van de knop
    static double buttonXPosition = 0;
    static double buttonYPosition = 0;
    // Zichtbaarheid van de knop
    static boolean isButtonVisible = true;
    // Breedte en hoogte van de knop
    static double buttonWidth = 100;
    static double buttonHeight = 50;
    // Lijndikte en kleur van de vormen
    static double shapeStrokeWidth = 2;
    static Color shapeStrokeColor = Color.BLACK;
}

public class EnhancedJavaFXApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Maak een knop met de tekst uit de variabele
        Button btn = new Button(Config.buttonText);
        btn.setStyle("-fx-background-color: " + toRgbString(Config.buttonColor) + "; -fx-font-size: " + Config.buttonSize + "px;");
        btn.setMinWidth(Config.buttonWidth);
        btn.setMinHeight(Config.buttonHeight);
        btn.setLayoutX(Config.buttonXPosition);
        btn.setLayoutY(Config.buttonYPosition);
        btn.setVisible(Config.isButtonVisible);

        // Maak een lay-out en voeg de vormen en knop toe
        Pane root = new Pane();
        root.setStyle("-fx-background-color: " + toRgbString(Config.backgroundColor) + ";");

        // Voeg vormen toe aan de lay-out op basis van de variabelen
        if (Config.isShapeVisible) {
            addShape(root, Config.shapeType1, Config.shapeSize1, Config.shapeColor1, Config.shapeXPosition1, Config.shapeYPosition1);
            addShape(root, Config.shapeType2, Config.shapeSize2, Config.shapeColor2, Config.shapeXPosition2, Config.shapeYPosition2);
            addShape(root, Config.shapeType3, Config.shapeSize3, Config.shapeColor3, Config.shapeXPosition3, Config.shapeYPosition3);
            addShape(root, Config.shapeType4, Config.shapeSize4, Config.shapeColor4, Config.shapeXPosition4, Config.shapeYPosition4);
            addShape(root, Config.shapeType5, Config.shapeSize5, Config.shapeColor5, Config.shapeXPosition5, Config.shapeYPosition5);
        }

        // Voeg de knop toe aan de lay-out
        root.getChildren().add(btn);

        // Voeg een actie toe aan de knop om de kleur van de vormen te veranderen
        btn.setOnAction(event -> {
            for (var node : root.getChildren().filtered(node -> node instanceof Shape)) {
                Shape shape = (Shape) node;
                shape.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            }
            btn.setText("Je klikte op mij!");
        });

        // Maak een scène met de vensterafmetingen uit de variabelen
        Scene scene = new Scene(root, Config.windowWidth, Config.windowHeight);

        // Stel het podium in en toon het
        primaryStage.setTitle(Config.windowTitle);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helpermethode om een vorm toe te voegen aan de lay-out
    private void addShape(Pane root, String type, double size, Color color, double x, double y) {
        Shape shape = createShape(type, size, color);
        if (shape != null) {
            shape.setStrokeWidth(Config.shapeStrokeWidth);
            shape.setStroke(Config.shapeStrokeColor);
            shape.setLayoutX(x);
            shape.setLayoutY(y);
            root.getChildren().add(shape);
        }
    }

    // Helpermethode om een vorm te maken op basis van het type, grootte en kleur
    private Shape createShape(String type, double size, Color color) {
        switch (type.toLowerCase()) {
            case "rectangle":
                return new Rectangle(size, size, color);
            case "circle":
                return new Circle(size / 2, color);
            case "ellipse":
                Ellipse ellipse = new Ellipse(size / 2, size / 3);
                ellipse.setFill(color);
                return ellipse;
            case "polygon":
                Polygon polygon = new Polygon();
                polygon.getPoints().addAll(
                        0.0, 0.0,
                        size, 0.0,
                        size / 2, size
                );
                polygon.setFill(color);
                return polygon;
            case "line":
                Line line = new Line(0, 0, size, size);
                line.setStroke(color);
                return line;
            default:
                return null;
        }
    }

    // Helpermethode om Color om te zetten naar RGB-string
    private static String toRgbString(Color color) {
        int r = (int) (color.getRed() * 255);
        int g = (int) (color.getGreen() * 255);
        int b = (int) (color.getBlue() * 255);
        return String.format("rgb(%d, %d, %d)", r, g, b);
    }

    public static void main(String[] args) {
        launch(args);
    }
}