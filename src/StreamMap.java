import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {

//        ブルーロック選手名鑑
        Map<Integer, String> BlueLocks = new HashMap<>() {
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
        System.out.println("検索する背番号を選択してください");

        Scanner sc1 = new Scanner(System.in);
        Integer searchNumber = sc1.nextInt();

//        背番号（数字）=名前を出力
        Map<Integer, String> Outputs = BlueLocks.entrySet().stream()
                .filter(blueLock -> searchNumber.equals(blueLock.getKey()))
                .collect((Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        if (Outputs.get(searchNumber) != null) {
            System.out.println(Outputs.keySet()+":"+Outputs.values());
        } else {
            System.out.println("検索した背番号は空き番です");
        }

    }
}