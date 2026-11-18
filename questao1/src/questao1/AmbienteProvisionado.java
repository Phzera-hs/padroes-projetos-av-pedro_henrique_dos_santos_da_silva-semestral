package questao1;

import java.util.ArrayList;
import java.util.List;

public class AmbienteProvisionado {
    private final String nome;
    private final String provedor;
    private final String regiao;
    private final double custoMensal;
    private final List<AbsMaquinaVirtual> maquinas = new ArrayList<>();
    private AbsArmazenamento armazenamento;
    private AbsFilaMensagens fila;

    public AmbienteProvisionado(String nome, String provedor, String regiao, double custoMensal) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.custoMensal = custoMensal;
    }

    public void adicionarMaquina(AbsMaquinaVirtual maquina) {
        maquinas.add(maquina);
    }

    public void definirArmazenamento(AbsArmazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public void definirFila(AbsFilaMensagens fila) {
        this.fila = fila;
    }

    public void imprimirResumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Resumo do Provisionamento ---\n");
        sb.append("Ambiente: ").append(nome).append("\n");
        sb.append("Provedor: ").append(provedor).append("\n");
        sb.append("Regiao: ").append(regiao).append("\n");
        for (AbsMaquinaVirtual m : maquinas) {
            sb.append("Maquina virtual: ").append(m.identificador).append("\n");
        }
        sb.append("Armazenamento: ").append(armazenamento.identificador).append("\n");
        sb.append("Fila: ").append(fila.identificador).append("\n");
        sb.append("Custo mensal estimado: R$ ").append(String.format("%.2f", custoMensal)).append("\n");
        System.out.println(sb);
    }
}
