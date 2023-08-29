import javax.swing.*;
import java.awt.event.*;

public class JPanelWprowadzanie extends JPanel {

    private final JTextField poleZakres;
    private final JTextField poleLiczbaProb;
    private final JButton zatwierdz;
    public int zakres;
    public int liczbaProb;

    //private  JPanelGra panelGra;                          // referencja do klasy aby była widoczna w tej klasie

    public JPanelWprowadzanie() {        //jw. (JPanelGra panelGra)
        //this.panelGra = panelGra;                          //jw.

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
        } catch (NumberFormatException f) {
            System.out.println("Błąd! Podaj liczbę");
        }
        System.out.println(zakres);
        System.out.println(liczbaProb);
    }
}