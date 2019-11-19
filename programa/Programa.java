package programa;

import dados.*;
import clientes.*;
import carros.*;
import exceptions.*;
import fachada.*;
import vendedores.*;
import abstrata.*;
import alugueis.*;
import java.util.Scanner;

public class Programa {

    /*  public static String Menu() {

        return "\n" + "----- MENU PRINCIPAL -----\n" + "\n"
                + "[1] PARA CADASTRAR UM AUTOM�VEL\n" + "[2] PARA REMOVER UM AUTOM�VEL\n"
                + "[3] PARA ATUALIZAR UM AUTOM�VEL\n" + "[4] PARA VERIFICAR SE UM AUTOM�VEL EXISTE\n"
                + "[5] PARA VERIFICAR SE UM AUTOM�VEL EST� ALUGADO\n"
                + "[6] PARA PROCURAR AS ESPECIFICA��ES DE UM AUTOM�VEL\n" + "[7] PARA CADASTRAR UM VENDEDOR\n"
                + "[8] PARA DEMITIR UM VENDEDOR\n" + "[9] PARA ATUALIZAR O CADASTRO DE UM VENDEDOR\n"
                + "[10] PARA VERIFICAR SE UM VENDEDOR EST� CADASTRADO NO SISTEMA\n" + "[11] PARA PROCURAR UM VENDEDOR\n"
                + "[12] PARA CADASTRAR UM CLIENTE\n" + "[13] PARA REMOVER UM CLIENTE\n" + "[14] PARA ATUALIZAR UM CLIENTE\n"
                + "[15] PARA VERIFICAR SE UM CLIENTE EST� CADASTRADO\n" + "[16] PARA PROCURAR UM CLIENTE\n" + "[17] PARA CADASTRAR UM ALUGUEL\n"
                + "[18] PARA REMOVER UM ALUGUEL\n" + "[19] PARA ATUALIZAR UM ALUGUEL\n" + "[20] PARA PROCURAR UM ALUGUEL A PARTIR DO CPF DE UM CLIENTE\n"
                + "[21] PARA PROCURAR UM ALUGUEL A PARTIR DA PLACA DO CARRO\n" + "[22] PARA CHECAR SE EXISTE UM CLIENTE ALUGANDO UM AUTOM�VEL\n"
                + "[23] PARA CHECAR SE EXISTE UM CARRO SENDO ALUGADO\n" + "[0] PARA SAIR\n";

    }

    public static boolean opcaovalida(String a) {

        boolean valido = false;
        for (int i = 0; i < 24 && !valido; i++) {
            if (a.equals(Integer.toString(i))) {
                valido = true;
            }
        }
        return valido;
    }*/
    public static void main(String[] args) throws CCException, QPIException, PDIException, ANException, PNEException, PEException, VCException, MATException, TELException, CPFException, FNEException, MNException, CJCexception, CNHexception, CNCException, CJAException, CJACException, CNCException, VNCException, DiaIException, ANEException, CNAException {

        Scanner in = new Scanner(System.in);
        String resp, a, b, c, e, lr, t, pa, resp1, cnh, data, cpfantigo, cnhantigo; //lr � pra pegar o resto da linha do int //pa � a placa antiga
        int qp = 0;
        int d = 0;
        int g = 0;
        int ga = 0;
        int dias = 0;
        double pd = 0;
        boolean repetir = true;
        boolean anoinvalido = true;
        boolean portasinvalidas = true;
        boolean diariainvalida = true;
        boolean matinvalido = true;
        boolean diasinvalidos = true;
        boolean exception = true;

        // RepositorioCarros repositoriocarro = new RepositorioCarrosLista();
        // RepositorioVendedor repositoriovendedor = new RepositorioVendedorLista();
        // RepositorioCliente repositoriocliente = new RepositorioClienteLista();
        // RepositorioAlugados repositorioalugados = new RepositorioAlugadosLista();
        RepositorioCliente repositoriocliente = new RepositorioClientesArray(100);
        CadastroClientes cadastrocliente = new CadastroClientes(repositoriocliente);
        RepositorioCarros repositoriocarro = new RepositorioCarrosArray(100);
        CadastroCarros cadastrocarro = new CadastroCarros(repositoriocarro);
        RepositorioVendedor repositoriovendedor = new RepositorioVendedorArray(100);
        CadastroVendedor cadastrovendedor = new CadastroVendedor(repositoriovendedor);
        RepositorioAlugados repositorioalugados = new RepositorioAlugadosArray(100);
        CadastroAluguel cadastroaluguel = new CadastroAluguel(repositorioalugados, repositoriocliente);
        ClasseFachada cf = new ClasseFachada(cadastrocarro, cadastrovendedor, cadastrocliente, cadastroaluguel);

        //while (repetir) {
        System.out.println();
        System.out.println("---- SISTEMA DE ALUGUEL DE CARROS ----");
        System.out.println();
        //System.out.println(Menu());
        int op;
        do {
            System.out.println("\n1 - Menu de Carros");
            System.out.println("2 - Menu de Funcionarios");
            System.out.println("3 - Menu de Clientes");
            System.out.println("4 - Menu de Alugueis");
            System.out.println("5 - Menu Checagem");
            System.out.println("0 - Sair");
            System.out.print("Digite sua escolha: ");
            op = in.nextInt();

            int menu;
            switch (op) {

                case 1:
                    System.out.println("\nMenu Carro: \n");
                    System.out.println("1 - Cadastrar Um Automóvel");
                    System.out.println("2 - Remover Um Automóvel");
                    System.out.println("3 - Atualizar Um Automóvel");
                    System.out.println("4 - Procurar Automóvel");
                    System.out.println("5 - Verificar estado do Automóvel");
                    System.out.print("Digite sua opção: ");
                    menu = in.nextInt();
                    in.nextLine();
                    switch (menu) {
                        case 1:
                            System.out.println("Você escolheu CADASTRAR UM AUTOMÓVEL.");
                            System.out.print("Digite o modelo do ve�culo: ");
                            a = in.nextLine();
                            System.out.print("Digite a cor do ve�culo: ");
                            b = in.nextLine();
                            System.out.print("Digite a placa do ve�culo: ");
                            c = in.nextLine();
                            System.out.print("Digite o ano do ve�culo: ");
                            while (anoinvalido) {
                                if (in.hasNextInt()) {
                                    d = in.nextInt();
                                    lr = in.nextLine();
                                    anoinvalido = false;
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para o ano: ");
                                }
                            }
                            anoinvalido = true;
                            System.out.print("Digite a quantidade de portas: ");
                            while (portasinvalidas) {
                                if (in.hasNextInt()) {
                                    qp = in.nextInt();
                                    lr = in.nextLine();
                                    portasinvalidas = false;
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para a quantidade de portas: ");
                                }
                            }
                            portasinvalidas = true;
                            System.out.print("Digite o valor do pre�o da di�ria: ");
                            while (diariainvalida) {
                                if (in.hasNextDouble()) {
                                    pd = in.nextDouble();
                                    lr = in.nextLine();
                                    diariainvalida = false;
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor num�rico para o pre�o da di�ria: ");
                                }
                            }
                            diariainvalida = true;
                            Carros carro1 = new Carros(a, b, c, d, qp, pd);
                            try {
                                cf.cadastrarCarro(carro1);
                                exception = false;
                            } catch (CCException erro) {
                                System.out.println(erro.getMessage());
                            } catch (QPIException erro) {
                                System.out.println(erro.getMessage());
                            } catch (PDIException erro) {
                                System.out.println(erro.getMessage());
                            } catch (ANException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    System.out.println("Cadastro realizado com sucesso!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: ");
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            if (resp1.equals("s")) {
                                repetir = true;
                            } else {
                                repetir = false;
                            }
                            break;

                        case 2: 	// REMOVER UM AUTOM�VEL

                            System.out.println("Você escolheu REMOVER UM AUTOM�VEL.");
                            System.out.print("Digite a placa do carro que Você deseja remover: ");
                            c = in.nextLine();
                            c = c.trim();
                            try {
                                cf.removerCarro(c);
                                exception = false;
                            } catch (PNEException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    System.out.println("Remoção realizada com sucesso!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: ");
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            repetir = resp1.equals("s");
                            break;

                        case 3:	//ATUALIZAR UM AUTOM�VEL

                            System.out.println("Você escolheu ATUALIZAR UM AUTOM�VEL.");
                            System.out.print("Digite a placa do carro que Você deseja atualizar: ");
                            pa = in.nextLine();
                            pa = pa.trim();
                            System.out.println("Reinsira todos os dados do carro");
                            System.out.print("Digite o modelo do ve�culo: ");
                            a = in.nextLine();
                            System.out.print("Digite a cor do ve�culo: ");
                            b = in.nextLine();
                            System.out.print("Digite a placa do ve�culo: ");
                            c = in.nextLine();
                            System.out.print("Digite o ano do ve�culo: ");
                            while (anoinvalido) {
                                if (in.hasNextInt()) {
                                    d = in.nextInt();
                                    anoinvalido = false;
                                    lr = in.nextLine();
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para o ano: ");
                                }
                            }
                            anoinvalido = true;
                            System.out.print("Digite a quantidade de portas: ");
                            while (portasinvalidas) {
                                if (in.hasNextInt()) {
                                    qp = in.nextInt();
                                    portasinvalidas = false;
                                    lr = in.nextLine();
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para a quantidade de portas: ");
                                }
                            }
                            portasinvalidas = true;
                            System.out.print("Digite o valor do pre�o da di�ria: ");
                            while (diariainvalida) {
                                if (in.hasNextDouble()) {
                                    pd = in.nextDouble();
                                    diariainvalida = false;
                                    lr = in.nextLine();
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor num�rico para o pre�o da di�ria: ");
                                }
                            }
                            diariainvalida = true;
                            Carros carro2 = new Carros(a, b, c, d, qp, pd);
                            try {
                                cf.atualizarCarro(carro2, pa);
                                exception = false;
                            } catch (CCException erro) {
                                System.out.println(erro.getMessage());
                            } catch (QPIException erro) {
                                System.out.println(erro.getMessage());
                            } catch (PDIException erro) {
                                System.out.println(erro.getMessage());
                            } catch (ANException erro) {
                                System.out.println(erro.getMessage());
                            } catch (PEException erro) {
                                System.out.println(erro.getMessage());
                            } catch (PNEException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    System.out.println("Atualização realizada com sucesso!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: ");
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            if (resp1.equals("s")) {
                                repetir = true;
                            } else {
                                repetir = false;
                            }
                            break;

                        /*case "4":	// VERIFICAR SE UM AUTOM�VEL EXISTE
                        *O procurar pode fazer a mesma função*
                        System.out.println("Você escolheu VERIFICAR SE UM AUTOM�VEL EXISTE.");
                        System.out.print("Digite a placa do autom�vel que Você deseja verificar: ");
                        pa = in.nextLine();
                        pa = pa.trim();
                        if (cf.existePlaca(pa)) {
                            System.out.println("O autom�vel existe.");
                        } else {
                            System.out.println("O autom�vel n�o existe.");
                        }
                        System.out.print("Se deseja realizar outra operação, digite [s]: ");
                        resp1 = in.nextLine();
                        resp1 = resp1.trim();
                        if (resp1.equals("s")) {
                            repetir = true;
                        } else {
                            repetir = false;
                        }
                        break;*/
                        case 4:	//PROCURAR UM AUTOM�VEL

                            System.out.println("Você escolheu PROCURAR UM AUTOM�VEL.");
                            System.out.print("Digite a placa do autom�vel que Você deseja procurar especifica��es: ");
                            pa = in.nextLine();
                            pa = pa.trim();
                            Carros car = null;
                            try {
                                car = cf.procurarCarro(pa);
                                exception = false;
                            } catch (PNEException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    exception = true;
                                    System.out.println("MODELO: " + car.getModelo());
                                    System.out.println("COR: " + car.getCor());
                                    System.out.println("PLACA: " + car.getPlaca());
                                    System.out.println("QUANTIDADE DE PORTAS: " + car.getQuantidadePortas());
                                    System.out.println("ANO: " + car.getAno());
                                    System.out.println("PRE�O DA DI�RIA: " + car.getPrecoDiaria());
                                    System.out.print("Se deseja realizar outra operação, digite [s]: ");
                                    resp1 = in.nextLine();
                                    resp1 = resp1.trim();
                                    if (resp1.equalsIgnoreCase("s")) {
                                        repetir = true;
                                    } else {
                                        repetir = false;
                                    }
                                }
                            }

                            break;

                        case 5:	// VERIFICAR SE UM AUTOM�VEL EST� ALUGADO

                            System.out.println("Você escolheu VERIFICAR SE UM AUTOM�VEL EST� ALUGADO.");
                            System.out.print("Digite a placa do autom�vel que Você deseja verificar: ");
                            pa = in.nextLine();
                            pa = pa.trim();
                            try {
                                if (cf.isAlugado(pa)) {
                                    System.out.println("O autom�vel est� alugado.");
                                } else {
                                    System.out.println("O autom�vel n�o est� alugado.");
                                }
                                exception = false;
                            } catch (PNEException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: ");
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            if (resp1.equals("s")) {
                                repetir = true;
                            } else {
                                repetir = false;
                            }
                            break;
                        default:
                            System.out.println("Opção Inválida");

                            break;

                    }
                    break;

                case 2:
                    //Menu Vendedor

                    System.out.println("\nMenu Vendedor: \n");
                    System.out.println("1 - Cadastrar");
                    System.out.println("2 - Demitir");
                    System.out.println("3 - Atualizar");
                    System.out.println("4 - Procurar");
                    System.out.print("Digite sua opção: ");
                    menu = in.nextInt();
                    in.nextLine();
                    switch (menu) {
                        case 1:

                            System.out.println("Você escolheu CADASTRAR UM VENDEDOR.");
                            System.out.print("Digite o nome do vendedor: ");
                            a = in.nextLine();
                            a = a.trim();
                            System.out.print("Digite o cpf do vendedor: ");
                            b = in.nextLine();
                            b = b.trim();
                            System.out.print("Digite o telefone do vendedor: ");
                            c = in.nextLine();
                            c = c.trim();
                            System.out.print("Digite a MATRICULA do vendedor: ");
                            while (matinvalido) {
                                if (in.hasNextInt()) {
                                    g = in.nextInt();
                                    lr = in.nextLine();
                                    matinvalido = false;
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para a MATRICULA: ");
                                }
                            }
                            matinvalido = true;
                            Vendedor vendedor = new Vendedor(a, b, c, g);
                            try {
                                cf.cadastrarVendedor(vendedor);
                                exception = false;
                            } catch (VCException erro) {
                                System.out.println(erro.getMessage());
                            } catch (MATException erro) {
                                System.out.println(erro.getMessage());
                            } catch (TELException erro) {
                                System.out.println(erro.getMessage());
                            } catch (CPFException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    System.out.println("Cadastro realizado com sucesso!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: ");
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            if (resp1.equals("s")) {
                                repetir = true;
                            } else {
                                repetir = false;
                            }
                            break;

                        case 2:

                            System.out.println("Você escolheu DEMITIR UM VENDEDOR");
                            System.out.print("Digite a MATRICULA do vendedor: ");
                            while (matinvalido) {
                                if (in.hasNextInt()) {
                                    g = in.nextInt();
                                    lr = in.nextLine();
                                    matinvalido = false;
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para a MATRICULA: ");
                                }
                            }
                            matinvalido = true;
                            try {
                                cf.removerVendedor(g);
                                exception = false;
                            } catch (FNEException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    System.out.println("Remoção realizada com sucesso!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: ");
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            if (resp1.equals("s")) {
                                repetir = true;
                            } else {
                                repetir = false;
                            }
                            break;

                        case 3:

                            System.out.println("Você escolheu ATUALIZAR O CADASTRO DE UM VENDEDOR");
                            System.out.print("Digite o nome do vendedor: ");
                            a = in.nextLine();
                            a = a.trim();
                            System.out.print("Digite o cpf do vendedor: ");
                            b = in.nextLine();
                            b = b.trim();
                            System.out.print("Digite o telefone do vendedor: ");
                            c = in.nextLine();
                            c = c.trim();
                            System.out.print("Digite a MATRICULA NOVA do vendedor: ");
                            while (matinvalido) {
                                if (in.hasNextInt()) {
                                    g = in.nextInt();
                                    lr = in.nextLine();
                                    matinvalido = false;
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para a MATRICULA: ");
                                }
                            }
                            matinvalido = true;
                            System.out.print("Digite a MATRICULA ANTIGA do vendedor: "); //TIREI O LN!!!!
                            while (matinvalido) {
                                if (in.hasNextInt()) {
                                    ga = in.nextInt();
                                    lr = in.nextLine();
                                    matinvalido = false;
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para a MATRICULA: ");
                                }
                            }
                            matinvalido = true;
                            Vendedor vendedor1 = new Vendedor(a, b, c, g);
                            try {
                                cf.atualizarVendedor(vendedor1, ga);
                                exception = false;
                            } catch (MATException erro) {
                                System.out.println(erro.getMessage());
                            } catch (MNException erro) {
                                System.out.println(erro.getMessage());
                            } catch (TELException erro) {
                                System.out.println(erro.getMessage());
                            } catch (CPFException erro) {
                                System.out.println(erro.getMessage());
                            } catch (VCException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    System.out.println("Atualização realizada com sucesso!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: "); //ADICIONEI ESSA OP��O
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            if (resp1.equals("s")) {
                                repetir = true;
                            } else {
                                repetir = false;
                            }
                            break;

                        /*case 4:

                                System.out.println("Você escolheu VERIFICAR SE UM VENDEDOR EST� CADASTRADO.");
                                System.out.print("Digite a MATRICULA do vendedor: ");
                                while (matinvalido) {
                                    if (in.hasNextInt()) {
                                        g = in.nextInt();
                                        lr = in.nextLine();
                                        matinvalido = false;
                                    } else {
                                        lr = in.nextLine();
                                        System.out.print("Entrada inválida. Digite um valor inteiro para a MATRICULA: ");
                                    }
                                }
                                matinvalido = true;
                                if (cf.existeVendedor(g)) {
                                    System.out.println("O vendedor existe.");
                                } else {
                                    System.out.println("O vendedor n�o existe.");
                                }
                                System.out.print("Se deseja realizar outra operação, digite [s]: ");
                                resp1 = in.nextLine();
                                resp1 = resp1.trim();
                                if (resp1.equals("s")) {
                                    repetir = true;
                                } else {
                                    repetir = false;
                                }
                                break;*/
                        case 4:

                            System.out.println("Você escolheu PROCURAR UM VENDEDOR.");
                            System.out.print("Digite a MATRICULA do vendedor: ");
                            while (matinvalido) {
                                if (in.hasNextInt()) {
                                    g = in.nextInt();
                                    lr = in.nextLine();
                                    matinvalido = false;
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para a MATRICULA: ");
                                }
                            }
                            matinvalido = true;
                            Vendedor ven = null;
                            try {
                                ven = cf.procurarVendedor(g);
                                exception = false;
                            } catch (VNCException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    exception = true;
                                    System.out.println(ven.getNome());
                                    System.out.println("CPF: " + ven.getCpf());
                                    System.out.println("TELEFONE: " + ven.getTelefone());
                                    System.out.println("MATRICULA: " + ven.getMatricula());
                                    System.out.print("Se deseja realizar outra operação, digite [s]: ");
                                    resp1 = in.nextLine();
                                    resp1 = resp1.trim();
                                    if (resp1.equalsIgnoreCase("s")) {
                                        repetir = true;
                                    } else {
                                        repetir = false;
                                    }
                                }
                            }

                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                    break;

                case 3:

                    //Menu Clientes
                    System.out.println("\nMenu Clientes: \n");
                    System.out.println("1 - Cadastrar");
                    System.out.println("2 - Remover");
                    System.out.println("3 - Atualizar");
                    System.out.println("4 - Procurar");
                    System.out.print("Digite sua opção: ");

                    menu = in.nextInt();
                    in.nextLine();

                    switch (menu) {

                        case 1:

                            System.out.println("Você escolheu CADASTRAR UM CLIENTE");
                            System.out.print("Digite o nome do cliente: ");
                            a = in.nextLine();
                            a = a.trim();
                            System.out.print("Digite o cpf do cliente: ");
                            b = in.nextLine();
                            b = b.trim();
                            System.out.print("Digite o telefone do cliente: ");
                            c = in.nextLine();
                            c = c.trim();
                            System.out.print("Digite a CNH do cliente: ");
                            cnh = in.nextLine();
                            cnh = cnh.trim();
                            System.out.print("Digite a data de cadastro: ");
                            data = in.nextLine();
                            data = data.trim();
                            Cliente cliente = new Cliente(a, b, c, cnh, data);
                            try {
                                cf.cadastrarCliente(cliente);
                                exception = false;
                            } catch (CJCexception erro) {
                                System.out.println(erro.getMessage());
                            } catch (CNHexception erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    System.out.println("Cadastro realizado com sucesso!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: ");
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            if (resp1.equals("s")) {
                                repetir = true;
                            } else {
                                repetir = false;
                            }
                            break;

                        case 2:

                            System.out.println("Você escolheu REMOVER UM CLIENTE");
                            System.out.print("Digite o cpf do cliente: ");
                            a = in.nextLine();
                            a = a.trim();
                            try {
                                cf.removerCliente(a);
                                exception = false;
                            } catch (CNCException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    System.out.println("Remoção realizada com sucesso!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: ");
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            if (resp1.equals("s")) {
                                repetir = true;
                            } else {
                                repetir = false;
                            }
                            break;

                        case 3:

                            System.out.println("Você escolheu ATUALIZAR O CADASTRO DE UM CLIENTE");
                            System.out.print("Digite o nome do cliente: ");
                            a = in.nextLine();
                            a = a.trim();
                            System.out.print("Digite o cpf antigo do cliente: ");
                            cpfantigo = in.nextLine();
                            cpfantigo = cpfantigo.trim();
                            System.out.println("Digite o cpf novo do cliente: ");
                            b = in.nextLine();
                            b = b.trim();
                            System.out.print("Digite o telefone do cliente: ");
                            c = in.nextLine();
                            c = c.trim();
                            System.out.println("Digite a CNH antiga do cliente: ");
                            cnhantigo = in.nextLine();
                            cnhantigo = cnhantigo.trim();
                            System.out.print("Digite a nova CNH do cliente: ");
                            cnh = in.nextLine();
                            cnh = cnh.trim();
                            System.out.print("Digite a data de cadastro: ");
                            data = in.nextLine();
                            data = data.trim();
                            Cliente cliente1 = new Cliente(a, b, c, cnh, data);
                            try {
                                cf.atualizarCliente(cliente1, cpfantigo, cnhantigo);
                                exception = false;
                            } catch (CNCException erro) {
                                System.out.println(erro.getMessage());
                            } catch (CNHexception erro) {
                                System.out.println(erro.getMessage());
                            } catch (CPFException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    System.out.println("Atualização realizada com sucesso!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: ");
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            if (resp1.equals("s")) {
                                repetir = true;
                            } else {
                                repetir = false;
                            }
                            break;

                        /*case 4:

                                System.out.println("Você escolheu VERIFICAR SE UM CLIENTE EST� CADASTRADO");
                                System.out.print("Digite o cpf do cliente: ");
                                a = in.nextLine();
                                a = a.trim();
                                if (cf.existeCliente(a)) {
                                    System.out.println("O cliente est� cadastrado.");
                                } else {
                                    System.out.println("O cliente n�o est� cadastrado.");
                                }
                                System.out.print("Se deseja realizar outra operação, digite [s]: ");
                                resp1 = in.nextLine();
                                resp1 = resp1.trim();
                                if (resp1.equals("s")) {
                                    repetir = true;
                                } else {
                                    repetir = false;
                                }
                                break;*/
                        case 4:

                            System.out.println("Você escolheu PROCURAR UM CLIENTE");
                            System.out.print("Digite o cpf do cliente: ");
                            a = in.nextLine();
                            a = a.trim();
                            Cliente client = null;
                            try {
                                client = cf.procurarCliente(a);
                                exception = false;
                            } catch (CNCException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    exception = true;
                                    System.out.println(client.getNome());
                                    System.out.println("CPF: " + client.getCpf());
                                    System.out.println("CNH: " + client.getCnh());
                                    System.out.println("DATA: " + client.getData());
                                    System.out.println("TELEFONE: " + client.getTelefone());
                                    System.out.print("Se deseja realizar outra operação, digite [s]: ");
                                    resp1 = in.nextLine();
                                    resp1 = resp1.trim();
                                    if (resp1.equals("s")) {
                                        repetir = true;
                                    } else {
                                        repetir = false;
                                    }
                                }
                            }

                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                    break;

                case 4:
                    //Menu Aluguel

                    System.out.println("\nMenu Aluguel: \n");
                    System.out.println("1 - Cadastrar");
                    System.out.println("2 - Remover");
                    System.out.println("3 - Atualizar");
                    System.out.println("4 - procurar");
                    System.out.print("Digite sua opção: ");
                    menu = in.nextInt();
                    in.nextLine();
                    switch (menu) {
                        case 1:

                            System.out.println("Você escolheu CADASTRAR UM ALUGUEL");
                            System.out.print("Digite a MATRICULA do vendedor: ");
                            while (matinvalido) {
                                if (in.hasNextInt()) {
                                    g = in.nextInt();
                                    lr = in.nextLine();
                                    matinvalido = false;
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para a MATRICULA: ");
                                }
                            }
                            matinvalido = true;
                            Vendedor ven1;
                            ven1 = cf.procurarVendedor(g);
                            System.out.print("Digite o cpf do cliente: ");
                            a = in.nextLine();
                            a = a.trim();
                            Cliente client1 = cf.procurarCliente(a);
                            System.out.print("Digite a placa do carro que o cliente deseja alugar: ");
                            pa = in.nextLine();
                            pa = pa.trim();
                            Carros car1;
                            car1 = cf.procurarCarro(pa);
                            System.out.print("Digite a quantidade de dias que o cliente vai alugar o carro: ");
                            while (diasinvalidos) {
                                if (in.hasNextInt()) {
                                    dias = in.nextInt();
                                    lr = in.nextLine();
                                    diasinvalidos = false;
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para os dias: ");
                                }
                            }
                            diasinvalidos = true;
                            Aluguel aluguel = new Aluguel(ven1, client1, car1, dias);
                            try {
                                cf.cadastrarAluguel(aluguel);
                                exception = false;
                            } catch (CJAException erro) {
                                System.out.println(erro.getMessage());
                            } catch (CJACException erro) {
                                System.out.println(erro.getMessage());
                            } catch (PNEException erro) {
                                System.out.println(erro.getMessage());
                            } catch (CNCException erro) {
                                System.out.println(erro.getMessage());
                            } catch (VNCException erro) {
                                System.out.println(erro.getMessage());
                            } catch (DiaIException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    System.out.println("Cadastro realizado com sucesso!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: ");
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            if (resp1.equals("s")) {
                                repetir = true;
                            } else {
                                repetir = false;
                            }
                            break;

                        case 2:

                            System.out.println("Você escolheu REMOVER UM ALUGUEL");
                            System.out.print("Digite o CPF do cliente: ");
                            a = in.nextLine();
                            a = a.trim();
                            try {
                                cf.removerAluguel(a);
                                exception = false;
                            } catch (ANEException erro) {
                                System.out.println(erro.getMessage());
                            } catch (CNAException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    System.out.println("Remoção realizada com sucesso!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: ");
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            if (resp1.equals("s")) {
                                repetir = true;
                            } else {
                                repetir = false;
                            }
                            break;

                        case 3:

                            System.out.println("Você escolheu ATUALIZAR UM ALUGUEL");
                            System.out.print("Digite o CPF cadastrado anteriormente: ");
                            cpfantigo = in.nextLine();
                            cpfantigo = cpfantigo.trim();
                            System.out.println("Digite a placa do carro cadastrada anteriormente: ");
                            pa = in.nextLine();
                            pa = pa.trim();
                            System.out.println("Reinsira os novos dados: ");
                            System.out.print("Digite a MATRICULA do vendedor: ");
                            while (matinvalido) {
                                if (in.hasNextInt()) {
                                    g = in.nextInt();
                                    lr = in.nextLine();
                                    matinvalido = false;
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para a MATRICULA: ");
                                }
                            }
                            matinvalido = true;
                            Vendedor ven2 = null;
                            try {
                                ven2 = cf.procurarVendedor(g);
                                exception = false;
                            } catch (VNCException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                }
                            }
                            exception = true;
                            System.out.print("Digite o cpf do cliente: ");
                            a = in.nextLine();
                            a = a.trim();
                            Cliente client2 = null;
                            try {
                                client2 = cf.procurarCliente(a);
                                exception = false;
                            } catch (CNCException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                }
                            }
                            exception = true;
                            System.out.print("Digite a placa do carro que o cliente deseja alugar: ");
                            b = in.nextLine();
                            b = b.trim();
                            Carros car2 = null;
                            try {
                                car2 = cf.procurarCarro(b);
                                exception = false;
                            } catch (PNEException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                }
                            }
                            exception = true;
                            System.out.print("Digite a quantidade de dias que o cliente vai alugar o carro: ");
                            while (diasinvalidos) {
                                if (in.hasNextInt()) {
                                    dias = in.nextInt();
                                    lr = in.nextLine();
                                    diasinvalidos = false;
                                } else {
                                    lr = in.nextLine();
                                    System.out.print("Entrada inválida. Digite um valor inteiro para os dias: ");
                                }
                            }
                            diasinvalidos = true;
                            Aluguel aluguel1 = new Aluguel(ven2, client2, car2, dias);
                            try {
                                cf.atualizarAluguel(aluguel1, pa, cpfantigo);
                                exception = false;
                            } catch (PNEException erro) {
                                System.out.println(erro.getMessage());
                            } catch (CNCException erro) {
                                System.out.println(erro.getMessage());
                            } catch (CJAException erro) {
                                System.out.println(erro.getMessage());
                            } catch (CJACException erro) {
                                System.out.println(erro.getMessage());
                            } catch (VNCException erro) {
                                System.out.println(erro.getMessage());
                            } catch (ANEException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    System.out.println("Atualização realizada com sucesso!");
                                }
                            }
                            exception = true;
                            System.out.print("Se deseja realizar outra operação, digite [s]: ");
                            resp1 = in.nextLine();
                            resp1 = resp1.trim();
                            if (resp1.equals("s")) {
                                repetir = true;
                            } else {
                                repetir = false;
                            }
                            break;

                        case 4:

                            System.out.println("Você escolheu PROCURAR CADASTRO DE ALUGUEL A PARTIR DO CPF DO CLIENTE");
                            System.out.print("Digite o CPF do cliente: ");
                            a = in.nextLine();
                            a = a.trim();
                            Aluguel a1 = null;
                            try {
                                a1 = cf.procurarAluguelCliente(a);
                                exception = false;
                            } catch (CNCException erro) {
                                System.out.println(erro.getMessage());
                            } catch (ANEException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    exception = true;
                                    System.out.println("NOME DO CLIENTE: " + a1.getCliente().getNome());
                                    System.out.println("CPF: " + a1.getCliente().getCpf());
                                    System.out.println("MODELO DO CARRO: " + a1.getCarros().getModelo());
                                    System.out.println("PLACA: " + a1.getCarros().getPlaca());
                                    System.out.println(a1.getVendedor().getNome());
                                    System.out.println("MATRICULA: " + a1.getVendedor().getMatricula());
                                    System.out.println("VALOR TOTAL DO ALUGUEL: R$" + a1.getValorTotal());
                                    System.out.print("Se deseja realizar outra operação, digite [s]: ");
                                    resp1 = in.nextLine();
                                    resp1 = resp1.trim();
                                    if (resp1.equals("s")) {
                                        repetir = true;
                                    } else {
                                        repetir = false;
                                    }
                                }
                            }

                            break;
                        default:

                            System.out.println("Opção Inválida");

                            break;

                    }

                    break;

                case 5:

                    //Menu alugueis
                    System.out.println("\nMenu Checagem: \n");
                    System.out.println("1 - PROCURAR CADASTRO DE ALUGUEL A PARTIR DA PLACA DO CARRO");
                    System.out.println("2 - CHECAR SE UM CLIENTE EST� ALUGANDO UM CARRO");
                    System.out.println("3 - CHECAR SE UM CARRO EST� SENDO ALUGADO");
                    System.out.print("Digite sua opção: ");
                    menu = in.nextInt();
                    in.nextLine();

                    switch (menu) {

                        case 1:

                            System.out.println(" escolheu PROCURAR CADASTRO DE ALUGUEL A PARTIR DA PLACA DO CARRO");
                            System.out.print("Digite a placa do carro: ");
                            a = in.nextLine();
                            a = a.trim();
                            Aluguel a2 = null;
                            try {
                                a2 = cf.procurarAluguelCarro(a);
                                exception = false;
                            } catch (PNEException erro) {
                                System.out.println(erro.getMessage());
                            } catch (CNAException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    exception = true;
                                    System.out.println("NOME DO CLIENTE: " + a2.getCliente().getNome());
                                    System.out.println("CPF: " + a2.getCliente().getCpf());
                                    System.out.println("MODELO DO CARRO: " + a2.getCarros().getModelo());
                                    System.out.println("PLACA: " + a2.getCarros().getPlaca());
                                    System.out.println(a2.getVendedor().getNome());
                                    System.out.println("MATRICULA: " + a2.getVendedor().getMatricula());
                                    System.out.println("VALOR TOTAL DO ALUGUEL: R$" + a2.getValorTotal());
                                    System.out.print("Se deseja realizar outra operação, digite [s]: ");
                                    resp1 = in.nextLine();
                                    resp1 = resp1.trim();
                                    if (resp1.equals("s")) {
                                        repetir = true;
                                    } else {
                                        repetir = false;
                                    }
                                }
                            }

                            break;

                        case 2:

                            System.out.println("Você escolheu CHECAR SE UM CLIENTE EST� ALUGANDO UM CARRO");
                            System.out.print("Digite o cpf do cliente: ");
                            a = in.nextLine();
                            a = a.trim();
                            try {
                                if (cf.existeClienteAlugando(a)) {
                                    System.out.println("O cliente est� alugando um carro.");
                                } else {
                                    System.out.println("O cliente n�o est� alugando um carro.");
                                }
                                exception = false;
                            } catch (CNCException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    exception = true;
                                    System.out.print("Se deseja realizar outra operação, digite [s]: ");
                                    resp1 = in.nextLine();
                                    resp1 = resp1.trim();
                                    if (resp1.equals("s")) {
                                        repetir = true;
                                    } else {
                                        repetir = false;
                                    }
                                }
                            }

                            break;

                        case 3:

                            System.out.println("Você escolheu CHECAR SE UM CARRO EST� SENDO ALUGADO");
                            System.out.println("Digite a placa do carro: ");
                            a = in.nextLine();
                            a = a.trim();
                            try {
                                if (cf.existeCarroAlugado(a)) {
                                    System.out.println("O carro está sendo alugado no momento.");
                                } else {
                                    System.out.println("O carro não está sendo alugado no momento.");
                                }
                                exception = false;
                            } catch (PNEException erro) {
                                System.out.println(erro.getMessage());
                            } finally {
                                if (exception) {
                                    System.out.println("Tente novamente!");
                                } else {
                                    exception = true;
                                    System.out.print("Se deseja realizar outra operação, digite [s]: ");
                                    resp1 = in.nextLine();
                                    resp1 = resp1.trim();
                                    if (resp1.equals("s")) {
                                        repetir = true;
                                    } else {
                                        repetir = false;
                                    }
                                }
                            }

                            break;

                        case 0:

                            repetir = false;
                            break;
                    }
            }
            if (!repetir) {
                System.out.println("Você escolheu SAIR");
            }
        } while (repetir);

    }
}
