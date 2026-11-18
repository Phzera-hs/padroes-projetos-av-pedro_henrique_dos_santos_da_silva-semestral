package questao1;

public class MontadorAmbiente {
    private final AbsFactoryNuvem fabrica;

    public MontadorAmbiente(AbsFactoryNuvem fabrica) {
        this.fabrica = fabrica;
    }

    public void provisionar(SolicitacaoAmbiente solicitacao) {
        Configuracao config = Configuracao.getInstance();
        HistoricoAuditoria auditoria = HistoricoAuditoria.getInstance();
        String provedor = fabrica.nomeProvedor();

        double custo = solicitacao.quantidadeMaquinas * fabrica.custoHoraMaquina() * AbsMaquinaVirtual.HORAS_MES
                + solicitacao.quantidadeGb * fabrica.custoGbMes()
                + fabrica.custoFilaMes();

        if (custo > config.getOrcamentoMensalMaximo()) {
            String motivo = "custo estimado R$ " + String.format("%.2f", custo)
                    + " excede o orcamento de R$ " + String.format("%.2f", config.getOrcamentoMensalMaximo());
            auditoria.registrar(solicitacao.nomeAmbiente, provedor, "RECUSADO - " + motivo);
            System.out.println("Ambiente " + solicitacao.nomeAmbiente + " RECUSADO: " + motivo + "\n");
            return;
        }

        AmbienteProvisionado ambiente = new AmbienteProvisionado(
                solicitacao.nomeAmbiente, provedor, config.getRegiaoPadrao(), custo);
        for (int i = 0; i < solicitacao.quantidadeMaquinas; i++) {
            ambiente.adicionarMaquina(fabrica.criarMaquinaVirtual());
        }
        ambiente.definirArmazenamento(fabrica.criarArmazenamento(solicitacao.quantidadeGb));
        ambiente.definirFila(fabrica.criarFila());

        ambiente.imprimirResumo();
        auditoria.registrar(solicitacao.nomeAmbiente, provedor, "ACEITO");
    }
}
