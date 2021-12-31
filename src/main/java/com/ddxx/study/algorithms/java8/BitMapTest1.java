package com.ddxx.study.algorithms.java8;

public class BitMapTest1 {

    public static void main(String[] args) {
        BitMap bitMap = new BitMap();
        bitMap.setBit(60);
        System.out.println(bitMap.getBit(60));
        System.out.println(bitMap.getBit(59));
    }


    static class BitMap{
        byte[] k = new byte[64] ;
        public void setBit(int id){
            k[id-1] = 1;
        }

        public Boolean getBit(int id){
            return k[id-1] == 1;
        }
    }
}
