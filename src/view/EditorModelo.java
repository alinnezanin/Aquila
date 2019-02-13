package view;

import java.awt.Color;
import java.awt.Panel;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class EditorModelo extends JFrame {

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

    public EditorModelo() {
         setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
  
        MeuStyledDocument document = new MeuStyledDocument();
        JTextPane textPane = new JTextPane(document);
         textPane.setText("Feature:\n"
                + " Given  \n"
                + " When \n"
               + "Then \n");
        add(new JScrollPane(textPane));
      
    }
}
