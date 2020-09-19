package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_Search extends JButton {

    public int size; // 콤보박스로부터 입력받은 size 값
    public int cycle; // 콤보박스로부터 입력받은 cycle 값

    public int total_count = 0; // 전체 비교횟수를 나타내는 변수
    public double average_count = 0; // 평균 비교횟수를 나타내는 변수

    Function_Search f = new Function_Search(); // 탐색을 하기위한 함수객체 생성

    public Button_Search(Text_Area t, JLabel total, JLabel average){
        setPreferredSize(new Dimension(100,30)); // 버튼 크기
        setText("Search"); // 버튼 이름


        addActionListener(new ActionListener() { //버튼 클릭시 이벤트 함수
            @Override
            public void actionPerformed(ActionEvent e) {

                f.size = size; // 콤보박스로부터 입력받은 size 값을 객체변수에 입력
                total_count = 0; // 전체 횟수 초기화

                for (int i = 0; i < cycle; i ++){
                    t.append(i+1 + "회 탐색\n");
                    f.search_start(); // 한번의 탐색 함수 호출

                    total_count += f.count; // 함수 안의 count 값을 추가

                    t.append(f.result); // 결과값 출력
                    t.append("\n");

                }
                average_count = (double)total_count/(double)cycle; // 평균 비교횟수 계산
                total.setText(Integer.toString(total_count)); // 전체 비교횟수 추가
                average.setText(Double.toString(average_count)); // 평균 비교횟수 추가

            }
        });

    }
}
