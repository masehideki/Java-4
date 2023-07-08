import java.util.InputMismatchException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {

//        ブルーロック選手名鑑
        Map<Integer, String> blueLocks = new HashMap<>() {
            {
                put(11, "Isagi");
                put(10, "Itoshi");
                put(8, "Bachira");
                put(15, "Barou");
                put(9, "Nagi");
                put(1, "Gagamaru");
                put(12, "Hiori");
                put(4, "Chigiri");
            }
        };
//        背番号検索
//        数値以外が入力されるまで継続
        while (true) {
            System.out.println("検索する背番号を選択してください");
            try {
                Scanner sc1 = new Scanner(System.in);
                Integer searchNumber = sc1.nextInt();

                //        背番号（数字）=名前を出力
                Map<Integer, String> outputs = blueLocks.entrySet().stream()
                        .filter(blueLock -> searchNumber.equals(blueLock.getKey()))
                        .collect((Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

                if (outputs.get(searchNumber) != null) {
                    System.out.println(outputs.keySet() + ":" + outputs.values());
                } else {
                    System.out.println("検索した背番号は空き番です");
                }
            } catch (InputMismatchException e) {
                System.out.println("数値以外が入力されました。検索を終了します。");
                break;
            }
        }
    }
}
