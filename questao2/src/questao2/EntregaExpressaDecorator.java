package questao2;

public class EntregaExpressaDecorator extends abstServicoAdicionalDecorator {
    public EntregaExpressaDecorator(abstItemFatura faturaDecorada) {
        super(faturaDecorada);
    }

    @Override
    String gerarDescricao() {
        return this.faturaDecorada.gerarDescricao()
                + "\n  + Entrega expressa: R$ " + String.format("%.2f", 450.00);
    }

    @Override
    double calcularTotal() {
        return this.faturaDecorada.calcularTotal() + 450.00;
    }
}
