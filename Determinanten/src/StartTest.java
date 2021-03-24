package Determinanten;

public class StartTest {

	public static void main(String[] args) {
		
		String filePath0 = "f:/Alles Mögliche/Uni/Mathe/src/Determinanten/Test.txt";
		testDet test0 = new testDet(filePath0);
		
		String filePath1 = "f:/Alles Mögliche/Uni/Mathe/src/Determinanten/Test1.txt";
		testDet test1 = new testDet(filePath1);
		
		String filePath2 = "f:/Alles Mögliche/Uni/Mathe/src/Determinanten/Test2.txt";
		testDet test4x4 = new testDet(filePath2);
		/*
		String filePath3 = "f:/Alles Mögliche/Uni/Mathe/src/Determinanten/Test3.txt";
		testDet testRoundErrors1= new testDet(filePath3);
		*/
		String filePath4 = "f:/Alles Mögliche/Uni/Mathe/src/Determinanten/Test4.txt";
		testDet test3x3= new testDet(filePath4);
		
	}
}
