package Carros;

import java.io.*;
import java.util.ArrayList;

public class Lista implements Arquivo{
    private Carro carro;
    private double valor;
    private String categoria;
    public ArrayList<Lista> lista=null;
    public ArrayList<String> keyword;
    String nome;

    public Lista() {
        lista = new ArrayList<Lista>();
    }
    Lista(Carro carro, double valor, String categoria, String nome, ArrayList<String> keyword) {
        this.nome = nome;
        this.carro = carro;
        this.valor = valor;
        this.categoria = categoria;
        lista=new ArrayList<Lista>();
        this.keyword = keyword;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(ArrayList<String> keyword) {
        this.keyword = keyword;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int readFile() throws IOException {
        InputStream is= new FileInputStream("carros.txt");
        InputStreamReader ls= new InputStreamReader(is);
        BufferedReader br= new BufferedReader(ls);

        String s = br.readLine();
        int qtd_carros=0;
        int c=1;
        for(int i=(s.length()-1);i>=0;i--) {
            qtd_carros=((s.charAt(i)-'0')*c);
            c*=10;
        }


        for(int i=0;i<qtd_carros;i++) {
            keyword = new ArrayList<String>();
            s=br.readLine();
            String nome=s; //read name
            s=br.readLine();
            String categoria = s;
            s=br.readLine();
            double valor =0;
            int j=1;
            for(int i2=s.length()-1;i2>=0;i2--) {
                valor+=((s.charAt(i2)-'0')*j);
                j*=10;
            }
            s=br.readLine();
            String modelo = s;
            s=br.readLine();
            String acessorios = s;
            s=br.readLine();
            int ano=0;
            c=1;
            for(int i1=s.length()-1;i1>=0;i1--) {
                ano+=((s.charAt(i1)-'0')*c);
                c*=10;
            }
            s=br.readLine();
            String codigo = s;
            s=br.readLine();
            String marca = s;
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
            s=br.readLine();
            keyword.add(s);
            Carro car = new Carro(codigo, marca, modelo, ano, acessorios);
            Lista lis = new Lista (car, valor, categoria, nome, keyword);
            lista.add(lis);
        }
        br.close();
        return 0;
    }

    @Override
    public int writeFile() throws IOException {
        OutputStream os= new FileOutputStream("carros.txt");
        OutputStreamWriter osw= new OutputStreamWriter(os);
        BufferedWriter bw= new BufferedWriter(osw);

        int tam=lista.size();
        bw.write(tam + "\n");
        for(int i=0;i<tam;i++) {
            Lista aux = lista.get(i);
            bw.write(aux.getNome()+ "\n"); //.
            bw.write(aux.getCategoria()+ "\n"); //.
            bw.write(aux.getValor()+ "\n");
            bw.write(aux.getCarro().getModelo()+ "\n"); //.
            bw.write(aux.getCarro().getAcessorios()+ "\n");
            bw.write(aux.getCarro().getAno()+ "\n");
            bw.write(aux.getCarro().getCodigo()+ "\n"); //.;
            bw.write(aux.getCarro().getMarca()+ "\n"); //.
            bw.write(aux.getKeyword().get(0) + "\n");
            bw.write(aux.getKeyword().get(1) + "\n");
            bw.write(aux.getKeyword().get(2) + "\n");
            bw.write(aux.getKeyword().get(3) + "\n");
            bw.write(aux.getKeyword().get(4) + "\n");
            bw.write(aux.getKeyword().get(5) + "\n");
            bw.write(aux.getKeyword().get(6) + "\n");
        }
        bw.close();
        return 0;
    }
}
