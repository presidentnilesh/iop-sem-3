/*
 * ============================================================
 *  MODULE 4 : STRING HANDLING
 *  Combined Demonstration Program
 *
 *  This single file walks through every topic covered in the
 *  Module 4 training deck, in the same order:
 *
 *    1. Introduction to Strings      -> 3 ways to create, memory, input
 *    2. String Methods                -> length, charAt, indexOf,
 *                                        substring, concat, trim,
 *                                        toUpperCase, replace ...
 *    3. Comparing Strings              -> ==, equals, equalsIgnoreCase,
 *                                         compareTo
 *    4. Immutable Strings               -> methods return NEW Strings
 *    5. StringBuilder vs StringBuffer    -> mutable text, palindrome check
 *
 *  Compile : javac Module4AllConcepts.java
 *  Run     : java Module4AllConcepts
 * ============================================================
 */

import java.util.Scanner;

public class Module4AllConcepts {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println(" MODULE 4: STRING HANDLING");
        System.out.println(" Combined Demonstration Program");
        System.out.println("========================================\n");

        // ---------------------------------------------------
        // 1. INTRODUCTION TO STRINGS
        // ---------------------------------------------------
        System.out.println("---- 1. Introduction to Strings ----");

        // Way 1: string literal (stored in the String Pool)
        String city = "Delhi";

        // Way 2: using new (always a brand-new object)
        String course = new String("B.Tech CSE");

        // Way 3: from a char array
        char[] letters = {'J', 'a', 'v', 'a'};
        String lang = new String(letters);

        System.out.println("city   = " + city);
        System.out.println("course = " + course + "  (length() = " + course.length() + ")");
        System.out.println("lang   = " + lang);

        // A String stores characters in order, like an array of char
        String word = "HELLO";
        System.out.println("word.charAt(0)                 = " + word.charAt(0));
        System.out.println("word.charAt(word.length() - 1) = " + word.charAt(word.length() - 1));

        // Reading text input: next() vs nextLine()
        System.out.print("Enter your first name: ");
        String first = sc.next();      // reads ONE word
        sc.nextLine();                 // eat the leftover Enter key

        System.out.print("Enter your city/address: ");
        String address = sc.nextLine(); // reads the WHOLE line

        System.out.println("Hello, " + first + "! Address: " + address);
        System.out.println();

        // ---------------------------------------------------
        // 2. STRING METHODS
        // ---------------------------------------------------
        System.out.println("---- 2. String Methods ----");

        String subject = "Java Programming";
        System.out.println("Text               : \"" + subject + "\"");
        System.out.println("length()           : " + subject.length());          // 16
        System.out.println("charAt(5)          : " + subject.charAt(5));         // P
        System.out.println("indexOf(\"Pro\")     : " + subject.indexOf("Pro"));   // 5
        System.out.println("indexOf('z')       : " + subject.indexOf('z'));      // -1
        System.out.println("contains(\"Java\")   : " + subject.contains("Java")); // true
        System.out.println("startsWith(\"Ja\")   : " + subject.startsWith("Ja")); // true
        System.out.println("isEmpty()          : " + subject.isEmpty());         // false

        // Real-life: building a college email ID
        String fullName = "  Riya Sharma  ";
        String clean = fullName.trim();                  // "Riya Sharma"
        int space = clean.indexOf(' ');                  // 4
        String firstName = clean.substring(0, space);    // "Riya"
        String lastName  = clean.substring(space + 1);   // "Sharma"

        String id = firstName.toLowerCase()
                             .concat(".")
                             .concat(lastName.toLowerCase());
        String email = id + "@college.edu";

        System.out.println("Email              : " + email);
        System.out.println("Uppercase          : " + email.toUpperCase());
        System.out.println("replace()          : " + email.replace("college", "cse"));
        System.out.println();

        // ---------------------------------------------------
        // 3. COMPARING STRINGS
        // ---------------------------------------------------
        System.out.println("---- 3. Comparing Strings ----");

        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = "JAVA";

