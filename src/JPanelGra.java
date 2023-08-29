import javax.swing.*;
import java.awt.event.*;

public class JPanelGra extends JPanel {

    int liczba;
    private final JTextArea poleKomunikat;
    private final JTextField poleZgadywanaLiczba;
    private final JButton zatwierdzLiczbe;


    public JPanelGra() {


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
        try {
            liczba = Integer.parseInt(wprowadzanaLiczba);
            System.out.println("Podałes liczbę " + liczba + " ta liczba jest za...");
            poleKomunikat.setText("Podałes liczbę " + liczba + " ta liczba jest za...");

        } catch (NumberFormatException f) {
            poleKomunikat.setText("Błąd! Podaj liczbę");
        }
    }
}
