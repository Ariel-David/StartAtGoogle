package startAtGoogle.Enums.exercise;

public enum Bird {
    BARN_OWL("Tyto alba") {
        public void sing() {
            System.out.println("Screeeee");
        }
    },

    BLUE_JAY("Cyanocitta cristata") {
        public void sing() {
            System.out.println("fee-der-de-lurp");
            System.out.println("jay-jay-jay");
            System.out.println("queedle-queedle-queedle");
        }
    },

    CARDINAL("Cardinalis cardinalis") {
        public void sing() {
            System.out.println("cheer-cheer-cheer-purty-purty-purty");
        }
    },

    CUCKOO("Cuculus canorus") {
        public void sing() {
            System.out.println("ku-ku");
        }
    };

    Bird(String scientificName) {
        this.scientificName = scientificName;
    }

    public final String scientificName;

    public abstract void sing();
}
