package Determinanten;


public class det {
    public static int nrOfMult = 0;
    private static int rang = 0;
    //Berechnung mit 1. Normalform
    public static double calcDet(double[][] A){
    	
    	A = ersteNormalform(A);
    	double det = A[0][0];
    	for(int i = 1; i<A.length;i++) {
    		det *= A[i][i];
    		nrOfMult++;
    	}
    	
        return det; // Durch Ihren Code ersetzen!
    }
    //Rekursive Berechnung mit Def. L.4.1.1 Skript
    public static double calcDetRec(double[][] A){
    	
    	double detA = 0;
    	int n = A.length;
    	
    	if(n>rang)
    		rang = n;
    	//Wenn ursprungsmatrix grade ist
    	if(n == 2 && rang%2 == 0) {
    		rang = 2;
    		return (A[0][0] * A[1][1]) - (A[0][1] * A[1][0]);
    	}
    		
    	//Wenn ursprungsmatrix ungrade ist
    	if(n==1 && rang%2 != 0) {
    		rang = 1;
    		return A[0][0];
    	}
    		
    	for(int i = 0; i < n ; i++) {
    		//showMatrix(A, 1);
    		detA += Math.pow(-1, i+1)*A[i][0]*calcDetRec(remove(i, A));
    	}
        return detA; // Durch Ihren Code ersetzen!
    }
    private static double[][] remove(int line, double[][] A){
    	int newN = A.length-1;
    	
    	double[][] Ai1 = new double[newN][newN];

    	
    	for(int i = 0, newi = 0; i<A.length;i++) {
    		if(i == line)
    			continue;
    		//j = 1 weil j = 0 die 1. Spalte ist und weg gelassen wird
        	for(int j = 1; j<A.length;j++) {
        		Ai1[newi][j-1] = A[i][j];
        	}
        	newi++;
    	}
		return Ai1;
    }
    public static void showMatrix(double[][] M, int nrOfDigits){
        int m = M.length;
        int n = M[0].length;
        //boolean hasNoNegativeEntry = true;
        double max = 0.0;
        for (int j=0; j<n; j++){
            for (int i=0; i<m; i++){
                if (M[i][j]>max) max = M[i][j];
                //if (M[i][j]<0.0) hasNoNegativeEntry = false; 
            }
        }
        int l;
        if (max==0) l = 5;
        else l = (int) Math.log10(Math.abs(max))+nrOfDigits+5;//+1: log, +1: sign, +1: point, +1
        if (nrOfDigits==0) l--;
        //if (hasNoNegativeEntry) l--;

        String f, s;
        f = "%"+l+"."+nrOfDigits+"f";
        for (int i=0; i<m; i++){
            s = "";
            for (int j=0; j<n; j++){
                s = s+String.format(f, M[i][j]);    
            }
            System.out.println(s);
        }
    }
    public static double[][] ersteNormalform(double[][]A){
    	
    	double factor;
    	
    	int rows = A.length-1;
    	int columns = A[0].length-1;
    	
    	//Geht durch jede Spalte
    	for(int j = 0;j<rows;j++) {
    		//Geht durch jede Zeile, fängt mit der 2. an
    		for(int i = j+1; i<=rows;i++ ) {
    			factor = -A[i][j]/A[j][j];
    			//Geht die Zeile durch mit dem Faktor durch.
    			for(int x = j; x<=columns;x++) {
    				A[i][x] = A[i][x]+(factor*A[j][x]);
    			}
    			nrOfMult++;
    		}
    	}
    	System.out.println("Erste Normalform(A):");
    	showMatrix(A, 1);
    	return A;
    }
}