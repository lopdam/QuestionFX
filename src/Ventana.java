
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author roboto
 */
public class Ventana {

    private static Stage s;

    private Scene scene;

    private Ventana next;
    private Ventana previous;

    private StackPane root;

    private ImageView fondo = new ImageView(new Image("/Recursos/fondo.png"));

    private Pane pane;

    private ImageView imagen;

    private int ancho = 960;
    private int alto = 540;

    private Button nextBtn = new Button("Next");
    private Button previousBtn = new Button("Previous");
    private Button comprobar = new Button("Check");
    private String stilo = "#ipad-grey {\n"
            + "    -fx-background-color: \n"
            + "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n"
            + "        linear-gradient(#020b02, #3a3a3a),\n"
            + "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\n"
            + "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\n"
            + "    -fx-background-insets: 0,1,4,5;\n"
            + "    -fx-background-radius: 9,8,5,4;\n"
            + "    -fx-padding: 15 30 15 30;\n"
            + "    -fx-font-family: \"Helvetica\";\n"
            + "    -fx-font-size: 18px;\n"
            + "    -fx-font-weight: bold;\n"
            + "    -fx-text-fill: #333333;\n"
            + "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);\n"
            + "}";

    private Label pregunta = new Label();
    private int respuesta;
    private CheckBox it1 = new CheckBox();
    private CheckBox it2 = new CheckBox();
    private CheckBox it3 = new CheckBox();
    private CheckBox it4 = new CheckBox();

    private String stlioText = "#text {\n"
            + "    -fx-font-family: \"Helvetica\";\n"
            + "    -fx-font-weight: bold;\n"
            + "    -fx-font-size: 18px;\n"
            + "}";
    private CheckBox checks[] = {it1, it2, it3, it4};

    private ImageView listo = new ImageView();

    public Ventana(Stage s, String pregunta, String it1, String it2, String it3, String it4, int respuesta, String img) {
        this.respuesta = respuesta;
        this.pregunta.setText(pregunta);
        this.it1.setText(it1);
        this.it2.setText(it2);
        this.it3.setText(it3);
        this.it4.setText(it4);
        /////////////////////////
        //Style
        this.pregunta.setStyle(stlioText);
        this.it1.setStyle(stlioText);
        this.it2.setStyle(stlioText);
        this.it3.setStyle(stlioText);
        this.it4.setStyle(stlioText);
        ///////////////////////////
        this.s = s;
        imagen = new ImageView(new Image("/Recursos/" + img));
        root = new StackPane();
        pane = new Pane();
        scene = new Scene(root, ancho, alto);

        fondo.setFitHeight(alto);
        fondo.setFitWidth(ancho);

        imagen.setFitHeight(350);
        imagen.setFitWidth(400);
        imagen.setLayoutX(20);
        imagen.setLayoutY(100);

        comprobar.setLayoutX(820);
        comprobar.setLayoutY(245);

        previousBtn.setLayoutX(30);
        previousBtn.setLayoutY(alto - 65);

        nextBtn.setLayoutY(alto - 65);
        nextBtn.setLayoutX(ancho - 125);

        comprobar.setStyle(stilo);
        nextBtn.setStyle(stilo);
        previousBtn.setStyle(stilo);
        ////////////////////////////////////////////////////////
        //Preguntas y Respuestas set Layout

        this.pregunta.setLayoutX(10);
        this.pregunta.setLayoutY(10);

        this.it1.setLayoutX(450);
        this.it1.setLayoutY(100);

        this.it2.setLayoutX(450);
        this.it2.setLayoutY(140);

        this.it3.setLayoutX(450);
        this.it3.setLayoutY(180);

        this.it4.setLayoutX(450);
        this.it4.setLayoutY(220);

        ///////////////////////////////////////////////////////////
        //Img check ubication
        listo.setLayoutX(520);
        listo.setLayoutY(245);

        listo.setFitHeight(275);
        listo.setFitWidth(250);
        //Imagen Check
        listo.setImage(new Image("/Recursos/nones.png"));
        ////////////////////////////////////////////////////////
        pane.getChildren().addAll(imagen, nextBtn, previousBtn, comprobar, this.pregunta, this.it1, this.it2, this.it3, this.it4, listo);
        root.getChildren().addAll(fondo, pane);
        Eventos();

    }

    private boolean verificar() {
        return checks[respuesta].isSelected();
    }

    private void Eventos() {
        nextBtn.setOnAction(value -> {
            if (next != null) {
                Settear();
                s.setScene(next.getScene());
            }
        });
        previousBtn.setOnAction(value -> {
            if (previous != null) {
                Settear();
                s.setScene(previous.getScene());
            }

        });
        it1.setOnAction(value -> {
            it2.setSelected(false);
            it3.setSelected(false);
            it4.setSelected(false);
        });

        it2.setOnAction(value -> {
            it1.setSelected(false);
            it3.setSelected(false);
            it4.setSelected(false);
        });

        it3.setOnAction(value -> {
            it1.setSelected(false);
            it2.setSelected(false);
            it4.setSelected(false);
        });

        it4.setOnAction(value -> {
            it1.setSelected(false);
            it2.setSelected(false);
            it3.setSelected(false);
        });

        comprobar.setOnAction(value -> {
            if (it1.isSelected() || it2.isSelected() || it3.isSelected() || it4.isSelected()) {
                if (verificar()) {
                    listo.setImage(new Image("/Recursos/si.png"));
                } else {
                    listo.setImage(new Image("/Recursos/no.png"));
                }
            } else {
                listo.setImage(new Image("/Recursos/nones.png"));
            }

        });

    }

    public Scene getScene() {
        return scene;
    }

    public Ventana getNext() {
        return next;
    }

    public void setNext(Ventana next) {
        this.next = next;
    }

    public Ventana getPrevious() {
        return previous;
    }

    public void setPrevious(Ventana previous) {
        this.previous = previous;
    }

    private void Settear() {
        it1.setSelected(false);
        it2.setSelected(false);
        it3.setSelected(false);
        it4.setSelected(false);
        listo.setImage(new Image("/Recursos/nones.png"));
    }

}
