package questao2;

public class ComissaoVeiculos extends abstRegraComissao {
    @Override
    double calcularComissao(double valorVenda) {
        double comissao = valorVenda * 0.08;
        return Math.min(comissao, 5000.00);
    }

    @Override
    String getDescricaoRegra() {
        return "Veiculos (8%, teto R$ 5.000,00)";
    }
}
