package lab05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test for Pokemon, PokemonBox, and PokemonAlreadyExistsException classes
 * @author Raul Soto
 * @version 0.0.α
 */
class PokemonTest {
    Pokemon[] caught = {
            new Pokemon("Pikachu", "Electric"),
            new Pokemon("Bulbasaur", "Grass", "Poison"),
            new Pokemon("Charmeleon", "Fire"),
            new Pokemon("Squirtle", "Water"),
            new Pokemon("Butterfree", "Bug", "Flying"),
            new Pokemon("Pidgeotto", "Normal", "Flying")
    };

    @Test
    void pokemonConstructorTest() {
        assertThrows(IllegalArgumentException.class, () -> new Pokemon("Pikachu", "none", "none"));
        assertThrows(IllegalArgumentException.class, () -> new Pokemon(null));
        assertDoesNotThrow(() -> new Pokemon());
        assertDoesNotThrow(() -> new Pokemon("Pikachu", "Electric"));
        assertDoesNotThrow(() -> new Pokemon("Pikachu", "Electric", null));
    }

    @Test
    void pokemonBoxConstructorTest() {
        assertThrows(IllegalArgumentException.class, () -> new PokemonBox(null));
        assertThrows(IllegalArgumentException.class, () -> new PokemonBox(new Pokemon[0]));
        assertDoesNotThrow(() -> new PokemonBox(caught));
    }

    @Test
    void pokemonBoxGetPokemonTest() {
        PokemonBox pokeBox = new PokemonBox(caught);
        assertThrows(IndexOutOfBoundsException.class, () -> pokeBox.getPokemon(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            pokeBox.getPokemon(pokeBox.getNumCaught() + 1);
        });
        assertDoesNotThrow(() -> pokeBox.getPokemon(0));
    }

    @Test
    void pokemonBoxAddTest() {
        PokemonBox pokeBox = new PokemonBox(caught);
        assertThrows(PokemonAlreadyExistsException.class, () ->
            pokeBox.add(new Pokemon("Pikachu", "Electric"))
        );
        assertDoesNotThrow(() -> pokeBox.add(new Pokemon("Mew", "Psychic")));
    }
}