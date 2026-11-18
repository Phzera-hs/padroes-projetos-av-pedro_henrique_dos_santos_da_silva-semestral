package questao2;

public class ComissaoImoveis extends abstRegraComissao {
    @Override
    double calcularComissao(double valorVenda) {
        return (valorVenda * 0.03) + 1500.00;
    }

    @Override
    String getDescricaoRegra() {
        return "Imoveis (3% + R$ 1.500,00 fixos)";
    }
}
