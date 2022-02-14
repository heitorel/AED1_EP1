package ep_aed1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ep_aed1 {
	
	public static void main(String[] args){
		pilhaIngenua();
		listaSimples();
	}
	
	public static void pilhaIngenua() {
		HashMap<String,long[]> tempos = new HashMap<String, long[]>();
		PilhaIngenua pile;
		for(int i=1; i<100; i++) {
			System.out.println("Starting task"+i+" with Pilha Ingenua");
			long[] temposAux = new long[3];
			try {
				pile = new PilhaIngenua();
				ArrayList<String> processedTasks = new ArrayList<String>();
				String fileName = "tarefas"+i+"000.txt";
				File entrada = new File("src/ep_aed1/entradas/"+fileName);
				Scanner leitor = new Scanner(entrada);
				temposAux[0] = System.currentTimeMillis();
				while(leitor.hasNextLine()) {
					String line = leitor.nextLine();
					if(!line.isEmpty()) {
						pile.add(Integer.parseInt(line));
					}else {
						processedTasks.add(""+pile.remove());
					}
				}
				temposAux[1] = System.currentTimeMillis();
				temposAux[2] = temposAux[1]-temposAux[0];
				tempos.put(fileName, temposAux);
				FileWriter writer = new FileWriter("src/ep_aed1/saidas_pilhaIngenua/"+fileName);
				for(String task : processedTasks) {
					writer.write(task+"\n");
				}
				writer.close();
				leitor.close();
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			FileWriter writerTempo = new FileWriter("src/ep_aed1/tempo_saidas_pilhaIngenua/tempos.txt");
			writerTempo.write("Tarefa; duracao(ms)\n");
			for(String key : tempos.keySet()) {
				writerTempo.write(key+"; "+tempos.get(key)[2]+"\n");
			}
			writerTempo.write("Duracao Total(ms): "+(tempos.get("tarefas99000.txt")[1]-tempos.get("tarefas1000.txt")[0]));
			writerTempo.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void listaSimples() {
		HashMap<String,long[]> tempos = new HashMap<String, long[]>();
		Pile pilha = new Pile();
		for(int i=1; i<100; i++) {
			System.out.println("Starting task"+i+" with Lista Simples");
			long[] temposAux = new long[3];
			try {
				ArrayList<String> processedTasks = new ArrayList<String>();
				String fileName = "tarefas"+i+"000.txt";
				File entrada = new File("src/ep_aed1/entradas/"+fileName);
				Scanner leitor = new Scanner(entrada);
				//System.out.println(fileName+" exists: "+leitor.hasNextLine());
				temposAux[0] = System.currentTimeMillis();
				while(leitor.hasNextLine()) {
					String line = leitor.nextLine();
					if(!line.isEmpty()) {
						Task task1 = new Task(line);
						if(pilha.isEmpty()) {
							pilha.setHead(task1);
						}else {
							task1.setNextTask(pilha.getHead());
							pilha.setHead(task1);
						}
					}else {
						Task taskAux = pilha.getHead();
						processedTasks.add(taskAux.getCode());
						Task nextHead = taskAux.getNextTask();
						pilha.setHead(nextHead);
					}
				}
				temposAux[1] = System.currentTimeMillis();
				temposAux[2] = temposAux[1]-temposAux[0];
				tempos.put(fileName, temposAux);
				FileWriter writer = new FileWriter("src/ep_aed1/saidas_listaSimples/"+fileName+".txt");
				for(String task : processedTasks) {
					writer.write(task+"\n");
				}
				writer.close();
				leitor.close();
				
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			FileWriter writerTempo = new FileWriter("src/ep_aed1/tempo_saidas_ListaSimples/tempos.txt");
			writerTempo.write("Tarefa; duracao(ms)\n");
			for(String key : tempos.keySet()) {
				writerTempo.write(key+"; "+tempos.get(key)[2]+"\n");
			}
			writerTempo.write("Duracao Total(ms): "+(tempos.get("tarefas99000.txt")[1]-tempos.get("tarefas1000.txt")[0]));
			writerTempo.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
