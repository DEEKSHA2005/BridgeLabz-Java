package coreprogramming.methods.level3;

import java.util.Scanner;

public class OTPGeneratorUtility {

    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }

    public static boolean areOTPsUnique(int[] otps) {

        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of OTPs to generate: ");
        int count = sc.nextInt();

        int[] otpArray = new int[count];

        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
        }

        for (int otp : otpArray) {
            System.out.println(otp);
        }

        boolean unique = areOTPsUnique(otpArray);

        System.out.println("\nAll OTPs are unique: " + unique);
    }
}
