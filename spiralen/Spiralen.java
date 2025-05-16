import javax.swing.*;
import java.awt.*;

public class Spiralen extends JPanel {

  private void drawSpiral(Graphics graphics, String[] args){

    // ~~ PRÜFUNG METHODE ~~ Standardwerte definieren, falls keine oder ungültige Parameter übergeben wurden
    int iterations = 10000;    // Anzahl der Linien in der Spirale
    double angle = 89;      // Drehwinkel in Grad zwischen den Linien
    double shrink = 0.99;   // Faktor, um den jede neue Linie verkürzt wird (0-1)

    // ÜBUNG: graphics.drawLine(10,10,150,200); //

    // Einlesen v parameter aus Kommandozeilenargumenten
    try {
      if(args.length == 3){ // ~~~ Prüfen ob richtige Anzahl 
        //Beiargs[0], usw. handelt es sich um Strings. Sie können einen int-Wert aus einem String mit ...
        // der Methode Integer.parseInt und einen double-Wert mit Double.parseDouble auslesen.
        iterations = Integer.parseInt(args[0]); // Anzahl an Wiederholungen
        angle = Double.parseDouble(args[1]); // Drehwinkel in Grad
        shrink = Double.parseDouble(args[2]); // Verkürzungsfaktor
      } else { // ~~~ Wenn Prüfung nicht true ist:
        System.out.println("Nicht 3 Parameter angegeben! Verwende Standardwerte."); // Nutzer mitteilen, dass nicht richtige Anzahl an Parameter gegeben wurde und Standardwerte benutzt werden
      }
    } catch (NumberFormatException exception) {
        // Fehlermeldung, wenn Parameter nicht in Zahlen umgewandelt werden können
        System.out.println("Ungültige Parameter! Verwende Standardwerte."); // Hier auch Nutzer mitteilen, dass Standardwerte bneutzt werden.



        // Überlegen Sie sich, welche ungültigen Werte der Nutzer übergeben kann:
        //▶ Waspassiert, wenn Sie nicht alle drei Kommandozeilenargumente beim Aufruf angeben? Wie
        //können Sie darauf reagieren? => if(args.length ==3) SONST STANDARDWERT
        //▶ Waspassiert, wenn Sie statt einer Zahl ein Wort übergeben? Wie können Sie darauf reagie
        //ren? => try{...}catch(e){STANDARDWERTE}
        // ▶ Wassind die gültigen Werte für die Eingabeparameter? => 1. Positive Iteration 2. Verkürzungsfaktor zwischen 0 und 1 (mehr unten)
        // Implementieren Sie zumindest eine Prüfung auf Gültigkeit!

    if (iterations <= 0) {
      // 1. Positive Iteration
      System.out.println("Iterations muss größer als 0 sein! Setze auf 50.");
      iterations = 50;
    }
    if (shrink <= 0 || shrink >= 1) {
      // 2. Verkürzungsfaktor zwischen 0 und 1 
      System.out.println("Shrink muss zwischen 0 und 1 liegen! Setze auf 0.95.");
      shrink = 0.95;
    }
    }

    // Initialisierung der Startkoordinaten und des Richtungsvektors
    double x = 20;          // x-Startkoordinate des ersten Punktes
    double y = 20;          // y-Startkoordinate des ersten Punktes
    double dx = 400;        // x-Komponente des initialen Richtungsvektors
    double dy = 0;          // y-Komponente des initialen Richtungsvektors
    
    // Schleife zum Zeichnen der Spirale mit der angegebenen Anzahl an Iterationen
    for (int i = 0; i < iterations; i++) {
        // Zeichne eine Linie vom aktuellen Punkt (x,y) zum berechneten Endpunkt (x+dx, y+dy)
        // ~~~~~~~~~~~~~~ Casting zu int , da drawLine() nur Ganzzahlen akzeptiert
        graphics.drawLine((int)x, (int)y, (int)(x+dx), (int)(y+dy));
        
        // ▶ Verschiebe (x,y) nach (x+dx,y+dy)
        x = x + dx;         // Neue x-Koordinate ist alter Endpunkt
        y = y + dy;         // Neue y-Koordinate ist alter Endpunkt
        
        // Drehe den Richtungsvektor (dx,dy) um den angegebenen Winkel
        double newDx = dx * Math.cos(Math.toRadians(angle)) - dy * Math.sin(Math.toRadians(angle));
        double newDy = dx * Math.sin(Math.toRadians(angle)) + dy * Math.cos(Math.toRadians(angle));
        dx = newDx;         // Aktualisiere x-Komponente des Richtungsvektors
        dy = newDy;         // Aktualisiere y-Komponente des Richtungsvektors
        
        // Verkürze den Richtungsvektor um den Faktor shrink
        // Dies erzeugt den Spiraleffekt, da jede neue Linie kürzer wird
        dx = dx * shrink;   // Verkürze x-Komponente
        dy = dy * shrink;   // Verkürze y-Komponente
    }

        

  }

  // DONT'T CHANGE ANYTHING BELOW HERE

  private String[] args;

  private final int WIDTH = 600;
  private final int HEIGHT = 600;

  private Spiralen(String[] args){
    super();
    this.args = args;
    JFrame frame = new JFrame("Spiralen");
    frame.setSize(WIDTH, HEIGHT);
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    frame.add(this);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setColor(java.awt.Color.WHITE);
    g.fillRect(0, 0, WIDTH, HEIGHT);
    g.setColor(new java.awt.Color(0.6f, 0, 0));
    drawSpiral(g, args);
  }

  public static void main(String[] args) {
    Spiralen spiralen = new Spiralen(args);
    
  }
    
}
