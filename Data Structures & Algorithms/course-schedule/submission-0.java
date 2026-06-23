
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

            // Step 1: Create graph
                    List<List<Integer>> graph = new ArrayList<>();
                            for (int i = 0; i < numCourses; i++) {
                                        graph.add(new ArrayList<>());
                                                }

                                                        // Step 2: In-degree array
                                                                int[] indegree = new int[numCourses];

                                                                        // Step 3: Build graph and indegree
                                                                                for (int[] pre : prerequisites) {
                                                                                            int course = pre[0];
                                                                                                        int prereq = pre[1];
                                                                                                                    graph.get(prereq).add(course);
                                                                                                                                indegree[course]++;
                                                                                                                                        }

                                                                                                                                                // Step 4: Queue for BFS
                                                                                                                                                        Queue<Integer> queue = new LinkedList<>();
                                                                                                                                                                for (int i = 0; i < numCourses; i++) {
                                                                                                                                                                            if (indegree[i] == 0) {
                                                                                                                                                                                            queue.offer(i);
                                                                                                                                                                                                        }
                                                                                                                                                                                                                }

                                                                                                                                                                                                                        // Step 5: Process courses
                                                                                                                                                                                                                                int completed = 0;
                                                                                                                                                                                                                                        while (!queue.isEmpty()) {
                                                                                                                                                                                                                                                    int curr = queue.poll();
                                                                                                                                                                                                                                                                completed++;

                                                                                                                                                                                                                                                                            for (int next : graph.get(curr)) {
                                                                                                                                                                                                                                                                                            indegree[next]--;
                                                                                                                                                                                                                                                                                                            if (indegree[next] == 0) {
                                                                                                                                                                                                                                                                                                                                queue.offer(next);
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                                            // Step 6: Check if all courses completed
                                                                                                                                                                                                                                                                                                                                                                                    return completed == numCourses;
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                        }

