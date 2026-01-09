public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage:");
            System.out.println("  myhttp get <url>");
            System.out.println("  myhttp post <url> <json>");
            System.out.println("  myhttp put <url> <json>");
            return;
        }

        String method = args[0];
        String url = args[1];

        switch (method.toLowerCase()) {
            case "get":
                System.out.println(SimpleHttpClient.get(url));
                break;

            case "post":
                if (args.length < 3) {
                    System.out.println("POST requires JSON body");
                    return;
                }
                System.out.println(SimpleHttpClient.postJson(url, args[2]));
                break;

            case "put":
                if (args.length < 3) {
                    System.out.println("PUT requires JSON body");
                    return;
                }
                System.out.println(SimpleHttpClient.putJson(url, args[2]));
                break;

            default:
                System.out.println("Unsupported method: " + method);
        }
    }
}
