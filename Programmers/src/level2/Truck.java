import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        //트럭 1초에 1만큼 움직임
        //다리길이 - bridge_length
        //견디는 무게 - weight
        //트럭별 무게 - truck_weights
        //트럭이 다리에 완전히 올라야 무게 고려함
        Truck truck = null;

        //대기 트럭
        Queue<Truck> wait = new LinkedList<Truck>();

        //진행중 트럭
        ArrayList<Truck> current = new ArrayList<Truck>();

        for (int i : truck_weights) {
            wait.add(new Truck(i, bridge_length));
        }

        //경과 시간
        int time = 0;

        //다리 현재 무게
        int curWeight = 0;

        //견딜수 있는 무게
        int weightCh = weight;

        //ArrayList에 대기 트럭 넣기
        //다리 건널때 큐에 넣기

        while (!(wait.isEmpty() && current.isEmpty())) {

            //다리위 트럭이 distance이상 지나갔으면 무게 원상복귀 후 current에서 제거한다.
            if(!current.isEmpty() && current.get(0).distance <= 0) {
                weightCh += current.get(0).weight;
                current.remove(0);
            }

            //대기 트럭이 존재하고 && 견딜수있는 무게-트럭의 무게 >=0일때
            //다음 트럭이 남은무게보다 가벼우면 다리 건너기 시작
            if(!wait.isEmpty() && weightCh - wait.peek().weight >= 0) {
                //가능한 무게에서 현재 지나가는 트럭 무게 빼기
                weightCh -= wait.peek().weight;
                current.add(wait.poll());
            }

            //다리 위 트럭의 distance 1씩 감소
            for (int i=0; i<current.size(); i++) {
                truck = current.get(i);
                truck.distance--;
            }
            time++;
        }
        return time;
    }
}

class Truck {
    int weight;
    int distance;

    public Truck(int weight, int distance) {
        this.weight = weight;
        this.distance = distance;
    }
}
