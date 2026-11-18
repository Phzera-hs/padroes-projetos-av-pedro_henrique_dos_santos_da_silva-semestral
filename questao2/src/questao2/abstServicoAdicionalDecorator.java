package questao2;

public abstract class abstServicoAdicionalDecorator extends abstItemFatura {
    protected abstItemFatura faturaDecorada;

    public abstServicoAdicionalDecorator(abstItemFatura faturaDecorada) {
        this.faturaDecorada = faturaDecorada;
    }

    @Override
    double getValorVendaBase() {
        return this.faturaDecorada.getValorVendaBase();
    }
}
