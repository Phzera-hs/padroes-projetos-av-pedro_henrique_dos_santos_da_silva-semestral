package questao2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditor implements IObservadorLote {
    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private List<String> registros = new ArrayList<>();

    @Override
    public void atualizar(Lote lote, Lance lance, Participante autor) {
        String dataHora = LocalDateTime.now().format(FORMATADOR);
        String log = "[" + dataHora + "] Lote: " + lote.getNome()
                + " | Participante: " + autor.getNome()
                + " | Valor: R$ " + String.format("%.2f", lance.getValor());
        this.registros.add(log);
        System.out.println("[Auditor] Lance registrado -> " + log);
    }

    public void imprimirHistorico() {
        System.out.println("--- Historico Completo do Auditor ---");
        for (String registro : this.registros) {
            System.out.println(registro);
        }
        System.out.println("-------------------------------------");
    }
}
