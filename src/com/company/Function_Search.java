package com.company;

import java.util.Random;

public class Function_Search { // 탐색 클래스

    public String result; // gui에 결과를 나타내줄 변수
    public int size = 10; // 임의의 정수를 생성할 범위
    public int count = 0; // 비교 횟수를 저장하는 변수
    public int select; //찾아야 하는 변수


    public void search_start() {
        result = ""; // gui출력을 위한 문자열 초기화

        Random r = new Random(); // 임의의 정수를 생성하기 위한 객체 생성


        select = r.nextInt(size) + 1; // 탐색해서 찾아야 하는 수 생성
        int[] array = new int[size]; // 임의의 정수를 담을 size크기만큼의 배열 생성

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

        // result에 배열 추가 및 배열 출력
        result = "만들어진 배열 :";

        for (int i : array){
            if (i == select){ // 탐색하는 수와 같을 때
                result += "[" + Integer.toString(i) + "]"; // 선택한 수는 괄호로 표시
                continue; // 다시 반복문 처음으로 이동
            }
            result += Integer.toString(i) + " "; // 출력문에 배열 추가
        }
        result += "\n\n탐색숫자 : " + Integer.toString(select); // gui 출력문

        //탐색 시작
        for (int i = 0; i < size; i++) { // 0부터 배열의 크기만큼 순차적으로 탐색
            if (array[i] == select) { // 배열에 저장된 수가 선택한 수와 같을 경우
                count = i + 1; // 비교횟수를 저장
                break; // 더이상 비교할 필요가 없으므로 반복문 탈출
            } else if (array[i] != select) { // 배열에 저장된 수가 선택한 수와 다른경우
                continue; // 다시 반복문의 처음으로 이동
            }
        }
        // 탐색 종료

        result += "\n비교횟수 : " + Integer.toString(count)+"\n"; // gui출력을 하기위해 결과를 String변수에 추가

    }

}
