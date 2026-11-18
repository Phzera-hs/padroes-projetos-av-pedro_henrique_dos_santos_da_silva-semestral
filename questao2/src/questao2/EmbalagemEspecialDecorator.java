package questao2;

public class EmbalagemEspecialDecorator extends abstServicoAdicionalDecorator {
    public EmbalagemEspecialDecorator(abstItemFatura faturaDecorada) {
        super(faturaDecorada);
    }

    @Override
    String gerarDescricao() {
        return this.faturaDecorada.gerarDescricao()
                + "\n  + Embalagem especial: R$ " + String.format("%.2f", 180.00);
    }

    @Override
    double calcularTotal() {
        return this.faturaDecorada.calcularTotal() + 180.00;
    }
}
