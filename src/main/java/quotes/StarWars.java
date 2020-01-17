package quotes;

public class StarWars {

        String starWarsQuote;

        public StarWars(String starWarsQuote){
            this.starWarsQuote = starWarsQuote;
        }

        public String toString(){
            return String.format(this.starWarsQuote);
        }
}

