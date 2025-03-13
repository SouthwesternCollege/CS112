package lab05;

public class PokemonAlreadyExistsException extends Exception{
    private Pokemon pokemon;
    public PokemonAlreadyExistsException(){
        super("Pokemon already exists");
    }

    public PokemonAlreadyExistsException(Pokemon pokemon){
        super("ERROR: " + pokemon.getName() + " already exists");
        this.pokemon = pokemon;
    }
}
