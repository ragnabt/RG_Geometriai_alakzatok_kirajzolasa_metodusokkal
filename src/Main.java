import java.util.Scanner;

public class Main {
    public static int val;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = getSize(scanner);

        boolean filled = isFilled(scanner);


        square(filled, size);
        System.out.println();
        rectangle(filled, size);
        System.out.println();
        rhombus(filled, size);
        System.out.println();
        parallelogram(filled, size);
        System.out.println();


        System.out.println(val);
        scanner.close();
    }


    private static boolean isFilled(Scanner scanner) {
        System.out.println("Filled? true or false?");
        boolean filled = Boolean.parseBoolean(input(scanner));
        return filled;
    }


    private static int getSize(Scanner scanner) {
        System.out.println("Height?");
        int size = Integer.parseInt(input(scanner));
        return size;
    }


    private static void square(boolean filled, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (filled == false) {
                    if ((i == 0 || j == 0) || (i == size - 1 || j == size - 1)) {
                        System.out.print("  *");
                    } else {
                        System.out.print("   ");
                    }
                } else {
                    System.out.print("  *");
                }
            }
            System.out.println();
        }
    }


    private static void parallelogram(boolean filled, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + (size - 1); j++) {

                boolean doNotFill = j < size - i - 1 || j > size - i - 2 + size;

                if (!filled) {
                    if (i == 0 || i == size - 1) {
                        if (doNotFill) {
                            System.out.print("   ");
                        } else {
                            System.out.print("  *");
                        }
                    } else if (j > size - i - 1 && j < size - i - 2 + size) {
                        System.out.print("   ");
                    } else if (doNotFill) {
                        System.out.print("   ");
                    } else {
                        System.out.print("  *");
                    }
                } else if (doNotFill) {
                    System.out.print("   ");
                } else {
                    System.out.print("  *");
                }
            }
            System.out.println();
        }
    }


    private static void rhombus(boolean filled, int size) {
        int starNumber = 1;
        int column;
        while (starNumber <= size) {
            column = 1;

            while (column++ <= size - starNumber) {
                System.out.print(" ");
            }
            column = 1;
            while (column <= starNumber * 2 - 1) {
                if (filled) {
                    System.out.print("*");
                } else if (starNumber > 1 && column > 1 && column < starNumber * 2 - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
                column++;
            }
            System.out.println();
            starNumber++;
        }
        starNumber = size - 1;
        while (starNumber > 0) {
            column = 1;
            while (column++ <= size - starNumber) {
                System.out.print(" ");
            }
            column = 1;
            while (column <= starNumber * 2 - 1) {
                if (filled) {
                    System.out.print("*");
                } else if (starNumber > 1 && column > 1 && column < starNumber * 2 - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
                column++;
            }
            System.out.println();
            starNumber--;
        }
    }

    private static void rectangle(boolean filled, int size) {
        int size2 = size * 2;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size2; j++) {
                if (filled == false) {
                    if ((i == 0 || j == 0) || (i == size - 1 || j == size2 - 1)) {
                        System.out.print("  *");
                    } else {
                        System.out.print("   ");
                    }
                } else {
                    System.out.print("  *");
                }
            }
            System.out.println();
        }
    }


    private static String input(Scanner scanner) {
        String input = scanner.nextLine();
        return input;
    }
}
