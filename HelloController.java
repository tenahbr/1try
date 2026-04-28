package org.example.demo2;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Box Box = new Box(200, 200, 200);
    private Rotate rotateXAxis;
    private Rotate rotateYAxis;
    private Translate translate;
    private PhongMaterial material = new PhongMaterial();
    private final double mouseSensitivity = 0.1;
    private final double movementSpeed = 10.0;
    private double mouseOldX, mouseOldY;
    private double mouseDeltaX, mouseDeltaY;

    @FXML
    private Circle Circle;
    Random random = new Random();

    @FXML
    private SplitMenuButton Figure;

    private Color generateRandomColor(Random random) {
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @FXML
    private Line Line;
    private double startAngle;
    private double anchorX, anchorY;

    @FXML
    private AnchorPane Pane;

    @FXML
    private AnchorPane Pane3 = new AnchorPane();
    private PerspectiveCamera camera;
    private final double rotationSpeed = 45.0;
    Group modelGroup = new Group();

    @FXML
    private Rectangle Rectangle;

    Line line1;
    Circle circle1;
    Rectangle rectangle1;
    double startMouseX;
    double startMouseY;
    double endMouseX;
    double endMouseY;

    @FXML
    private Slider Slider;

    @FXML
    private TabPane TabPane;

    @FXML
    private MenuItem black;

    @FXML
    private MenuItem blue;

    @FXML
    private SplitMenuButton color;

    private Color color1;

    @FXML
    private MenuItem menucircle;

    @FXML
    private MenuItem menuline;

    @FXML
    private MenuItem menurectangle;

    @FXML
    private Tab pane1;

    @FXML
    private Tab pane2;

    @FXML
    private MenuItem red;

    @FXML
    private Tab tabpane3;

    @FXML
    void ActionBlack(ActionEvent event) {
        color.setText("чёрный");

    }

    @FXML
    void ActionBlue(ActionEvent event) {
        color.setText("синий");

    }

    @FXML
    void ActionRed(ActionEvent event) {
        color.setText("Красный");

    }

    @FXML
    void LineMouseDragged(MouseEvent event) {
        double deltaX = event.getSceneX() - anchorX;
        double deltaY = event.getSceneY() - anchorY;
        double newAngle = Math.atan2(deltaY, deltaX) * 180 / Math.PI + 90;

        Line.setRotate(startAngle + newAngle);

    }

    @FXML
    void LineMousePressed(MouseEvent event) {
        anchorX = event.getSceneX();
        anchorY = event.getSceneY();
        startAngle = Line.getRotate();
    }

    @FXML
    void OnMouseClick(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            Circle.setFill(generateRandomColor(random));

        } else if (event.getButton() == MouseButton.SECONDARY) {
            Circle.setFill(Paint.valueOf("linear-gradient(from 0.0% 0.0% to 100.0% 100.0%, 0xd71b1bff 0.0%, 0xd71b1bff 0.6711409395973155%, 0xdc1fffff 100.0%)"));
        }

    }

    @FXML
    void OnMouseExited(MouseEvent event) {
        Rectangle.setFill(Paint.valueOf("linear-gradient(from 0.0% 0.0% to 100.0% 100.0%, 0x1ffff2ff 0.0%, 0x1ffff2ff 38.92617449664429%, 0x1ffff2ff 38.92617449664429%, 0x1ffff0ff 39.07554427893272%, 0x0d00ffff 100.0%)"));
    }


    @FXML
    void OnMouseMoved(MouseEvent event) {
        Rectangle.setFill(generateRandomColor(random));

    }

    @FXML
    void OnScroll(ScrollEvent event) {
        Object object = event.getTarget();
        if (object instanceof Circle) {
            if (event.getDeltaY() > 0) {
                Circle.setRadius(Circle.getRadius() + 5);
            } else if (event.getDeltaY() < 0) {
                Circle.setRadius(Circle.getRadius() - 5);
            }
        }
        else if (object instanceof  Line) {
            if (event.getDeltaY() > 0) {
                Line.setStrokeWidth(Line.getStrokeWidth()*1.05);
            } else if (event.getDeltaY() < 0) {
                Line.setStrokeWidth(Line.getStrokeWidth()/1.05);
            }
        }
        else if (object instanceof Rectangle) {
            if (event.getDeltaY() > 0) {
                Rectangle.setWidth(Rectangle.getWidth() * 1.05);
                Rectangle.setHeight(Rectangle.getHeight() * 1.05);
            } else if (event.getDeltaY() < 0) {
                Rectangle.setWidth(Rectangle.getWidth() / 1.05);
                Rectangle.setHeight(Rectangle.getHeight() / 1.05);
            }
        }
    }

    @FXML
    void ScrollPane3(ScrollEvent event) {
        double delta = event.getDeltaY();
        if (delta > 0) {
            translate.setZ(translate.getZ() + movementSpeed);
        } else {
            translate.setZ(translate.getZ() - movementSpeed);
        }
        System.out.println("scroll");
    }

    @FXML
    void actionPressedPane3(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            mouseOldX = event.getSceneX();
            mouseOldY = event.getSceneY();
            System.out.println("press");
        }

    }

    @FXML
    void actionmenucircle(ActionEvent event) {
        Figure.setText("круг");

    }

    @FXML
    void actionmenuline(ActionEvent event) {
        Figure.setText("линия");

    }

    @FXML
    void actionmenurectangle(ActionEvent event) {
        Figure.setText("прямоугольник");

    }


    @FXML
    void pane3Dragged(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
            mouseDeltaX = event.getSceneX() - mouseOldX;
            mouseDeltaY = event.getSceneY() - mouseOldY;
            rotateXAxis.setAngle(rotateXAxis.getAngle() - mouseDeltaY * mouseSensitivity);
            rotateYAxis.setAngle(rotateYAxis.getAngle() - mouseDeltaX * mouseSensitivity);

            mouseOldX = event.getSceneX();
            mouseOldY = event.getSceneY();
            System.out.println("dragged");
        }

    }

    @FXML
    void paneclick(MouseEvent event) {

    }

    @FXML
    void panedragged(MouseEvent event) {
        endMouseX=event.getX();
        endMouseY=event.getY();
        switch (Figure.getText()){
            case "линия":
                line1.setEndX(endMouseX);
                line1.setEndY(endMouseY);
                break;
            case "круг":
                double radius = Math.sqrt(Math.pow((startMouseX - endMouseX), 2)
                        + Math.pow((startMouseY - endMouseY), 2));
                circle1.setRadius(radius);
                break;
            case "прямоугольник":
                rectangle1.setWidth(Math.abs(startMouseX - endMouseX));
                rectangle1.setHeight(Math.abs(startMouseY - endMouseY));
                rectangle1.setX(Math.min(startMouseX, endMouseX));
                rectangle1.setY(Math.min(startMouseY, endMouseY));
                break;

        }

    }

    @FXML
    void panepressed(MouseEvent event) {
        if (color.getText().equals("Красный")){
            color1=Color.RED;

        } else if (color.getText().equals("синий")) {
           color1=Color.BLUE;

            
        } else if (color.getText().equals("чёрный")) {
            color1= Color.BLACK;

        }
        startMouseX= event.getX();
        startMouseY= event.getY();
        switch (Figure.getText()){
            case "круг":
                System.out.println("круг");
                circle1 = new Circle(startMouseX, startMouseY, 0);
                circle1.setFill(color1);  // цвет
                circle1.setStroke(Color.RED);
                circle1.setStrokeWidth(Slider.getValue());
                Pane.getChildren().addAll(circle1);
                break;
            case "линия":
                System.out.println("линия");
                line1 = new Line(startMouseX, startMouseY, event.getX()+1, event.getY()+1);
                line1.setStrokeWidth(Slider.getValue());
                line1.setStroke(color1);
                Pane.getChildren().addAll(line1);

                break;
            case "прямоугольник":
                System.out.println("прямоугольник");
                rectangle1 = new Rectangle(startMouseX, startMouseY, 20, 20);
                rectangle1.setFill(color1);  // цвет
                rectangle1.setStroke(Color.RED);
                rectangle1.setStrokeWidth(Slider.getValue());
                Pane.getChildren().addAll(rectangle1);
                break;
        }
    }

    public void Box(){
        material.setDiffuseColor(Color.OLIVE);
        Box.setMaterial(material);
        rotateXAxis = new Rotate(0, Rotate.X_AXIS);
        rotateYAxis = new Rotate(0, Rotate.Y_AXIS);
        translate = new Translate();
        modelGroup.getTransforms().addAll(translate, rotateXAxis, rotateYAxis);
        modelGroup.getChildren().add(Box);
        AmbientLight ambientLight = new AmbientLight(Color.WHITE);
        PointLight pointLight = new PointLight(Color.WHITE);
        pointLight.setTranslateX(800);
        pointLight.setTranslateY(-700);
        pointLight.setTranslateZ(-300);
        Pane3.getChildren().addAll(modelGroup, ambientLight, pointLight);
    }


    @FXML
    void initialize() {
        Box();
        camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-500);
    }

}
