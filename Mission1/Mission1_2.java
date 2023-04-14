import java.util.ArrayList;
import java.util.Scanner;

public class Mission1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("내 좌표 x값을 입력해 주세요.");
        int x = sc.nextInt();
        System.out.println("내 좌표 y값을 입력해 주세요.");
        int y = sc.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int cnt = 1;
        while (cnt <= 10) {
            System.out.printf("%d/10 번째 입력%n", cnt);
            ArrayList<Integer> coord = new ArrayList<>();
            System.out.println("임의의 좌표 x값을 입력해 주세요.");
            coord.add(sc.nextInt());
            System.out.println("임의의 좌표 y값을 입력해 주세요.");
            coord.add(sc.nextInt());
            if (list.contains(coord)) {
                System.out.println("동일한 좌표값이 이미 존재합니다. 다시 입력해 주세요.");
            } else {
                list.add(coord);
                cnt++;
            }
        }
        int idx = -1;
        Double min = Double.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> coord = list.get(i);
            int x_new = coord.get(0);
            int y_new = coord.get(1);
            Double d = Math.sqrt(Math.pow(x-x_new, 2)+Math.pow(y-y_new, 2));
            System.out.printf("(%d, %d) => %f%n", x_new, y_new, d);
            if (d < min) {
                min = d;
                idx = i;
            }
        }
        System.out.println("제일 가까운 좌표:");
        ArrayList<Integer> coord = list.get(idx);
        int x_opt = coord.get(0);
        int y_opt = coord.get(1);
        System.out.printf("(%d, %d) => %f", x_opt, y_opt, min);
    }
}
