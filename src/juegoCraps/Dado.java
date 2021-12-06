package juegoCraps;
/**

*Class Dado generate a random value between 1 and 6
* @author Marlon Anacona

 */
import java.util.Random;

public class Dado
{

    //atributo
    private int cara;

    /**
     *Method that generate an value to cara
     *
     * @return number between (1,6)
     */
    public int getCara() {
        Random aleatorio= new Random();
                cara=aleatorio.nextInt(6)+1;
        return cara;
    }
}
