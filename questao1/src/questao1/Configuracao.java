package questao1;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;


public final class Configuracao {
    private static final Configuracao INSTANCIA = new Configuracao();

    private final String regiaoPadrao;
    private final double orcamentoMensalMaximo;

    private Configuracao() {
        Properties props = new Properties();
        Path arquivo = Paths.get("config.properties");
        if (!Files.exists(arquivo)) {
            arquivo = Paths.get("questao1", "config.properties");
        }
        try (InputStream in = Files.newInputStream(arquivo)) {
            props.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("Nao foi possivel ler config.properties", e);
        }
        this.regiaoPadrao = props.getProperty("regiao.padrao");
        this.orcamentoMensalMaximo = Double.parseDouble(props.getProperty("orcamento.mensal.maximo"));
    }

    public static Configuracao getInstance() {
        return INSTANCIA;
    }

    public String getRegiaoPadrao() {
        return regiaoPadrao;
    }

    public double getOrcamentoMensalMaximo() {
        return orcamentoMensalMaximo;
    }
}
