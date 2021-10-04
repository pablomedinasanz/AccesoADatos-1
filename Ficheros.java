package practicasFicheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ficheros {

	private static final char A_MAYUSCULAS = 32;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("fichero.txt");
		if (file.exists()) {
			System.out.println("Existe");
			System.out.println("La ruta es: " + file.getAbsolutePath());
			
		} else {
			try {
				file.createNewFile();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		metodoFileWriterCaracteres(file);
//		metodoFileWriter(file);
//		metodoFileReader(file);
//		metodoFileOutputStream(file);
//		metodoFileInputStream(file);
		metodoRandomAccessFile();
	}
	
	private static void metodoFileWriterCaracteres(File file) {
		
		String cad = "buenos días";
		char[] arrayChar = cad.toCharArray();
		
		
		try {
			
			FileWriter fw = new FileWriter(file);
			
			for (int i = 0; i < arrayChar.length; i++) {
				
				System.out.println((char)(arrayChar[i]-A_MAYUSCULAS));
				fw.write(arrayChar[i]-A_MAYUSCULAS);
						
			}
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void metodoFileWriter(File file) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriba un texto para el fichero:");
		String texto = sc.nextLine();
		
		
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write(texto);
			
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void metodoFileReader(File file) {
		
		try {
			
			FileReader fr = new FileReader(file);
			
			int valor = fr.read();
			while (valor != -1) {
				System.out.println((char) valor);
				valor = fr.read();
				
			}
			fr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static void metodoFileOutputStream(File file) { // escribir bytes de manera secuencial
		
		try {
			
			FileOutputStream fos = new FileOutputStream(file);
			String texto = " doijofsijdfsojfsojfiosfosdoosdo ";
			
			byte codigos[] = texto.getBytes();
			fos.write(codigos);
			
			fos.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void metodoFileInputStream(File file) {
		
		try {
			
			FileInputStream fis = new FileInputStream(file);
			
			int valor = fis.read();
			System.out.println("LECTURA DEL BINARIA DEL FICHERO");
			while(valor != -1) {
				System.out.println((char)valor);
				valor = fis.read();
			}
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void metodoRandomAccessFile() {
//		CONSTRUCTORES POSIBLES:
//		RandomAccessFile(String ruta, String modo)
//		RandomAccessFile(String fichero, String modo)
//		MODOS: r / rw
		
		File ficheroRandom = new File("ficheroRandom.dat");
		
		
		try {
			ficheroRandom.createNewFile();
			
			RandomAccessFile raf = new RandomAccessFile(ficheroRandom, "rw");
			String texto = raf.readLine();
			System.out.println(texto);
			
			String writeText = "  klk chelton  ";
			
			raf.writeBytes(writeText);
			
			String texto2 = raf.readLine();
			System.out.println(texto2);
	
			raf.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
