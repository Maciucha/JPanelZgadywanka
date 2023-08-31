import javax.swing.*;
import java.awt.event.*;

public class JPanelGra extends JPanel implements KomunikatListener {
    private final JTextArea poleKomunikat;
    private final JTextField poleZgadywanaLiczba;
    private final JButton zatwierdzLiczbe;
    int zmienna;
    private final JPanelWprowadzanie panelWprowadzanie;


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




        for (int i = 0; i < panelWprowadzanie.liczbaProb; i++) {

            String wprowadzanaLiczba = poleZgadywanaLiczba.getText();
            zmienna = Integer.parseInt(wprowadzanaLiczba);

            try {
                if (i == 0) {
                    poleKomunikat.setText(" Podaj pierwszą liczbę z zakresu 0-" + panelWprowadzanie.zakres + " który wybrałeś \n Masz na to jeszcze " + (panelWprowadzanie.liczbaProb - i) + " prób.");
                    System.out.println("zakres: " + panelWprowadzanie.zakres + "\n Liczba prób: " + panelWprowadzanie.liczbaProb);
                    break;
                } else {
                    poleKomunikat.setText(" Podaj kolejną liczbę z zakresu 0-" + panelWprowadzanie.zakres + " który wybrałeś \n Masz na to jeszcze " + (panelWprowadzanie.liczbaProb - i) + " prób.");
                    System.out.println("zakres: " + panelWprowadzanie.zakres + "\n Liczba prób: " + panelWprowadzanie.liczbaProb);
                }
                if (panelWprowadzanie.liczba == zmienna) {
                    poleKomunikat.setText(" Brawo!\n Liczba podana przez Ciebie: " + zmienna + " jest taka sama\n  jak wylosowana przeze mnie liczba: " + panelWprowadzanie.liczba);
                } else if (panelWprowadzanie.liczba > zmienna) {
                    poleKomunikat.setText("Twoja liczba " + zmienna + " ma za niską wartość");
                } else {
                    poleKomunikat.setText("Twoja liczba " + zmienna + " ma za wysoką wartość");
                }
            } catch (NumberFormatException f) {
                poleKomunikat.setText("Błąd! Podaj liczbę");
            }
        }
    }

    @Override
    public void onKomunikat(String komunikat) {
        poleKomunikat.setText(komunikat);
    }
}
