# ScoreBoardRadar
Simple score board replication of a football game, which displays summary and live score of a game

**Functional Requirements:**
A score board that supports following operations
1. start a game with 'home team' and 'away team' with initial score (0-0)
2. Finish a game it will remove from score board.
3. update score 'home team' and 'away team'.
4. Summary of games by a total score - those games with the same total score will be returned ordered by the most recently added to our system.

**Non functional requirements:**
Java 11+,
Junit 5 (unit test cases),
Jacoco (code coverage)


**Output of board summary:**
1.Entering board summary
2.Team{name='Uruguay'}6-Team{name='Italy'}6 - 1
3.Team{name='Spain'}10-Team{name='Brazil'}2 - 2
4.Team{name='Norway'}3-Team{name='England'}3 - 7
5.Team{name='Mexico'}0-Team{name='Canada'}5 - 3
6.Team{name='Argentina'}3-Team{name='Australia'}1 - 4
7.Team{name='Germany'}2-Team{name='France'}2 - 5
8.Exiting board summary
