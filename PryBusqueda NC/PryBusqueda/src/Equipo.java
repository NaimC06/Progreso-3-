import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private List<Jugador> lista;
    private int codigo = 1;

    public Equipo() {
        lista = new ArrayList<>();
    }

    public void agregarJugador(Jugador nuevo) {
        nuevo.setCodigo(codigo);
        codigo++;
        lista.add(nuevo);
    }

    public Jugador buscarBinario(int codigo) throws Exception {
        // Asegurarse de que la lista no esté vacía antes de acceder a getLast()
        if (lista.isEmpty()) {
            throw new Exception("La lista de jugadores está vacía.");
        }
        if (codigo < 1 || codigo > lista.getLast().getCodigo()) {
            throw new Exception("No existe el jugador con el código " + codigo);
        }

        int inf = 0;
        int sup = lista.size() - 1;
        int c;

        while (inf <= sup) {
            c = (inf + sup) / 2;
            if (lista.get(c).getCodigo() == codigo) {
                return lista.get(c);
            } else if (codigo < lista.get(c).getCodigo()) {
                sup = c - 1;
            } else {
                inf = c + 1;
            }
        }
        throw new Exception("No se encontró el código " + codigo);
    }

    // Nuevo método para obtener el índice de un jugador usando búsqueda binaria
    private int buscarIndiceBinario(int codigo) throws Exception {
        if (lista.isEmpty()) {
            throw new Exception("La lista de jugadores está vacía.");
        }
        if (codigo < 1 || codigo > lista.getLast().getCodigo()) {
            throw new Exception("No existe el jugador con el código " + codigo);
        }

        int inf = 0;
        int sup = lista.size() - 1;
        int c;

        while (inf <= sup) {
            c = (inf + sup) / 2;
            if (lista.get(c).getCodigo() == codigo) {
                return c; // Retorna el índice si lo encuentra
            } else if (codigo < lista.get(c).getCodigo()) {
                sup = c - 1;
            } else {
                inf = c + 1;
            }
        }
        throw new Exception("No se encontró el código " + codigo); // No se encontró el jugador
    }

    public void editarJugador(Jugador usado) throws Exception {
        try {
            int index = buscarIndiceBinario(usado.getCodigo());
            lista.set(index, usado);
        } catch (Exception e) {
            throw new Exception("Error al editar el jugador: " + e.getMessage());
        }
    }

    public boolean eliminarJugador(int codigo) throws Exception {
        try {
            int index = buscarIndiceBinario(codigo);
            lista.remove(index);
            return true;
        } catch (Exception e) {
            throw new Exception("Error al eliminar el jugador: " + e.getMessage());
        }
    }

    public String listarTodos() {
        StringBuilder sb = new StringBuilder();
        for (Jugador j : lista) {
            sb.append(j.toString());
        }
        return sb.toString();
    }
}
