
package principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import modelo.Posicao;

public class MatrizPanels extends javax.swing.JFrame {

    private final Integer n = 10;
    private final Integer m = 10;
    private Map<String, JLabel> labelsMap = new HashMap<>();
    private Map<String, Posicao> localizacaoAtual = new HashMap<>();
    private Boolean poderBonus = false;
    private Integer vidaVilao;
    private Jogo jogo;
  
    public MatrizPanels() {
        
        super("Puzzle Heros X Vilains");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.vidaVilao = 3;
        this.jogo = new Jogo();
        gerarMapa();
        
        //H -> Herói
        //V -> Vilao
        //X -> Poder Bonus
        
        spawnPersonagem("H");
        spawnPersonagem("V");
        spawnPersonagem("X");
        
        new Thread(new Runnable() {
        @Override
        public void run() {
            // Chama o método 'executar' em um thread separado
            jogo.executar(labelsMap, poderBonus, localizacaoAtual, vidaVilao, n);
        }
    }).start();
 
    }
    
    // Método para acessar um JLabel pelo nome
    public JLabel getLabel(String nome) {
        return labelsMap.get(nome);
    }
    
     public void gerarMapa() 
    {
        
            //i é linha e j coluna
        
            JPanel matrizPanel = new JPanel();
            matrizPanel.setLayout(new GridLayout(n + 1, m + 1, 5, 5)); // GridLayout com espaço adicional para os números

            // Criando a borda preta para cada painel
            Border border = new LineBorder(Color.BLACK, 1);

            matrizPanel.add(new JLabel()); // Célula vazia no canto superior esquerdo

            // Adicionando rótulos de números para as colunas
            for (int i = 1; i <= m; i++) {
                JLabel colunaLabel = new JLabel(String.valueOf(i));
                colunaLabel.setHorizontalAlignment(JLabel.CENTER);
                matrizPanel.add(colunaLabel);
            }

            // Adicionando os painéis com borda e números nas células
            for (int i = 1; i <= n; i++) {
                // Adicionando número da linha
                JLabel linhaLabel = new JLabel(String.valueOf(i));
                linhaLabel.setHorizontalAlignment(JLabel.CENTER);
                matrizPanel.add(linhaLabel);

                for (int j = 1; j <= m; j++)
                {
                    JPanel panel = new JPanel();
                    panel.setBackground(Color.WHITE);
                    panel.setBorder(border);

                    // Criando a JLabel para a célula
                    JLabel cellLabel = new JLabel();
                    cellLabel.setName("label" + i + j);  // nome dinâmico como "labelXY"
                    cellLabel.setHorizontalAlignment(JLabel.CENTER);

                    // Armazenando a JLabel no Map usando o nome gerado como chave
                    labelsMap.put(cellLabel.getName(), cellLabel);

                    // Adiciona a célula ao painel
                    panel.add(cellLabel);

                    matrizPanel.add(panel);
                }
            }

            // Adicionando o painel de matriz ao frame
            add(matrizPanel, BorderLayout.CENTER);

            // Ajustando o tamanho do frame para acomodar o painel
            pack(); // Ajusta automaticamente o tamanho da janela conforme o conteúdo

            // Definindo um tamanho fixo para o JFrame
            setPreferredSize(new Dimension(600, 600)); // Tamanho preferido para o JFrame (ajuste conforme necessário)
            setSize(getPreferredSize());  // Aplica o tamanho preferido ao JFrame

            // Impedindo que a janela seja redimensionada
            setResizable(false);  // Impede o redimensionamento da janela

            // Centralizando o JFrame na tela
            setLocationRelativeTo(null);  // Centraliza a janela na tela

            setVisible(true);  // Torna o JFrame visível
        }

    public int gerarPosicao()
    {
        return (int) (Math.random() * n + 1);
    }
    
    public void spawnPersonagem(String personagem)
    {     
        int linha = gerarPosicao();
        int coluna = gerarPosicao();
        Posicao posicao = new Posicao();
        
        posicao.setColuna(coluna);
        posicao.setLinha(linha);
        
        localizacaoAtual.put(personagem, posicao);
        
        JLabel jLabel = labelsMap.get("label" + linha + coluna);
        jLabel.setText(personagem);
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) 
{
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MatrizPanels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatrizPanels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatrizPanels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatrizPanels.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MatrizPanels().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
