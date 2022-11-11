package com.example.hospitaldata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class HospitalDataApplication {


    private static final int THREAD_COUNT = 16;

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(HospitalDataApplication.class, args);
        /*ReadLineContext<Hospital> hospitalReadLineContext = (ReadLineContext<Hospital>) context.getBean("hospitalReadLineContext");
        HospitalDao hospitalDao = context.getBean(HospitalDao.class);
        List<Hospital> hospitals = hospitalReadLineContext.readByLine("C:\\Users\\admin\\Desktop\\의원_UTF8.txt");
        long start = System.currentTimeMillis();
        //약 25 분 소요
        //for (Hospital hospital : hospitals) {
        //    hospitalDao.add(hospital);
        //}


        //thread 적용 :178 초
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            int total = hospitals.size();
            int unit = total / THREAD_COUNT;
            int fromIdx = i * unit;
            int toIdx = (i < THREAD_COUNT - 1) ? fromIdx + unit : total;
            InsertThread insertThread = new InsertThread(hospitalDao, hospitals, fromIdx, toIdx);
            insertThread.start();
            threads.add(insertThread);
        }
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Insert done. " + (System.currentTimeMillis() - start) + "ms");
    }

    static class InsertThread extends Thread {
        final HospitalDao dao;
        final List<Hospital> hospitals;
        final int fromIdx;
        final int toIdx;

        public InsertThread(HospitalDao dao, List<Hospital> hospitals, int fromIdx, int toIdx) {
            this.dao = dao;
            this.hospitals = hospitals;
            this.fromIdx = fromIdx;
            this.toIdx = toIdx;
        }

        @Override
        public void run() {
            for (int i = fromIdx; i < toIdx; i++) {
                dao.add(hospitals.get(i));
            }
        }
        */



    }
}
