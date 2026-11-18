package questao1;

public class AwsFilaMensagens extends AbsFilaMensagens {
    public static final double CUSTO_FIXO_MES = 0.40;
    public static final String PREFIXO = "sqs-";

    public AwsFilaMensagens(int sequencial) {
        super(PREFIXO + sequencial, CUSTO_FIXO_MES);
    }
}
