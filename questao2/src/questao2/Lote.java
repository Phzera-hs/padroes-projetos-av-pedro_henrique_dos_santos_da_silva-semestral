package questao2;

import java.util.ArrayList;
import java.util.List;

public class Lote {
    private String nome;
    private String categoria;
    private double precoInicial;
    private double precoReserva;
    private double lanceAtual;
    private Participante maiorOfertante;
    private boolean encerrado;
    private boolean vendido;
    private List<Lance> lances = new ArrayList<>();
    private List<IObservadorLote> observadores = new ArrayList<>();
    private abstRegraComissao regraComissao;

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, abstRegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regraComissao;
        this.encerrado = false;
        this.vendido = false;
    }

    public void adicionarObservador(IObservadorLote observador) {
        if (observador != null && !this.observadores.contains(observador)) {
            this.observadores.add(observador);
        }
    }

    public void removerObservador(IObservadorLote observador) {
        this.observadores.remove(observador);
    }

    protected void notificarObservadores(Lance lance, Participante autor) {
        for (IObservadorLote obs : new ArrayList<>(this.observadores)) {
            obs.atualizar(this, lance, autor);
        }
    }

    public void setRegraComissao(abstRegraComissao novaRegra) {
        this.regraComissao = novaRegra;
        System.out.println("[Campanha] Regra de comissao do lote '" + this.nome
                + "' alterada para: " + novaRegra.getDescricaoRegra());
    }

    public boolean registrarLance(Participante autor, double valor) {
        if (this.encerrado) {
            System.out.println("[Lance Recusado] O lote '" + this.nome + "' ja esta encerrado.");
            return false;
        }

        double valorMinimoAceito = this.lanceAtual * 1.05;
        if (valor + 1e-6 < valorMinimoAceito) {
            System.out.println("[Lance Recusado] " + autor.getNome() + " ofertou R$ "
                    + String.format("%.2f", valor) + " no lote '" + this.nome
                    + "'. O valor deve ser pelo menos 5% maior que o lance atual (minimo: R$ "
                    + String.format("%.2f", valorMinimoAceito) + ").");
            return false;
        }

        Lance novoLance = new Lance(autor, valor);
        this.lances.add(novoLance);
        this.lanceAtual = valor;
        this.maiorOfertante = autor;

        System.out.println("[Lance Aceito] " + autor.getNome() + " ofertou R$ "
                + String.format("%.2f", valor) + " no lote '" + this.nome + "'.");
        notificarObservadores(novoLance, autor);
        return true;
    }

    public void encerrar() {
        if (this.encerrado) {
            return;
        }
        this.encerrado = true;
        if (!this.lances.isEmpty() && this.lanceAtual >= this.precoReserva) {
            this.vendido = true;
            System.out.println("[Encerramento] Lote '" + this.nome + "' VENDIDO para "
                    + this.maiorOfertante.getNome() + " por R$ " + String.format("%.2f", this.lanceAtual) + ".");
        } else {
            this.vendido = false;
            System.out.println("[Encerramento] Lote '" + this.nome
                    + "' NAO VENDIDO (maior lance R$ " + String.format("%.2f", this.lanceAtual)
                    + " nao atingiu a reserva de R$ " + String.format("%.2f", this.precoReserva) + ").");
        }
    }

    public double calcularComissaoVenda() {
        if (!this.vendido) {
            return 0.0;
        }
        return this.regraComissao.calcularComissao(this.lanceAtual);
    }

    public void imprimirAcertoVendedor() {
        System.out.println("--- Acerto do Vendedor ---");
        System.out.println("Lote: " + this.nome + " (" + this.categoria + ")");
        if (!this.vendido) {
            System.out.println("Status: Lote nao vendido. Nenhum repasse ou comissao aplicavel.");
            System.out.println("--------------------------");
            return;
        }
        double valorVenda = this.lanceAtual;
        double comissao = calcularComissaoVenda();
        double valorLiquido = valorVenda - comissao;

        System.out.println("Regra aplicada: " + this.regraComissao.getDescricaoRegra());
        System.out.println("Valor de venda: R$ " + String.format("%.2f", valorVenda));
        System.out.println("Comissao cobrada: R$ " + String.format("%.2f", comissao));
        System.out.println("Valor liquido a repassar: R$ " + String.format("%.2f", valorLiquido));
        System.out.println("--------------------------");
    }

    public String getNome() {
        return this.nome;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public double getLanceAtual() {
        return this.lanceAtual;
    }

    public int getTotalLances() {
        return this.lances.size();
    }

    public Participante getMaiorOfertante() {
        return this.maiorOfertante;
    }

    public boolean isEncerrado() {
        return this.encerrado;
    }

    public boolean isVendido() {
        return this.vendido;
    }
}
