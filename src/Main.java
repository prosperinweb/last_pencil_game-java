import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("How many pencils would you like to use:");
        int pencils = getPencils();

        System.out.println("Who will be the first (John, Jack):");
        String firstPlayer = getFirstPlayer();

        boolean isBotsTurn = firstPlayer.equalsIgnoreCase("Jack");

        while (pencils > 0) {
            displayPencils(pencils);
            if (isBotsTurn) {
                int botMove = getBotMove(pencils, random);
                System.out.println(botMove);
                pencils -= botMove;
            } else {
                int playerMove = getPlayerMove(pencils);
                pencils -= playerMove;
            }
            isBotsTurn = !isBotsTurn;
        }

        System.out.println(isBotsTurn ? "Jack won!" : "John won!");
    }

    private static void displayPencils(int pencils) {
        System.out.println("|".repeat(pencils));
    }

    private static String getFirstPlayer() {
        String firstPlayer;
        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                firstPlayer = scanner.nextLine();
                if (firstPlayer.equalsIgnoreCase("John") || firstPlayer.equalsIgnoreCase("Jack")) {
                    break;
                } else {
                    System.out.println("Choose between 'John' and 'Jack'");
                }
            } catch (InputMismatchException e) {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }
        return firstPlayer;
    }

    private static int getPencils() {
        int pencils;
        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                pencils = Integer.parseInt(scanner.nextLine());
                if (pencils > 0) break;
                throw new InputMismatchException("The number of pencils should be positive");
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return pencils;
    }

    public static int getBotMove(int currentPencils, Random random) {
        System.out.println("Jack's turn:");
        if (currentPencils == 1) {
            return 1;
        } else if (currentPencils % 4 == 1) {
            return random.nextInt(3) + 1;
        } else if (currentPencils % 4 == 0) {
            return 3;
        } else {
            return currentPencils % 4 - 1;
        }
    }

    private static int getPlayerMove(int currentPencils) {
        System.out.println("John's turn:");
        return getValidMove(currentPencils);
    }

    private static int getValidMove(int currentPencils) {
        int move;
        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                move = Integer.parseInt(scanner.nextLine());
                if (move > 0 && move < 4 && move <= currentPencils) {
                    break;
                } else {
                    if (!(move > 0 && move < 4)) throw new InputMismatchException("Possible values: '1', '2', '3");
                    throw new InputMismatchException("too many pencils");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Possible values: '1', '2', '3");
            }
        }
        return move;
    }
}