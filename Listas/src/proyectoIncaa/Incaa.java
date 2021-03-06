package proyectoIncaa;

import java.util.ArrayList;
import java.util.List;

public class Incaa {

	ArrayList<Pelicula> catalogo;

	// METODOS COMUNES
	public Incaa() {
		this.catalogo = new ArrayList<Pelicula>();
	}

	public List<Pelicula> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(ArrayList<Pelicula> catalogo) {
		this.catalogo = catalogo;
	}

	@Override
	public String toString() {
		return catalogo.toString();
	}

	public boolean agregarPelicula(int idPelicula, String nombre, Genero genero) throws Exception {

		int i = 0;

		while (i < catalogo.size()) {

			if (catalogo.get(i).equals(idPelicula))
				throw new Exception(nombre + " no se pudo agregar, ID existente=" + catalogo.get(i));

			if (catalogo.get(i).equals(nombre))
				throw new Exception(nombre + "no se pudo agregar, nombre de pelicula existente=" + catalogo.get(i));

			i++;
		}

		Pelicula peliculaNueva = new Pelicula(idPelicula, nombre, genero);

		return catalogo.add(peliculaNueva);
	}

	// TRAER PELICULA
	public Pelicula traerPelicula(String nombre) {
		int i = 0;
		while (i < catalogo.size()) {
			if (catalogo.get(i).equals(nombre)) {
				return catalogo.get(i);
			}
			i++;
		}
		return null;
	}

	public Pelicula traerPelicula(int id) {
		int i = 0;
		while (i < catalogo.size()) {
			if (catalogo.get(i).equals(id)) {
				return catalogo.get(i);
			}
			i++;
		}
		return null;
	}

	public List<Pelicula> traerPelicula(Genero genero) {
		int i = 0;
		List<Pelicula> listaPorGenero = new ArrayList<Pelicula>();
		while (i < catalogo.size()) {
			if (catalogo.get(i).equals(genero)) {
				listaPorGenero.add(catalogo.get(i));
			}
			i++;
		}
		return listaPorGenero;

	}

	// MODIFICAR PELICULA Y GENERO
	public void modificarPelicula(int idPelicula, String nombre) throws Exception {

		if (traerPelicula(idPelicula) == null)
			throw new Exception("La pelicula con ese ID no existe");

		traerPelicula(idPelicula).setPelicula(nombre);
	}

	// MODIFICAR PELICULA
	public void modificarGenero(int idPelicula, Genero genero) throws Exception {

		if (traerPelicula(idPelicula) == null)
			throw new Exception("El genero con ese ID no existe");

		traerPelicula(idPelicula).setGenero(genero);
	}

	// ELIMINAR PELICULA
	public boolean eliminarPelicula(int idPelicula) throws Exception {

		if (traerPelicula(idPelicula) == null)
			throw new Exception("La pelicula con ese ID no existe");

		return catalogo.remove(traerPelicula(idPelicula));
	}

}
