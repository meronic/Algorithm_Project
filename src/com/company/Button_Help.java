package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_Help extends JButton {
    String text_help = "배열의 크기 : 1부터 지정된 범위 내까지 중복없이 랜덤한 정수 배열을 생성합니다. \n반복횟수 : 순차탐색의 반복횟수를 설정합니다.";

    public Button_Help(){
        setText("Help");

        setPreferredSize(new Dimension(100,30));

        addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog( null, "알고리즘 과제 프로그램\n" + text_help, "Help_Message", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }
}
