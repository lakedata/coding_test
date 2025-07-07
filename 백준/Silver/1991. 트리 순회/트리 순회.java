import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, Node> tree = new HashMap<>();

    static class Node {
        char left;
        char right;

        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 트리 구성
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            char root = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            tree.put(root, new Node(left, right));
        }

        // 순회 결과 출력
        StringBuilder sb = new StringBuilder();
        preorder('A', sb);
        System.out.println(sb.toString());

        sb.setLength(0); // StringBuilder 초기화
        inorder('A', sb);
        System.out.println(sb.toString());

        sb.setLength(0); // StringBuilder 초기화
        postorder('A', sb);
        System.out.println(sb.toString());
    }

    // 전위 순회: 루트 → 왼쪽 → 오른쪽
    static void preorder(char cur, StringBuilder sb) {
        if (cur == '.') return;
        sb.append(cur);
        preorder(tree.get(cur).left, sb);
        preorder(tree.get(cur).right, sb);
    }

    // 중위 순회: 왼쪽 → 루트 → 오른쪽
    static void inorder(char cur, StringBuilder sb) {
        if (cur == '.') return;
        inorder(tree.get(cur).left, sb);
        sb.append(cur);
        inorder(tree.get(cur).right, sb);
    }

    // 후위 순회: 왼쪽 → 오른쪽 → 루트
    static void postorder(char cur, StringBuilder sb) {
        if (cur == '.') return;
        postorder(tree.get(cur).left, sb);
        postorder(tree.get(cur).right, sb);
        sb.append(cur);
    }
}
