import java.util.Scanner;

/*
    PRIME REDUCTION

    Given an input x:

    1. if x is prime, prnt x and stop
    2. factor x into its frime factors p1,p2,...,pk
    3. let x = p1 + p2 + ... + pk
    4. go back to step 1


    For each integer, print the value produced
    by prime reduction executed on that input, followed
    by the number of times the first line of the process executed.
 */

public class PrimeCreator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int input = sc.nextInt();
            if(input==4) break;
            reduceToPrimes(input, 0);
        }
        sc.close();
    }

    private static void reduceToPrimes(int myNumber, int counter){
        counter++;
        int newNumber = 0;
        int i = 2;

        if(isPrime(myNumber)){
            System.out.println(myNumber + " " + counter);
            return;
        }

        while(true){
            if(myNumber % i == 0){
                myNumber /= i;
                newNumber += i;
                if(isPrime(myNumber)){
                    newNumber += myNumber;
                    break;
                }
                i = 1;
            }
            i++;
        }
        reduceToPrimes(newNumber, counter);
    }

    private static boolean isPrime(int number){
        if(number == 2) return true;
        for(int i = 2; i < Math.pow(number, 0.5)+1; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

}
