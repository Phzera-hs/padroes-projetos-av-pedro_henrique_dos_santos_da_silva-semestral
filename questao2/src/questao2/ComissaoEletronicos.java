package questao2;

public class ComissaoEletronicos extends abstRegraComissao {
    @Override
    double calcularComissao(double valorVenda) {
        double comissao = valorVenda * 0.12;
        return Math.max(comissao, 50.00);
    }

    @Override
    String getDescricaoRegra() {
        return "Eletronicos (12%, minimo R$ 50,00)";
    }
}
