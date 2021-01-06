package com.ddxx.study.algorithms.demo;

class ThreadPrintDemo2 {
  public static void main(String[] args) {
    final ThreadPrintDemo2 demo2 = new ThreadPrintDemo2();
    Thread t1 = new Thread(demo2::print1);
    Thread t2 = new Thread(demo2::print2);

    t1.start();
    t2.start();
  }

  public synchronized void print2() {
    for (int i = 1; i <= 10; i += 2) {
      System.out.println("print2->"+i);
      this.notify();
      try {
        this.wait();
        Thread.sleep(100);
      } catch (Exception e) {}
    }
  }

  public synchronized void print1() {
    for (int i = 0; i <= 10; i += 2) {
      System.out.println("print1->"+i);
      this.notify();
      try {
        this.wait();
        Thread.sleep(100);
      } catch (Exception e) {}
    }
  }
}