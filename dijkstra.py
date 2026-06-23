import sys
import heapq


def solve():
    input = sys.stdin.buffer.readline
    n, m = map(int, input().split())

    graph = [[] for _ in range(n)]
    for edge_no in range(m):
        a, b, w = map(int, input().split())
        graph[a].append((b, w, edge_no))

    inf = 10**30
    dist = [inf] * n
    parent = [-1] * n
    parent_edge = [-1] * n
    version = [0] * n

    dist[0] = 0
    pq = [(0, 0, 0)]

    while pq:
        current_dist, current, current_version = heapq.heappop(pq)
        if current_dist != dist[current] or current_version != version[current]:
            continue

        for next_node, weight, edge_no in graph[current]:
            if next_node == 0:
                continue

            next_dist = current_dist + weight

            if next_dist < dist[next_node]:
                dist[next_node] = next_dist
                parent[next_node] = current
                parent_edge[next_node] = edge_no
                version[next_node] += 1
                heapq.heappush(pq, (next_dist, next_node, version[next_node]))
            elif next_dist == dist[next_node] and edge_no > parent_edge[next_node]:
                parent[next_node] = current
                parent_edge[next_node] = edge_no
                version[next_node] += 1
                heapq.heappush(pq, (next_dist, next_node, version[next_node]))

    result = []
    for target in range(1, n):
        if dist[target] == inf:
            result.append(f"V0 V{target} (-1)")
            continue

        path = []
        node = target
        while node != -1:
            path.append(node)
            node = parent[node]
        path.reverse()

        route = " ".join(f"V{node}" for node in path)
        result.append(f"{route} ({dist[target]})")

    sys.stdout.write("\n".join(result))


if __name__ == "__main__":
    solve()
