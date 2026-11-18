package questao1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public final class HistoricoAuditoria {
    private static final HistoricoAuditoria INSTANCIA = new HistoricoAuditoria();
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    private final List<String> registros = new ArrayList<>();

    private HistoricoAuditoria() {
    }

    public static HistoricoAuditoria getInstance() {
        return INSTANCIA;
    }

    public synchronized void registrar(String nomeAmbiente, String provedor, String resultado) {
        String dataHora = LocalDateTime.now().format(FORMATO);
        registros.add(dataHora + " | Ambiente: " + nomeAmbiente + " | Provedor: " + provedor
                + " | Resultado: " + resultado);
    }

    public synchronized void imprimirHistorico() {
        System.out.println("--- Historico de Auditoria ---");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}
