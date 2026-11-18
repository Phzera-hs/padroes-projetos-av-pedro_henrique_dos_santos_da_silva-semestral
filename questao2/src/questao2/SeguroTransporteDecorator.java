package questao2;

public class SeguroTransporteDecorator extends abstServicoAdicionalDecorator {
    public SeguroTransporteDecorator(abstItemFatura faturaDecorada) {
        super(faturaDecorada);
    }

    private double calcularCustoServico() {
        return getValorVendaBase() * 0.015;
    }

    @Override
    String gerarDescricao() {
        return this.faturaDecorada.gerarDescricao()
                + "\n  + Seguro de transporte (1,5%): R$ " + String.format("%.2f", calcularCustoServico());
    }

    @Override
    double calcularTotal() {
        return this.faturaDecorada.calcularTotal() + calcularCustoServico();
    }
}
