package questao1;

public class AwsMaquinaVirtual extends AbsMaquinaVirtual {
    public static final double CUSTO_HORA = 0.10;
    public static final String PREFIXO = "i-";

    public AwsMaquinaVirtual(int sequencial) {
        super(PREFIXO + sequencial, CUSTO_HORA);
    }
}
