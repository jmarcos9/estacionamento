package segundoPeriodo.poo.estacionamento;

public class Estacionamento {

    private int codigo;
    private String nome;
    private String cidade;
    private int vagas;
    boolean situacao;
    private float valorIncial;
    private float valorAdicional;
    private int franquiaInicial;

    public Estacionamento(int codigo, String nome, String cidade, int vagas, boolean situacao, float valorIncial, float valorAdicional, int franquiaInicial) {

        this.situacao = situacao;
        this.valorIncial = valorIncial;
        this.valorAdicional = valorAdicional;
        this.franquiaInicial = franquiaInicial;
    }

    public Estacionamento(int codigo, String nome, String cidade, int vagas) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
        this.vagas = vagas;

    }

    public Estacionamento(boolean situacao) {
        this.situacao = situacao;
    }

    public Estacionamento() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public float getValorIncial() {
        return valorIncial;
    }

    public void setValorIncial(float valorIncial) {
        this.valorIncial = valorIncial;
    }

    public float getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(float valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public int getFranquiaInicial() {
        return franquiaInicial;
    }

    public void setFranquiaInicial(int franquiaInicial) {
        this.franquiaInicial = franquiaInicial;
    }



    void ativar(){
        situacao=true;
    }

    public void desativar(){
        setSituacao(false);
    }


    public void vagas(int ocupar) {
        vagas -= ocupar;
    }

    /*public void mostrarEstado(){
        if (isSituacao()){
            System.out.println("Estacionamento ativado");
        } else {
            System.out.println("Estacionamento Desativado");
        }
    }*/

    public void mudaEstado(){
        if (isSituacao()){
            desativar();
        } else {
            ativar();
        }
    }




}
