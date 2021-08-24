package me.bingbingpa.programmers.codingtest;

import java.util.*;

public class GoodDays {
    public static void main(String[] args) {
        GoodDays T = new GoodDays();
        int[][] date = new int[][]{
                {3, 0, 20}, {2, 1, 17}, {3, 0, 17}, {2, 0, 31}, {1, 0, 19}, {1, 0, 19}, {4, 1, 14}
        };
        System.out.println(Arrays.toString(T.solution(date)));
    }

    public int[] solution(int[][] data) {
        List<GoodDay> goodDays = new ArrayList<>();
        int length = data.length;

        for (int i = 0; i < length; i++) {
            goodDays.add(GoodDay.of(data[i][0], data[i][1], data[i][2], i));
        }

        Collections.sort(goodDays);

        return new int[]{goodDays.get(length - 1).getIndex(), goodDays.get(0).getIndex()};
    }

    private static class GoodDay implements Comparable<GoodDay> {
        private static final Map<Integer, Integer> skyCode = Map.of(
                1, 20,
                2, 20,
                3, 17,
                4, 10
        );
        private static final Map<Integer, Integer> precipitationCode = Map.of(
                0, 0,
                1, 5,
                2, 14
        );
        private static final Map<Integer, Integer> days = Map.of(
                0, 1,
                1, 2,
                2, 4,
                3, 3,
                4, 6,
                5, 7,
                6, 5
        );

        private final int weatherValue;
        private final int index;

        public GoodDay(int weatherValue, int index) {
            this.weatherValue = weatherValue;
            this.index = index;
        }

        public static GoodDay of(int weather, int precipitation, int temperature, int index) {
            int sum = skyCode.get(weather) + precipitationCode.get(precipitation) + getTemperature(temperature);
            if (temperature >= 30 || temperature <= 0 || weather == 4 || precipitation == 1) {
                sum = 0;
            }
            return new GoodDay(sum, index);
        }

        private static int getTemperature(int num) {
            return 20 - Math.abs(22 - num);
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(GoodDay o) {
            if (this.weatherValue == o.weatherValue) {
                if (this.weatherValue == 0) {
                    return days.get(o.index) - days.get(index);
                }
                return days.get(index) - days.get(o.index);

            }
            return this.weatherValue - o.weatherValue;
        }

        @Override
        public String toString() {
            return "GoodDay{" +
                    "weatherValue=" + weatherValue +
                    ", index=" + index +
                    '}';
        }
    }
}
