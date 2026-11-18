package questao1;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbsFactoryNuvem {
    protected final AtomicInteger seqMaquinas = new AtomicInteger();
    protected final AtomicInteger seqArmazenamentos = new AtomicInteger();
    protected final AtomicInteger seqFilas = new AtomicInteger();

    public abstract String nomeProvedor();

    public abstract AbsMaquinaVirtual criarMaquinaVirtual();

    public abstract AbsArmazenamento criarArmazenamento(int quantidadeGb);

    public abstract AbsFilaMensagens criarFila();

    public abstract double custoHoraMaquina();

    public abstract double custoGbMes();

    public abstract double custoFilaMes();
}
