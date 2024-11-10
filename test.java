import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String link = scan.nextLine();

            if (link.equals("end")) {
                break;
            }

            String subPattern = "^(www|WWW)\\.";
            String domPattern = "(?<=\\.)[0-9a-zA-Z]{2,15}(?=\\.)";
            String tdlPattern = "\\.(net|org|com|ir)$";

            Pattern sub = Pattern.compile(subPattern);
            Matcher subMatcher = sub.matcher(link);

            Pattern dom = Pattern.compile(domPattern);
            Matcher domMatcher = dom.matcher(link);

            Pattern tdl = Pattern.compile(tdlPattern);
            Matcher tdlMatcher = tdl.matcher(link);

            boolean isSubdomainCorrect = subMatcher.find();
            boolean isDomainCorrect = domMatcher.find();
            boolean isTDLCorrect = tdlMatcher.find();

            if (!isSubdomainCorrect) {
                System.out.println("Subdomain is not correct!!!");
            } else if (!isDomainCorrect) {
                System.out.println("There is no such website!!!");
            } else if (!isTDLCorrect) {
                System.out.println("There is no such top level domain!!!");
            } else {
                System.out.println("URL is correct.");
            }
        }
    }
}
