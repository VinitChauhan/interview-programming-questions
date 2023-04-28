package org.example.dataStructure;

public class CubicSearch {
    // find possible value of x, y and z in 5x+4y+2z=108

    public static void main(String[] args) {
        int n = 12;
        for ( int i = 0 ; i < n ; i++ ) {
            for ( int j = 0 ; j < n ; j++ ) {
                for ( int k = 0 ; k < n ; k++ ) {
                    if (i * 5 + j * 4 + k * 2 == 108) {
                        System.out.println(i + "," + j + "," + k);
                    }
                }
            }
        }
    }
}
//50+36+22=108
//Time Complexity --> (1+n+n)(1+n+n)(1+n+n+n)
//(1+2n)(1+2n)(1+3n)-->(1+4n+4n^2)(1+3n)-->1+3n+4n+12n^2+4n^2+12n^3
//7n+16n^2+12n^3-->n+n^2+n^3-->n(1+n+n^2)-->n^2+n^3-->O(n^3)