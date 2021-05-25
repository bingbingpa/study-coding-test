package me.bingbingpa.codeup.basic100;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class RGBShuffle {
    public static void main(String[] args) {
        solution(2, 2, 2);
    }

    /**
     * TODO 빨강(r), 초록(g), 파랑(b) 각 빛의 가짓수가 주어질 때, 주어진 rgb 빛들을 섞어 만들 수 있는 모든 경우의 조합(r g b)과 만들 수 있는 색의 가짓 수를 계산하라.
     * 예를 들어, 3 3 3 은 빨녹파 빛에 대해서 각각 0~2까지 3가지 색이 있음을 의미한다.
     * 0 <= r,g,b <= 127
     */
    public static void solution(int r, int g, int b) {
        int loop = r * g * b;
        int rLoop = g * b;
        int gLoop = b;
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 0; i < loop; i++) {
                int colorR = i / rLoop;
                int colorG = (i % rLoop) / gLoop;
                int colorB = i % b;
                bw.write(colorR + " " + colorG + " " + colorB + "\n");
            }
            bw.write(loop + "");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
