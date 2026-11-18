package questao2;

public class PainelLeiloeiro implements IObservadorLote {
    @Override
    public void atualizar(Lote lote, Lance lance, Participante autor) {
        System.out.println("[Painel do Leiloeiro] Lote '" + lote.getNome()
                + "' | Maior lance: R$ " + String.format("%.2f", lote.getLanceAtual())
                + " | Total de lances recebidos: " + lote.getTotalLances());
    }
}
