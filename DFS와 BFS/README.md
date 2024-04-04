# DFS와 BFS
- DFS는 재귀와 스택을 이용해 구현하며, 자식 노드의 마지막 노드를 만날 때까지 파고 든다.
- BFS는 큐를 이용해 구현하며, 자신의 모든 자식노드를 방문하고 다음 레벨로 이동하는 레벨 순회이다.
```
    1. 첫번째 노드를 넣고 시작한다.
    2. 스택/큐에서 top을 꺼낸다.
    3. top을 출력한다.
    4. top의 자식 노드 중 방문하지 않은 자식 노드를 스택/큐에 넣는다.
    5. 넣은 자식 노드를 방문 처리한다.
    6. 위 단계를 반복한다.
```
DFS와 BFS 모두 로직은 같으나, 결과가 다른 이유는 사용하는 자료구조가 달라 꺼내는 노드의 순서가 다르기 때문이다.

<br>

[전체 코드 바로가기](https://github.com/EunsilSon/algorithms/blob/main/DFS%EC%99%80%20BFS/GraphSearch.java)

## 재귀를 이용한 DFS
```java
void dfsWithRecursive(int[][] arr, int x) {
        visited[x] = true;
        System.out.print(x + " ");

        for (int i = 0; i < arr[x].length; i++) {
            if (arr[x][i] == 1 && !visited[i]) {
                dfsWithRecursive(arr, i);
            }
        }
    }
```

<br>

## Stack을 이용한 DFS
```java
void dfsWithStack(int[][] arr) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[9];

        stack.push(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            int x = stack.pop();
            System.out.print(x + " ");

            for (int i = 0; i < arr[x].length; i++) {
                if (arr[x][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
```

<br>

## Queue를 이용한 BFS
```java
void bfs(int[][] arr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int x = queue.remove();
            System.out.print(x + " ");

            for (int i = 0; i < arr[x].length; i++) {
                if (arr[x][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
```