package questao1;

public class AwsArmazenamento extends AbsArmazenamento {
    public static final double CUSTO_GB_MES = 0.023;
    public static final String PREFIXO = "s3://";

    public AwsArmazenamento(int sequencial, int quantidadeGb) {
        super(PREFIXO + sequencial, quantidadeGb, CUSTO_GB_MES);
    }
}
