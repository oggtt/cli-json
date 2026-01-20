public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            printUsage();
            return;
        }

        String method = args[0].toUpperCase();
        String url = args[1];

        try {
            switch (method) {
                case "GET" -> handleGet(url);
                case "POST" -> handlePost(url, args);
                case "PUT" -> handlePut(url, args);
                default -> {
                    System.out.println("Unsupported method: " + method);
                    printUsage();
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void handleGet(String url) throws Exception {
        System.out.println(SimpleHttpClient.get(url));
    }

    private static void handlePost(String url, String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("POST requires JSON body");
            return;
        }
        System.out.println(SimpleHttpClient.postJson(url, args[2]));
    }

    private static void handlePut(String url, String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("PUT requires JSON body");
            return;
        }
        System.out.println(SimpleHttpClient.putJson(url, args[2]));
    }

    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("  myhttp get <url>");
        System.out.println("  myhttp post <url> <json>");
        System.out.println("  myhttp put <url> <json>");
    }
}
