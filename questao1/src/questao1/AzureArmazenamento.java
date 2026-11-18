package questao1;

public class AzureArmazenamento extends AbsArmazenamento {
    public static final double CUSTO_GB_MES = 0.02;
    public static final String PREFIXO = "blob://";

    public AzureArmazenamento(int sequencial, int quantidadeGb) {
        super(PREFIXO + sequencial, quantidadeGb, CUSTO_GB_MES);
    }
}
