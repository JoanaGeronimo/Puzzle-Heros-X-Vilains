package principal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Posicao;


public class Jogo 
{
    private int vidaAtual;
    private boolean poderBonus = false;
    private int n;
       
    private void preencherRegras(List<String> regras)
    {
        ControleRegras controleRegras = new ControleRegras();
        regras.addAll(controleRegras.definirPrioridades());    
       
    }
    
    private int gerarPosicao(Integer n)
    {
        return (int) (Math.random() * n + 1);
    }
    
    private void limparLabels(Map<String, JLabel> labelsMap, Map<String, Posicao> localizacaoAtual)
    {
        
        for (Map.Entry<String, Posicao> entry : localizacaoAtual.entrySet()) 
        {
           String key = "label" + entry.getValue().getLinha() + entry.getValue().getColuna();
           JLabel jLabelAux = labelsMap.get(key);
           
           if(jLabelAux != null)
           { 
               jLabelAux.setText("");
           }       
           
        }
    }
    
    private void preencherLabels(Map<String, JLabel> labelsMap, int x, int y, String classe)
    {
        JLabel jLabel = labelsMap.get("label" + x + y);
        
        jLabel.setText(classe);
    }
    
    private boolean verificarPosicaoOcupada(int x, int y, Map<String, Posicao> localizacaoAtual) {
    
        for (Posicao pos : localizacaoAtual.values()) 
        {
            if (pos.getColuna() == x && pos.getLinha() == y) 
            {
                return true; // A posição já está ocupada
            }
        }
    return false; 
}

   private void novoSpawn(Map<String, JLabel> labelsMap, Integer n, Map<String, Posicao> localizacaoAtual) {
    limparLabels(labelsMap, localizacaoAtual);
    
    // Limpa todas as posições antes de gerar novas
    localizacaoAtual.clear();
    
    Set<String> posicoesOcupadas = new HashSet<>();

    String[] entidades = {"H", "V", "X"}; // Ajuste conforme necessário

    for (String entidade : entidades) {
        int x, y;
        
        do {
            x = gerarPosicao(n);
            y = gerarPosicao(n);
        } while (posicoesOcupadas.contains(x + "," + y)); 
        
        // Adiciona a nova posição corretamente
        localizacaoAtual.put(entidade, new Posicao(x, y));
        posicoesOcupadas.add(x + "," + y);

        preencherLabels(labelsMap, x, y, entidade);
    }

}


   
    
    private boolean verificarRegra(String regra,Map<String, JLabel> labelsMap, Map<String, Posicao> localizacaoAtual )
    {
        try
        {           
            switch(regra)
            {
                case "2":
                {
                    return localizacaoAtual.get("H").getColuna() > localizacaoAtual.get("V").getColuna();
                }
                case "3":
                {
                    return localizacaoAtual.get("H").getColuna() < localizacaoAtual.get("V").getColuna();
                }
                case "4":
                {
                    return localizacaoAtual.get("H").getLinha()< localizacaoAtual.get("V").getLinha();
                }
                case "5":
                {
                    return localizacaoAtual.get("H").getLinha() > localizacaoAtual.get("V").getLinha();
                }
            }
            
        }catch(IllegalStateException e)
        {
            System.out.println("Nenhuma regra foi escolhida");
        }
        
        return false;
    }
    
    private void limparLabel(JLabel jLabel)
    {
        jLabel.setText("");
    }
    
     private void verificarPosicoes(Map<String, JLabel> labelsMap, Map<String, Posicao> localizacaoAtual)
     {
         
         if(localizacaoAtual.get("H").equals(localizacaoAtual.get("V")))
         {
             if(this.poderBonus)
             {
                 this.vidaAtual =  this.vidaAtual - 2;
                 poderBonus = false;
             }
             else
             {
                  this.vidaAtual--;
             }
             
             novoSpawn(labelsMap, this.n, localizacaoAtual);
         }
         
         if(localizacaoAtual.get("H").equals(localizacaoAtual.get("X")))
         {
             poderBonus = true;
         }
     }
     private void mover(Map<String, JLabel> labelsMap, Map<String, Posicao> localizacaoAtual, int deslocamentoX, int deslocamentoY)
    {
        // Obtém a posição atual do herói
        int linha = localizacaoAtual.get("H").getLinha();
        int coluna = localizacaoAtual.get("H").getColuna();

        // Calcula a nova posição com o deslocamento
        linha = linha + deslocamentoX;
        coluna = coluna + deslocamentoY;

        // Limpa o label da posição anterior
        String key = "label" + localizacaoAtual.get("H").getLinha() + localizacaoAtual.get("H").getColuna();
        JLabel jLabel = labelsMap.get(key);
        limparLabel(jLabel);

        // Atualiza a posição do herói no mapa
        localizacaoAtual.get("H").setLinha(linha);
        localizacaoAtual.get("H").setColuna(coluna);
        
         // Atualiza o label da nova posição
        String novaKey = "label" + linha + coluna;
        jLabel = labelsMap.get(novaKey);
        jLabel.setText("H");
        
        verificarPosicoes(labelsMap, localizacaoAtual);

      
    }

   
    private void moverEsquerda(Map<String, JLabel> labelsMap, Map<String, Posicao> localizacaoAtual)
    {
        mover(labelsMap, localizacaoAtual, 0, -1); // Mover para a esquerda: x = 0, y = -1
    }

