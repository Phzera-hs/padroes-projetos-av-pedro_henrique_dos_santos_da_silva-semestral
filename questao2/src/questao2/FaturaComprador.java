package questao2;

public class FaturaComprador {
    public static void imprimir(abstItemFatura fatura) {
        System.out.println("--- Fatura do Comprador ---");
        System.out.println(fatura.gerarDescricao());
        System.out.println("Total a pagar: R$ " + String.format("%.2f", fatura.calcularTotal()));
        System.out.println("---------------------------");
    }
}
