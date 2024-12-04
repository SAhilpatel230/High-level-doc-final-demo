##Section 1: Project Description
Cybersecurity Trivia Game
The project aims to develop a multiplayer trivia game focusing on cybersecurity topics, build as a console application. The backend is implemented in Java, while the client-side utilizes JavaScript, HTML, and CSS for visuals. WebSockets enable real-time communication between the client and server, allowing the server to manage questions, player sessions, and scoring.
Section 2: Overview
The trivia game operates in a browser environment, displaying questions, collecting player answers, and updating scores in real-time. WebSocket communication ensures a seamless gaming experience with live updates and direct server interaction.
Section 3: System Architecture
• Backend (Java WebSocket Server): Manages data synchronization, player sessions, and live score updates. • Frontend (HTML/CSS/JavaScript): Browser-based interface displaying trivia questions and receiving player inputs for scoring.
Section 4: Data Dictionary
• Player Object: Stores each player's unique ID, score, and connection state to the server.
• Question Object: Contains trivia questions, possible answers, and the correct answer.
• Game State Object: Monitors game progress, including current question number, individual scores, and game status (active or finished).
Section 5: Data Design
The backend server processes and updates player responses and scores based on real-time events, handling game state transitions and syncing question/answer data across both players for a consistent experience.
Section 6: User Interface Design
• Gameplay Screen: Displays a trivia question with four answer options. Players select answers by clicking.
• Scoreboard: Updates live scores for each player after every question.
• End Screen: Shows final scores and announces the winner.
Features Implemented so far:
The below backend features have been implemented:
1.	Player Management: Players enter their names at the start, which are used to personalize the game experience.
2.	Question Bank: Includes 10 cybersecurity questions covering topics like malware, encryption, protocols, and security tools.
3.	Score Tracking: Tracks the player’s score, increasing it for each correct answer and displaying it at the end.
4.	Sequential Questioning: Presents each question in order, with multiple-choice options displayed for easy selection.
5.	Answer Validation and Feedback: Ensures only valid answers are accepted and provides feedback on each response (correct or incorrect).
6.	End Summary: Shows the players' final score with a personalized closing message.
How to Play
• Run the program in an eclipse java environment.
• Enter your name when prompted.
• Answer each question by typing the number corresponding to your choice.
• View your score at the end of the game.

