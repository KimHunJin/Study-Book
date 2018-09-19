package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E {
    public static void main(String[] args) {

    }
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> leftRet = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> rightRet = new ArrayList<>();

    private ArrayList<ArrayList<Integer>> order(int[][] nodeInfo, int x, int y, int index, int maxX, int minX) {
        ret.add(new ArrayList<>());
        ret.add(new ArrayList<>());

        ArrayList<int[]> sub = new ArrayList<>();
        ArrayList<Integer> subIndex = new ArrayList<>();

        int maxY = 0;
        for(int i = 0; i < nodeInfo.length;i++) {
            if(nodeInfo[i][1] < y && nodeInfo[i][1] > maxY) {
                maxY = nodeInfo[i][1];
            }
        }

        int leftChildIndex = -1;
        int rightChildeIndex = -1;

        for(int i = 0; i< nodeInfo.length;i++ ) {
            if(nodeInfo[i][1] == maxY) {
                sub.add(nodeInfo[i]);
                subIndex.add(i);
            }
        }

        int redMin = 987654321;
        for(int i = 0; i <sub.size();i++) {
            if(x-sub.get(i)[0] < redMin && x - sub.get(i)[0] > 0 && sub.get(i)[0] > minX) {
                redMin = x - sub.get(i)[0];
                leftChildIndex = subIndex.get(i);
            }
        }

        redMin = 987654321;
        for(int i =0; i<sub.size();i++) {
            if(sub.get(i)[0] - x < redMin && sub.get(i)[0] - x > 0 && sub.get(i)[0] < maxX){
                redMin = sub.get(i)[0] - x;
                rightChildeIndex = subIndex.get(i);
            }
        }

        ret.get(0).add(index+1);

        if(leftChildIndex != -1) {
            leftRet = order(nodeInfo, nodeInfo[leftChildIndex][0], nodeInfo[leftChildIndex][1], leftChildIndex, nodeInfo[index][0], minX);
            for(int i =0; i<leftRet.get(0).get(0);i++) {
                ret.get(0).add(leftRet.get(0).get(leftRet.get(0).size()-1));
                ret.get(1).add(leftRet.get(1).get(leftRet.get(1).size()-1));
            }
        }

        if(leftChildIndex != -1) {
            rightRet = order(nodeInfo, nodeInfo[rightChildeIndex][0], nodeInfo[rightChildeIndex][1], rightChildeIndex,maxX, nodeInfo[index][0]);
            for (int i = 0; i < rightRet.get(0).get(0); i++) {
                ret.get(0).add(rightRet.get(0).get(rightRet.get(0).size() - 1));
                ret.get(1).add(rightRet.get(1).get(rightRet.get(1).size() - 1));
            }
        }
        ret.get(1).add(index+1);
        return ret;
    }

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};

        ArrayList root = new ArrayList<>();
        int rootIndex = 0;

        int maxY = -1;
        int maxX = 0;

        for(int i =0; i<nodeinfo.length;i++) {
            if(maxY < nodeinfo[i][1]) {
                maxY = nodeinfo[i][1];
                root = new ArrayList(Arrays.asList(nodeinfo[i]));
                rootIndex = i;
            }
            if(maxX < nodeinfo[i][0]) {
                maxX = nodeinfo[i][0];
            }
        }
        ArrayList<ArrayList<Integer>> result = order(nodeinfo, (Integer)root.get(0), (Integer)root.get(1), rootIndex, 100000+1, -1);
        answer = new int[2][result.get(0).size()];
        for(int i=0;i<result.size();i++) {
            for(int j=0;j<result.get(i).size();j++) {
                answer[i][j] = result.get(i).get(j);
            }
        }

        return answer;
    }
}




