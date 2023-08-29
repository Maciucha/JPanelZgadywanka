import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            private static void utworzInterface() {

                JFrame ramkaPaneli = new JFrame("Wprowadź parametry gry.");
                ramkaPaneli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ramkaPaneli.setBounds(800, 400, 800, 600);
                ramkaPaneli.setAlwaysOnTop(true);

                JPanelWprowadzanie panelWprowadzanie = new JPanelWprowadzanie(); // tworzę panel do wprowadzania danych
                JPanelGra panelGra = new JPanelGra(); // tworzę panel do wprowadzania liczb i wyswietlania komunikatów podczas gry.

                JPanel panelGlowny = new JPanel(); // tworzę panel główny do umieszczania w nim innych paneli
                panelGlowny.setLayout(new BorderLayout());

                panelGlowny.add(panelWprowadzanie, BorderLayout.NORTH);
                panelGlowny.add(panelGra, BorderLayout.CENTER);

                ramkaPaneli.getContentPane().add(panelGlowny);
                ramkaPaneli.pack();
                ramkaPaneli.setVisible(true);

                ramkaPaneli.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            panelWprowadzanie.wykonajAkcjeZatwierdz();
                        }

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });


            }

            public void run() {
                utworzInterface();
            }
        });
    }
}