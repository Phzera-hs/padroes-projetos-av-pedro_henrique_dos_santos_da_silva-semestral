package questao2;

public class ComissaoArte extends abstRegraComissao {
    @Override
    double calcularComissao(double valorVenda) {
        return valorVenda * 0.20;
    }

    @Override
    String getDescricaoRegra() {
        return "Arte (20%)";
    }
}
