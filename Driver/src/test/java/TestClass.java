import org.example.Barca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClass {

    private Barca barca;

    @BeforeEach
    void setUp() {
        barca = new Barca();
    }


    @Test
    public void primeiros100() {

        int i;
        int j = 1;

        for(j= 1; j<6 ; j++) {
            for (i = 1; i < 21; i++) {
                barca.ocupaLugar(j, i);
            }
        }
        //Testar colocar passageiro da fileira 21 a 39 -                                                   	Erro - 2

        int resultado;

        resultado = barca.ocupaLugar("F22A01");
        Assertions.assertEquals(2, resultado);
// Testar colocar passageiro na fileira de 1 a 20 -                                                	Erro - 2
        resultado = barca.ocupaLugar("F01A02");
        Assertions.assertEquals(2, resultado);

       //Testar colocar passageiro de 40 a 60 -                                                               	Aceitar - 3

        resultado = barca.ocupaLugar("F1A01");
        Assertions.assertEquals(3, resultado);

        // Testar colocar passageiro da mesma posição nas fileiras de 40 a 60 -      		Erro – 1

        resultado = barca.ocupaLugar("F1A01");
        Assertions.assertEquals(1, resultado);

        //Testar colocar em um assento com identificador inválido -                          		Erro - 0

        resultado = barca.ocupaLugar("F400A5000");
        Assertions.assertEquals(0, resultado);

    }

    @Test
    public void primeiros100NaoEntraram() {
        int resultado;
        //Testar colocar passageiro da fileira 21 a 39 -                                                   	Erro - 2
        resultado = barca.ocupaLugar("F22A01");
        Assertions.assertEquals(2, resultado);


// Testar colocar passageiro na fileira de 1 a 20 -                                                	Erro - 2
        resultado = barca.ocupaLugar("F01A01");
        Assertions.assertEquals(3, resultado);

        //Testar colocar passageiro de 40 a 60 -                                                               	Aceitar - 3

        resultado = barca.ocupaLugar("F41A01");
        Assertions.assertEquals(2, resultado);

        // Testar colocar passageiro da mesma posição nas fileiras de 40 a 60 -      		Erro – 1

        resultado = barca.ocupaLugar("F1A01");
        Assertions.assertEquals(1, resultado);

        //Testar colocar em um assento com identificador inválido -                          		Erro - 0

        resultado = barca.ocupaLugar("F400A5000");
        Assertions.assertEquals(0, resultado);

    }

    @Test
    public void primeiros200JaEntraram() {

        int i;
        int j = 1;

        for(j= 1; j<6 ; j++) {
            for (i = 1; i < 21; i++) {
                barca.ocupaLugar(j, i);
            }
        }

        for(j= 41; j<46 ; j++) {
            for (i = 1; i < 21; i++) {
                barca.ocupaLugar(j, i);
            }
        }

        int resultado;



        // Testar colocar da fileira 21 a 39 -                                                                         	Aceitar – 3
        resultado = barca.ocupaLugar("F22A01");
        Assertions.assertEquals(3, resultado);


        //Testar colocar em um assento já ocupado -                                                     	Erro – 1
        resultado = barca.ocupaLugar("F22A01");
        Assertions.assertEquals(1, resultado);

        // Testar colocar em um assento com identificador inválido -                       		Erro – 0
        resultado = barca.ocupaLugar("F400A5000");
        Assertions.assertEquals(0, resultado);

    }


}
