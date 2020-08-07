import java.util.Scanner;

public class EmptyDiamond {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String userInput;
        int input = 0;

        while (flag) {
            userInput = scanner.next();
            try {
                input = Integer.parseInt(userInput);
                flag = false;
            } catch (Exception e) {
                System.out.println("Your input is not valid!!!");
            }
        }

        topHalfDiamond(input);
        downHalfDiamond(input);
    }


    public static void topHalfDiamond(int input) {

        int leftSpace = input;
        int diameter = (input * 2) + 1;
        int counter = 1;
        int begin = 0;
        int end = 0;

        int star;

        for (int j = 0; j < (diameter / 2) + 1; j++) {
            int i = 0;
            star = 0;
            while (i < leftSpace) {
                System.out.print(" ");
                i++;
            }
            for (int k = 0; k < counter; k++) {
                star++;
            }
            if ((input % 2 == 0 && star > (input + 1)) || (input % 2 == 1 && star > input)) {

                for (int k = 0; k < counter; k++) {
                    if (i >= begin && i <= end)
                        System.out.print(" ");
                    else
                        System.out.print("*");
                    i++;
                }
            } else
                for (int k = 0; k < counter; k++) {
                    if (input % 2 == 0) {
                        if (k == 1)
                            begin = i;
                        if (k == counter - 2)
                            end = i;
                    } else {
                        if (k == 0)
                            begin = i;
                        if (k == counter - 1)
                            end = i;
                    }
                    System.out.print("*");
                    i++;
                }

            leftSpace--;
            counter += 2;
            while (i < diameter) {
                System.out.print(" ");
                i++;
            }
            System.out.println();
        }
    }

    public static void downHalfDiamond(int input) {

        int diameter = (input * 2) + 1;
        int leftSpace = 1;
        int counter = diameter - 2;
        int star;
        int begin;
        int end;

        for (int j = 0; j < (diameter / 2); j++) {
            star = 0;
            int i = 0;
            while (i < leftSpace) {
                System.out.print(" ");
                i++;
            }
            leftSpace++;

            for (int k = counter; k > 0; k--) {
                star++;
            }

            if (input % 2 == 0) {
                begin = ((star - (input - 1)) / 2);
                end = begin + (input - 2);
            } else {
                begin = (star - input) / 2;
                end = begin + (input - 1);
            }

            if ((input % 2 == 0 && star > (input + 1)) || (input % 2 == 1 && star > input)) {
                for (int k = 0; k < counter; k++) {
                    if (k >= begin && k <= end)
                        System.out.print(" ");
                    else
                        System.out.print("*");
                    i++;
                }
            } else
                for (int k = 0; k < counter; k++) {
                    System.out.print("*");
                    i++;
                }

            counter -= 2;
            while (i < diameter) {
                System.out.print(" ");
                i++;
            }
            System.out.println();
        }
    }

}