package ProgramacaoModular.tp1.model;

public class Duracao {
    private int horas;
    private int minutos;
    private int segundos;

    public Duracao(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        normalizar();
    }

    private void normalizar() {
        this.minutos += this.segundos / 60;
        this.segundos %= 60;
        this.horas += this.minutos / 60;
        this.minutos %= 60;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public Duracao somar(Duracao outra) {
        return new Duracao(
            this.horas + outra.horas,
            this.minutos + outra.minutos,
            this.segundos + outra.segundos
        );
    }

    public Duracao subtrair(Duracao outra) {
        int totalSegundosThis = this.horas * 3600 + this.minutos * 60 + this.segundos;
        int totalSegundosOutra = outra.horas * 3600 + outra.minutos * 60 + outra.segundos;
        int diferenca = Math.abs(totalSegundosThis - totalSegundosOutra);
        return new Duracao(0, 0, diferenca);
    }

    public int compareTo(Duracao outra) {
        if (this.horas != outra.horas) {
            return Integer.compare(this.horas, outra.horas);
        }
        if (this.minutos != outra.minutos) {
            return Integer.compare(this.minutos, outra.minutos);
        }
        return Integer.compare(this.segundos, outra.segundos);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}