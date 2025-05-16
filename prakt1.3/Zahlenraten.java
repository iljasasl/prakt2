import java.util.Scanner;

public class Zahlenraten {
    
    public static void main(String[] args) {
        // Lokale Variablen fürs Spiel 
        int bits;
        int max;
        int zahl = 0;
        
        // Scanner für Input vom Nutzer
        Scanner scanner = new Scanner(System.in);
        
        // Hier frag ich den Spielee nach der Bit-Anzahl
        System.out.print("Wieviele Bits soll die Zahl haben? ");
        bits = scanner.nextInt();
        
        // Nur 0 < bits <= 8 erlaubt
        while (bits <= 0 || bits > 8) {
            System.out.println("Bitte nur Werte zwischen 1 und 8 eingeben!");
            System.out.print("Wieviele Bits soll die Zahl haben? ");
            bits = scanner.nextInt();
        }
        
        // Funktion für max zahl
        max = (int) Math.pow(2, bits);  // max^bits wie gefordert
        
        // Zum Testen geb ich max aus
        System.out.println("Denken Sie sich eine Zahl zwischen 0 und " + (max-1));
        
        // Hauptschleife mit "Kommt Zahl hier vor?" Frage
        for (int i = 0; i < bits; i++) {
            System.out.println("Kommt Ihre Zahl in folgender Aufzählung vor? (j/n)");
            
            // Hier rufe ich meine Funktion auf
            printNumbersWithBit(max, i);
            
            // Spieler Input scannen und dem String antwort zuweisen
            String antwort = scanner.next();
            
            // Wenn "j", dann addiere ich 2 hoch i zur zahl
            if (antwort.equals("j") || antwort.equals("J")) {
                zahl = zahl + (int) Math.pow(2, i);  // 2 hoch i zur Zahl dazurechnen
            }
        }
        
        // Am Ende geb ich die errratene Zahl aus
        System.out.println("Die Zahl ist: " + zahl);
        
        // Scanner aus
        scanner.close();
    }
    
    // Diese Methode gibt alle Zahlen aus, die an der bestimmten Stelle ein Bit gesetzt haben
    private static void printNumbersWithBit(int max, int bit) {
        // Ich gehe alle Zahlen von 0 bis max-1 durch
        for (int i = 0; i < max; i++) {

            // Ich verschiebe die Zahl um bit Stellen nach rechts
            int verschoben = i >> bit;
            
            // Wenn das letzte Bit 1 ist (ungerade Zahl), dann gebe ich die Zahl aus
            if (verschoben % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();  // Neue Zeile am Ende
    }
}