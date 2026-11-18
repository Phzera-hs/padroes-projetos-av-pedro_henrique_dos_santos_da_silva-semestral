package questao1;

public abstract class AbsMaquinaVirtual extends AbsRecursoNuvem {
    public static final int HORAS_MES = 730;
    protected final double custoHora;

    public AbsMaquinaVirtual(String identificador, double custoHora) {
        super(identificador);
        this.custoHora = custoHora;
    }

    @Override
    public double custoMensal() {
        return custoHora * HORAS_MES;
    }
}
