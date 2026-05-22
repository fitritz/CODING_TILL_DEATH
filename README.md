# 800-DSA-Problems-Java

Structured Java DSA repository for placements, internships, and coding interviews.

- 800 runnable Java programs
- 31 topic folders (beginner -> advanced)
- interview + contest oriented problem progression
- each file contains a full `main`-driven solution

## Repository Layout

| Folder | Topic | Problems |
|---|---|---:|
| `01_Basics` | Basics | 26 |
| `02_Arrays` | Arrays | 26 |
| `03_Strings` | Strings | 26 |
| `04_Searching` | Searching | 26 |
| `05_Sorting` | Sorting | 26 |
| `06_Recursion` | Recursion | 26 |
| `07_Bit_Manipulation` | Bit Manipulation | 26 |
| `08_Linked_List` | Linked List | 26 |
| `09_Stack` | Stack | 26 |
| `10_Queue` | Queue | 26 |
| `11_Binary_Search` | Binary Search | 26 |
| `12_Hashing` | Hashing | 26 |
| `13_Two_Pointers` | Two Pointers | 26 |
| `14_Sliding_Window` | Sliding Window | 26 |
| `15_Trees` | Trees | 26 |
| `16_BST` | BST | 26 |
| `17_Heap` | Heap | 26 |
| `18_Graphs` | Graphs | 26 |
| `19_Backtracking` | Backtracking | 26 |
| `20_Greedy` | Greedy | 26 |
| `21_Dynamic_Programming` | Dynamic Programming | 26 |
| `22_Trie` | Trie | 26 |
| `23_Segment_Tree` | Segment Tree | 26 |
| `24_Advanced_Graphs` | Advanced Graphs | 26 |
| `25_Competitive_Programming` | CP Patterns | 26 |
| `26_Number_Theory` | Number Theory | 25 |
| `27_Geometry` | Geometry | 25 |
| `28_Game_Theory` | Game Theory | 25 |
| `29_String_Algorithms` | String Algorithms | 25 |
| `30_DP_On_Trees` | DP on Trees | 25 |
| `31_DP_On_Graphs` | DP on Graphs | 25 |

## What You Get Per File

- complete compilable Java code
- input parsing + output printing
- optimized approach implementation
- no partial snippets
- ready to run directly from terminal

## How to Run

### Compile one file
```bash
javac 05_Binary_Search_Revision_05.java
```

### Run one file
```bash
java BinarySearchRevision05
```

Use the class name defined in that file.

### Compile all files (PowerShell)
```powershell
Get-ChildItem -Recurse -Filter *.java | ForEach-Object { javac $_.FullName }
```

## Suggested Study Flow

1. Foundation:
   Basics -> Arrays -> Strings -> Searching -> Sorting
2. Core DS:
   Recursion -> Linked List -> Stack -> Queue -> Hashing
3. Pattern Mastery:
   Binary Search -> Two Pointers -> Sliding Window
4. Trees + Graph Core:
   Trees -> BST -> Heap -> Graphs
5. Problem Solving Layer:
   Backtracking -> Greedy -> Dynamic Programming
6. Advanced Topics:
   Trie -> Segment Tree -> Advanced Graphs -> Number Theory -> String Algorithms
7. Interview+Contest Finish:
   Geometry -> Game Theory -> DP on Trees -> DP on Graphs

## Difficulty Guide

- Easy:
  direct implementation, basic loops, standard DS usage
- Medium:
  pattern-based questions, combined data structures, clean edge-case handling
- Hard:
  multi-step DP/graph/theory problems and tighter optimization requirements

## Placement Preparation Strategy

1. Solve 8-12 questions daily from one active topic.
2. Keep one revision day every week.
3. Re-solve previously marked hard questions without looking at code.
4. Maintain a mistakes notebook:
   off-by-one, overflow, wrong base case, missing boundary checks.
5. Before interviews, do mixed sets:
   arrays + binary search + hash + tree + graph + dp.

## Progress Tracking

- topic checklist: [PROGRESS_TRACKER.md](./PROGRESS_TRACKER.md)
- ordered learning path: [ROADMAP.md](./ROADMAP.md)

## Notes

- Input style varies naturally across files (`BufferedReader`, fast reader, scanner wrappers) to mirror realistic practice.
- Solutions are intentionally concise and competitive-programming friendly.
