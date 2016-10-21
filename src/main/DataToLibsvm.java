package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

import data.DataPrinter;
import data.Domain;

public class DataToLibsvm {
	public static void main(String[] args) throws Exception {
		
		if(args.length<3){
			System.err.println("Three Parameters Needed: domain data config!");
			System.exit(1);			
		}
		
		String domain_file_name = args[0]; 
		
		String data_file_name = args[1];
		
		String config_file_name = args[2];
		
		Domain domain = new Domain(domain_file_name);
		
		int label_index = 0;
		HashSet<Integer> label_positive_values = new HashSet<Integer>();
		
		BufferedReader confFile = new BufferedReader(new FileReader(config_file_name));
		
		label_index = Integer.parseInt(confFile.readLine());
		
		String[] strPositiveValues = confFile.readLine().split("\\s+");
		
		for(int i=0;i<strPositiveValues.length;i++){
			int value_int = domain.str2int(strPositiveValues[i], label_index);
			label_positive_values.add(value_int);
		}
		
		new DataPrinter(data_file_name, domain).printo_libsvm(data_file_name+"."+label_index+".libsvm."+"txt", label_index, label_positive_values);	
	}

}
