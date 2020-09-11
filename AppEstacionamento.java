package segundoPeriodo.poo.estacionamento;
/*
Vagas = Quantidade de vagas alocadas para estacionamento.
Situação = Ativado ou desativado

Por ocasião do cadastro do estacionamento a sua situação do estacionamento deve
ser desativada.
Não deve ser permitida ativar o estacionamento se ele já estiver ativo.
Não deve ser permitida desativar o estacionamento se ele já estiver desativado.

Valor inicial: Valor do estacionamento para a hora iniciais franquiadas.
Valor adicional: Valor por estacionamento por hora adicional além da hora franquiada.
Hora franquiada inicial: Quantidade de horas franquiadas para permanência coberta pelo valor
inicial.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppEstacionamento implements Impressao {
    static List<Estacionamento> listaEstacionamento = new ArrayList<Estacionamento>();
    //static List<Placas> listaPlcas= new ArrayList<Placas>();

    static Scanner scan = new Scanner(System.in);
    static int opcao;
    static boolean infValida = false;
    static int vagastotal;

    public static void main(String[] args) {

        do {
            System.out.println("\n1 - Cadastrar Estacionamento \n2 - Ativar/Desativar Estacionamento " +
                    "\n3 - Alugar Vaga  \n4 - Liberar Vaga \n5 - Listar Estacionamento \n6 - Calcular Pagamento \n7 - Encerrar");
            System.out.print("Entre com a opção: ");
            opcao = scan.nextInt();

            switch (opcao){
                case 1:
                    cadastrarEstacionamento();
                    break;
                case 2:
                    ativarDesativar();
                    break;
                case 3:
                    alugarVaga();
                    break;
                case 4:
                    liberarVaga();
                    break;
                case 5:
                    listarEstacionamentos();
                    break;
                case 6:
                    calcularPagamento();
                    break;
                case 7:
                    System.out.println("Programa encerrado");
                default:
                    System.out.println("Opção Inválida");
            }
        } while (opcao != 0);
    }

    public static void cadastrarEstacionamento(){
        int codigo;
        do {
            try {
                System.out.print("Cadastre Código para Novo Estacionamento: ");
                codigo = scan.nextInt();
                break;
            }catch (Exception e) {
                Impressao.entreComNumeros();
                scan.next();
                continue;
            }
        } while (true);

        scan.nextLine();
        System.out.print("Informe o Nome do Estacionamento: ");
        String nome = scan.nextLine();

        System.out.print("Informe a Cidade do Estacionamento: ");
        String cidade = scan.nextLine();

        int vagas;
        do {
            try {
                System.out.print("Cadastre Quantidade de Vagas: ");
                vagas = scan.nextInt();
                break;
            }catch (Exception e) {
                Impressao.entreComNumeros();
                scan.next();
                continue;
            }
        } while (true);

        Estacionamento estacionamento = new Estacionamento(codigo, nome, cidade, vagas);
        listaEstacionamento.add(estacionamento);
        Impressao.cadastradoComSucesso();
        vagastotal = vagas;
    }

    public static Estacionamento pesquisarEstacionamentoCodigo(int cod) {
        for (Estacionamento estacionamento : listaEstacionamento) {
            if (estacionamento.getCodigo() == cod) {
                return estacionamento;
            }
        }
        return null;
    }

    static Estacionamento estacionamento = new Estacionamento();
    public static boolean ativarDesativar(){
        if (listaEstacionamento.size() == 0){
            Impressao.estacionamentoNaoCadastrado();
            return true;
        }

        int codigo = 0;
        do {
            try {
                System.out.print("\nInforme o Código do Estacionamento para Ativar/Desativar: ");
                codigo = scan.nextInt();
                break;
            }
            catch(Exception e) {
                Impressao.entreComNumeros();
                scan.next();
                //continue;
            }
        } while (true);

        Estacionamento estacionamento = pesquisarEstacionamentoCodigo(codigo);
        if (estacionamento == null){
            Impressao.estacionamentoNaoCadastrado();
        } else {
            System.out.println("Options: \n1 - Ativar Estacionamento \n2 - Desativar Estacionamento ");
            while (true){
                try {
                    System.out.print("Entre com a Opção: ");
                    opcao = scan.nextByte();
                    break;
                } catch (Exception exception) {
                    scan.next();
                    Impressao.entreComNumeros();
                    continue;
                }
            }

            if (opcao == 1) {
                if (estacionamento.situacao == true) {
                    System.out.println("Estacionamento já está ativado");
                } else {
                    estacionamento.ativar();
                    System.out.printf("Estacionamento código: %d Ativado.", codigo);
                    System.out.println();
                }
            }

            if (opcao == 2) {
                if (estacionamento.situacao == false) {
                    System.out.println("Estacionamento já está desativado");
                } else {
                    estacionamento.desativar();
                    System.out.printf("Estacionamento código: %d Desativado.",codigo);
                }
            }
            return true;
        }
        return false;
    }

    public static void alugarVaga(){
        if (listaEstacionamento.size() == 0){
            Impressao.estacionamentoNaoCadastrado();
            return;
        }

        if (estacionamento.situacao == true ){
            System.out.println("Estacionamento não ativado");
            return;
        } else {
            int codigo = 0;
            do {
                try {
                    System.out.print("\nInforme o Código do Estacionamento para Ocupar Vaga: ");
                    codigo = scan.nextInt();
                    break;
                }
                catch(Exception e) {
                    Impressao.entreComNumeros();
                    scan.next();
                    continue;
                }
            } while (true);

            Estacionamento estacionamento = pesquisarEstacionamentoCodigo(codigo);
            if (estacionamento == null){
                System.out.println("Estacionamento não cadastrado");
            }
            System.out.println();
            if (estacionamento.getVagas() == 0) {
                System.out.println("\nNão temos mais Vagas");
                return;
            }
            int vagaLiberada = estacionamento.getVagas();
            scan.nextLine();
            System.out.print("Informe placa do veículo: ");
            String placa = scan.nextLine();
            estacionamento.setVagas(vagaLiberada-1);
        }
    }

    public static void liberarVaga(){
        if (listaEstacionamento.size() == 0){
            Impressao.estacionamentoNaoCadastrado();
            return;
        }
        System.out.println();
        if (estacionamento.situacao == true ){
            System.out.println("Estacionamento não ativado");
            return;
        } else {
            int codigo = 0;
            do {
                try {
                    System.out.print("\nInforme o Código do Estacionamento para Liberar Vaga: ");
                    codigo = scan.nextInt();
                    break;
                }
                catch(Exception e) {
                    Impressao.entreComNumeros();
                    scan.next();
                    continue;
                }
            } while (true);
            System.out.println();
            Estacionamento estacionamento = pesquisarEstacionamentoCodigo(codigo);
            if (estacionamento == null){
                System.out.println("Estacionamento não cadastrado");
            }
            if (estacionamento.getVagas() == vagastotal) {
                System.out.println("\nTodas as vagas foram liberadas");
                return;
            }
            System.out.println();
            int vagaLiberada = estacionamento.getVagas();
            scan.nextLine();
            System.out.print("Informe placa do veículo: ");
            String placa = scan.nextLine();
            estacionamento.setVagas(vagaLiberada+1);
        }
    }

    public static void calcularPagamento(){
        final double VALOR_FRANQUIA = 10.00;
        final double VALOR_ADICIONAL = 3.00;
        final int HORA_FRANQUIA = 4;
        int tempoPermanecia = 0;
        double valorAdicional;
        double valorTotalPagar;

        if (listaEstacionamento.size() == 0){
            Impressao.estacionamentoNaoCadastrado();
            return;
        }
        System.out.println();
        if (estacionamento.situacao == true ) {
            System.out.println("Estacionamento não ativado");
            return;
        }

        while (true){
            try {
                System.out.print("Informe Tempo de Permanecencia: ");
                tempoPermanecia = scan.nextInt();
                break;
            }catch (Exception e){
                Impressao.entreComNumeros();
                scan.next();
                continue;
            }
        }
        valorAdicional = (tempoPermanecia - HORA_FRANQUIA) * VALOR_ADICIONAL;
        valorTotalPagar = VALOR_FRANQUIA + valorAdicional;
        if (HORA_FRANQUIA > tempoPermanecia){
            System.out.printf("\nValor Total a pagar R$ %.2f", VALOR_FRANQUIA);
        } else {
            System.out.printf("\nValor Total a pagar R$ %.2f", valorTotalPagar);
        }
    }

    public static void listarEstacionamentos(){
        if (listaEstacionamento.size() == 0){
            Impressao.estacionamentoNaoCadastrado();
            return;
        }
        System.out.println("           Listagem de Estacionamento              ");
        System.out.println("Cód   Descrição       Cidade      Qtde Vagas Disponíveis");
        for (Estacionamento estacionamento : listaEstacionamento){
            System.out.printf("\n%-6d %-16s %-16s %-6d", estacionamento.getCodigo(),
                    estacionamento.getNome(), estacionamento.getCidade(), estacionamento.getVagas());
        }
        System.out.println();
    }


}
