package questao1;

public class AzureFactory extends AbsFactoryNuvem {

    @Override
    public String nomeProvedor() {
        return "Azure";
    }

    @Override
    public AbsMaquinaVirtual criarMaquinaVirtual() {
        return new AzureMaquinaVirtual(seqMaquinas.incrementAndGet());
    }

    @Override
    public AbsArmazenamento criarArmazenamento(int quantidadeGb) {
        return new AzureArmazenamento(seqArmazenamentos.incrementAndGet(), quantidadeGb);
    }

    @Override
    public AbsFilaMensagens criarFila() {
        return new AzureFilaMensagens(seqFilas.incrementAndGet());
    }

    @Override
    public double custoHoraMaquina() {
        return AzureMaquinaVirtual.CUSTO_HORA;
    }

    @Override
    public double custoGbMes() {
        return AzureArmazenamento.CUSTO_GB_MES;
    }

    @Override
    public double custoFilaMes() {
        return AzureFilaMensagens.CUSTO_FIXO_MES;
    }
}