        System.out.println("s1 == s2              : " + (s1 == s2));    // true  (same pooled object)
        System.out.println("s1 == s3              : " + (s1 == s3));    // false (different objects)
        System.out.println("s1.equals(s3)         : " + s1.equals(s3)); // true  (same characters)
        System.out.println("s1.equals(s4)         : " + s1.equals(s4)); // false (case differs)
        System.out.println("s1.equalsIgnoreCase(s4): " + s1.equalsIgnoreCase(s4)); // true

        // compareTo: negative = comes before, 0 = equal, positive = comes after
        System.out.println("\"Aman\".compareTo(\"Riya\") : " + "Aman".compareTo("Riya")); // -17
        System.out.println("\"Riya\".compareTo(\"Riya\") : " + "Riya".compareTo("Riya")); // 0

        // Null-safe comparison: put the known literal first
        String missing = null;
        System.out.println("\"Riya\".equals(null)     : " + "Riya".equals(missing)); // false, no crash

        // Real-life: login check
        String savedUser = "admin";
        String savedPass = "Java@123";

        System.out.print("Username (try: admin): ");
        String user = sc.nextLine().trim();
        System.out.print("Password (try: Java@123): ");
        String pass = sc.nextLine().trim();

        boolean userOk = user.equalsIgnoreCase(savedUser); // usernames: case-insensitive
        boolean passOk = pass.equals(savedPass);           // passwords: case-sensitive

        if (userOk && passOk) {
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid credentials");
        }
        System.out.println();

        // ---------------------------------------------------
        // 4. IMMUTABLE STRINGS
        // ---------------------------------------------------
        System.out.println("---- 4. Immutable Strings ----");

        String name = "riya";
        name.toUpperCase();                 // result thrown away!
        System.out.println("After name.toUpperCase();        -> " + name); // riya

        name = name.toUpperCase();          // keep the NEW String
        System.out.println("After name = name.toUpperCase(); -> " + name); // RIYA

        String greet = "Hello";
        String other = greet;               // both point to "Hello"
        greet = greet + " World";           // greet now points to a NEW object

        System.out.println("greet = " + greet);  // Hello World
        System.out.println("other = " + other);  // Hello (unchanged)
        System.out.println();

        // ---------------------------------------------------
        // 5. STRINGBUILDER vs STRINGBUFFER
        // ---------------------------------------------------
        System.out.println("---- 5. StringBuilder vs StringBuffer ----");

        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Rocks");            // Java Rocks
        System.out.println("append  : " + sb);
        sb.insert(0, "I think ");       // I think Java Rocks
        System.out.println("insert  : " + sb);
        sb.replace(0, 7, "We say");     // We say Java Rocks
        System.out.println("replace : " + sb);
        sb.delete(0, 7);                // Java Rocks
        System.out.println("delete  : " + sb);
        sb.reverse();                   // skcoR avaJ
        System.out.println("reverse : " + sb + "  (length = " + sb.length() + ")");

        String result = sb.toString();  // convert back to a normal String
        System.out.println("toString().toUpperCase() : " + result.toUpperCase());

        // Building text in a loop - ONE object, edited in place
        StringBuilder list = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            list.append("Roll ").append(100 + i);
            if (i < 5) {
                list.append(", ");
            }
        }
        System.out.println("Roll call : " + list);

        // StringBuffer: same methods, but synchronized (thread-safe)
        StringBuffer log = new StringBuffer("Log:");
        log.append(" start").append(" | end");
        System.out.println("StringBuffer : " + log + "  (length = " + log.length() + ")");

        // Real-life: palindrome checker
        System.out.print("Enter a word to check for palindrome: ");
        String input = sc.nextLine().trim().toLowerCase();

        String reversed = new StringBuilder(input)
                              .reverse()
                              .toString();

        if (input.equals(reversed)) {
            System.out.println(input + " is a palindrome");
        } else {
            System.out.println(input + " is NOT a palindrome");
        }

        System.out.println("\n========================================");
        System.out.println(" End of Module 4 Demonstration Program");
        System.out.println("========================================");

        sc.close();
    }
}