    private void moverDireita(Map<String, JLabel> labelsMap, Map<String, Posicao> localizacaoAtual)
    {
        mover(labelsMap, localizacaoAtual, 0, 1); // Mover para a direita: x = 0, y = 1
    }

    private void moverParaCima(Map<String, JLabel> labelsMap, Map<String, Posicao> localizacaoAtual)
    {
        mover(labelsMap, localizacaoAtual, -1, 0); // Mover para cima: x = -1, y = 0
    }

    private void moverParaBaixo(Map<String, JLabel> labelsMap, Map<String, Posicao> localizacaoAtual)
    {
        mover(labelsMap, localizacaoAtual, 1, 0); // Mover para baixo: x = 1, y = 0
    }
    
    public void executar(Map<String, JLabel> labelsMap, Boolean poderBonus, Map<String, 
            Posicao> localizacaoAtual, Integer vidaVilao, Integer n)
    {
        List<String> regrasProducao = new ArrayList<>() ;
        preencherRegras(regrasProducao);
        
        this.vidaAtual = vidaVilao;
        this.n = n;
        int i = 0;
        int passos = 0;
        boolean sairForEach = false;
         
        while(vidaAtual > 0)
        {
            for (String regra : regrasProducao) 
            {
                if(sairForEach)
                {
                    sairForEach = false;
                    break;
                }
                
                switch(regra)
                {
                   //Regra 2: SE o número da coluna da posição atual for superior
                   //ao número da coluna da posição do vilão ENTÃO dar um passo para a esquerda.
                    case "2":
                    {
                        if(!verificarRegra(regra, labelsMap, localizacaoAtual))
                        {
                            continue;
                        }
                        else
                        {         
                            System.out.println("Regra 2");
                             try 
                           {
                              System.out.println("[" + passos + "]" + "- " + "Movendo para esquerda");                           
                              Thread.sleep(1000); // Pausa por 1 segundos
                           } 
                           catch (InterruptedException e) 
                           {
                              e.printStackTrace();
                           }
                             
                              moverEsquerda(labelsMap, localizacaoAtual);
                              passos++;
                              sairForEach = true;
                              break;
                        }   
                    }
                   //Regra 3: SE o número da coluna da posição atual for inferior ao número 
                  //da coluna da posição do vilão ENTÃO dar um passo para a direita.
                    case "3":
                    {
                        if(!verificarRegra(regra, labelsMap, localizacaoAtual))
                        {
                            continue;
                        }
                        else
                        {System.out.println("Regra 3");
                             try 
                           {
                              System.out.println("[" + passos + "]" + "- " + "Movendo para direita");                           
                              Thread.sleep(1000); // Pausa por 1 segundos
                           } 
                           catch (InterruptedException e) 
                           {
                              e.printStackTrace();
                           }
                             
                              moverDireita(labelsMap, localizacaoAtual);
                              passos++;
                              sairForEach = true;
                              break;
                        }
                        
                    }
                    //Regra 4: SE o número da linha da posição atual for 
                    //inferior ao número da linha da posição do vilão ENTÃO dar um passo para baixo.
                    case "4":
                    {
                        if(!verificarRegra(regra, labelsMap, localizacaoAtual))
                        {
                            continue;
                        }
                        else
                        {System.out.println("Regra 4");
                            try 
                           {
                              System.out.println("[" + passos + "]" + "- " + "Movendo para baixo");                           
                              Thread.sleep(1000); // Pausa por 1 segundos
                           } 
                           catch (InterruptedException e) 
                           {
                              e.printStackTrace();
                           }
                             
                              moverParaBaixo(labelsMap, localizacaoAtual);
                              passos++;
                              sairForEach = true;
                              break;
                        }

                    }
                    //Regra 5: SE o número da linha da posição atual for superior ao número da linha da
                    //posição do vilão ENTÃO dar um passo para cima.
                    case "5":
                    {System.out.println("Regra 5");
                        if(!verificarRegra(regra, labelsMap, localizacaoAtual))
                        {
                            continue;
                        }
                        else
                        {
                             try 
                           {
                              System.out.println("[" + passos + "]" + "- " + "Movendo para cima");                           
                              Thread.sleep(1000); // Pausa por 1 segundos
                           } 
                           catch (InterruptedException e) 
                           {
                              e.printStackTrace();
                           }
                             
                              moverParaCima(labelsMap, localizacaoAtual);
                              passos++;
                              sairForEach = true;
                              break;
                        }
                        
                    }
                   
                }
            }
        }
        
       JOptionPane.showMessageDialog(null, "Total de passos: " + passos, "FIM DE JOGO!", JOptionPane.INFORMATION_MESSAGE);
    }       
    
}
