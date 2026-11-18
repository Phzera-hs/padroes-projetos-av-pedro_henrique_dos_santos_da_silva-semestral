package questao2;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== CASA DE LEILOES ONLINE =====\n");

        Lote loteArte = new Lote("Quadro Modernista", "Arte", 1000.00, 1300.00, new ComissaoArte());
        Lote loteVeiculo = new Lote("Sedan Classico 1998", "Veiculos", 50000.00, 70000.00, new ComissaoVeiculos());

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        ana.acompanhar(loteArte);
        bruno.acompanhar(loteArte);
        carla.acompanhar(loteArte);
        loteArte.adicionarObservador(painel);
        loteArte.adicionarObservador(auditor);

        ana.acompanhar(loteVeiculo);
        bruno.acompanhar(loteVeiculo);
        loteVeiculo.adicionarObservador(painel);
        loteVeiculo.adicionarObservador(auditor);

        System.out.println(">> Rodada de lances: " + loteArte.getNome());
        ana.darLance(loteArte, 1030.00);   
        ana.darLance(loteArte, 1100.00);  
        bruno.darLance(loteArte, 1250.00); 

        System.out.println("\n[Acompanhamento] Carla deixou de acompanhar '" + loteArte.getNome() + "'.");
        carla.deixarDeAcompanhar(loteArte);

        carla.darLance(loteArte, 1500.00);

        System.out.println();
        loteArte.setRegraComissao(new ComissaoEletronicos());

        loteArte.encerrar();
        ana.darLance(loteArte, 1700.00);   
        System.out.println();

        System.out.println(">> Rodada de lances: " + loteVeiculo.getNome());
        ana.darLance(loteVeiculo, 51000.00); 
        bruno.darLance(loteVeiculo, 55000.00); 
        loteVeiculo.encerrar();                
        System.out.println();

        loteArte.imprimirAcertoVendedor();
        loteVeiculo.imprimirAcertoVendedor();

        abstItemFatura faturaArte = new VendaLote(loteArte);
        faturaArte = new SeguroTransporteDecorator(faturaArte);
        faturaArte = new CertificadoAutenticidadeDecorator(faturaArte);
        faturaArte = new EmbalagemEspecialDecorator(faturaArte);
        faturaArte = new EmbalagemEspecialDecorator(faturaArte);
        faturaArte = new EntregaExpressaDecorator(faturaArte);

        FaturaComprador.imprimir(faturaArte);

        auditor.imprimirHistorico();
    }
}
