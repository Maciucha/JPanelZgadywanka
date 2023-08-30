import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class JPanelWprowadzanie extends JPanel {
    private KomunikatListener komunikatListener;
    private final JTextField poleZakres;
    private final JTextField poleLiczbaProb;
    private final JButton zatwierdz;
    public int zakres;
    public int liczbaProb;

    public int liczba;

    public JPanelWprowadzanie() {


        poleZakres = new JTextField("podaj koniec zakresu", 12);
        poleLiczbaProb = new JTextField("podaj ilość prób", 12);
        zatwierdz = new JButton("Zatwierdź parametry");

        add(poleZakres);
        add(poleLiczbaProb);
        add(zatwierdz);

        poleLiczbaProb.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                poleLiczbaProb.setText("");
            }
        });

        poleZakres.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                poleZakres.setText("");
            }
        });

        poleLiczbaProb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                poleLiczbaProb.setText("");
            }
        });

        ActionListener zatwierdzListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wykonajAkcjeZatwierdz();
            }
        };

        zatwierdz.addActionListener(zatwierdzListener);
        poleZakres.addActionListener(zatwierdzListener);
        poleLiczbaProb.addActionListener(zatwierdzListener);
    }



    public void wykonajAkcjeZatwierdz() {
        String zakresWpisany = poleZakres.getText();
        String liczbaProbWpisana = poleLiczbaProb.getText();
        try {
            zakres = Integer.parseInt(zakresWpisany);
            liczbaProb = Integer.parseInt(liczbaProbWpisana);

            Random random = new Random();
            liczba = random.nextInt(zakres);

            komunikatListener.onKomunikat(" Podaj pierwszą liczbę z zakresu 0-" + zakres + " który wybrałeś \n Masz na to jeszcze " + liczbaProb + " prób.");
            System.out.println(liczba);
            System.out.println("Zakres ustawiony na 0-" + zakres);
            System.out.println("Liczba prób ustawiona na " + liczbaProb);
        } catch (NumberFormatException f) {
            System.out.println("Błąd! Podaj liczbę");
        }
    }
    public void setKomunikatListener(KomunikatListener listener) {
        this.komunikatListener = listener;
    }
}