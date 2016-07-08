package conjuntos;

public class Conjunto {
	private String[] conjuntoA, conjuntoB, conjuntoAB;
	
	public Conjunto(){
		conjuntoA = new String[5];
		conjuntoB = new String[5];
		conjuntoAB = new String[conjuntoA.length + conjuntoB.length];
	}
	
	public void llenarA(String elementos){
		String temp;
		String tempA = "";
		int tam = 0;
		
		for(int i = 0; i < elementos.length(); i++){
			temp = elementos.charAt(i) + "";
			
			if(!temp.equals(",") && (!temp.equals(" "))){
				tempA += temp;
				tam++;
			}
		}
		
		conjuntoA = new String[tam];
		
		for(int i = 0; i < tam; i++){
			conjuntoA[i] = tempA.charAt(i) + ""; 
		}
		
		conjuntoAB = new String[conjuntoA.length + conjuntoB.length];
	}
	
	public void llenarB(String elementos){
		String temp;
		String tempB = "";
		int tam = 0;
		
		for(int i = 0; i < elementos.length(); i++){
			temp = elementos.charAt(i) + "";
			
			if(!temp.equals(",") && (!temp.equals(" "))){
				tempB += temp;
				tam++;
			}
		}
		
		conjuntoB = new String[tam];
		
		for(int i = 0; i < tam; i++){
			conjuntoB[i] = tempB.charAt(i) + ""; 
		}
		
		conjuntoAB = new String[conjuntoA.length + conjuntoB.length];
	}
	
	public int getTamA(){
		return conjuntoA.length;
	}
	
	public int getTamB(){
		return conjuntoB.length;
	}
	
	public int getTamAB(){
		return conjuntoAB.length;
	}
	
	public String getElementoA(int posicion){
		return conjuntoA[posicion];
	}
	
	public String getElementoB(int posicion){
		return conjuntoB[posicion];
	}
	
	public String getElementoAB(int posicion){
		return conjuntoAB[posicion];
	}
	
	public void union(){
		vaciarConjuntoAB();
		
		int posicionAB = 0;
		boolean existe;
		
		for(int i = 0; i < conjuntoA.length; i++){
			conjuntoAB[posicionAB] = conjuntoA[i];
			
			posicionAB++;
		}
		
		for(int i = 0; i < conjuntoB.length; i++){
			existe = false;
			
			for(int j = 0; j < conjuntoAB.length; j++){
				if(conjuntoB[i].equals(conjuntoAB[j])){
					existe = true;
					
					break;
				}
			}
			
			if(!existe){
				conjuntoAB[posicionAB] = conjuntoB[i];
				
				posicionAB++;
			}
		}
	}
	
	public void interseccion(){
		vaciarConjuntoAB();
		
		int posicionAB = 0;
		
		for(int i = 0; i < conjuntoA.length; i++){
			for(int j = 0; j < conjuntoB.length; j++){
				if(conjuntoA[i].equals(conjuntoB[j])){
					conjuntoAB[posicionAB] = conjuntoA[i];
					
					posicionAB++;
				}
			}
		}
	}
	
	public void diferencia(){
		vaciarConjuntoAB();
		
		int posicionAB = 0;
		boolean existe;
		
		for(int i = 0; i < conjuntoA.length; i++){
			existe = false;
			
			for(int j = 0; j < conjuntoB.length; j++){
				if(conjuntoA[i].equals(conjuntoB[j])){
					existe = true;
					
					break;
				}
			}
			
			if(!existe){
				conjuntoAB[posicionAB] = conjuntoA[i];
				
				posicionAB++;
			}
		}		
	}
	
	public void limpiarConjuntos(){
		for(int i = 0; i < conjuntoA.length; i++){
			conjuntoA[i] = "null";
		}
		
		for(int i = 0; i < conjuntoB.length; i++){
			conjuntoB[i] = "null";
		}
		
		for(int i = 0; i < conjuntoAB.length; i++){
			conjuntoAB[i] = "null";
		}
	}
	
	private void vaciarConjuntoAB(){
		for(int i = 0; i < conjuntoAB.length; i++){
			conjuntoAB[i] = "null";
		}
	}
}