package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {

    public Text_Area text_area = new Text_Area(); // 텍스트 영역 추가
    public JScrollPane scrollPane = new JScrollPane(text_area); //텍스트 영역에 스크롤 추가

    public JLabel totalLabel = new JLabel("전체 비교횟수 : "); // 비교횟수를 보여주기 위한 라벨 추가
    public JLabel total = new JLabel();

    public JLabel averageLabel = new JLabel("평균 비교횟수 : ");
    public JLabel average = new JLabel();

    public Button_Search btn_search = new Button_Search(text_area, total, average); // 실행버튼 객체 생성

    public Panel(){ // 생성과 동시에 설정 추가
        setBorder(BorderFactory.createEmptyBorder(20,30,30,30)); // 여백 padding 설정
        setLayout(new FlowLayout()); // 레이아웃 설정

        JLabel title_label = new JLabel("<html>순차탐색의 평균 시간복잡도 측정<br><br>"); // 맨위에 나타나는 타이틀

        add(title_label); // 라벨추가


        // 콤보박스 설정

        Integer size[] = {10,100,1000}; // 선택할 배열의 사이즈 추가
        Integer cycle[] = {1,10,100}; // 선택할 탐색의 반복횟수 추가

        JComboBox<Integer> comboBox_size = new JComboBox(size); // 추가된 내용의 combobox 생성
        JComboBox<Integer> comboBox_cycle = new JComboBox(cycle);

        final int[] size_check = {(int) comboBox_size.getSelectedItem()}; // combobox의 Action내부에서 사용하기 위해 final로 생성
        final int[] cycle_check = {(int) comboBox_cycle.getSelectedItem()};




        // 기능추가
        add(scrollPane); // 스크롤을 가진 텍스트 영역 추가

        // 콤보박스 패널에 추가
        add(new JLabel("배열의 크기"));
        add(comboBox_size);


        add(new JLabel("반복횟수"));
        add(comboBox_cycle);


        /// 실행 버튼 추가

        add(btn_search);

        btn_search.size = size_check[0]; // 버튼 클릭시 실행하게 되는 함수를 위해 변수를 저장
        btn_search.cycle = cycle_check[0];

        // 콤보박스 이벤트 추가
        comboBox_size.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size_check[0] = (int)comboBox_size.getSelectedItem(); //선택한 값으로 size 변경
                btn_search.size = size_check[0]; // 탐색을 위해 함수로 넘겨주는 변수도 변경
            }
        });

        comboBox_cycle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cycle_check[0] = (int)comboBox_cycle.getSelectedItem(); // 선택한 값으로 cycle 변경
                btn_search.cycle = cycle_check[0];

            }
        });

        // 실행버튼
        add(new Button_Help()); // 도움말 버튼
        add(new Button_Exit()); // 종료 버튼끝


        // 결과 라벨 패널에 추가

        add(totalLabel);
        add(total);
        total.setPreferredSize(new Dimension(200,30)); // 사이즈 설정

        add(averageLabel);
        add(average);
        average.setPreferredSize(new Dimension(200,30));

    }

}
