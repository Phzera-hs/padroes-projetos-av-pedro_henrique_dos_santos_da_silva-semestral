package questao1;

public class AzureMaquinaVirtual extends AbsMaquinaVirtual {
    public static final double CUSTO_HORA = 0.12;
    public static final String PREFIXO = "vm-";

    public AzureMaquinaVirtual(int sequencial) {
        super(PREFIXO + sequencial, CUSTO_HORA);
    }
}
