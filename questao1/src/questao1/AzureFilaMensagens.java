package questao1;

public class AzureFilaMensagens extends AbsFilaMensagens {
    public static final double CUSTO_FIXO_MES = 0.50;
    public static final String PREFIXO = "sb-";

    public AzureFilaMensagens(int sequencial) {
        super(PREFIXO + sequencial, CUSTO_FIXO_MES);
    }
}
