package questao1;

public class Main {
    private static final AbsFactoryNuvem FABRICA_AWS = new AwsFactory();
    private static final AbsFactoryNuvem FABRICA_AZURE = new AzureFactory();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = executar(new SolicitacaoAmbiente("Producao-Web", "Aws", 2, 100));
        Thread t2 = executar(new SolicitacaoAmbiente("Analytics", "Aws", 1, 50));
        Thread t3 = executar(new SolicitacaoAmbiente("Homologacao-API", "Azure", 1, 200));
        Thread t4 = executar(new SolicitacaoAmbiente("Cluster-BigData", "Azure", 4, 100));

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        HistoricoAuditoria.getInstance().imprimirHistorico();
    }

    private static Thread executar(SolicitacaoAmbiente solicitacao) {
        Thread thread = new Thread(() -> {
            AbsFactoryNuvem fabrica = escolherFabrica(solicitacao.provedor);
            new MontadorAmbiente(fabrica).provisionar(solicitacao);
        });
        thread.start();
        return thread;
    }

    private static AbsFactoryNuvem escolherFabrica(String provedor) {
        switch (provedor) {
            case "Aws":
                return FABRICA_AWS;
            case "Azure":
                return FABRICA_AZURE;
            default:
                throw new IllegalArgumentException("Provedor nao suportado: " + provedor);
        }
    }
}
