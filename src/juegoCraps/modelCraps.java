package juegoCraps;

import java.util.SimpleTimeZone;

/**
 * Class modelCraps apply craps rules
 *
 * estado=1 natural winner
 * estado=2 craps looser
 * estado=3 estabilish punto
 * estado=4 punto winner
 * estado=5 punto looser
 *
 */
public class modelCraps {

    private Dado dado1,dado2;
    private int tiro, punto,estado,flag;
    private String[] estadoToString ;
    private int[] caras;


    public  modelCraps(){

        dado1=new Dado();
        dado2=new Dado();
        caras=new int[2];
        estadoToString=new String[2];
        flag=0;
    }

    public void calcularTiro(){
        caras[0]=dado1.getCara();
        caras[1]=dado2.getCara();
        tiro= caras[0]+caras[1];

    }
    
    public  void determinarJuego()
    {
        if(flag==0)
        {
        if(tiro==7 || tiro==11){
            estado=1;
            
        }else{
            if(tiro==3||tiro==2||tiro==12)
            {
                estado=2;
            }else{
                estado=3;
                punto=tiro;
                flag=1;
            }
        }
        }else{
            //ronda punto
            rondaPunto();
        }
    }

    private void rondaPunto() {
        if(tiro==punto){
            estado=4;
            flag=0;
        }else{

            if (tiro==7){
                estado=5;
                flag=0;
            }else{
                estado=6;
            }
        }

    }

    public int getTiro() {
        return tiro;
    }

    public int getPunto() {
        return punto;
    }

    /**
     * Estabilish message game state according to estado atribute value
     * @return message  for the view class
     */
    public String[] getEstadoToString() {
        switch (estado){
            case 1:
                estadoToString[0]="Tiro de salida= "+tiro;
                estadoToString[1]="Sacaste natural, Has ganado!";
                break;
            case 2:
                estadoToString[0]="Tiro de salida= "+tiro;
                estadoToString[1]="Sacaste craps, Has perdido!!";
                break;
            case 3:
                estadoToString[0]="Tiro de salida= "+tiro+ "'\nPunto = "+ punto;
                estadoToString[1]="Estableciste punto en"+punto+
                "Debes seguir lanzando!!"+
                "\n pero si  sacas 7 antes que "+punto+" perderas";
                break;
            case 4:
                estadoToString[0]="Tiro de salida= "+tiro+ "'\nPunto = "+ punto
                +"\nValor del nuevo tiro = "+ tiro;
                estadoToString[1]="Volviste a sacar"+punto+", has ganado!!";
                break;
                case 5:
                    estadoToString[0]="Tiro de salida= "+tiro+ "'\nPunto = "+ punto+
                    "\nValor del nuevo tiro= "+tiro;
                estadoToString[1]="Sacaste 7 antes que "+punto+"Has perdido!!";
                break;
            case 6:
                estadoToString[0]="Tiro de salida= "+punto+ "'\nPunto = "+ punto+
                        "\nValor del nuevo tiro= "+tiro;
                estadoToString[1]= "Estas en punto y Debes seguir lanzando!!"+
                        "\n pero si  sacas 7 antes que "+punto+" perderas";;
                break;

        }
        return estadoToString;
    }

    public int[] getCaras() {

        return caras;
    }
}

