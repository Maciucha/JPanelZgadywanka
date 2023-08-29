import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class JPanelGra extends JPanel {
    private JPanelWprowadzanie panelWprowadzanie;

    int zmienna;
    private final JTextArea poleKomunikat;
    private final JTextField poleZgadywanaLiczba;
    private final JButton zatwierdzLiczbe;


    public JPanelGra(JPanelWprowadzanie panelWprowadzanie) {
        this.panelWprowadzanie = panelWprowadzanie;


        poleZgadywanaLiczba = new JTextField("Wpisz liczbę do odgadnięcia");
        poleKomunikat = new JTextArea(10, 20);
        poleKomunikat.setEditable(false);
        zatwierdzLiczbe = new JButton("Zatwierdż liczbę");

        add(poleKomunikat);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(poleZgadywanaLiczba);
        add(zatwierdzLiczbe);

        poleZgadywanaLiczba.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                poleZgadywanaLiczba.setText("");
            }
        });

        poleZgadywanaLiczba.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                poleZgadywanaLiczba.setText("");
            }
        });

        ActionListener zatwierdzGraListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wykonajAkcjeZatwierdzGra();
            }
        };

        poleZgadywanaLiczba.addActionListener(zatwierdzGraListener);
        zatwierdzLiczbe.addActionListener(zatwierdzGraListener);
    }

    public void wykonajAkcjeZatwierdzGra() {
        String wprowadzanaLiczba = poleZgadywanaLiczba.getText();
        Random random = new Random();
        int liczba = random.nextInt(panelWprowadzanie.zakres);
        for (int i = 0; i < panelWprowadzanie.liczbaProb; i++) {

            try {
                if (i==0)
                {
                    poleKomunikat.setText("Podaj pierwszą liczbę z zakresu 0-" + panelWprowadzanie.zakres + " który wybrałeś \n Masz na to jeszcze " + (panelWprowadzanie.liczbaProb - i) + " prób.");
                } else
                {
                    poleKomunikat.setText("Podaj kolejną liczbę z zakresu 0-" + panelWprowadzanie.zakres + " który wybrałeś \n Masz na to jeszcze " + (panelWprowadzanie.liczbaProb - i) + " prób.");
                }
            } catch (NumberFormatException f) {
                poleKomunikat.setText("Błąd! Podaj liczbę");
            }
            zmienna = Integer.parseInt(wprowadzanaLiczba);

        }
    }
}
