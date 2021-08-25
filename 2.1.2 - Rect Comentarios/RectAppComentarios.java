

public class RectApp {  // Declara a Classe como Publica
    public static void main (String[] args) {   //Cria a função main como publica e static
        Rect r1 = new Rect(1,1, 10,10);   // Chama a classe Rect pafra criar o retângulo r1 com a largura w no valor de 10
        r1.print();  // Recebe o resultado do método da classe Rect (void print) e imprime na tela 
     }
} 

class Rect {   // Cria a classe Rect que vai fornecer o resultado para a função main
     int x, y;   // declara as variaveis x e y com o tipo inteiro
     int w, h;   // declara as variaveis x e h com o tipo inteiro
     Rect (int x, int y, int w, int h) {   // Cria o construtor do retangulo com as variaveis que foram declaradas e recebe os valores dos argumentos da função main
         this.x = x;   // Estabelece que para este retangulo que está sendo criado (this.) a posição x no quadro da tela tem o valor do argumento que foi passado
         this.y = y;  // Estabelece que para este retangulo que está sendo criado (this.) a posição y no quadro da tela tem o valor do argumento que foi passado
         this.w = w;  // Estabelece que para este retangulo que está sendo criado (this.) a largura w do retangulo tem o valor do argumento que foi passado
         this.h = h;  // Estabelece que para este retangulo que está sendo criado (this.) a altura h do retangulo tem o valor do argumento que foi passado
     }

     void print () {    // Cria o metodo da classe que fornecerá o retorno para a função main, neste caso e imprimir (print) o retangulo na tela  
       System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n", 
           this.w, this.h, this.x, this.y);  // Estabelece o formato da impressão que será passado para a função main com o texto e os valores
       }
}



