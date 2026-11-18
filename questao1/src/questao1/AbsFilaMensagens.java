package questao1;

public abstract class AbsFilaMensagens extends AbsRecursoNuvem {
    protected final double custoFixoMes;

    public AbsFilaMensagens(String identificador, double custoFixoMes) {
        super(identificador);
        this.custoFixoMes = custoFixoMes;
    }

    @Override
    public double custoMensal() {
        return custoFixoMes;
    }
}
