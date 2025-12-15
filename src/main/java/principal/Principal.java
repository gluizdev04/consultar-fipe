package principal;

import model.Dados;
import model.Modelos;
import model.Veiculo;
import service.ConsumoApi;
import service.ConversorDeDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private final String urlBase = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoApi consumoApi = new ConsumoApi();
    ConversorDeDados conversorDeDados = new ConversorDeDados();
    Scanner entrada = new Scanner(System.in);

    public void exibirMenu() {


        var menu = """
                ***OPÇÕES***
                Motos 
                Carros
                Caminhões
                
                Qual tipo de veículo deseja consultar?
                """;

        System.out.println(menu);
        var endereco = entrada.nextLine();

        if (endereco.contains("car")) {
            endereco = urlBase + "/carros/marcas";
        } else if (endereco.contains("mo")) {
            endereco = urlBase + "/motos/marcas";
        } else {
            endereco = urlBase + "caminhoes/marcas";
        }

        var json = consumoApi.obterDados(endereco);
        System.out.println(json);
        var marcas = conversorDeDados.obterList(json, Dados.class);
        marcas.stream()
                .forEach(System.out::println);

        System.out.print("Informe o código da marca para consulta: ");
        var codigoMarca = entrada.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";

        json = consumoApi.obterDados(endereco);
        var listaModelo = conversorDeDados.obterDados(json, Modelos.class);
        System.out.println("\nModelos dessa marca:");
        listaModelo.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);


        System.out.print("Digite o trecho do carro que deseja consultar: ");
        var trechoCarroDesejado = entrada.nextLine();

        List<Dados> modelosFiltrados = listaModelo.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(trechoCarroDesejado.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados");
        modelosFiltrados.forEach(System.out::println);

        System.out.print("Digite o código do modelo para buscar os valores de avaliação: ");
        var codigoModelo = entrada.nextLine();
        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumoApi.obterDados(endereco);
        List<Dados> anos = conversorDeDados.obterList(json, Dados.class);

        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAno = endereco + "/" + anos.get(i).codigo();
            json = consumoApi.obterDados(enderecoAno);
            Veiculo veiculoValor = conversorDeDados.obterDados(json, Veiculo.class);
            veiculos.add(veiculoValor);
        }
        veiculos.forEach(System.out::println);
    }
}
