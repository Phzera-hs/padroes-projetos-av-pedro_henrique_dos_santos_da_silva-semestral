package questao2;

public class CertificadoAutenticidadeDecorator extends abstServicoAdicionalDecorator {
    public CertificadoAutenticidadeDecorator(abstItemFatura faturaDecorada) {
        super(faturaDecorada);
    }

    @Override
    String gerarDescricao() {
        return this.faturaDecorada.gerarDescricao()
                + "\n  + Certificado de autenticidade: R$ " + String.format("%.2f", 300.00);
    }

    @Override
    double calcularTotal() {
        return this.faturaDecorada.calcularTotal() + 300.00;
    }
}
