package questao1;

public class AwsFactory extends AbsFactoryNuvem {

    @Override
    public String nomeProvedor() {
        return "Aws";
    }

    @Override
    public AbsMaquinaVirtual criarMaquinaVirtual() {
        return new AwsMaquinaVirtual(seqMaquinas.incrementAndGet());
    }

    @Override
    public AbsArmazenamento criarArmazenamento(int quantidadeGb) {
        return new AwsArmazenamento(seqArmazenamentos.incrementAndGet(), quantidadeGb);
    }

    @Override
    public AbsFilaMensagens criarFila() {
        return new AwsFilaMensagens(seqFilas.incrementAndGet());
    }

    @Override
    public double custoHoraMaquina() {
        return AwsMaquinaVirtual.CUSTO_HORA;
    }

    @Override
    public double custoGbMes() {
        return AwsArmazenamento.CUSTO_GB_MES;
    }

    @Override
    public double custoFilaMes() {
        return AwsFilaMensagens.CUSTO_FIXO_MES;
    }
}
