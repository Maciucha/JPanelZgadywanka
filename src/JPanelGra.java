import javax.swing.*;
import java.awt.event.*;

public class JPanelGra extends JPanel implements KomunikatListener {
    private  JTextArea poleKomunikat;
    private  JTextField poleZgadywanaLiczba;
    private  JPanelWprowadzanie panelWprowadzanie;
    int zmienna;

    String wprowadzanaLiczba;


    public JPanelGra(JPanelWprowadzanie panelWprowadzanie) {
        this.panelWprowadzanie = panelWprowadzanie;


        poleZgadywanaLiczba = new JTextField("Wpisz liczbę do odgadnięcia");
        poleKomunikat = new JTextArea(10, 20);
        poleKomunikat.setEditable(false);
        JButton zatwierdzLiczbe = new JButton("Zatwierdż liczbę");

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

        ActionListener zatwierdzGraListener = e -> wykonajAkcjeZatwierdzGra();

        poleZgadywanaLiczba.addActionListener(zatwierdzGraListener);
        zatwierdzLiczbe.addActionListener(zatwierdzGraListener);
    }

    public void wykonajAkcjeZatwierdzGra() {


        for (int i = 0; i < panelWprowadzanie.liczbaProb; i++) {

            try {
                wprowadzanaLiczba = poleZgadywanaLiczba.getText();
                zmienna = Integer.parseInt(wprowadzanaLiczba);

                if (panelWprowadzanie.liczba == zmienna) {
                    poleKomunikat.setText(" Brawo!\n Liczba podana przez Ciebie: " + zmienna + " jest taka sama\n  jak wylosowana przeze mnie liczba: " + panelWprowadzanie.liczba);
                } else if (panelWprowadzanie.liczba > zmienna) {
                    poleKomunikat.setText("Twoja liczba " + zmienna + " ma za niską wartość\n Podaj kolejną liczbę z zakresu 0-" + panelWprowadzanie.zakres + " który wybrałeś \n Masz na to jeszcze " + (panelWprowadzanie.liczbaProb - i) + " prób.");
                } else {
                    poleKomunikat.setText("Twoja liczba " + zmienna + " ma za wysoką wartość\n Podaj kolejną liczbę z zakresu 0-" + panelWprowadzanie.zakres + " który wybrałeś \n Masz na to jeszcze " + (panelWprowadzanie.liczbaProb - i) + " prób.");
                } if (panelWprowadzanie.liczbaProb == i){
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
