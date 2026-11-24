package principal;

import java.util.List;
import java.util.ArrayList;

public class ControleRegras 
{

    public List <String> definirPrioridades()
    {
        //Regra 2: SE o número da coluna da posição atual for superior ao número da coluna da posição do vilão ENTÃO dar um passo para a esquerda.
        //Regra 3: SE o número da coluna da posição atual for inferior ao número da coluna da posição do vilão ENTÃO dar um passo para a direita.
        //Regra 4: SE o número da linha da posição atual for inferior ao número da linha da posição do vilão ENTÃO dar um passo para baixo.
        //Regra 5: SE o número da linha da posição atual for superior ao número da linha da posição do vilão ENTÃO dar um passo para cima.
            
        List <String> regras = new ArrayList<>();
        
        regras.add("2");
        regras.add("3");
        regras.add("4");
        regras.add("5");
        
        return regras;
        
    }
            
            
            
            
}
