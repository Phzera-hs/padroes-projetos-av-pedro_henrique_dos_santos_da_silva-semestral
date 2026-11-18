package questao2;

public class VendaLote extends abstItemFatura {
    private Lote lote;

    public VendaLote(Lote lote) {
        if (lote == null || !lote.isVendido()) {
            throw new IllegalArgumentException("A fatura so pode ser gerada para um lote vendido.");
        }
        this.lote = lote;
    }

    @Override
    String gerarDescricao() {
        return "Lote: " + this.lote.getNome() + " (Comprador: " + this.lote.getMaiorOfertante().getNome() + ")"
                + "\n  - Valor de venda do lote: R$ " + String.format("%.2f", this.lote.getLanceAtual());
    }

    @Override
    double calcularTotal() {
        return this.lote.getLanceAtual();
    }

    @Override
    double getValorVendaBase() {
        return this.lote.getLanceAtual();
    }
}
