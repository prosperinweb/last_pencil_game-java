# Last Pencil Game (Java)

## Overview
The Last Pencil Game is a simple, interactive console-based game implemented in Java completed as part of the Jetbrains Academy Java Developer track.
In this game, players take turns to remove 1 to 3 pencils from a given number of pencils. 
The player forced to take the last pencil loses. The game can be played against a bot (Jack) or another player (John).

## Features
- Interactive command-line interface
- Player versus Bot (Jack) mode
- Player versus Player (John) mode
- Randomized bot decisions for enhanced gameplay

## Requirements
- Java Runtime Environment (JRE) 8 or higher

## Installation
1. Clone the repository to your local machine:
   
2. Navigate to the cloned repository directory.

3. Compile the Java code:
    ```
    javac lastpencil/Main.java
    ```

## How to Play
1. Run the game:
    ```
    java lastpencil.Main
    ```

2. Enter the total number of pencils to use.

3. Choose the first player: John (Player) or Jack (Bot).

4. Follow the on-screen instructions to play the game. Each player can take 1, 2, or 3 pencils on their turn.

5. The player who is forced to take the last pencil loses the game.

## Gameplay Rules
- The game starts with a set number of pencils.
- Players alternate turns to remove 1, 2, or 3 pencils.
- The player forced to take the last pencil loses.
- The bot's moves are partly randomized, but it follows a strategy to increase its chances of winning.
