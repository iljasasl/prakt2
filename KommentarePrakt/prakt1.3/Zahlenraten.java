import java.util.Scanner;

public class Zahlenraten {
    
    public static void main(String[] args) {
        /**
         * Lokale Variablen fürs Spiel 
         * int zahl jetzt schon mal initialisieren weil sonst Benutzung ohne initialiserung
         */
        int bits;
        int max;
        int zahl = 0;
        
        /**
         * Scanner erstellen für Input vom Nutzer
         */
        Scanner scanner = new Scanner(System.in);
        
        /**
         * Hier frag ich den Spielee nach der Bit-Anzahl
         */
        System.out.print("Wieviele Bits soll die Zahl haben? ");
        bits = scanner.nextInt();
        
        
        /**
         * Nur 0 < bits <= 8 erlaubt wie im Aufgabenblatt steht
         */
        while (bits <= 0 || bits > 8) {
            System.out.println("Bitte nur Werte zwischen 1 und 8 eingeben!");
            System.out.print("Wieviele Bits soll die Zahl haben? ");
            bits = scanner.nextInt();
        }
        
        /**
         *  ▶ Setzen Sie max auf den Wert 2bits:
         * 
         *  Funktion für max zahl: max^bits wie gefordert im Aufgabenblatt
         */
        max = (int) Math.pow(2, bits); 
        
        /**
         * ▶ Testen Sie Ihr Programm bis hierhin, indem Sie den Wert von bits und max ausgeben:
         */
        System.out.printf("Test: %d %d%n", max, bits);


        /**
         * "Denken Sie Sich eine Zahl" Frage
         */
        System.out.println("Denken Sie sich eine Zahl zwischen 0 und " + (max-1));
        
        /**
         *  ▶ Implementieren Sie eine Schleife, die den Nutzer für jedes Bit i von 0 bis bit fragt, ob die
            gedachte Zahl in der Liste der Zahlen ist, die printNumbersWithBit(max, i) ausgibt.
            => for schleife für jedes i 0 bis bit
         */
        for (int i = 0; i < bits; i++) {
            System.out.println("Kommt Ihre Zahl in folgender Aufzählung vor? (j/n)");
            
            /**
             * Hier rufe ich meine Funktion printNumbersWithBit(max, i) auf
             */
            printNumbersWithBit(max, i);
            
            /**
             * Spieler Input scannen und dem String antwort zuweisen
             */
            String antwort = scanner.next();
            
            /**
             * Wenn "j", dann addiere ich 2 hoch i zur zahl
             * &&
             * j und J als Antwortmöglichkeit falls Nutzer nicht gescheit liest
             */
            if (antwort.equals("j") || antwort.equals("J")) {
                zahl = zahl + (int) Math.pow(2, i);  
            }
        }
        
        /**
         * Am Ende geb ich die errratene Zahl aus
         */
        System.out.println("Die Zahl ist: " + zahl);
        
        /**
         * Scanner aus machen
         */
        scanner.close();
    }
    
    /**
     *  Implementieren SieeineMethodeprivate static void printNumbersWithBit(int max, int bit),die
        alle int-Zahlen von 0 bis max-1 ausgibt, deren Bit an der Stelle mit der Wertigkeit bit („von
        rechts“) eine 1 stehen haben.
     * @param max Alle zahlen   
     * @param bit Anzahl der bits der zu ratenden zahl
     */
    private static void printNumbersWithBit(int max, int bit) {
        /**
         * Ich gehe alle Zahlen von 0 bis max-1 durch
         */
        for (int i = 0; i < max; i++) {

            /**
             *  ▶ In Java gibt es den Bit-Shift-Operator a >> n, der die Bits in a um n Stellen nach rechts ver
                schiebt, bspw. ist (22 >> 2)== 5 gleich da 22 = (10110)2 und damit 6>>2 in Binär (101)2 = 5.
                Das Bit an der Stelle n steht nach der Operation ganz rechts.
             */
            int verschoben = i >> bit;
            
            /**
             * ▶ Umherauszufinden, ob das letzte Bit 0 oder 1 ist können Sie prüfen ob die Zahl gerade (0)
                oder ungerade (1) ist.
             */

            if (verschoben % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        /**
         * Neue Zeile am Ende
         */
        System.out.println(); 
    }
}