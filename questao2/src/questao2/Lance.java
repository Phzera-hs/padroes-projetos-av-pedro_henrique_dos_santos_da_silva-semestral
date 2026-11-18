package questao2;

public class Lance {
    private Participante participante;
    private double valor;

    public Lance(Participante participante, double valor) {
        this.participante = participante;
        this.valor = valor;
    }

    public Participante getParticipante() {
        return this.participante;
    }

    public double getValor() {
        return this.valor;
    }
}
