package org.altairretro.practice;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		String[][] brr= new String[3][3];
		brr[0][0]="p";
		brr[0][1]="r";
		brr[1][0]="e";
		brr[1][1]="m";
		brr[2][0]="k";
		brr[2][1]="u";
		brr[2][2]="m";
		 for(int i=0;i<brr.length;i++) {
			 System.out.println(brr[i][i]);
		 }

	}

}
