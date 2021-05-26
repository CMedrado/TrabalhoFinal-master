package Carros;

import java.io.*;
import java.util.ArrayList;

public class LocadoraFisica implements Arquivo {
    private String nome;
    private String cnpj;
    private String telefone;
    protected Localizacao localizacao;
    public ArrayList<LocadoraFisica> locadora;
    public ArrayList<String> keyword;

    public LocadoraFisica(){
        locadora = new ArrayList<LocadoraFisica>();
    }

    public LocadoraFisica(String nome, String cnpj, String telefone, Localizacao localizacao, ArrayList<String> keyword) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.localizacao = localizacao;
        this.keyword = keyword;

    }

    public String toString() {
        return "Locadora - CNPJ: " + getCnpj() + ", Nome: " + getNome() + ", Telefone: " + getTelefone() + ", Endereco: " + localizacao.getEndereco() + ", Bairro: " + localizacao.getBairro() + ", Cidade: " + localizacao.getCidade() + ", Estado: " + localizacao.getEstado();
    }
    @Override
    public int readFile() throws IOException {
        InputStream is= new FileInputStream("locadora.txt");
        InputStreamReader isr= new InputStreamReader(is);
        BufferedReader br= new BufferedReader(isr);

        String s = br.readLine();
        int qtd_locadoras=0;
        int c=1;
        for(int i=(s.length()-1);i>=0;i--) {
            qtd_locadoras=((s.charAt(i)-'0')*c);
            c*=10;
        }


        for(int i=0;i<qtd_locadoras;i++) {
            s=br.readLine();
            String nome=s; //read name
            s=br.readLine();
            String cnpj = s;
            s=br.readLine();
            String telefone = s;
            s=br.readLine();
            String endereco = s;
            s=br.readLine();
            String bairro = s;
            s=br.readLine();
            String cidade = s;
            s=br.readLine();
            String estado = s;
            keyword = new ArrayList<String>();
            s=br.readLine();
            keyword.add(s);
            s=br.readLine();
            keyword.add(s);
            s=br.readLine();
            keyword.add(s);
            s=br.readLine();
            keyword.add(s);
            s=br.readLine();
            keyword.add(s);
            Localizacao loca = new Localizacao(endereco,bairro,cidade,estado);
            LocadoraFisica loc = new LocadoraFisica (nome,cnpj,telefone, loca, keyword);
            locadora.add(loc);
        }
        br.close();
        return 0;
    }

    public int writeFile() throws IOException {

        OutputStream os = new FileOutputStream("locadora.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw= new BufferedWriter(osw);

        int tam = locadora.size();
        bw.write(tam + "\n");
        for (int i = 0; i < tam; i++) {
            LocadoraFisica aux = locadora.get(i);
            bw.write(aux.getNome() + "\n"); //.
            bw.write(aux.getCnpj() + "\n");
            bw.write(aux.getTelefone() + "\n");
            bw.write(aux.localizacao.getEndereco() + "\n"); //.
            bw.write(aux.localizacao.getBairro() + "\n"); //.
            bw.write(aux.localizacao.getCidade() + "\n"); //.
            bw.write(aux.localizacao.getEstado() + "\n"); //.
            bw.write(aux.getKeyword().get(0) + "\n");
            bw.write(aux.getKeyword().get(1) + "\n");
            bw.write(aux.getKeyword().get(2) + "\n");
            bw.write(aux.getKeyword().get(3) + "\n");
            bw.write(aux.getKeyword().get(4) + "\n");
        }
        bw.close();
        return 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(ArrayList<String> keyword) {
        this.keyword = keyword;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
}
