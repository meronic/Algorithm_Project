package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random r = new Random(); // 임의의 정수를 생성하기 위한 객체 생
        System.out.println("알고리즘 1차 과제 순차탐색의 평균시간복잡도 측정");

        int size = 1000; // 임의의 정수를 생성할 범위 지정
        int total_count = 0; // 전체적인 비교 횟수를 모두 더하는 변수

        int cycle = 100; // 탐색의 반복 횟수를 정의하는 변수

        System.out.println("전체 반복 횟수 : " + cycle +"\n");

        // cycle 횟수만큼 반복하기 위한 전체 for문
        for (int start = 0; start < cycle; start++) {
            //System.out.println(start+1 + "회 탐색 ");
            int select = r.nextInt(size) + 1; // 탐색해서 찾아야 하는 수 생성
            int[] array = new int[size]; // 임의의 정수를 담을 size크기만큼의 배열 생성

            System.out.println("찾아야 하는 수 : " + select);

            // size만큼 배열에서 1부터 size만큼의 임의의 정수를 만들어 배열에 추가
            for (int i = 0; i < size; i++) {
                array[i] = r.nextInt(size) + 1; // 1부터 ~ size 까지의 난수를 위해 +1
                for (int j = 0; j < i; j++) { // 배열의 중복 확인
                    if (array[i] == array[j]) { // 중복 값이 나온경우
                        i--; // 다시 난수 생성
                    }
                }
            }
            // size 크기만큼의 중복되지 않는 임의의 정수를 가진 배열 생성 끝.

            //탐색 시작
            for (int i = 0; i < size; i++) { // 0부터 배열의 크기만큼 순차적으로 탐색
                if (array[i] == select) { // 배열에 저장된 수가 선택한 수와 같을 경우
                    int count = i + 1; // 비교횟수를 저장
                    System.out.println("count :" + count);
                    total_count += count; // 전체비교횟수를 저장하는 변수에 더함
                    break; // 더이상 비교할 필요가 없으므로 반복문 탈출
                }
                else if (array[i] != select){ // 배열에 저장된 수가 선택한 수와 다른경우
                    continue; // 다시 반복문의 처음으로 이동
                }
            }




            for (int a : array) { // 랜덤배열 출력
                if (a == select) {
                    System.out.print("[" + a + "] ");
                    continue;
                }
                System.out.print(a + " ");
            }

            System.out.println("\n");
        }

        System.out.println(cycle + "회 탐색의 count 합계 : " + total_count);
        System.out.println("평균 count : " + ((double)total_count/(double)cycle));
    }
}
