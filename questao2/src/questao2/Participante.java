package questao2;

public class Participante implements IObservadorLote {
    private String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void acompanhar(Lote lote) {
        lote.adicionarObservador(this);
    }

    public void deixarDeAcompanhar(Lote lote) {
        lote.removerObservador(this);
    }

    public boolean darLance(Lote lote, double valor) {
        return lote.registrarLance(this, valor);
    }

    @Override
    public void atualizar(Lote lote, Lance lance, Participante autor) {
        if (this != autor) {
            System.out.println("[Notificacao -> " + this.nome + "] Novo lance no lote '" + lote.getNome()
                    + "': R$ " + String.format("%.2f", lance.getValor()));
        }
    }
}
