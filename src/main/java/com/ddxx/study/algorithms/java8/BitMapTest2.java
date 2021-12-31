package com.ddxx.study.algorithms.java8;

public class BitMapTest2 {

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(10000000);
        bitMap.setBit(999999);
        System.out.println(bitMap.getBit(999999));
        System.out.println(bitMap.getBit(59));
        bitMap.setBit(1);
        System.out.println(bitMap.getBit(1));
    }

    static class BitMap{
        long[] ids ;

        public BitMap(int size) {
            this.ids = new long[calculateIndex(size-1) + 1];
        }

        public void setBit(int id){
            ids[calculateIndex(id)] |= ( 1L << id - 1);
        }

        public Boolean getBit(int id){
            return  (ids[calculateIndex(id)] & (1L << id - 1)) != 0;
        }

        private int calculateIndex(int size){
            return size >> 6;
        }
    }
}
