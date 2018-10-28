import java.util.ArrayList;
import java.util.List;

public class Truck_Bridge {

    static class BridgeInfo {
        int bridgeLength;
        int weight;
        int[] truckWeights;

        BridgeInfo(int bridgeLength, int weight, int[] truckWeights) {
            this.bridgeLength = bridgeLength;
            this.weight = weight;
            this.truckWeights = truckWeights;
        }
    }

    public static void main(String[] args) {
        Truck_Bridge truck_bridge = new Truck_Bridge();

        List<BridgeInfo> list = new ArrayList<>();

        // 7
        int[] testA = {7, 4, 5, 3};
        list.add(new BridgeInfo(2, 10, testA));

        // 101
        int[] testB = {10};
        list.add(new BridgeInfo(100, 100, testB));

        // 202
        int[] testC = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        list.add(new BridgeInfo(100, 100, testC));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(truck_bridge.solution(list.get(i).bridgeLength, list.get(i).weight, list.get(i).truckWeights));
        }

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int size = truck_weights.length;

        int[] times = new int[size];

        int currentWeight = 0;
        int time = 1;
        for (int i = 0; i < size; i++) {
            if (currentWeight + truck_weights[i] > weight) {

            } else {
                times[i] = time + bridge_length;
                time++;
                currentWeight += truck_weights[i];
            }
        }

        return answer;
    }
}
