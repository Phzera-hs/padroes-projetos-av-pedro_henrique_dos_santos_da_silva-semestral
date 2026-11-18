package questao1;

public abstract class AbsArmazenamento extends AbsRecursoNuvem {
    protected final int quantidadeGb;
    protected final double custoGbMes;

    public AbsArmazenamento(String identificador, int quantidadeGb, double custoGbMes) {
        super(identificador);
        this.quantidadeGb = quantidadeGb;
        this.custoGbMes = custoGbMes;
    }

    @Override
    public double custoMensal() {
        return quantidadeGb * custoGbMes;
    }
}
