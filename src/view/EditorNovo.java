package view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;

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
            new String[]{"dont", "fill", "out", "click", "link", "mouse",
                "over", "select", "data", "showed", "title", "use",
                "-", "valid", "data", "use-valid-data", "checked",
                "choose", "click", "disable", "dont-fill-out", "enable",
                "click-link", "mouse-over", "opened", "put", "select-data",
                "showed", "showed-title", "<", ">"});

    private static final List<String> GHERKIN = Arrays.asList(
            new String[]{"Given", "When", "Then", "And", "Feature:", "Feature", "Scenario", ":"});

    public static void main(String args[]) {
        try {
            EditorNovo editor = new EditorNovo();
            editor.setVisible(true);
            editor.setExtendedState(JFrame.MAXIMIZED_BOTH);

        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    public EditorNovo() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        MeuStyledDocument document = new MeuStyledDocument();
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setFont(new Font("Tahoma", 1, 14));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save_37110.png"))); // NOI18N
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", 1, 14));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back_arrow_14447.png"))); // NOI18N
        JTextPane textPane = new JTextPane(document);
        textPane.setText("Feature:\n"
                + "Scenario: \n"
                + " Given  \n"
                + " When \n"
                + " Then \n");
        textPane.setFont(new Font("Tahoma", 1, 18));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(new JScrollPane(textPane));
        JPanel painel = new JPanel();
        Dimension dimension = new Dimension(300, 50);
        painel.setMaximumSize(dimension);
        painel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        painel.add(btnSalvar);
        painel.add(btnVoltar);
        painel.setAlignmentX(RIGHT_ALIGNMENT);
        getContentPane().add(painel);

        btnVoltar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent e) {

                int dialogButton = JOptionPane.showConfirmDialog(null, "Deseja sair sem salvar os arquivos?", "Saida", JOptionPane.YES_NO_OPTION);
                if (dialogButton == JOptionPane.YES_OPTION) {                
                    TelaInicial t = new TelaInicial();
                    t.setVisible(true);
                    EditorNovo.this.setVisible(false);
                } 

            }
        });
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                JFileChooser seleciona = new JFileChooser();

                if (seleciona.showSaveDialog(EditorNovo.this) == JFileChooser.APPROVE_OPTION) {
                    File arquivoA = seleciona.getSelectedFile();
                    //     txtFuncionalidade.setText(arquivoA.getAbsolutePath());
                    String textoQueSeraEscrito = textPane.getText();

                    //String a ser analisada
                    String Str = new String(textoQueSeraEscrito);
                    //Posição do caracter na string

                    FileWriter arquivo;
                    try {
                        arquivo = new FileWriter(new File(arquivoA.getAbsolutePath() + ".feature"));
                        arquivo.write(textoQueSeraEscrito);
                        JOptionPane.showMessageDialog(null, "salvo com sucesso");

                        arquivo.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        JOptionPane.showConfirmDialog(null, "erro ao salvar, tente novamente");
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showConfirmDialog(null, "erro ao salvar, tente novamente");
                    }

                    EditorNovo.this.setVisible(false);
                    TelaInicial t = new TelaInicial();
                    t.setVisible(true);

                }

            }
        });

    }

}
