package segundoPeriodo.poo.estacionamento;

public interface Impressao{

    public static void estacionamentoNaoCadastrado(){
        System.out.println("*****************************************************");
        System.out.println("* Estacionamento Existe Estacionamentos Cadastrados *");
        System.out.println("*****************************************************");
    }

    public static void entreComNumeros(){
        System.out.println("*****************************************************");
        System.out.println("*            Entre apenas com números               *");
        System.out.println("*****************************************************");
    }

    public static void cadastradoComSucesso(){
        System.out.println("*****************************************************");
        System.out.println("*     Estacionamento Cadastrado com Sucesso!        *");
        System.out.println("*****************************************************");
    }

}
