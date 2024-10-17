import ProgramacaoModular.CompeticaoCiclismo;
import ProgramacaoModular.model.*;
import ProgramacaoModular.utils.Data;
import ProgramacaoModular.utils.Duracao;
import ProgramacaoModular.utils.Hora;

public class MainPrograma {
    public static void main(String[] args) {
        // Criar uma competição de ciclismo
        CompeticaoCiclismo competicao = new CompeticaoCiclismo();

        // Criar ciclistas
        Ciclista ciclista1 = new Ciclista(1, "João Silva", "São Paulo");
        Ciclista ciclista2 = new Ciclista(2, "Maria Oliveira", "Rio de Janeiro");
        Ciclista ciclista3 = new Ciclista(3, "Carlos Santos", "Belo Horizonte");

        // Adicionar ciclistas à competição
        competicao.adicionarCiclista(ciclista1);
        competicao.adicionarCiclista(ciclista2);
        competicao.adicionarCiclista(ciclista3);

        // Criar e adicionar etapas para cada ciclista
        for (int i = 1; i <= 21; i++) {
            Data data = new Data(i, 7, 2023);
            Hora horaInicial = new Hora(8, 0, 0);

            // Duração aleatória para cada etapa (entre 2h e 6h)
            int horasAleatorias = 2 + (int)(Math.random() * 4);
            int minutosAleatorios = (int)(Math.random() * 60);
            int segundosAleatorios = (int)(Math.random() * 60);
            Duracao duracao = new Duracao(horasAleatorias, minutosAleatorios, segundosAleatorios);

            Etapa etapa = new Etapa(i, data, horaInicial, duracao);

            ciclista1.adicionarEtapa(etapa);

            // Criar etapas ligeiramente diferentes para os outros ciclistas
            duracao = new Duracao(horasAleatorias, minutosAleatorios + 1, segundosAleatorios);
            etapa = new Etapa(i, data, horaInicial, duracao);
            ciclista2.adicionarEtapa(etapa);

            duracao = new Duracao(horasAleatorias, minutosAleatorios - 1, segundosAleatorios);
            etapa = new Etapa(i, data, horaInicial, duracao);
            ciclista3.adicionarEtapa(etapa);
        }

        // Determinar o vencedor da competição
        Ciclista vencedor = competicao.getVencedor();
        System.out.println("O vencedor da competição é: " + vencedor.getNome());

        // Mostrar o tempo total de cada ciclista
        System.out.println("Tempo total de " + ciclista1.getNome() + ": " + ciclista1.getTempoTotal());
        System.out.println("Tempo total de " + ciclista2.getNome() + ": " + ciclista2.getTempoTotal());
        System.out.println("Tempo total de " + ciclista3.getNome() + ": " + ciclista3.getTempoTotal());

        // Comparar dois ciclistas
        Duracao diferenca = competicao.getDiferencaTempo(ciclista1, ciclista2);
        System.out.println("Diferença de tempo entre " + ciclista1.getNome() + " e " + ciclista2.getNome() + ": " + diferenca);

        // Determinar o vencedor de uma etapa específica
        int etapaEscolhida = 10; // Por exemplo, a décima etapa
        Ciclista vencedorEtapa = competicao.getVencedorEtapa(etapaEscolhida);
        System.out.println("O vencedor da etapa " + etapaEscolhida + " é: " + vencedorEtapa.getNome());

        // Verificar quem venceu uma etapa específica entre dois ciclistas
        boolean ciclista1Venceu = ciclista1.venceuEtapa(ciclista2, etapaEscolhida);
        System.out.println(ciclista1.getNome() + (ciclista1Venceu ? " venceu " : " perdeu para ") + ciclista2.getNome() + " na etapa " + etapaEscolhida);
    }
}