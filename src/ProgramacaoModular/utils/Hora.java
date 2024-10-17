package ProgramacaoModular.utils;

public class Hora {
    private int hora;
    private int minuto;
    private int segundo;

    public Hora(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public int compareTo(Hora outra) {
        if (this.hora != outra.hora) {
            return Integer.compare(this.hora, outra.hora);
        }
        if (this.minuto != outra.minuto) {
            return Integer.compare(this.minuto, outra.minuto);
        }
        return Integer.compare(this.segundo, outra.segundo);
    }
}
