package questao1;

public abstract class AbsRecursoNuvem {
    public final String identificador;

    public AbsRecursoNuvem(String identificador) {
        this.identificador = identificador;
    }

    public abstract double custoMensal();
}
