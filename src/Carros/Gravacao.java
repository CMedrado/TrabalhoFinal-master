package Carros;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Gravacao {

    public static void main(String[] args) throws IOException {

        LocadoraFisica loc = new LocadoraFisica();
        loc.readFile();

        Lista lis = new Lista();
        lis.readFile();

        Carro carro;

        Localizacao localizacao;

        String login_type = JOptionPane.showInputDialog("User or Admin ?");
        if (login_type.equals("Admin")) {
            String operation = "";
            while (!(operation.equals("S") || operation.equals("s"))) {
                operation = operation = JOptionPane.showInputDialog("Escolha a operação\n I -Inclusão\n E - Exclusão\n A-Alteração\n C-Consulta \n S-Sair");
                if (operation.equals("I")) {
                    String str = "";
                    String op = JOptionPane.showInputDialog("Oque incluir? \n C - Carro ou  L - Locadora de Carros");
                    if (op.equals("C")) {
                        ArrayList<String> keyword = new ArrayList<String>();
                        String nome = JOptionPane.showInputDialog("Qual o nome da locadora?");
                        keyword.add(nome);
                        String categoria = JOptionPane.showInputDialog("Qual o categoria do categoria?\n Luxo\n Esportivo \n Van\n Standard");
                        keyword.add(categoria);
                        String valor = JOptionPane.showInputDialog("Qual o valor do carro?");
                        double valor2 = 0;
                        int j = 1;
                        for (int i2 = valor.length() - 1; i2 >= 0; i2--) {
                            valor += ((valor.charAt(i2) - '0') * j);
                            j *= 10;
                        }
                        String modelo = JOptionPane.showInputDialog("Qual o modelo do carro?");
                        keyword.add(modelo);
                        String acessorios = JOptionPane.showInputDialog("Qual os acessorios do carro?");
                        String aux = JOptionPane.showInputDialog("Qual o ano do carro?");
                        int ano = 0;
                        int c = 1;
                        for (int i1 = aux.length() - 1; i1 >= 0; i1--) {
                            ano += ((aux.charAt(i1) - '0') * c);
                            c *= 10;
                        }
                        keyword.add(aux);
                        String codigo = JOptionPane.showInputDialog("Qual o codgio do carro?");
                        keyword.add(codigo);
                        String marca = JOptionPane.showInputDialog("Qual a marca do carro?");
                        keyword.add(marca);
                        carro = new Carro(codigo, marca, modelo, ano, acessorios);
                        Lista lista = new Lista(carro, valor2, categoria, nome, keyword);
                        lis.lista.add(lista);
                    }
                    if (op.equals("L")) {
                        ArrayList<String> keyword = new ArrayList<String>();
                        String nome = JOptionPane.showInputDialog("Coloque o nome");
                        keyword.add(nome);
                        String cnpj = JOptionPane.showInputDialog("Coloque o cnpj");
                        String telefone = JOptionPane.showInputDialog("Coloque o telefone");
                        String endereco = JOptionPane.showInputDialog("Coloque o endereco");
                        keyword.add(endereco);
                        String bairro = JOptionPane.showInputDialog("Coloque o bairro");
                        keyword.add(bairro);
                        String cidade = JOptionPane.showInputDialog("Coloque a cidade");
                        keyword.add(cidade);
                        String estado = JOptionPane.showInputDialog("Coloque o estado");
                        keyword.add(estado);
                        localizacao = new Localizacao(endereco, bairro, cidade, estado);
                        LocadoraFisica al = new LocadoraFisica(nome, cnpj, telefone, localizacao, keyword);
                        loc.locadora.add(al);
                    }
                }
                if (operation.equals("E")) {
                    String str = "";
                    String op = JOptionPane.showInputDialog("Oque excluir? \n C - Carro ou  L - Locadora de Carros");
                    if (op.equals("C")) {
                        String codigo = JOptionPane.showInputDialog("Qual o codigo do carro que sera excluido?");
                        for (int i = 0; i < lis.lista.size(); i++) {
                            if (codigo.equals(lis.lista.get(i).getCarro().getCodigo())) {
                                lis.lista.remove(i);
                            }
                        }
                    }
                    if (op.equals("L")) {
                        String nome = JOptionPane.showInputDialog("Qual o nome da Locadora que sera excluido?");
                        for (int i = 0; i < lis.lista.size(); i++) {
                            if (nome.equals(lis.lista.get(i).getNome())) {
                                loc.locadora.remove(i);
                                for (int i3 = 0; i3 < loc.locadora.size(); i3++) {
                                    for (int i2 = 0; i2 < loc.locadora.get(i3).keyword.size(); i2++) {
                                        if (nome.equals(lis.lista.get(i3).keyword.get(i2))) {
                                            lis.lista.remove(i3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (operation.equals("A")) {
                    String op = JOptionPane.showInputDialog("Oque alterar?\n C - Carro\n L - Locadora de Carros");
                    if (op.equals("C")) {
                        String name = JOptionPane.showInputDialog("Insira o codigo do carro");
                        for (int i = 0; i < lis.lista.size(); i++) {
                            if (name.equals(lis.lista.get(i).getCarro().getCodigo())) {
                                String aux = JOptionPane.showInputDialog("Locadora: " + lis.lista.get(i).getNome() + "\nCategoria: " + lis.lista.get(i).getCategoria() + "\nValor: " + lis.lista.get(i).getValor() + "\nModelo: " + lis.lista.get(i).getCarro().getModelo() + "\nAcessorios: " + lis.lista.get(i).getCarro().getAcessorios() + "\n Anos: " + lis.lista.get(i).getCarro().getAno() + "\nCodigo: " + lis.lista.get(i).getCarro().getCodigo() + "\nMarca: " + lis.lista.get(i).getCarro().getMarca() + "\n Deseja Alterar? (S/N)");
                                if (aux.equals("S")) {
                                    ArrayList<String> keyword = new ArrayList<String>();
                                    String nome = JOptionPane.showInputDialog("Qual o nome da locadora?");
                                    lis.lista.get(i).setNome(nome);
                                    keyword.add(nome);
                                    String categoria = JOptionPane.showInputDialog("Qual o categoria do categoria?\n Luxo\n Esportivo \n Van\n Standard");
                                    lis.lista.get(i).setCategoria(categoria);
                                    keyword.add(categoria);
                                    String valor = JOptionPane.showInputDialog("Qual o valor do carro?");
                                    double valor2 = 0;
                                    int j = 1;
                                    for (int i2 = valor.length() - 1; i2 >= 0; i2--) {
                                        valor += ((valor.charAt(i2) - '0') * j);
                                        j *= 10;
                                    }
                                    lis.lista.get(i).setValor(valor2);
                                    String modelo = JOptionPane.showInputDialog("Qual o modelo do carro?");
                                    keyword.add(modelo);
                                    String acessorios = JOptionPane.showInputDialog("Qual os acessorios do carro?");
                                    String ano2 = JOptionPane.showInputDialog("Qual o ano do carro?");
                                    int ano = 0;
                                    int c = 1;
                                    for (int i1 = aux.length() - 1; i1 >= 0; i1--) {
                                        ano += ((aux.charAt(i1) - '0') * c);
                                        c *= 10;
                                    }
                                    String codigo = JOptionPane.showInputDialog("Qual o codgio do carro?");
                                    keyword.add(codigo);
                                    String marca = JOptionPane.showInputDialog("Qual a marca do carro?");
                                    keyword.add(marca);
                                    carro = new Carro(codigo, marca, modelo, ano, acessorios);
                                    lis.lista.get(i).setCarro(carro);
                                    lis.lista.get(i).setKeyword(keyword);
                                }
                            }
                        }
                    }
                    if (op.equals("L")) {
                        String name = JOptionPane.showInputDialog("Insira o codigo do carro");
                        for (int i = 0; i < lis.lista.size(); i++) {
                            if (name.equals(lis.lista.get(i).getCarro().getCodigo())) {
                                String aux = JOptionPane.showInputDialog("Locadora: " + loc.locadora.get(i).getNome() + "\nCNPJ: " + loc.locadora.get(i).getCnpj() + "\nTelefone: " + loc.locadora.get(i).getTelefone() + "\nEndereco: " + loc.locadora.get(i).getLocalizacao().getEndereco() + "\nBairro: " + loc.locadora.get(i).getLocalizacao().getBairro() + "\n Cidade: " + loc.locadora.get(i).getLocalizacao().getCidade() + "\nEstado: " + loc.locadora.get(i).getLocalizacao().getEstado() + "\n Deseja Alterar? (S/N)");
                                if (aux.equals("S")) {
                                    ArrayList<String> keyword = new ArrayList<String>();
                                    String nome = JOptionPane.showInputDialog("Coloque o nome");
                                    loc.locadora.get(i).setNome(nome);
                                    keyword.add(nome);
                                    String cnpj = JOptionPane.showInputDialog("Coloque o cnpj");
                                    loc.locadora.get(i).setCnpj(cnpj);
                                    String telefone = JOptionPane.showInputDialog("Coloque o telefone");
                                    loc.locadora.get(i).setTelefone(telefone);
                                    String endereco = JOptionPane.showInputDialog("Coloque o endereco");
                                    keyword.add(endereco);
                                    String bairro = JOptionPane.showInputDialog("Coloque o bairro");
                                    keyword.add(bairro);
                                    String cidade = JOptionPane.showInputDialog("Coloque a cidade");
                                    keyword.add(cidade);
                                    String estado = JOptionPane.showInputDialog("Coloque o estado");
                                    keyword.add(estado);
                                    localizacao = new Localizacao(endereco, bairro, cidade, estado);
                                    loc.locadora.get(i).setLocalizacao(localizacao);
                                    loc.locadora.get(i).setKeyword(keyword);
                                    String str = "";
                                    for (int i2 = 0; i2 < lis.lista.size(); i2++) {
                                        for (int i3 = 0; i3 < lis.lista.get(i2).keyword.size(); i3++) {
                                            if (nome.equals(lis.lista.get(i2).keyword.get(i3))) {
                                                lis.lista.get(i2).setNome(nome);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (operation.equals("C")) {
                    String op = JOptionPane.showInputDialog("Oque consultar? \n C - Carro ou  L - Locadora de Carros");
                    if (op.equals("C")) {
                        String ls = "";
                        String kw = JOptionPane.showInputDialog("Informe um desses \n Nome da Locadora\n Categoria do Carro\n Modelo do Carro\n Codigo do Carro\n Marca do Carro");
                        for (int i = 0; i < lis.lista.size(); i++) {
                            for (int i2 = 0; i2 < lis.lista.get(i).keyword.size(); i2++) {
                                if (kw.equals(lis.lista.get(i).keyword.get(i2))) {
                                    ls += (lis.lista.get(i)) + "\n";
                                    for (int i3 = 0; i3 < loc.locadora.size(); i3++) {
                                        for (int i4 = 0; i4 < loc.locadora.get(i3).keyword.size(); i4++) {
                                            if (lis.lista.get(i).getNome().equals(loc.locadora.get(i3).keyword.get(i4))) {
                                                ls += (loc.locadora.get(i3)) + "\n";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, ls);
                    }
                    if (op.equals("L")) {
                        String ls = "";
                        String kw = JOptionPane.showInputDialog("Informe um desses \n Nome da Locadora\n Endereco\n Bairro\n Cidade\n Estado");
                        for (int i = 0; i < loc.locadora.size(); i++) {
                            for (int i2 = 0; i2 < loc.locadora.get(i).keyword.size(); i2++) {
                                if (kw.equals(loc.locadora.get(i).keyword.get(i2))) {
                                    ls += (loc.locadora.get(i)) + "\n";
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, ls);
                    }
                }
            }
            if (login_type.equals("User")) {
                String op = JOptionPane.showInputDialog("Oque consultar? \n C - Carro ou  L - Locadora de Carros");
                if (op.equals("C")) {
                    String dr = "";
                    String ls = "";
                    String kw = JOptionPane.showInputDialog("Informe um desses \n Nome da Locadora\n Categoria do Carro\n Modelo do Carro\n Codigo do Carro\n Marca do Carro");
                    for (int i = 0; i < lis.lista.size(); i++) {
                        for (int i2 = 0; i2 < lis.lista.get(i).keyword.size(); i2++) {
                            if (kw.equals(lis.lista.get(i).keyword.get(i2))) {
                                ls += (lis.lista.get(i)) + "\n";
                                for (int i3 = 0; i3 < loc.locadora.size(); i3++) {
                                    for (int i4 = 0; i4 < loc.locadora.get(i3).keyword.size(); i4++) {
                                        if (lis.lista.get(i).getNome().equals(loc.locadora.get(i3).keyword.get(i4))) {
                                            ls += (loc.locadora.get(i3)) + "\n";
                                        }
                                    }
                                }
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, ls);
                }
                if (op.equals("L")) {
                    String ls = "";
                    String kw = JOptionPane.showInputDialog("Informe um desses \n Nome da Locadora\n Endereco\n Bairro\n Cidade\n Estado");
                    for (int i = 0; i < loc.locadora.size(); i++) {
                        for (int i2 = 0; i2 < loc.locadora.get(i).keyword.size(); i2++) {
                            if (kw.equals(loc.locadora.get(i).keyword.get(i2))) {
                                ls += (loc.locadora.get(i)) + "\n";
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, ls);
                }
            }
        }
        lis.writeFile();
        loc.writeFile();
    }
}