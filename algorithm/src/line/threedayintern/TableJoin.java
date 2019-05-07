package line.threedayintern;

import javafx.scene.control.Tab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TableJoin {
    public static void main(String[] args) {
        new TableJoin().solve();
    }

    class Table {
        String a = "NULL";
        String b = "NULL";
        String c = "NULL";
        String d = "NULL";
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine(), 10);
            List<String> names = new ArrayList<>();

            String[] tmp = br.readLine().split(" ");
            for (String s : tmp) {
                names.add(s);
            }

            List<Integer> ids = new ArrayList<>();

            Map<Integer, Table> map = new HashMap<>();
            for (int i = 1; i < n; i++) {
                tmp = br.readLine().split(" ");
                int id = Integer.parseInt(tmp[0], 10);
                Table table = new Table();
                table.a = tmp[1];
                table.b = tmp[2];
                map.put(id, table);
                ids.add(id);
            }

            n = Integer.parseInt(br.readLine(), 10);

            tmp = br.readLine().split(" ");
            for (int i = 1; i < tmp.length; i++) {
                names.add(tmp[i]);
            }



            for (int i = 1; i < n; i++) {
                tmp = br.readLine().split(" ");
                int id = Integer.parseInt(tmp[0], 10);
                if (map.containsKey(id)) {
                    map.get(id).c = tmp[1];
                    map.get(id).d = tmp[2];
                }
            }

            Collections.sort(ids);

            System.out.print("");
            for(String s: names) {
                System.out.print(s+ " ");
            }
            System.out.println();
            for (int id : ids) {
                Table t = map.get(id);
                System.out.println(id+ " " + t.a + " " + t.b + " " + t.c + " " + t.d);
            }


        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
