package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class EditorNovo extends JFrame {

    private class MeuStyledDocument extends DefaultStyledDocument {

        private final AttributeSet palavraReservada;
        private final AttributeSet palavraNormal;
        private final AttributeSet palavraGherkin;

        public MeuStyledDocument() {
            final StyleContext context = StyleContext.getDefaultStyleContext();
            palavraReservada = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
            palavraGherkin = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.MAGENTA);
            palavraNormal = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        }

        @Override
        public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
            super.insertString(offset, str, a);
            highlight();
        }

        @Override
        public void remove(int offs, int len) throws BadLocationException {
            super.remove(offs, len);
            //aaa
            highlight();
        }

        private void highlight() throws BadLocationException {
            String text = getText(0, getLength());
            String s = "ab-'cd ef";
            String[] xxx = s.split("\\W|-");
            String[] palavras = text.split("\\W");
            int inicio = 0;
            int fim = 0;
            for (String palavra : palavras) {
                inicio = text.indexOf(palavra, inicio);
                fim = inicio + palavra.length();

                AttributeSet estilo;
                if (RESERVADAS.contains(palavra)) {
                    estilo = palavraReservada;
                } else if (GHERKIN.contains(palavra)) {
                    estilo = palavraGherkin;
                } else {
                    estilo = palavraNormal;
                }
                setCharacterAttributes(inicio, fim, estilo, false);
                inicio = fim + 1;
            }
        }
    }

    private static final List<String> RESERVADAS = Arrays.asList(
            new String[]{"dont", "fill", "out", "click", "link", "mouse", "over", "select", "data", "showed", "title", "use", "-", "valid", "data", "use-valid-data", "checked", "choose", "click", "disable", "dont-fill-out", "enable", "click-link", "mouse-over", "opened", "put", "select-data", "showed", "showed-title", "<", ">"});

    private static final List<String> GHERKIN = Arrays.asList(
            new String[]{"Given", "When", "Then", "And", "Feature", "Scenario", ":"});

    public static void main(String args[]) {
        try {
            EditorNovo editor = new EditorNovo();
            editor.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    public EditorNovo() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        MeuStyledDocument document = new MeuStyledDocument();
        JButton bt1 = new JButton("Salvar");
        JTextPane textPane = new JTextPane(document);
        textPane.setText("Feature:\n"
                + " Given  \n"
                + " When \n"
                + "Then \n");
        textPane.setSize(300, 300);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(new JScrollPane(textPane));
        getContentPane().add(bt1);

        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                Salvar salvarComo = new Salvar();
                salvarComo.salvaTexto = textPane.getText();
                salvarComo.setVisible(true);
                EditorNovo.this.setVisible(false);

            }
        });
    }

}
