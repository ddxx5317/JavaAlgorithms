package com.ddxx.study.algorithms.java8;

public class BitMapTest {

    public static void main(String[] args) {
        BitMap bitMap = new BitMap();
        bitMap.setBit(60);
        System.out.println(bitMap.getBit(60));
        System.out.println(bitMap.getBit(59));
        System.out.println(bitMap.getBit(64));
        bitMap.setBit(64);
        System.out.println(bitMap.getBit(64));

        System.out.println(64 >> 6);
    }

    static class BitMap{
        long a = 0;
        public void setBit(long id){
            a |= ( 1L << id - 1);
        }

        public Boolean getBit(long id){
            return  (a & (1L << id - 1)) != 0;
        }
    }
}
