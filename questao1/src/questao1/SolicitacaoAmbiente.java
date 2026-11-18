package questao1;

public class SolicitacaoAmbiente {
    public final String nomeAmbiente;
    public final String provedor;
    public final int quantidadeMaquinas;
    public final int quantidadeGb;

    public SolicitacaoAmbiente(String nomeAmbiente, String provedor, int quantidadeMaquinas, int quantidadeGb) {
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.quantidadeMaquinas = quantidadeMaquinas;
        this.quantidadeGb = quantidadeGb;
    }
}
